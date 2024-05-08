package org.senla.api;


import org.senla.model.User;
import org.senla.model.dto.UserCreationDTO;
import org.senla.model.dto.UserDTO;
import org.senla.model.dto.UserMapper;
import org.senla.service.UserService;
import org.senla.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.NativeWebRequest;

import java.util.List;
import java.util.Optional;
import jakarta.annotation.Generated;

import static java.util.stream.Collectors.toList;

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2024-05-05T16:09:04.794912+03:00[Europe/Moscow]", comments = "Generator version: 7.5.0")
@RestController
@RequestMapping("${openapi.openAPI30.base-path:}")
public class UserApiController implements UserApi {

    private final NativeWebRequest request;
    private final UserService userService;
    private final UserMapper userMapper;
    @Autowired
    public UserApiController(NativeWebRequest request, UserServiceImpl userService, UserMapper userMapper) {
        this.request = request;
        this.userService = userService;
        this.userMapper = userMapper;
    }

    @Override
    public Optional<NativeWebRequest> getRequest() {
        return Optional.ofNullable(request);
    }

    @Override
    @GetMapping("/user")
    @ResponseBody
    public List<UserDTO> allUser() {
        return userService.getAll()
                .stream()
                .map(userMapper::toDto)
                .collect(toList());
    }

    @Override
    @GetMapping("/user/email/{email}")
    @ResponseBody
    public Optional<UserDTO> userByEmail(@PathVariable String email) {
        return userService.getByEmail(email).map(userMapper::toDto);
    }

    @Override
    @GetMapping("/user/{id}")
    @ResponseBody
    public Optional<UserDTO> userById(@PathVariable Long id) {
        return userService.getById(id).map(userMapper::toDto);
    }

    @Override
    @GetMapping("/user/phoneNumber/{phoneNumber}")
    @ResponseBody
    public Optional<UserDTO> userByPhone(@PathVariable String phoneNumber) {
        return userService.getByPhoneNumber(phoneNumber).map(userMapper::toDto);
    }

    @Override
    @DeleteMapping("/user/{id}")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public void removeUserById(@PathVariable Long id) {
        userService.getById(id);
    }

    @Override
    @PostMapping("/user")
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    public void singUpUser(@RequestBody UserCreationDTO userDTO) {
        User user = userMapper.toUser(userDTO);
        userService.save(user);
    }

    @Override
    @PatchMapping("/user/{id}")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public void updateUser(@RequestBody UserCreationDTO userDTO, @PathVariable Long id) {
        User user = userMapper.toUser(userDTO);
        userService.update(user, id);
    }
}