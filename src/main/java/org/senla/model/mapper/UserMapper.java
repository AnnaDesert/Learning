package org.senla.model.mapper;

import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.senla.model.User;
import org.senla.model.dto.UserCreationDTO;
import org.senla.model.dto.UserDTO;
import org.springframework.stereotype.Component;

@Mapper(componentModel = "spring", injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface UserMapper {
    public UserDTO toDto(User user);
    public User toUser(UserCreationDTO userDTO);
}