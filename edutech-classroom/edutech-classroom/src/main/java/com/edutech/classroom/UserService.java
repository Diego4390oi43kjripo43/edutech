package com.edutech.classroom;

import com.edutech.classroom.dto.UserDTO;
import com.edutech.classroom.entity.User;
import com.edutech.classroom.exception.ResourceNotFoundException;
import com.edutech.classroom.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository repo;

    public List<UserDTO> findAll() {
        return repo.findAll().stream()
                .map(UserDTO::fromEntity)
                .toList();
    }

    public UserDTO findById(Integer id) {
        User entity = repo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Usuario no encontrado"));
        return UserDTO.fromEntity(entity);
    }

    public UserDTO create(UserDTO dto) {
        User entity = dto.toEntity();
        User saved = repo.save(entity);
        return UserDTO.fromEntity(saved);
    }

    public UserDTO update(Integer id, UserDTO dto) {
        repo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Usuario no encontrado"));
        User updated = dto.toEntity();
        updated.setId(id);
        return UserDTO.fromEntity(repo.save(updated));
    }

    public void delete(Integer id) {
        User entity = repo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Usuario no encontrado"));
        repo.delete(entity);
    }
}