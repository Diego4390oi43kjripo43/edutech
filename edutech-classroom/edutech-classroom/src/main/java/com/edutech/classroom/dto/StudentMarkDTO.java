package com.edutech.classroom.dto;

import com.edutech.classroom.entity.CourseQuiz;
import com.edutech.classroom.entity.StudentMark;
import com.edutech.classroom.entity.User;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;
import org.hibernate.annotations.ColumnDefault;

import java.math.BigDecimal;
import java.time.Instant;

@Data
public class StudentMarkDTO {
    private Integer id;
    private CourseQuiz quiz;
    private User student;
    private BigDecimal mark;
    private String comments;
    private Instant gradedAt;

    public static StudentMarkDTO fromEntity(StudentMark entity) {
        StudentMarkDTO dto = new StudentMarkDTO();
        dto.setId(entity.getId());
        dto.setQuiz(entity.getQuiz());
        dto.setStudent(entity.getStudent());
        dto.setMark(entity.getMark());
        dto.setComments(entity.getComments());
        dto.setGradedAt(entity.getGradedAt());
        return dto;
    }

    public StudentMark toEntity() {
        StudentMark entity = new StudentMark();
        entity.setId(this.getId());
        entity.setQuiz(this.getQuiz());
        entity.setStudent(this.getStudent());
        entity.setMark(this.getMark());
        entity.setComments(this.getComments());
        entity.setGradedAt(this.getGradedAt());
        return entity;
    }
}
