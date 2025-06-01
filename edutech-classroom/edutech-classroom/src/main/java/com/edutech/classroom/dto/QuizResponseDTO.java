package com.edutech.classroom.dto;

import com.edutech.classroom.entity.CourseQuiz;
import com.edutech.classroom.entity.QuizResponse;
import com.edutech.classroom.entity.User;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;
import org.hibernate.annotations.ColumnDefault;

import java.time.Instant;

@Data
public class QuizResponseDTO {

    private Integer id;
    private CourseQuiz quiz;
    private User student;
    private String selectedOption;
    private String responseContent;
    private String assignmentUrl;
    private Instant submittedAt;

    public static QuizResponseDTO fromEntity(QuizResponse entity) {
        QuizResponseDTO dto = new QuizResponseDTO();
        dto.setId(entity.getId());
        dto.setQuiz(entity.getQuiz());
        dto.setStudent(entity.getStudent());
        dto.setSelectedOption(entity.getSelectedOption());
        dto.setResponseContent(entity.getResponseContent());
        dto.setAssignmentUrl(entity.getAssignmentUrl());
        dto.setSubmittedAt(entity.getSubmittedAt());
        return dto;
    }

    public QuizResponse toEntity() {
        QuizResponse entity = new QuizResponse();
        entity.setId(this.getId());
        entity.setQuiz(this.getQuiz());
        entity.setStudent(this.getStudent());
        entity.setSelectedOption(this.getSelectedOption());
        entity.setResponseContent(this.getResponseContent());
        entity.setAssignmentUrl(this.getAssignmentUrl());
        entity.setSubmittedAt(this.getSubmittedAt());
        return entity;
    }
}
