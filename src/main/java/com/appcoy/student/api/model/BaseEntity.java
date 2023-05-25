package com.appcoy.student.api.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.time.LocalDate;

@MappedSuperclass
@Getter
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
public class BaseEntity<T> {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "entity_sequence")
    @SequenceGenerator(name = "entity_sequence", sequenceName = "entity_sequence_name", allocationSize = 1)
    private Long id;
    private LocalDate dateCreated;
    private LocalDate dateModified;
    private Boolean isSoftDeleted;

    @PrePersist
    private void prePersist() {
        this.dateCreated = LocalDate.now();
        this.dateModified = LocalDate.now();
        this.isSoftDeleted = false;
    }

    @PreUpdate
    private void preUpdate() {
        this.dateModified = LocalDate.now();
    }
}
