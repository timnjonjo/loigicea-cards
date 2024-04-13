package com.timnjonjo.cards.persistence;

import jakarta.persistence.Column;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@Getter
@Setter
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public abstract class CustomAuditable {
    @CreatedDate
    private LocalDateTime createdAt;
    @CreatedBy
    private User createdBy;
    @LastModifiedBy
    private User updatedBy;
    @LastModifiedDate
    private LocalDateTime updatedAt;

    private User deletedBy;
    private LocalDateTime deletedAt;

    public void delete() {
        this.deletedBy = this.updatedBy;
        this.deletedAt = LocalDateTime.now();
    }
}
