package com.edutech.classroom.dto;

import com.edutech.classroom.entity.Course;
import com.edutech.classroom.entity.CourseComment;
import com.edutech.classroom.entity.User;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;
import org.hibernate.annotations.ColumnDefault;

import java.time.Instant;

@Data
public class CourseCommentDTO {
    private Integer id;
    private Integer courseId;
    private Integer userId;
    private String commentText;
    private Integer rating;
    private Instant createdAt;

    public static CourseCommentDTO fromEntity(CourseComment entity) {
        CourseCommentDTO dto = new CourseCommentDTO();
        dto.setId(entity.getId());
        dto.setCourseId(entity.getCourse().getId());
        dto.setUserId(entity.getUser().getId());
        dto.setCommentText(entity.getCommentText());
        dto.setRating(entity.getRating());
        dto.setCreatedAt(entity.getCreatedAt());
        return dto;
    }

    public CourseComment toEntity() {
        CourseComment entity = new CourseComment();
        entity.setId(this.getId());
        Course course = new Course();
        course.setId(this.getCourseId());
        entity.setCourse(course);
        User user = new User();
        user.setId(this.getUserId());
        entity.setUser(user);
        entity.setCommentText(this.getCommentText());
        entity.setRating(this.getRating());
        entity.setCreatedAt(this.getCreatedAt());
        return entity;
    }

}
