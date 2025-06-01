package com.edutech.classroom.dto;

import com.edutech.classroom.entity.Payment;
import com.edutech.classroom.entity.User;
import jakarta.persistence.Column;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;
import org.hibernate.annotations.ColumnDefault;

import java.math.BigDecimal;
import java.time.Instant;

@Data
public class PaymentDTO {
    private Integer id;
    private User user;
    private BigDecimal amount;
    private Instant paymentDate;
    private String paymentMethod;
    private String paymentInstitution;
    private String transactionId;
    private String status;

    public static PaymentDTO fromEntity(Payment entity) {
        PaymentDTO dto = new PaymentDTO();
        dto.setId(entity.getId());
        dto.setUser(entity.getUser());
        dto.setAmount(entity.getAmount());
        dto.setPaymentDate(entity.getPaymentDate());
        dto.setPaymentMethod(entity.getPaymentMethod());
        dto.setPaymentInstitution(entity.getPaymentInstitution());
        dto.setTransactionId(entity.getTransactionId());
        dto.setStatus(entity.getStatus());
        return dto;
    }


    public Payment toEntity() {
        Payment entity = new Payment();
        entity.setId(this.getId());
        entity.setUser(this.getUser());
        entity.setAmount(this.getAmount());
        entity.setPaymentDate(this.getPaymentDate());
        entity.setPaymentMethod(this.getPaymentMethod());
        entity.setPaymentInstitution(this.getPaymentInstitution());
        entity.setTransactionId(this.getTransactionId());
        entity.setStatus(this.getStatus());
        return entity;
    }

}
