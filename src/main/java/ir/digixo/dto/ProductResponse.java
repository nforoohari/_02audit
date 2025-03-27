package ir.digixo.dto;


import ir.digixo.entity.Product;
import lombok.EqualsAndHashCode;
import lombok.Getter;

import java.math.BigDecimal;

//lombok annotations
@Getter
@EqualsAndHashCode(callSuper = true)
public class ProductResponse extends ProductDto {

    String creationDate;
    String lastModifiedBy;
    String lastModifiedDate;

    private ProductResponse(
            final String productName,
            final String description,
            final BigDecimal price,
            final String creationDate,
            final String lastModifiedBy,
            final String lastModifiedDate) {

        super(productName, description, price);
        this.creationDate = creationDate;
        this.lastModifiedBy = lastModifiedBy;
        this.lastModifiedDate = lastModifiedDate;
    }

    public static ProductResponse from(final Product product) {
        return new ProductResponse(
                product.getName(),
                product.getDescription(),
                product.getPrice(),
                product.getCreationDate().toString(),
                product.getLastModifiedBy(),
                product.getLastModifiedDate().toString());
    }
}
