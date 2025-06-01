package com.edutech.classroom;

import com.edutech.classroom.dto.DiscountCouponDTO;
import com.edutech.classroom.entity.DiscountCoupon;
import com.edutech.classroom.exception.ResourceNotFoundException;
import com.edutech.classroom.repository.DiscountCouponRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DiscountCouponService {

    private final DiscountCouponRepository repo;

    public List<DiscountCouponDTO> findAll() {
        return repo.findAll().stream()
                .map(DiscountCouponDTO::fromEntity)
                .toList();
    }

    public DiscountCouponDTO findById(Integer id) {
        DiscountCoupon entity = repo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Cupón no encontrado"));
        return DiscountCouponDTO.fromEntity(entity);
    }

    public DiscountCouponDTO create(DiscountCouponDTO dto) {
        DiscountCoupon entity = dto.toEntity();
        DiscountCoupon saved = repo.save(entity);
        return DiscountCouponDTO.fromEntity(saved);
    }

    public DiscountCouponDTO update(Integer id, DiscountCouponDTO dto) {
        DiscountCoupon existing = repo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Cupón no encontrado"));
        DiscountCoupon updated = dto.toEntity();
        updated.setId(existing.getId());
        return DiscountCouponDTO.fromEntity(repo.save(updated));
    }

    public void delete(Integer id) {
        DiscountCoupon entity = repo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Cupón no encontrado"));
        repo.delete(entity);
    }
}