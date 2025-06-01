package com.edutech.classroom;

import com.edutech.classroom.dto.EnrollmentDTO;
import com.edutech.classroom.entity.Course;
import com.edutech.classroom.entity.Enrollment;
import com.edutech.classroom.entity.Student;
import com.edutech.classroom.exception.ResourceNotFoundException;
import com.edutech.classroom.repository.EnrollmentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EnrollmentService {

    private final EnrollmentRepository repo;

    public List<EnrollmentDTO> findAll() {
        return repo.findAll().stream()
                .map(EnrollmentDTO::fromEntity)
                .toList();
    }

    public EnrollmentDTO findById(Integer id) {
        Enrollment entity = repo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Matrícula no encontrada"));
        return EnrollmentDTO.fromEntity(entity);
    }

    public EnrollmentDTO create(EnrollmentDTO dto) {
        Enrollment entity = dto.toEntity();
        Enrollment saved = repo.save(entity);
        return EnrollmentDTO.fromEntity(saved);
    }

    public EnrollmentDTO update(Integer id, EnrollmentDTO dto) {
        Enrollment existing = repo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Matrícula no encontrada"));
        Enrollment updated = dto.toEntity();
        updated.setId(existing.getId());
        return EnrollmentDTO.fromEntity(repo.save(updated));
    }

    public void delete(Integer id) {
        Enrollment entity = repo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Matrícula no encontrada"));
        repo.delete(entity);
    }
}