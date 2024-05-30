package org.senla.api;


import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import org.senla.model.User;
import org.senla.model.dto.UserCreationDTO;
import org.senla.model.dto.UserDTO;
import org.senla.model.mapper.UserMapper;
import org.senla.service.UserService;
import org.senla.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

import static java.util.stream.Collectors.toList;
@RestController
@Validated
@RequestMapping("/api/v1")
@Tag(name = "user", description = "Запросы для user")
public class UserApiController {
    private final UserService userService;
    private final UserMapper userMapper;
    @Autowired
    public UserApiController(UserServiceImpl userService, UserMapper userMapper) {
        this.userService = userService;
        this.userMapper = userMapper;
    }

    @GetMapping("/user")
    @ResponseBody
    public List<UserDTO> allUser() {
        return userService.getAll()
                .stream()
                .map(userMapper::toDto)
                .collect(toList());
    }

    @GetMapping("/user/email/{email}")
    @ResponseBody
    public Optional<UserDTO> userByEmail(
            @Parameter(name = "email", description = "Адрес электронной почты", required = true, in = ParameterIn.PATH)
            @PathVariable("email") @Email String email
    ) {
        return userService.getByEmail(email).map(userMapper::toDto);
    }
    
    @GetMapping("/user/{id}")
    @ResponseBody
    public Optional<UserDTO> userById(
            @Parameter(name = "id", description = "ID пользователя", required = true, in = ParameterIn.PATH)
            @PathVariable("id") @Min(1) Long id
    ) {
        return userService.getById(id).map(userMapper::toDto);
    }
    
    @GetMapping("/user/phoneNumber/{phoneNumber}")
    @ResponseBody
    public Optional<UserDTO> userByPhone(
            @Parameter(name = "phoneNumber", description = "Номер телефона", required = true, in = ParameterIn.PATH)
            @PathVariable("phoneNumber") String phoneNumber
    ) {
        return userService.getByPhoneNumber(phoneNumber).map(userMapper::toDto);
    }

    @GetMapping("/user/name/{name}")
    @ResponseBody
    public List<UserDTO> userByName(
            @Parameter(name = "name", description = "Имя пользователя", required = true, in = ParameterIn.PATH)
            @PathVariable("name") String name
    ) {
        return userService.getByName(name)
                .stream()
                .map(userMapper::toDto)
                .collect(toList());
    }
    
    @DeleteMapping("/user/{id}")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public void removeUserById(@PathVariable @Min(1) Long id) {
        userService.getById(id);
    }
    
    @PostMapping("/user")
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    public void singUpUser(@RequestBody UserCreationDTO userDTO) {
        User user = userMapper.toUser(userDTO);
        userService.save(user);
    }

    @PatchMapping("/user/{id}")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public void updateUser(@RequestBody UserCreationDTO userDTO, @PathVariable @Min(1) Long id) {
        User user = userMapper.toUser(userDTO);
        userService.update(user, id);
    }
}