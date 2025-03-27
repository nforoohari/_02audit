package ir.digixo.entity;

import ir.digixo.audit.Auditable;
import jakarta.persistence.*;
import lombok.*;

import org.hibernate.envers.Audited;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.math.BigDecimal;
import java.util.Date;

@Entity
@Getter
@Setter
@RequiredArgsConstructor
@NoArgsConstructor(force = true)
@AllArgsConstructor

@Builder
public class Product extends Auditable<String> {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NonNull
    private String name;
    @NonNull
    private String description;
    @NonNull
    private BigDecimal price;

    //





}
