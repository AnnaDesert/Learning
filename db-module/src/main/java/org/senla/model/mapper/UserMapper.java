package org.senla.model.mapper;

import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.senla.model.User;
import org.senla.swagger.model.UserCreationDTO;
import org.senla.swagger.model.UserDTO;

@Mapper(componentModel = "spring", injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface UserMapper {
    public UserDTO toDto(User user);
    public User toUser(UserCreationDTO userDTO);
}