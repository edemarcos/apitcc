package com.edemarcos.tcc.app.user.entrypoint;

import com.edemarcos.tcc.app.category.entrypoint.controller.response.CategoryResponse;
import com.edemarcos.tcc.app.user.entrypoint.mapper.UserMapperController;
import com.edemarcos.tcc.app.user.entrypoint.request.UserRequest;
import com.edemarcos.tcc.app.user.entrypoint.response.UserResponse;
import com.edemarcos.tcc.domain.user.entities.User;
import com.edemarcos.tcc.domain.user.usecases.FindAllUserUseCase;
import com.edemarcos.tcc.domain.user.usecases.FindByIdUserUseCase;
import com.edemarcos.tcc.domain.user.usecases.InsertUserUseCase;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/user")
@Tag(name = "User", description = "User API")
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

    @Operation(summary = "Inserir novo usuário", method = "POST")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Usuário criado"),
            @ApiResponse(responseCode = "500", description = "Falha ao inserir usuário: Existem campos vazios"),
    })
    @PostMapping
    public ResponseEntity<?> insert(@RequestBody UserRequest userRequest) {
        userRequest.setPassword(new BCryptPasswordEncoder().encode(userRequest.getPassword()));
        var user = userMapperController.toUser(userRequest);
        User createdUser = insertUserUseCase.execute(user);
        UserResponse userResponse = userMapperController.toUserResponse(createdUser);
        return ResponseEntity.status(HttpStatus.CREATED).body(userResponse);
    }

    @Operation(summary = "Buscar usuário por ID", method = "GET")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Usuário encontrado"),
            @ApiResponse(responseCode = "404", description = "Usuário não encontrado"),
    })
    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable final Long id) {
        var user = findByIdUserUseCase.execute(id);
        var userResponse = userMapperController.toUserResponse(user);
        return ResponseEntity.ok().body(userResponse);
    }

    @Operation(summary = "Listar todos os usuários", method = "GET")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Lista de usuários retornada com sucesso"),
    })
    @GetMapping
    public ResponseEntity<?> findAll() {
        var users = findAllUserUseCase.execute();
        return ResponseEntity.ok().body(users);
    }
}
