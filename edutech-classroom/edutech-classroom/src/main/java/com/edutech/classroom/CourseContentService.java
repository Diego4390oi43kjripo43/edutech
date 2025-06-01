package com.edutech.classroom;

import com.edutech.classroom.dto.CourseContentDTO;
import com.edutech.classroom.entity.CourseContent;
import com.edutech.classroom.exception.ResourceNotFoundException;
import com.edutech.classroom.repository.CourseContentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CourseContentService {

    private final CourseContentRepository repo;

    public List<CourseContentDTO> findAll() {
        return repo.findAll().stream()
                .map(CourseContentDTO::fromEntity)
                .toList();
    }

    public CourseContentDTO findById(Integer id) {
        CourseContent content = repo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Contenido del curso no encontrado"));
        return CourseContentDTO.fromEntity(content);
    }

    public CourseContentDTO create(CourseContentDTO dto) {
        CourseContent saved = repo.save(dto.toEntity());
        return CourseContentDTO.fromEntity(saved);
    }

    public CourseContentDTO update(Integer id, CourseContentDTO dto) {
        repo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Contenido del curso no encontrado"));
        CourseContent entity = dto.toEntity();
        entity.setId(id);
        return CourseContentDTO.fromEntity(repo.save(entity));
    }

    public void delete(Integer id) {
        CourseContent entity = repo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Contenido del curso no encontrado"));
        repo.delete(entity);
    }
}
