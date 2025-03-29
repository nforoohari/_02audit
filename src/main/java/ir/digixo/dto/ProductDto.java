package ir.digixo.dto;

import lombok.*;

import java.math.BigDecimal;

//lombok annotations
@ToString
@Getter
@AllArgsConstructor
@EqualsAndHashCode
public class ProductDto {

    @NonNull
    String productName;
    @NonNull
    String description;
    @NonNull
    BigDecimal price;
}
