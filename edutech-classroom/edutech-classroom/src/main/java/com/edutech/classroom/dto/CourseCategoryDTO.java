package com.edutech.classroom.dto;

import com.edutech.classroom.entity.CourseCategory;
import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class CourseCategoryDTO {

    private Integer id;
    @NotNull(message = "El Nombre categoria no puede estar vacio")
    @Size(max=100, message = "el nombre de category no puede superar los 100 caracteres")
    private String name;
    private String description;

    public static CourseCategoryDTO fromEntity(CourseCategory entity) {
        CourseCategoryDTO dto = new CourseCategoryDTO();
        dto.setId(entity.getId());
        dto.setName(entity.getName());
        dto.setDescription(entity.getDescription());
        return dto;
    }

    public CourseCategory toEntity() {
        CourseCategory entity = new CourseCategory();
        entity.setId(this.getId());
        entity.setName(this.getName());
        entity.setDescription(this.getDescription());
        return entity;
    }
}
