package com.edutech.classroom.dto;

import com.edutech.classroom.entity.Course;
import com.edutech.classroom.entity.CourseContent;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class CourseContentDTO {

    private Integer id;
    @NotNull(message = "El ID del curso es obligatorio")
    private Integer courseId;
    @NotNull(message = "El título es obligatorio")
    @Size(max = 255, message = "El título no puede superar los 255 caracteres")
    private String title;
    @NotNull(message = "El tipo de contenido es obligatorio")
    @Size(max = 50, message = "El tipo de contenido no puede superar los 50 caracteres")
    private String contentType;
    @NotNull(message = "La URL es obligatoria")
    @Size(max = 1000, message = "La URL no puede superar los 1000 caracteres")
    private String url;

    private Integer orderIndex;

    public static CourseContentDTO fromEntity(CourseContent entity) {
        CourseContentDTO dto = new CourseContentDTO();
        dto.setId(entity.getId());
        dto.setCourseId(entity.getCourse().getId());
        dto.setTitle(entity.getTitle());
        dto.setContentType(entity.getContentType());
        dto.setUrl(entity.getUrl());
        dto.setOrderIndex(entity.getOrderIndex());
        return dto;
    }

    public CourseContent toEntity() {
        CourseContent entity = new CourseContent();
        entity.setId(this.getId());

        Course course = new Course();
        course.setId(this.getCourseId());
        entity.setCourse(course);

        entity.setTitle(this.getTitle());
        entity.setContentType(this.getContentType());
        entity.setUrl(this.getUrl());
        entity.setOrderIndex(this.getOrderIndex());
        return entity;
    }
}
