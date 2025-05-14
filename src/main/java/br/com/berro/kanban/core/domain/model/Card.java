package br.com.berro.kanban.core.domain.model;

import java.time.LocalDateTime;
import java.util.UUID;

public class Card {

    private UUID id;
    private String name;
    private String description;
    private Integer position;
    private LocalDateTime createdAt;
    private UUID columnId;

    public Card() {}

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

    public Integer getPosition() {
        return position;
    }

    public void setPosition(Integer position) {
        this.position = position;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public UUID getColumnId() {
        return columnId;
    }

    public void setColumnId(UUID columnId) {
        this.columnId = columnId;
    }
}
