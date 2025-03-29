package ir.digixo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ir.digixo.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
