package com.edutech.classroom;

import com.edutech.classroom.dto.RoleDTO;
import com.edutech.classroom.entity.Role;
import com.edutech.classroom.exception.ResourceNotFoundException;
import com.edutech.classroom.repository.RoleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RoleService {

    private final RoleRepository repo;

    public List<RoleDTO> findAll() {
        return repo.findAll().stream()
                .map(RoleDTO::fromEntity)
                .toList();
    }

    public RoleDTO findById(Integer id) {
        Role entity = repo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Rol no encontrado"));
        return RoleDTO.fromEntity(entity);
    }

    public RoleDTO create(RoleDTO dto) {
        Role entity = dto.toEntity();
        Role saved = repo.save(entity);
        return RoleDTO.fromEntity(saved);
    }

    public RoleDTO update(Integer id, RoleDTO dto) {
        Role existing = repo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Rol no encontrado"));
        Role updated = dto.toEntity();
        updated.setId(existing.getId());
        return RoleDTO.fromEntity(repo.save(updated));
    }

    public void delete(Integer id) {
        Role entity = repo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Rol no encontrado"));
        repo.delete(entity);
    }
}
