package com.edutech.classroom;

import com.edutech.classroom.dto.CourseQuizQuestionDTO;
import com.edutech.classroom.entity.CourseQuizQuestion;
import com.edutech.classroom.exception.ResourceNotFoundException;
import com.edutech.classroom.repository.CourseQuizQuestionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CourseQuizQuestionService {

    private final CourseQuizQuestionRepository repo;

    public List<CourseQuizQuestionDTO> findAll() {
        return repo.findAll().stream()
                .map(CourseQuizQuestionDTO::fromEntity)
                .toList();
    }

    public CourseQuizQuestionDTO findById(Integer id) {
        CourseQuizQuestion question = repo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Pregunta del quiz no encontrada"));
        return CourseQuizQuestionDTO.fromEntity(question);
    }

    public CourseQuizQuestionDTO create(CourseQuizQuestionDTO dto) {
        CourseQuizQuestion saved = repo.save(dto.toEntity());
        return CourseQuizQuestionDTO.fromEntity(saved);
    }

    public CourseQuizQuestionDTO update(Integer id, CourseQuizQuestionDTO dto) {
        repo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Pregunta del quiz no encontrada"));
        CourseQuizQuestion entity = dto.toEntity();
        entity.setId(id);
        return CourseQuizQuestionDTO.fromEntity(repo.save(entity));
    }

    public void delete(Integer id) {
        CourseQuizQuestion entity = repo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Pregunta del quiz no encontrada"));
        repo.delete(entity);
    }
}
