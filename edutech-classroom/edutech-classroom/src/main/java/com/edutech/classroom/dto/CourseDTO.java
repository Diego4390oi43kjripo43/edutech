package com.edutech.classroom.dto;

import com.edutech.classroom.entity.Course;
import com.edutech.classroom.entity.CourseCategory;
import com.edutech.classroom.entity.User;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
public class CourseDTO {
    private Integer id;
    private String title;
    private String description;
    private CourseCategory category;
    private Integer managerId;
    private Integer instructorId;
    private LocalDate publishDate;
    private BigDecimal price;
    private String image;
    private String status;

    public static CourseDTO fromEntity(Course entity) {
        CourseDTO dto = new CourseDTO();
        dto.setId(entity.getId());
        dto.setTitle(entity.getTitle());
        dto.setDescription(entity.getDescription());
        dto.setCategory(entity.getCategory());
        dto.setManagerId(entity.getManager() != null ? entity.getManager().getId() : null);
        dto.setInstructorId(entity.getInstructor() != null ? entity.getInstructor().getId() : null);
        dto.setPublishDate(entity.getPublishDate());
        dto.setPrice(entity.getPrice());
        dto.setImage(entity.getImage());
        dto.setStatus(entity.getStatus());
        return dto;
    }

    public Course toEntity() {
        Course entity = new Course();
        entity.setId(this.id);
        entity.setTitle(this.title);
        entity.setDescription(this.description);
        entity.setCategory(this.category);

        if (this.managerId != null) {
            User manager = new User();
            manager.setId(this.managerId);
            entity.setManager(manager);
        }

        if (this.instructorId != null) {
            User instructor = new User();
            instructor.setId(this.instructorId);
            entity.setInstructor(instructor);
        }

        entity.setPublishDate(this.publishDate);
        entity.setPrice(this.price);
        entity.setImage(this.image);
        entity.setStatus(this.status);
        return entity;
    }
}
