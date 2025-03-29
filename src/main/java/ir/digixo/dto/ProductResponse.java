package ir.digixo.dto;

import java.math.BigDecimal;
import ir.digixo.entity.Product;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

//lombok annotations
@ToString
@Getter
@EqualsAndHashCode(callSuper = true)
public class ProductResponse extends ProductDto {

    String createdDate;
    String lastModifiedBy;
    String lastModifiedDate;

    private ProductResponse(
            final String productName,
            final String description,
            final BigDecimal price,
            final String createdDate,
            final String lastModifiedBy,
            final String lastModifiedDate) {

        super(productName, description, price);
        this.createdDate = createdDate;
        this.lastModifiedBy = lastModifiedBy;
        this.lastModifiedDate = lastModifiedDate;
    }

    public static ProductResponse from(final Product product) {
        return new ProductResponse(
                product.getName(),
                product.getDescription(),
                product.getPrice(),
                product.getCreatedDate().toString(),
                product.getLastModifiedBy(),
                product.getLastModifiedDate().toString());
    }
}
