package org.senla.service.impl;

import com.fasterxml.jackson.databind.MappingIterator;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;
import lombok.RequiredArgsConstructor;
import org.senla.exception.NotFoundResourceException;
import org.senla.model.Product;
import org.senla.model.dto.ProductCreationDTO;
import org.senla.model.mapper.ProductMapper;
import org.senla.repository.ProductRepository;
import org.senla.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.apache.commons.codec.binary.Base64;

import static java.util.stream.Collectors.toList;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;
    private final ProductMapper productMapper;

    @Override
    public Product save(Product product) {
        return productRepository.save(product);
    }

    @Override
    public List<Product> saveCSV(String fileName) throws IOException {
        Reader myReader = new FileReader(new String(Base64.decodeBase64(fileName)));
        CsvMapper mapper = new CsvMapper();
        CsvSchema schema = mapper.schemaFor(ProductCreationDTO.class)
                .withColumnSeparator(';').withSkipFirstDataRow(true);
        MappingIterator<ProductCreationDTO> iterator = mapper
                .readerFor(ProductCreationDTO.class)
                .with(schema)
                .readValues(myReader);

        return productRepository.saveAll(iterator.readAll()
                .stream()
                .map(productMapper::toProduct)
                .collect(toList()));
    }

    @Override
    public void remove(Long id) {
        Optional<Product> data = productRepository.findById(id);
        if(!data.isPresent()) {
            throw new NotFoundResourceException("Not found product on ID="+id);
        }
        productRepository.deleteById(id);
    }

    @Override
    public Optional<Product> getById(Long id) {
        Optional<Product> data = productRepository.findById(id);
        if(!data.isPresent()) {
            throw new NotFoundResourceException("Not found product on ID="+id);
        }
        return data;
    }

    @Override
    public List<Product> getByName(String name) {
        return productRepository.findByName(name);
    }

    @Override
    public List<Product> getAll() {
        return new ArrayList<>(productRepository.findAll());
    }

    @Override
    public Optional<Product> update(Product updateProduct, Long id) {
        Optional<Product> data = productRepository.findById(id);
        if(!data.isPresent()) {
            throw new NotFoundResourceException("Not found product on ID="+id);
        }
        return data
                .map(product -> {
                    updateProduct.setId(product.getId());
                    return productRepository.save(updateProduct);
                });
    }

    @Override
    public List<Product> findByCategory(String category) {
        return productRepository.findByCategory(category);
    }
}