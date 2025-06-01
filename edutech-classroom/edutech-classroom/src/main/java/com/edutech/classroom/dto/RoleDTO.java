package com.edutech.classroom.dto;

import com.edutech.classroom.entity.Role;
import jakarta.persistence.Column;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class RoleDTO {
    private Integer id;
    private String name;
    private String description;

    public static RoleDTO fromEntity(Role entity) {
        RoleDTO dto = new RoleDTO();
        dto.setId(entity.getId());
        dto.setName(entity.getName());
        dto.setDescription(entity.getDescription());
        return dto;
    }

    public Role toEntity() {
        Role entity = new Role();
        entity.setId(this.getId());
        entity.setName(this.getName());
        entity.setDescription(this.getDescription());
        return entity;
    }
}
