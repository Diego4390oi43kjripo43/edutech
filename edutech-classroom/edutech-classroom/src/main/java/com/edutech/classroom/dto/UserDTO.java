package com.edutech.classroom.dto;

import com.edutech.classroom.entity.Role;
import com.edutech.classroom.entity.User;
import jakarta.persistence.Column;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;
import org.hibernate.annotations.ColumnDefault;

import java.time.Instant;

@Data
public class UserDTO {
    private Integer id;
    private String firstName;
    private String lastName;
    private String email;
    private String passwordHash;
    private Role role;
    private Boolean isActive = false;
    private Instant createdAt;
    private Instant updatedAt;

    public static UserDTO fromEntity(User entity) {
        UserDTO dto = new UserDTO();
        dto.setId(entity.getId());
        dto.setFirstName(entity.getFirstName());
        dto.setLastName(entity.getLastName());
        dto.setEmail(entity.getEmail());
        dto.setPasswordHash(entity.getPasswordHash());
        dto.setRole(entity.getRole());
        dto.setIsActive(entity.getIsActive());
        dto.setCreatedAt(entity.getCreatedAt());
        dto.setUpdatedAt(entity.getUpdatedAt());
        return dto;
    }

    public User toEntity() {
        User entity = new User();
        entity.setId(this.getId());
        entity.setFirstName(this.getFirstName());
        entity.setLastName(this.getLastName());
        entity.setEmail(this.getEmail());
        entity.setPasswordHash(this.getPasswordHash());
        entity.setRole(this.getRole());
        entity.setIsActive(this.getIsActive());
        entity.setCreatedAt(this.getCreatedAt());
        entity.setUpdatedAt(this.getUpdatedAt());
        return entity;
    }
}
