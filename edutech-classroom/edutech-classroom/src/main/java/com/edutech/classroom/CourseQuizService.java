package com.edutech.classroom;

import com.edutech.classroom.dto.CourseQuizDTO;
import com.edutech.classroom.entity.CourseQuiz;
import com.edutech.classroom.exception.ResourceNotFoundException;
import com.edutech.classroom.repository.CourseQuizRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CourseQuizService {

    private final CourseQuizRepository repo;

    public List<CourseQuizDTO> findAll() {
        return repo.findAll().stream().map(CourseQuizDTO::fromEntity).toList();
    }

    public CourseQuizDTO findById(Integer id) {
        CourseQuiz entity = repo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Quiz no encontrado"));
        return CourseQuizDTO.fromEntity(entity);
    }

    public CourseQuizDTO create(CourseQuizDTO dto) {
        CourseQuiz entity = dto.toEntity();
        return CourseQuizDTO.fromEntity(repo.save(entity));
    }

    public CourseQuizDTO update(Integer id, CourseQuizDTO dto) {
        repo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Quiz no encontrado"));
        CourseQuiz entity = dto.toEntity();
        entity.setId(id);
        return CourseQuizDTO.fromEntity(repo.save(entity));
    }

    public void delete(Integer id) {
        CourseQuiz entity = repo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Quiz no encontrado"));
        repo.delete(entity);
    }
}