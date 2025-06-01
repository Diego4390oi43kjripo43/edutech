package com.edutech.classroom;

import com.edutech.classroom.dto.CourseDTO;
import com.edutech.classroom.entity.Course;
import com.edutech.classroom.exception.ResourceNotFoundException;
import com.edutech.classroom.repository.CourseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.StreamSupport;

@Service
@RequiredArgsConstructor
public class CourseService {

    private final CourseRepository repo;

    public List<CourseDTO> findAll() {
        return StreamSupport.stream(repo.findAll().spliterator(), false)
                .map(CourseDTO::fromEntity)
                .toList();
    }

    public CourseDTO findById(Integer id) {
        Course course = repo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Curso no encontrado"));
        return CourseDTO.fromEntity(course);
    }

    public CourseDTO create(CourseDTO dto) {
        Course course = dto.toEntity();
        return CourseDTO.fromEntity(repo.save(course));
    }

    public CourseDTO update(Integer id, CourseDTO dto) {
        repo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Curso no encontrado"));
        Course course = dto.toEntity();
        course.setId(id);
        return CourseDTO.fromEntity(repo.save(course));
    }

    public void delete(Integer id) {
        Course course = repo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Curso no encontrado"));
        repo.delete(course);
    }
}