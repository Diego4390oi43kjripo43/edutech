package com.edutech.classroom;

import com.edutech.classroom.dto.QuizResponseDTO;
import com.edutech.classroom.entity.QuizResponse;
import com.edutech.classroom.exception.ResourceNotFoundException;
import com.edutech.classroom.repository.QuizResponseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class QuizResponseService {

    private final QuizResponseRepository repo;

    public List<QuizResponseDTO> findAll() {
        return repo.findAll().stream()
                .map(QuizResponseDTO::fromEntity)
                .toList();
    }

    public QuizResponseDTO findById(Integer id) {
        QuizResponse entity = repo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Respuesta de cuestionario no encontrada"));
        return QuizResponseDTO.fromEntity(entity);
    }

    public QuizResponseDTO create(QuizResponseDTO dto) {
        QuizResponse entity = dto.toEntity();
        QuizResponse saved = repo.save(entity);
        return QuizResponseDTO.fromEntity(saved);
    }

    public QuizResponseDTO update(Integer id, QuizResponseDTO dto) {
        QuizResponse existing = repo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Respuesta de cuestionario no encontrada"));
        QuizResponse updated = dto.toEntity();
        updated.setId(existing.getId());
        return QuizResponseDTO.fromEntity(repo.save(updated));
    }

    public void delete(Integer id) {
        QuizResponse entity = repo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Respuesta de cuestionario no encontrada"));
        repo.delete(entity);
    }
}