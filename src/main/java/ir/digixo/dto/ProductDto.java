package ir.digixo.dto;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NonNull;

import java.math.BigDecimal;

//lombok annotations
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
