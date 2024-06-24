package org.senla.model.mapper;

import javax.annotation.processing.Generated;
import org.senla.model.RoleEnum;
import org.senla.model.User;
import org.senla.swagger.model.UserCreationDTO;
import org.senla.swagger.model.UserDTO;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-06-24T09:46:27+0300",
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
        userDTO.setRole( roleEnumToRoleEnum( user.getRole() ) );

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
        user.role( roleEnumToRoleEnum1( userDTO.getRole() ) );

        return user.build();
    }

    protected UserDTO.RoleEnum roleEnumToRoleEnum(RoleEnum roleEnum) {
        if ( roleEnum == null ) {
            return null;
        }

        UserDTO.RoleEnum roleEnum1;

        switch ( roleEnum ) {
            case SUPER_ADMIN: roleEnum1 = UserDTO.RoleEnum.SUPER_ADMIN;
            break;
            case ADMIN: roleEnum1 = UserDTO.RoleEnum.ADMIN;
            break;
            case USER: roleEnum1 = UserDTO.RoleEnum.USER;
            break;
            default: throw new IllegalArgumentException( "Unexpected enum constant: " + roleEnum );
        }

        return roleEnum1;
    }

    protected RoleEnum roleEnumToRoleEnum1(UserCreationDTO.RoleEnum roleEnum) {
        if ( roleEnum == null ) {
            return null;
        }

        RoleEnum roleEnum1;

        switch ( roleEnum ) {
            case SUPER_ADMIN: roleEnum1 = RoleEnum.SUPER_ADMIN;
            break;
            case ADMIN: roleEnum1 = RoleEnum.ADMIN;
            break;
            case USER: roleEnum1 = RoleEnum.USER;
            break;
            default: throw new IllegalArgumentException( "Unexpected enum constant: " + roleEnum );
        }

        return roleEnum1;
    }
}
