package ir.digixo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;
import lombok.extern.slf4j.Slf4j;
import ir.digixo.dto.ProductDto;
import ir.digixo.dto.ProductResponse;
import ir.digixo.entity.Product;
import ir.digixo.repository.ProductRepository;
import ir.digixo.exception.EntityNotFoundException;

@Slf4j
@Service
public class ProductService {

    @Autowired
    ProductRepository repository;

    public void saveAll(final List<Product> products) {
        log.info("Saving all products");
        repository.saveAll(products);
    }

    public List<ProductResponse> getAll() {
        log.info("Getting all products");
        return repository.findAll()
                .stream()
                .map(ProductResponse::from)
                .collect(Collectors.toList());
    }

    public void saveProduct(final ProductDto dto) {

        final Product p = Product.builder()
                .name(dto.getProductName())
                .description(dto.getDescription())
                .price(dto.getPrice())
                .build();
        Product sp = repository.save(p);
        log.info("A product was created, id = {}", sp.getId());
    }

    public Product getProduct(final Long id) throws EntityNotFoundException {
        log.info("Getting product id = {}", id);
        return repository.findById(id).orElseThrow(() ->
                new EntityNotFoundException(String.format("Product %s not found", id)));
    }

    public Product updateProductV1(final Long id, final ProductDto dto) throws EntityNotFoundException {
        log.info("Updating(V1) product id = {}", id);
        getProduct(id);
        final Product p = Product.builder()
                .id(id)
                .name(dto.getProductName())
                .description(dto.getDescription())
                .price(dto.getPrice())
                .build();
        return repository.save(p);
    }

    public Product updateProductV2(final Long id, final ProductDto dto) throws EntityNotFoundException {
        log.info("Updating(V2) product id = {}", id);
        Product p = getProduct(id);
        p.setName(dto.getProductName());
        p.setDescription(dto.getDescription());
        p.setPrice(dto.getPrice());
        return repository.save(p);
    }
}
