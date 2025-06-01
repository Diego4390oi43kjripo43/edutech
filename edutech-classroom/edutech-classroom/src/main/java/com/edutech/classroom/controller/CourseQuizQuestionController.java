package com.edutech.classroom.controller;

import com.edutech.classroom.CourseQuizQuestionService;
import com.edutech.classroom.dto.CourseQuizQuestionDTO;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/course-quiz-questions")
@RequiredArgsConstructor
public class CourseQuizQuestionController {

    private final CourseQuizQuestionService service;

    @GetMapping
    public ResponseEntity<List<CourseQuizQuestionDTO>> findAll() {
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<CourseQuizQuestionDTO> findById(@PathVariable Integer id) {
        return ResponseEntity.ok(service.findById(id));
    }

    @PostMapping
    public ResponseEntity<CourseQuizQuestionDTO> create(@RequestBody @Valid CourseQuizQuestionDTO dto) {
        CourseQuizQuestionDTO created = service.create(dto);
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(created.getId())
                .toUri();
        return ResponseEntity.created(location).body(created);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CourseQuizQuestionDTO> update(@PathVariable Integer id, @RequestBody @Valid CourseQuizQuestionDTO dto) {
        return ResponseEntity.ok(service.update(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}