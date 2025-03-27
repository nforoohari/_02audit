package ir.digixo.service;


import ir.digixo.dto.ProductDto;
import ir.digixo.dto.ProductResponse;
import ir.digixo.entity.Product;
import ir.digixo.exception.EntityNotFoundException;
import ir.digixo.repository.ProductRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

//lombok annotation
@Slf4j
//spring annotation
@Service
public class ProductService {

    @Autowired
    ProductRepository repository;

    //save all products in the db
    public void saveAll(final List<Product> products) {
        repository.saveAll(products);
    }

    //get all products from the db
    public List<ProductResponse> getAll() {
        log.info("Getting all products");
        return repository.findAll()
                .stream()
                .map(ProductResponse::from)
                .collect(Collectors.toList());
    }

    //get product by id from the db
    public Product getProduct(final Long id) throws EntityNotFoundException {
        log.info("Getting product id = {}", id);
        return repository.findById(id).orElseThrow(() ->
                new EntityNotFoundException(String.format("Product %s not found", id)));
    }

    public void createProduct(final ProductDto dto) throws EntityNotFoundException {


        final Product p = Product.builder()
                .name(dto.getProductName())
                .description(dto.getDescription())
                .price(dto.getPrice())
                .build();
        Product save = repository.save(p);
        log.info("creating product id = {}", save.getId());
    }

    //update product in the db
    public Product updateProduct(final Long id, final ProductDto dto) throws EntityNotFoundException {
        log.info("Updating product id = {}", id);
        getProduct(id);
        final Product p = Product.builder()
        		.id(id)
                .name(dto.getProductName())
                .description(dto.getDescription())
                .price(dto.getPrice())
                .build();
        Product updated = repository.save(p);
        return updated;
    }
}
