package org.senla.model;

import jakarta.validation.constraints.NotNull;
import org.springframework.format.annotation.DateTimeFormat;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name = "price_dynamics")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PriceDynamics {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "id_shop", nullable = false)
    @NotNull
    private Long idShop;

    @Column(name = "id_batch", nullable = false)
    @NotNull
    private Long idBatch;

    @Column(nullable = false)
    @NotNull
    private Float price;

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    @Column(nullable = false)
    @NotNull
    private LocalDateTime date;
}
