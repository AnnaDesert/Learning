package org.senla.model.mapper;

import javax.annotation.processing.Generated;
import org.senla.model.User;
import org.senla.model.dto.UserCreationDTO;
import org.senla.model.dto.UserDTO;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-06-13T17:37:49+0300",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 21.0.2 (Oracle Corporation)"
)
@Component
public class UserMapperImpl implements UserMapper {

    @Override
    public UserDTO toDto(User user) {
        if ( user == null ) {
            return null;
        }

        UserDTO userDTO = new UserDTO();

        userDTO.setId( user.getId() );
        userDTO.setName( user.getName() );
        userDTO.setSurname( user.getSurname() );
        userDTO.setPhoneNumber( user.getPhoneNumber() );
        userDTO.setEmail( user.getEmail() );
        userDTO.setRole( user.getRole() );

        return userDTO;
    }

    @Override
    public User toUser(UserCreationDTO userDTO) {
        if ( userDTO == null ) {
            return null;
        }

        User.UserBuilder user = User.builder();

        user.password( userDTO.getPassword() );
        user.name( userDTO.getName() );
        user.surname( userDTO.getSurname() );
        user.phoneNumber( userDTO.getPhoneNumber() );
        user.email( userDTO.getEmail() );
        user.role( userDTO.getRole() );

        return user.build();
    }
}
