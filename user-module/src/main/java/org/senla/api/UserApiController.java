package org.senla.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import lombok.RequiredArgsConstructor;
import org.senla.model.User;
import org.senla.model.mapper.UserListMapper;
import org.senla.swagger.api.UserApi;
import org.senla.swagger.model.ChangePasswordRequestDTO;
import org.senla.swagger.model.UserCreationDTO;
import org.senla.swagger.model.UserDTO;
import org.senla.model.mapper.UserMapper;
import org.senla.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Optional;

import static java.util.stream.Collectors.toList;
@RestController
@Validated
@RequestMapping("/api/v1")
@Tag(name = "user", description = "Запросы для user")
@RequiredArgsConstructor
public class UserApiController implements UserApi {
    private final UserService userService;
    private final UserMapper userMapper;
    private final UserListMapper userListMapper;

    @Override
    public Optional<ObjectMapper> getObjectMapper() {
        return Optional.empty();
    }

    @Override
    public Optional<HttpServletRequest> getRequest() {
        return Optional.empty();
    }

//    @GetMapping("/user")
    @ResponseBody
    @Override
    public ResponseEntity<List<UserDTO>> allUser() {
        return ResponseEntity.ok(userListMapper.toDtoList(userService.getAll()));
    }

    //    @GetMapping("/user/email/{email}")
    @ResponseBody
    @Override
    public ResponseEntity<UserDTO> userByEmail(
            @Parameter(name = "email", description = "Адрес электронной почты", required = true, in = ParameterIn.PATH)
            @PathVariable("email") @Email String email
    ) {
        return ResponseEntity.ok(userMapper.toDto(userService.getByEmail(email).get()));
    }
    
//    @GetMapping("/user/{id}")
    @ResponseBody
    @Override
    public ResponseEntity<UserDTO> userById(
            @Parameter(name = "id", description = "ID пользователя", required = true, in = ParameterIn.PATH)
            @PathVariable("id") @Min(1) Long id
    ) {
        return ResponseEntity.ok(userMapper.toDto(userService.getById(id).get()));
    }
    
//    @GetMapping("/user/phoneNumber/{phoneNumber}")
    @ResponseBody
    @Override
    public ResponseEntity<UserDTO> userByPhone(
            @Parameter(name = "phoneNumber", description = "Номер телефона", required = true, in = ParameterIn.PATH)
            @PathVariable("phoneNumber") String phoneNumber
    ) {
        return ResponseEntity.ok(userMapper.toDto(userService.getByPhoneNumber(phoneNumber).get()));
    }

//    @GetMapping("/user/name/{name}")
    @ResponseBody
    @Override
    public ResponseEntity<List<UserDTO>> userByName(
            @Parameter(name = "name", description = "Имя пользователя", required = true, in = ParameterIn.PATH)
            @PathVariable("name") String name
    ) {
        return ResponseEntity.ok(userListMapper.toDtoList(userService.getByName(name)));
    }
    
//    @DeleteMapping("/user/{id}")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    @Override
    public ResponseEntity<Void> removeUserById(@PathVariable @Min(1) Long id) {
        userService.getById(id);
        return null;
    }
    
//    @PostMapping("/user")
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    @Override
    public ResponseEntity<Void> singUpUser(@RequestBody UserCreationDTO userDTO) {
        User user = userMapper.toUser(userDTO);
        userService.save(user);
        return null;
    }

//    @PatchMapping("/user/{id}")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    @Override
    public ResponseEntity<Void> updateUser( @PathVariable @Min(1) Long id, @RequestBody UserCreationDTO userDTO) {
        User user = userMapper.toUser(userDTO);
        userService.update(user, id);
        return null;
    }
}