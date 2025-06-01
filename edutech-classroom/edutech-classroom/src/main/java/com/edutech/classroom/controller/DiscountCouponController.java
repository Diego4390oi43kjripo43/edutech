package com.edutech.classroom.controller;

import com.edutech.classroom.DiscountCouponService;
import com.edutech.classroom.dto.DiscountCouponDTO;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/discount-coupons")
@RequiredArgsConstructor
public class DiscountCouponController {

    private final DiscountCouponService service;

    @GetMapping
    public ResponseEntity<List<DiscountCouponDTO>> findAll() {
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<DiscountCouponDTO> findById(@PathVariable Integer id) {
        return ResponseEntity.ok(service.findById(id));
    }

    @PostMapping
    public ResponseEntity<DiscountCouponDTO> create(@RequestBody @Valid DiscountCouponDTO dto) {
        DiscountCouponDTO created = service.create(dto);
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(created.getId())
                .toUri();
        return ResponseEntity.created(location).body(created);
    }

    @PutMapping("/{id}")
    public ResponseEntity<DiscountCouponDTO> update(@PathVariable Integer id, @RequestBody @Valid DiscountCouponDTO dto) {
        return ResponseEntity.ok(service.update(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}