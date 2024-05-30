package org.senla.repository;

import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.senla.model.Shop;
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
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@ContextConfiguration(initializers = {ShopRepositoryTest.Initializer.class})
@Testcontainers
@Transactional
@Sql("classpath:init_test_script.sql")
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
class ShopRepositoryTest {
    @Autowired
    private ShopRepository shopRepository;
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
        Optional<Shop> shopGet = shopRepository.findById(2L);
        assertThat(shopGet.isPresent()).isTrue();
        assertThat(shopGet.get().getId()).isEqualTo(2L);
    }

    @Test
    public void update() {
        Shop updateShop = new Shop();
        updateShop.setName("Продуктовый");

        shopRepository.findById(2L)
                .map(shop -> {
                    updateShop.setId(shop.getId());
                    return shopRepository.save(updateShop);
                });

        Optional<Shop> shop = shopRepository.findById(2L);
        assertThat(shop.isPresent()).isTrue();
        assertThat(shop.get().getId()).isEqualTo(2L);
        assertThat(shop.get().getName()).isEqualTo("Продуктовый");
    }

    @Test
    public void remove() {
        Optional<Shop> shopGet = shopRepository.findById(2L);

        assertThat(shopGet.isPresent()).isTrue();
        assertThat(shopGet.get().getId()).isEqualTo(2L);
        shopRepository.deleteById(2L);

        Optional<Shop> shopGetRemove = shopRepository.findById(2L);
        assertThat(shopGetRemove.isPresent()).isFalse();
    }

    @Test
    public void save() {
        Shop shop = new Shop();
        shop.setName("Произвольный");
        shop.setAddress("ул. Произвольная 32");
        shop.setIdAdmin(3L);

        shopRepository.save(shop);
        Optional<Shop> shopGet = shopRepository.findById(4L);

        assertThat(shopGet.isPresent()).isTrue();
        assertThat(shopGet.get().getId()).isEqualTo(4L);
    }

    @Test
    public void findAll() {
        List<Shop> shopsList = shopRepository.findAll();
        assertThat(shopsList).isNotEmpty();
    }

    @Test
    void findByName() {
        List<Shop> shopGet = shopRepository.findByName("Мир колбас");
        assertThat(shopGet).isNotEmpty();
        assertThat(shopGet.get(0).getName()).isEqualTo("Мир колбас");
    }

    @Test
    void findByAddress() {
        List<Shop> shopGet = shopRepository.findByAddress("ул. Мясной переулок 12");
        assertThat(shopGet).isNotEmpty();
        assertThat(shopGet.get(0).getAddress()).isEqualTo("ул. Мясной переулок 12");
    }
}