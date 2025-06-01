package com.edutech.classroom.dto;

import com.edutech.classroom.entity.CourseQuiz;
import com.edutech.classroom.entity.CourseQuizQuestion;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;
import org.hibernate.annotations.ColumnDefault;

import java.time.Instant;

@Data
public class CourseQuizQuestionDTO {
    private Integer id;
    private CourseQuiz quiz;
    private String questionText;
    private String optionA;
    private String optionB;
    private String optionC;
    private String optionD;
    private String optionE;
    private String correctAnswer;
    private String correctOption;
    private Integer orderIndex;
    private Instant createdAt;

    public static CourseQuizQuestionDTO fromEntity(CourseQuizQuestion entity) {
        CourseQuizQuestionDTO dto = new CourseQuizQuestionDTO();
        dto.setId(entity.getId());
        dto.setQuiz(entity.getQuiz());
        dto.setQuestionText(entity.getQuestionText());
        dto.setOptionA(entity.getOptionA());
        dto.setOptionB(entity.getOptionB());
        dto.setOptionC(entity.getOptionC());
        dto.setOptionD(entity.getOptionD());
        dto.setOptionE(entity.getOptionE());
        dto.setCorrectAnswer(entity.getCorrectAnswer());
        dto.setCorrectOption(entity.getCorrectOption());
        dto.setOrderIndex(entity.getOrderIndex());
        dto.setCreatedAt(entity.getCreatedAt());
        return dto;
    }

    public CourseQuizQuestion toEntity() {
        CourseQuizQuestion entity = new CourseQuizQuestion();
        entity.setId(this.getId());
        entity.setQuiz(this.getQuiz());
        entity.setQuestionText(this.getQuestionText());
        entity.setOptionA(this.getOptionA());
        entity.setOptionB(this.getOptionB());
        entity.setOptionC(this.getOptionC());
        entity.setOptionD(this.getOptionD());
        entity.setOptionE(this.getOptionE());
        entity.setCorrectAnswer(this.getCorrectAnswer());
        entity.setCorrectOption(this.getCorrectOption());
        entity.setOrderIndex(this.getOrderIndex());
        entity.setCreatedAt(this.getCreatedAt());
        return entity;
    }
}
