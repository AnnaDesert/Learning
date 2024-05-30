package org.senla.repository;

import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.senla.model.ProductCatalog;
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
@ContextConfiguration(initializers = {ProductCatalogRepositoryTest.Initializer.class})
@Testcontainers
@Transactional
@Sql("classpath:init_test_script.sql")
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
class ProductCatalogRepositoryTest {
    @Autowired
    private ProductCatalogRepository productCatalogRepository;
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
        Optional<ProductCatalog> productCatalogGet = productCatalogRepository.findById(2L);
        assertThat(productCatalogGet.isPresent()).isTrue();
        assertThat(productCatalogGet.get().getId()).isEqualTo(2L);
    }

    @Test
    public void update() {
        ProductCatalog updateProductCatalog = new ProductCatalog();
        updateProductCatalog.setCount(102);

        productCatalogRepository.findById(2L)
                .map(productCatalog -> {
                    updateProductCatalog.setId(productCatalog.getId());
                    return productCatalogRepository.save(updateProductCatalog);
                });

        Optional<ProductCatalog> productCatalog = productCatalogRepository.findById(2L);
        assertThat(productCatalog.isPresent()).isTrue();
        assertThat(productCatalog.get().getId()).isEqualTo(2L);
        assertThat(productCatalog.get().getCount()).isEqualTo(102);
    }

    @Test
    public void remove() {
        Optional<ProductCatalog> productCatalogGet = productCatalogRepository.findById(2L);

        assertThat(productCatalogGet.isPresent()).isTrue();
        assertThat(productCatalogGet.get().getId()).isEqualTo(2L);
        productCatalogRepository.deleteById(2L);

        Optional<ProductCatalog> productCatalogGetRemove = productCatalogRepository.findById(2L);
        assertThat(productCatalogGetRemove.isPresent()).isFalse();
    }

    @Test
    public void save() {
        ProductCatalog productCatalog = new ProductCatalog();
        productCatalog.setIdShop(2L);
        productCatalog.setPrice(102F);
        productCatalog.setIdBatch(2L);
        productCatalog.setCount(56);

        productCatalogRepository.save(productCatalog);
        Optional<ProductCatalog> productCatalogGet = productCatalogRepository.findById(4L);

        assertThat(productCatalogGet.isPresent()).isTrue();
        assertThat(productCatalogGet.get().getId()).isEqualTo(4L);
    }

    @Test
    public void findAll() {
        List<ProductCatalog> productCatalogsList = productCatalogRepository.findAll();
        assertThat(productCatalogsList).isNotEmpty();
    }
}