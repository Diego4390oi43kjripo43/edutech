package com.edutech.classroom.dto;

import com.edutech.classroom.entity.Course;
import com.edutech.classroom.entity.CourseQuiz;
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
public class CourseQuizDTO {
    private Integer id;
    private Course course;
    private String title;
    private String description;
    private String quizType;
    private Instant createdAt;

    public static CourseQuizDTO fromEntity(CourseQuiz entity) {
        CourseQuizDTO dto = new CourseQuizDTO();
        dto.setId(entity.getId());
        dto.setCourse(entity.getCourse());
        dto.setTitle(entity.getTitle());
        dto.setDescription(entity.getDescription());
        dto.setQuizType(entity.getQuizType());
        dto.setCreatedAt(entity.getCreatedAt());
        return dto;
    }
    public CourseQuiz toEntity() {
        CourseQuiz entity = new CourseQuiz();
        entity.setId(this.id);
        entity.setCourse(this.course);
        entity.setTitle(this.title);
        entity.setDescription(this.description);
        entity.setQuizType(this.quizType);
        entity.setCreatedAt(this.createdAt);
        return entity;
    }
}
