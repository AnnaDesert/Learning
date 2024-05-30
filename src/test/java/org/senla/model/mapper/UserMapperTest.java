package org.senla.model.mapper;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.senla.model.RoleEnum;
import org.senla.model.User;
import org.senla.model.dto.UserCreationDTO;
import org.senla.model.dto.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@SpringBootTest
class UserMapperTest {
    @Autowired
    UserMapper userMapper;

    @Test
    void toDto() {
        User user = new User();
        user.setId(1L);
        user.setName("Игорь");
        user.setSurname("Произвольный");
        user.setPhoneNumber("7 950 456 34 54");
        user.setEmail("randomIgor@mail.ru");
        user.setPassword("1q2w3e4r5t6y");
        user.setRole(RoleEnum.USER);

        UserDTO userDTO = userMapper.toDto(user);

        Assertions.assertNotNull(userDTO);
        assertThat(userDTO.getId()).isEqualTo(user.getId());
        assertThat(userDTO.getName()).isEqualTo(user.getName());
        assertThat(userDTO.getSurname()).isEqualTo(user.getSurname());
        assertThat(userDTO.getPhoneNumber()).isEqualTo(user.getPhoneNumber());
        assertThat(userDTO.getRole()).isEqualTo(user.getRole());
    }

    @Test
    void toUser() {
        UserCreationDTO userDTO = new UserCreationDTO();
        userDTO.setName("Игорь");
        userDTO.setSurname("Произвольный");
        userDTO.setPhoneNumber("7 950 456 34 54");
        userDTO.setEmail("randomIgor@mail.ru");
        userDTO.setPassword("1q2w3e4r5t6y");
        userDTO.setRole(RoleEnum.USER);

        User user = userMapper.toUser(userDTO);

        Assertions.assertNotNull(user);
        assertThat(userDTO.getPassword()).isEqualTo(user.getPassword());
        assertThat(userDTO.getName()).isEqualTo(user.getName());
        assertThat(userDTO.getSurname()).isEqualTo(user.getSurname());
        assertThat(userDTO.getPhoneNumber()).isEqualTo(user.getPhoneNumber());
        assertThat(userDTO.getRole()).isEqualTo(user.getRole());
    }
}