package com.edutech.classroom;

import com.edutech.classroom.dto.SupportTicketDTO;
import com.edutech.classroom.entity.SupportTicket;
import com.edutech.classroom.exception.ResourceNotFoundException;
import com.edutech.classroom.repository.SupportTicketRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SupportTicketService {

    private final SupportTicketRepository repo;

    public List<SupportTicketDTO> findAll() {
        return repo.findAll().stream()
                .map(SupportTicketDTO::fromEntity)
                .toList();
    }

    public SupportTicketDTO findById(Integer id) {
        SupportTicket entity = repo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Ticket de soporte no encontrado"));
        return SupportTicketDTO.fromEntity(entity);
    }

    public SupportTicketDTO create(SupportTicketDTO dto) {
        SupportTicket entity = dto.toEntity();
        SupportTicket saved = repo.save(entity);
        return SupportTicketDTO.fromEntity(saved);
    }

    public SupportTicketDTO update(Integer id, SupportTicketDTO dto) {
        repo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Ticket de soporte no encontrado"));
        SupportTicket updated = dto.toEntity();
        updated.setId(id);
        return SupportTicketDTO.fromEntity(repo.save(updated));
    }

    public void delete(Integer id) {
        SupportTicket entity = repo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Ticket de soporte no encontrado"));
        repo.delete(entity);
    }
}