package br.com.berro.kanban.core.domain.model;

import java.time.LocalDateTime;
import java.util.UUID;

public class Board {

    private UUID id;
    private String name;
    private String description;
    private LocalDateTime createdAt = LocalDateTime.now();

    public Board() {}

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
}
