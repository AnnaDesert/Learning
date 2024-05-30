package org.senla.repository;

import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.senla.model.ProductCategory;
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
@ContextConfiguration(initializers = {ProductCategoryRepositoryTest.Initializer.class})
@Testcontainers
@Transactional
@Sql("classpath:init_test_script.sql")
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
class ProductCategoryRepositoryTest {
    @Autowired
    private ProductCategoryRepository productCategoryRepository;
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
        Optional<ProductCategory> productCategoryGet = productCategoryRepository.findById(2L);
        assertThat(productCategoryGet.isPresent()).isTrue();
        assertThat(productCategoryGet.get().getId()).isEqualTo(2L);
    }

    @Test
    public void update() {
        ProductCategory updateProductCategory = new ProductCategory();
        updateProductCategory.setName("Молочная продукция");

        productCategoryRepository.findById(2L)
                .map(productCategory -> {
                    updateProductCategory.setId(productCategory.getId());
                    return productCategoryRepository.save(updateProductCategory);
                });

        Optional<ProductCategory> productCategory = productCategoryRepository.findById(2L);
        assertThat(productCategory.isPresent()).isTrue();
        assertThat(productCategory.get().getId()).isEqualTo(2L);
        assertThat(productCategory.get().getName()).isEqualTo("Молочная продукция");
    }

    @Test
    public void remove() {
        Optional<ProductCategory> productCategoryGet = productCategoryRepository.findById(2L);

        assertThat(productCategoryGet.isPresent()).isTrue();
        assertThat(productCategoryGet.get().getId()).isEqualTo(2L);
        productCategoryRepository.deleteById(2L);

        Optional<ProductCategory> productCategoryGetRemove = productCategoryRepository.findById(2L);
        assertThat(productCategoryGetRemove.isPresent()).isFalse();
    }

    @Test
    public void save() {
        ProductCategory productCategory = new ProductCategory();
        productCategory.setName("Молочная продукция");

        productCategoryRepository.save(productCategory);
        Optional<ProductCategory> productCategoryGet = productCategoryRepository.findById(4L);

        assertThat(productCategoryGet.isPresent()).isTrue();
        assertThat(productCategoryGet.get().getId()).isEqualTo(4L);
    }

    @Test
    public void findAll() {
        List<ProductCategory> productCategorysList = productCategoryRepository.findAll();
        assertThat(productCategorysList).isNotEmpty();
    }

    @Test
    void findByName() {
        Optional<ProductCategory> productCategoryGet = productCategoryRepository.findByName("Алкоголь");
        assertThat(productCategoryGet.isPresent()).isTrue();
        assertThat(productCategoryGet.get().getName()).isEqualTo("Алкоголь");
    }
}