package com.edutech.classroom;

import com.edutech.classroom.dto.PaymentDTO;
import com.edutech.classroom.entity.Payment;
import com.edutech.classroom.exception.ResourceNotFoundException;
import com.edutech.classroom.repository.PaymentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PaymentService {

    private final PaymentRepository repo;

    public List<PaymentDTO> findAll() {
        return repo.findAll().stream()
                .map(PaymentDTO::fromEntity)
                .toList();
    }

    public PaymentDTO findById(Integer id) {
        Payment entity = repo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Pago no encontrado"));
        return PaymentDTO.fromEntity(entity);
    }

    public PaymentDTO create(PaymentDTO dto) {
        Payment entity = dto.toEntity();
        Payment saved = repo.save(entity);
        return PaymentDTO.fromEntity(saved);
    }

    public PaymentDTO update(Integer id, PaymentDTO dto) {
        Payment existing = repo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Pago no encontrado"));
        Payment updated = dto.toEntity();
        updated.setId(existing.getId());
        return PaymentDTO.fromEntity(repo.save(updated));
    }

    public void delete(Integer id) {
        Payment entity = repo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Pago no encontrado"));
        repo.delete(entity);
    }
}