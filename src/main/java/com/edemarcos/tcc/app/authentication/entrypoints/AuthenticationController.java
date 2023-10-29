package com.edemarcos.tcc.app.authentication.entrypoints;


import com.edemarcos.tcc.app.authentication.entrypoints.request.AuthenticationDTO;
import com.edemarcos.tcc.app.authentication.entrypoints.response.LoginResponseDTO;
import com.edemarcos.tcc.app.user.dataproviders.mapper.UserMapper;
import com.edemarcos.tcc.app.user.dataproviders.model.UserModel;
import com.edemarcos.tcc.domain.authentication.usecases.GenerateTokenUseCase;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("auth")
public class AuthenticationController {
    @Autowired
    private AuthenticationManager authenticationManager;

    private GenerateTokenUseCase generateTokenUseCase;

    private UserMapper userMapper;

    public AuthenticationController(GenerateTokenUseCase generateTokenUseCase, UserMapper userMapper) {
        this.generateTokenUseCase = generateTokenUseCase;
        this.userMapper = userMapper;
    }


    @PostMapping("/login")
    public ResponseEntity login(@RequestBody @Valid AuthenticationDTO data){
        var usernamePassword = new UsernamePasswordAuthenticationToken(data.login(), data.password());
        var auth = this.authenticationManager.authenticate(usernamePassword);
        var user = (UserModel) auth.getPrincipal();
        var userEntity = userMapper.toEntity(user);
        var token = generateTokenUseCase.execute(userEntity);

        return ResponseEntity.ok(new LoginResponseDTO(token));
    }

}
