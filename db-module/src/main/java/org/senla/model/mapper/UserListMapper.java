package org.senla.model.mapper;

import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.senla.model.User;
import org.senla.swagger.model.UserCreationDTO;
import org.senla.swagger.model.UserDTO;

import java.util.List;

@Mapper(componentModel = "spring", uses = UserListMapper.class, injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface UserListMapper {
    public List<UserDTO> toDtoList(List<User> user);
    public List<User> toUserList(List<UserCreationDTO> userDTO);
}
