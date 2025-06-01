package com.edutech.classroom;

import com.edutech.classroom.dto.CourseCommentDTO;
import com.edutech.classroom.entity.CourseComment;
import com.edutech.classroom.exception.ResourceNotFoundException;
import com.edutech.classroom.repository.CourseCommentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CourseCommentService {

    private final CourseCommentRepository repo;

    public List<CourseCommentDTO> findAll() {
        return repo.findAll().stream()
                .map(CourseCommentDTO::fromEntity)
                .toList();
    }

    public CourseCommentDTO findById(Integer id) {
        CourseComment comment = repo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Comentario no encontrado"));
        return CourseCommentDTO.fromEntity(comment);
    }

    public CourseCommentDTO create(CourseCommentDTO dto) {
        CourseComment saved = repo.save(dto.toEntity());
        return CourseCommentDTO.fromEntity(saved);
    }

    public CourseCommentDTO update(Integer id, CourseCommentDTO dto) {
        repo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Comentario no encontrado"));
        CourseComment entity = dto.toEntity();
        entity.setId(id);
        return CourseCommentDTO.fromEntity(repo.save(entity));
    }

    public void delete(Integer id) {
        CourseComment entity = repo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Comentario no encontrado"));
        repo.delete(entity);
    }
}
