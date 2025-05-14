package br.com.berro.kanban.interfaces.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.springframework.format.annotation.NumberFormat;

import java.util.UUID;

public class ColumnDTO {
    private UUID id;
    @NotBlank
    private String name;
    @NotNull
    @NumberFormat
    private Integer position;
    @org.hibernate.validator.constraints.UUID
    private UUID boardId;

    public ColumnDTO() {}

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

    public Integer getPosition() {
        return position;
    }

    public void setPosition(Integer position) {
        this.position = position;
    }

    public UUID getBoardId() {
        return boardId;
    }

    public void setBoardId(UUID boardId) {
        this.boardId = boardId;
    }
}
