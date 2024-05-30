package org.senla.repository;

import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.senla.model.Product;
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
@ContextConfiguration(initializers = {ProductRepositoryTest.Initializer.class})
@Testcontainers
@Transactional
@Sql("classpath:init_test_script.sql")
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
class ProductRepositoryTest {
    @Autowired
    private ProductRepository productRepository;
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
        Optional<Product> productGet = productRepository.findById(2L);
        assertThat(productGet.isPresent()).isTrue();
        assertThat(productGet.get().getId()).isEqualTo(2L);
    }

    @Test
    public void update() {
        Product updateProduct = new Product();
        updateProduct.setName("Кекс");

        productRepository.findById(2L)
                .map(product -> {
                    updateProduct.setId(product.getId());
                    return productRepository.save(updateProduct);
                });

        Optional<Product> product = productRepository.findById(2L);
        assertThat(product.isPresent()).isTrue();
        assertThat(product.get().getId()).isEqualTo(2L);
        assertThat(product.get().getName()).isEqualTo("Кекс");
    }

    @Test
    public void remove() {
        Optional<Product> productGet = productRepository.findById(2L);

        assertThat(productGet.isPresent()).isTrue();
        assertThat(productGet.get().getId()).isEqualTo(2L);
        productRepository.deleteById(2L);

        Optional<Product> productGetRemove = productRepository.findById(2L);
        assertThat(productGetRemove.isPresent()).isFalse();
    }

    @Test
    public void save() {
        Product product = new Product();
        product.setName("Кекс");

        productRepository.save(product);
        Optional<Product> productGet = productRepository.findById(4L);

        assertThat(productGet.isPresent()).isTrue();
        assertThat(productGet.get().getId()).isEqualTo(4L);
    }

    @Test
    public void findAll() {
        List<Product> productsList = productRepository.findAll();
        assertThat(productsList).isNotEmpty();
    }

    @Test
    void findByName() {
        List<Product> productGet = productRepository.findByName("Печенье");
        assertThat(productGet).isNotEmpty();
        assertThat(productGet.get(0).getName()).isEqualTo("Печенье");
    }
}