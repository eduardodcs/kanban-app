package br.com.berro.kanban.interfaces.dto;

import jakarta.validation.constraints.NotBlank;

import java.util.UUID;

public class BoardDTO {
    private UUID id;
    @NotBlank
    private String name;
    private String description;

    public BoardDTO() {}

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
}
