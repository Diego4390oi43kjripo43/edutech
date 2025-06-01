package com.edutech.classroom;

import com.edutech.classroom.dto.CourseCategoryDTO;
import com.edutech.classroom.entity.CourseCategory;
import com.edutech.classroom.exception.ResourceNotFoundException;
import com.edutech.classroom.repository.CourseCategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.stream.Collectors;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CourseCategoryService {

    private final CourseCategoryRepository repo;

    public List<CourseCategoryDTO> findAll() {
        return repo.findAll().stream()
                .map(CourseCategoryDTO::fromEntity)
                .collect(Collectors.toList());
    }

    public CourseCategoryDTO findById(Integer id) {
        CourseCategory category = repo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Categoría no encontrada"));
        return CourseCategoryDTO.fromEntity(category);
    }

    public CourseCategoryDTO create(CourseCategoryDTO dto) {
        CourseCategory saved = repo.save(dto.toEntity());
        return CourseCategoryDTO.fromEntity(saved);
    }

    public CourseCategoryDTO update(Integer id, CourseCategoryDTO dto) {
        repo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Categoría no encontrada"));
        CourseCategory entity = dto.toEntity();
        entity.setId(id);
        return CourseCategoryDTO.fromEntity(repo.save(entity));
    }

    public void delete(Integer id) {
        CourseCategory entity = repo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Categoría no encontrada"));
        repo.delete(entity);
    }

}
