package com.edutech.classroom.dto;

import com.edutech.classroom.entity.Course;
import com.edutech.classroom.entity.Enrollment;
import com.edutech.classroom.entity.User;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.time.Instant;

@Data
public class EnrollmentDTO {
    private Integer id;
    @NotNull(message = "El ID del estudiante es obligatorio")
    private Integer studentId;
    @NotNull(message = "El ID del curso es obligatorio")
    private Integer courseId;
    private Instant enrolledAt;
    @Size(max = 20, message = "El estado no debe superar los 20 caracteres")
    private String status;

    public static EnrollmentDTO fromEntity(Enrollment enrollment) {
        EnrollmentDTO dto = new EnrollmentDTO();
        dto.setId(enrollment.getId());
        dto.setStudentId(enrollment.getStudent().getId());
        dto.setCourseId(enrollment.getCourse().getId());
        dto.setEnrolledAt(enrollment.getEnrolledAt());
        dto.setStatus(enrollment.getStatus());
        return dto;
    }

    public Enrollment toEntity() {
        Enrollment entity = new Enrollment();
        entity.setId(this.getId());

        User student = new User();
        student.setId(this.getStudentId());
        entity.setStudent(student);

        Course course = new Course();
        course.setId(this.getCourseId());
        entity.setCourse(course);

        entity.setEnrolledAt(this.getEnrolledAt());
        entity.setStatus(this.getStatus());
        return entity;
    }
}