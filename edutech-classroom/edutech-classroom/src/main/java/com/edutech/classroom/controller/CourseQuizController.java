package com.edutech.classroom.controller;

import com.edutech.classroom.CourseQuizService;
import com.edutech.classroom.dto.CourseQuizDTO;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/course-quizzes")
@RequiredArgsConstructor
public class CourseQuizController {

    private final CourseQuizService service;

    @GetMapping
    public ResponseEntity<List<CourseQuizDTO>> findAll() {
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<CourseQuizDTO> findById(@PathVariable Integer id) {
        return ResponseEntity.ok(service.findById(id));
    }

    @PostMapping
    public ResponseEntity<CourseQuizDTO> create(@RequestBody @Valid CourseQuizDTO dto) {
        CourseQuizDTO created = service.create(dto);
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(created.getId())
                .toUri();
        return ResponseEntity.created(location).body(created);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CourseQuizDTO> update(@PathVariable Integer id, @RequestBody @Valid CourseQuizDTO dto) {
        return ResponseEntity.ok(service.update(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}