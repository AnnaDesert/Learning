package org.senla.repository;

import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.senla.model.RoleEnum;
import org.senla.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.util.TestPropertyValues;
import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.testcontainers.containers.MySQLContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;
import org.testcontainers.utility.DockerImageName;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@ContextConfiguration(initializers = {UserRepositoryTest.Initializer.class})
@Testcontainers
@Transactional
@Sql("classpath:init_test_script.sql")
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
class UserRepositoryTest {
    @Autowired
    private UserRepository userRepository;
    @Container
    public static MySQLContainer<?> database =
            new MySQLContainer<>(DockerImageName.parse("mysql:latest"))
                    .withDatabaseName("national_food_price_monitoring_service_fp_test_db")
                    .withUsername("root")
                    .withPassword("");

    static class Initializer implements ApplicationContextInitializer<ConfigurableApplicationContext> {
        public void initialize(ConfigurableApplicationContext configurableApplicationContext) {
            TestPropertyValues.of(
                    "spring.datasource.url=" + database.getJdbcUrl(),
                    "spring.datasource.username=" + database.getUsername(),
                    "spring.datasource.password=" + database.getPassword(),
                    "spring.liquibase.enabled=true"
            ).applyTo(configurableApplicationContext.getEnvironment());
        }
    }

    @Test
    public void getById() {
        Optional<User> userGet = userRepository.findById(2L);
        assertThat(userGet.isPresent()).isTrue();
        assertThat(userGet.get().getId()).isEqualTo(2L);
    }

    @Test
    public void update() {
        User updateUser = new User();
        updateUser.setName("Витя");

        userRepository.findById(2L)
                .map(user -> {
                    updateUser.setId(user.getId());
                    return userRepository.save(updateUser);
                });

        Optional<User> user = userRepository.findById(2L);
        assertThat(user.isPresent()).isTrue();
        assertThat(user.get().getId()).isEqualTo(2L);
        assertThat(user.get().getName()).isEqualTo("Витя");
    }

    @Test
    public void remove() {
        Optional<User> userGet = userRepository.findById(2L);

        assertThat(userGet.isPresent()).isTrue();
        assertThat(userGet.get().getId()).isEqualTo(2L);
        userRepository.deleteById(2L);

        Optional<User> userGetRemove = userRepository.findById(2L);
        assertThat(userGetRemove.isPresent()).isFalse();
    }

    @Test
    public void save() {
        User user = new User();
        user.setName("Игорь");
        user.setSurname("Произвольный");
        user.setPhoneNumber("7 950 456 34 54");
        user.setEmail("randomIgor@mail.ru");
        user.setPassword("1q2w3e4r5t6y");
        user.setRole(RoleEnum.USER);

        userRepository.save(user);
        Optional<User> userGet = userRepository.findById(4L);

        assertThat(userGet.isPresent()).isTrue();
        assertThat(userGet.get().getId()).isEqualTo(4L);
    }

    @Test
    public void findAll() {
        List<User> usersList = userRepository.findAll();
        assertThat(usersList).isNotEmpty();
    }

    @Test
    void findByName() {
        List<User> userGet = userRepository.findByName("Кирил");
        assertThat(userGet).isNotEmpty();
        assertThat(userGet.get(0).getName()).isEqualTo("Кирил");
    }

    @Test
    void findByEmail() {
        Optional<User> userGet = userRepository.findByEmail("proizwol@mail.ru");
        assertThat(userGet.isPresent()).isTrue();
        assertThat(userGet.get().getEmail()).isEqualTo("proizwol@mail.ru");
    }

    @Test
    void findByPhoneNumber() {
        Optional<User> userGet = userRepository.findByPhoneNumber("7 980 484 34 34");
        assertThat(userGet.isPresent()).isTrue();
        assertThat(userGet.get().getPhoneNumber()).isEqualTo("7 980 484 34 34");
    }
}