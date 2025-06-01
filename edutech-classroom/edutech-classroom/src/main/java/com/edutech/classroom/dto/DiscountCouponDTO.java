package com.edutech.classroom.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import com.edutech.classroom.entity.DiscountCoupon;
import jakarta.validation.constraints.*;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
public class DiscountCouponDTO{
    private Integer id;

    @NotNull(message = "El código del cupón no puede estar vacío")
    @Size(max = 50, message = "El código del cupón no puede superar los 50 caracteres")
    private String code;

    @Size(max = 255, message = "La descripción no puede superar los 255 caracteres")
    private String description;

    @NotNull(message = "El porcentaje de descuento es obligatorio")
    @DecimalMin(value = "0.0", inclusive = false, message = "El descuento debe ser mayor que 0")
    @DecimalMax(value = "100.0", message = "El descuento no puede ser mayor a 100")
    private BigDecimal discountPercentage;

    @NotNull(message = "La fecha de inicio es obligatoria")
    private LocalDate validFrom;

    @NotNull(message = "La fecha de fin es obligatoria")
    private LocalDate validUntil;

    private Boolean isActive = false;

    public static DiscountCouponDTO fromEntity(DiscountCoupon entity) {
        DiscountCouponDTO dto = new DiscountCouponDTO();
        dto.setId(entity.getId());
        dto.setCode(entity.getCode());
        dto.setDescription(entity.getDescription());
        dto.setDiscountPercentage(entity.getDiscountPercentage());
        dto.setValidFrom(entity.getValidFrom());
        dto.setValidUntil(entity.getValidUntil());
        dto.setIsActive(entity.getIsActive());
        return dto;
    }

    public DiscountCoupon toEntity() {
        DiscountCoupon entity = new DiscountCoupon();
        entity.setId(this.getId());
        entity.setCode(this.getCode());
        entity.setDescription(this.getDescription());
        entity.setDiscountPercentage(this.getDiscountPercentage());
        entity.setValidFrom(this.getValidFrom());
        entity.setValidUntil(this.getValidUntil());
        entity.setIsActive(this.getIsActive());
        return entity;
    }
}

