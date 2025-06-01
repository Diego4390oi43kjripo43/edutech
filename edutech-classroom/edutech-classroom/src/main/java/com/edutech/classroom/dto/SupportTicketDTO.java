package com.edutech.classroom.dto;

import com.edutech.classroom.entity.SupportTicket;
import com.edutech.classroom.entity.User;
import jakarta.persistence.Column;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;
import org.hibernate.annotations.ColumnDefault;

import java.time.Instant;

@Data
public class SupportTicketDTO {
    private Integer id;
    private User user;
    private User supportUser;
    private String subject;
    private String description;
    private String status;
    private Instant createdAt;
    private Instant closedAt;

    public static SupportTicketDTO fromEntity(SupportTicket entity) {
        SupportTicketDTO dto = new SupportTicketDTO();
        dto.setId(entity.getId());
        dto.setUser(entity.getUser());
        dto.setSupportUser(entity.getSupportUser());
        dto.setSubject(entity.getSubject());
        dto.setDescription(entity.getDescription());
        dto.setStatus(entity.getStatus());
        dto.setCreatedAt(entity.getCreatedAt());
        dto.setClosedAt(entity.getClosedAt());
        return dto;
    }

    public SupportTicket toEntity() {
        SupportTicket entity = new SupportTicket();
        entity.setId(this.getId());
        entity.setUser(this.getUser());
        entity.setSupportUser(this.getSupportUser());
        entity.setSubject(this.getSubject());
        entity.setDescription(this.getDescription());
        entity.setStatus(this.getStatus());
        entity.setCreatedAt(this.getCreatedAt());
        entity.setClosedAt(this.getClosedAt());
        return entity;
    }
}
