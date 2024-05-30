package org.senla.repository;

import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.senla.model.BatchOfProduct;
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

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@ContextConfiguration(initializers = {BatchOfProductRepositoryTest.Initializer.class})
@Testcontainers
@Transactional
@Sql("classpath:init_test_script.sql")
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
class BatchOfProductRepositoryTest{
    @Autowired
    private BatchOfProductRepository batchOfProductRepository;
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
        Optional<BatchOfProduct> batchOfProductGet = batchOfProductRepository.findById(2L);
        assertThat(batchOfProductGet.isPresent()).isTrue();
        assertThat(batchOfProductGet.get().getId()).isEqualTo(2L);
    }

    @Test
    public void update() {
        BatchOfProduct updateBatchOfProduct = new BatchOfProduct();
        updateBatchOfProduct.setCount(102);

        batchOfProductRepository.findById(2L)
                .map(batchOfProduct -> {
                    updateBatchOfProduct.setId(batchOfProduct.getId());
                    return batchOfProductRepository.save(updateBatchOfProduct);
                });

        Optional<BatchOfProduct> batchOfProduct = batchOfProductRepository.findById(2L);
        assertThat(batchOfProduct.isPresent()).isTrue();
        assertThat(batchOfProduct.get().getId()).isEqualTo(2L);
        assertThat(batchOfProduct.get().getCount()).isEqualTo(102);
    }

    @Test
    public void remove() {
        Optional<BatchOfProduct> batchOfProductGet = batchOfProductRepository.findById(2L);

        assertThat(batchOfProductGet.isPresent()).isTrue();
        assertThat(batchOfProductGet.get().getId()).isEqualTo(2L);
        batchOfProductRepository.deleteById(2L);

        Optional<BatchOfProduct> batchOfProductGetRemove = batchOfProductRepository.findById(2L);
        assertThat(batchOfProductGetRemove.isPresent()).isFalse();
    }

    @Test
    public void save() {
        BatchOfProduct batchOfProduct = new BatchOfProduct();
        batchOfProduct.setExpirationDateStart(LocalDateTime.of(2024, 12, 23,15, 30));
        batchOfProduct.setExpirationDateEnd(LocalDateTime.of(2024, 12, 27,15, 30));
        batchOfProduct.setIdProduct(3L);
        batchOfProduct.setCount(56);

        batchOfProductRepository.save(batchOfProduct);
        Optional<BatchOfProduct> batchOfProductGet = batchOfProductRepository.findById(4L);

        assertThat(batchOfProductGet.isPresent()).isTrue();
        assertThat(batchOfProductGet.get().getId()).isEqualTo(4L);
    }

    @Test
    public void findAll() {
        List<BatchOfProduct> batchOfProductsList = batchOfProductRepository.findAll();
        assertThat(batchOfProductsList).isNotEmpty();
    }
}