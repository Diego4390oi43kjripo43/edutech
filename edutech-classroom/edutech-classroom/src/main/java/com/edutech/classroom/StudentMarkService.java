package com.edutech.classroom;

import com.edutech.classroom.dto.StudentMarkDTO;
import com.edutech.classroom.entity.StudentMark;
import com.edutech.classroom.exception.ResourceNotFoundException;
import com.edutech.classroom.repository.StudentMarkRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentMarkService {

    private final StudentMarkRepository repo;

    public List<StudentMarkDTO> findAll() {
        return repo.findAll().stream()
                .map(StudentMarkDTO::fromEntity)
                .toList();
    }

    public StudentMarkDTO findById(Integer id) {
        StudentMark entity = repo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Nota del estudiante no encontrada"));
        return StudentMarkDTO.fromEntity(entity);
    }

    public StudentMarkDTO create(StudentMarkDTO dto) {
        StudentMark entity = dto.toEntity();
        StudentMark saved = repo.save(entity);
        return StudentMarkDTO.fromEntity(saved);
    }

    public StudentMarkDTO update(Integer id, StudentMarkDTO dto) {
        StudentMark existing = repo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Nota del estudiante no encontrada"));
        StudentMark updated = dto.toEntity();
        updated.setId(existing.getId());
        return StudentMarkDTO.fromEntity(repo.save(updated));
    }

    public void delete(Integer id) {
        StudentMark entity = repo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Nota del estudiante no encontrada"));
        repo.delete(entity);
    }
}
