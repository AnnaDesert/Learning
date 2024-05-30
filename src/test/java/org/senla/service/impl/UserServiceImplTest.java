package org.senla.service.impl;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.senla.model.RoleEnum;
import org.senla.model.User;
import org.senla.repository.UserRepository;
import org.senla.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@RunWith(SpringRunner.class)
@SpringBootTest
class UserServiceImplTest {
    @Autowired
    private UserService userService;

    @MockBean
    private UserRepository userRepository;

    @Test
    void save() {
        User user = new User();
        user.setId(1L);
        user.setName("Игорь");
        user.setSurname("Произвольный");
        user.setPhoneNumber("7 950 456 34 54");
        user.setEmail("randomIgor@mail.ru");
        user.setPassword("1q2w3e4r5t6y");
        user.setRole(RoleEnum.USER);

        Assertions.assertNotNull(user);
        userService.save(user);
        verify(userRepository, times(1)).save(user);
    }

    @Test
    void remove() {
        userService.remove(2L);
        verify(userRepository, times(1)).deleteById(2L);
    }

    @Test
    void getById() {
        userService.getById(3L);
        verify(userRepository, times(1)).findById(3L);
    }

    @Test
    void getByName() {
        userService.getByName("Игорь");
        verify(userRepository, times(1)).findByName("Игорь");
    }

    @Test
    void getByEmail() {
        userService.getByEmail("randomIgor@mail.ru");
        verify(userRepository, times(1)).findByEmail("randomIgor@mail.ru");
    }

    @Test
    void getByPhoneNumber() {
        userService.getByPhoneNumber("7 950 456 34 54");
        verify(userRepository, times(1)).findByPhoneNumber("7 950 456 34 54");
    }
    
    @Test
    void getAll() {
        userService.getAll();
        verify(userRepository, times(1)).findAll();
    }

    @Test
    void update() {
        User user = new User();
        user.setName("Игорь");
        user.setSurname("Произвольный");
        user.setPhoneNumber("7 950 456 34 54");
        user.setEmail("randomIgor@mail.ru");
        user.setPassword("1q2w3e4r5t6y");
        user.setRole(RoleEnum.USER);

        User userIn = new User();
        userIn.setId(2L);
        user.setName("Игорь");
        user.setSurname("Произвольный");
        user.setPhoneNumber("7 960 456 34 54");
        user.setEmail("randomIgor@gmail.com");
        user.setPassword("1q2w3e4r5t6y");
        user.setRole(RoleEnum.USER);

        given(userRepository.findById(2L)).willReturn(Optional.of(userIn));

        Assertions.assertNotNull(user);
        userService.update(user, 2L);
        verify(userRepository, times(1)).findById(2L);
        Assertions.assertNotNull(userIn);
        assertThat(user.getId()).isEqualTo(2L);
        verify(userRepository, times(1)).save(user);
    }
}