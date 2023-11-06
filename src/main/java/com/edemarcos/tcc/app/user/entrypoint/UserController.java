package com.edemarcos.tcc.app.user.entrypoint;

import com.edemarcos.tcc.app.category.entrypoint.controller.response.CategoryResponse;
import com.edemarcos.tcc.app.user.entrypoint.mapper.UserMapperController;
import com.edemarcos.tcc.app.user.entrypoint.request.UserRequest;
import com.edemarcos.tcc.app.user.entrypoint.response.UserResponse;
import com.edemarcos.tcc.domain.user.entities.User;
import com.edemarcos.tcc.domain.user.usecases.FindAllUserUseCase;
import com.edemarcos.tcc.domain.user.usecases.FindByIdUserUseCase;
import com.edemarcos.tcc.domain.user.usecases.InsertUserUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/user")
public class UserController {

    private InsertUserUseCase insertUserUseCase;

    private UserMapperController userMapperController;

    private FindByIdUserUseCase findByIdUserUseCase;

    private FindAllUserUseCase findAllUserUseCase;

    public UserController(InsertUserUseCase insertUserUseCase, UserMapperController userMapperController, FindByIdUserUseCase findByIdUserUseCase, FindAllUserUseCase findAllUserUseCase) {
        this.insertUserUseCase = insertUserUseCase;
        this.userMapperController = userMapperController;
        this.findByIdUserUseCase = findByIdUserUseCase;
        this.findAllUserUseCase = findAllUserUseCase;
    }

    @PostMapping
    public ResponseEntity<?> insert(@RequestBody UserRequest userRequest ) {
        userRequest.setPassword(new BCryptPasswordEncoder().encode(userRequest.getPassword()));
        var user = userMapperController.toUser(userRequest) ;
        User createdUser = insertUserUseCase.execute(user);
        UserResponse userResponse = userMapperController.toUserResponse(createdUser);
        return ResponseEntity.status(HttpStatus.CREATED).body(userResponse);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable final Long id){
        var user = findByIdUserUseCase.execute(id);
        var userResponse = userMapperController.toUserResponse(user);
        return ResponseEntity.ok().body(userResponse);
    }

    @GetMapping
    public ResponseEntity<?> findAll(){
        var users = findAllUserUseCase.execute();
        return ResponseEntity.ok().body(users);
    }
}
