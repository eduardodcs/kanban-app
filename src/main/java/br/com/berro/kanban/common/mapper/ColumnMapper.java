package br.com.berro.kanban.common.mapper;

import br.com.berro.kanban.core.domain.model.Column;
import br.com.berro.kanban.infrastructure.persistence.entity.BoardEntity;
import br.com.berro.kanban.infrastructure.persistence.entity.ColumnEntity;
import br.com.berro.kanban.interfaces.dto.ColumnDTO;
import org.springframework.stereotype.Component;

@Component
public class ColumnMapper {

    public static ColumnDTO toDTO(Column model) {
        ColumnDTO dto = new ColumnDTO();
        dto.setId(model.getId());
        dto.setName(model.getName());
        dto.setPosition(model.getPosition());
        dto.setBoardId(model.getBoardId());
        return dto;
    }

    public static Column toModel(ColumnDTO dto) {
        Column model = new Column();
        model.setId(dto.getId());
        model.setName(dto.getName());
        model.setPosition(dto.getPosition());
        model.setBoardId(dto.getBoardId());
        return model;
    }

    public static ColumnEntity toEntity(Column model) {
        ColumnEntity entity = new ColumnEntity();
        entity.setId(model.getId());
        entity.setName(model.getName());
        entity.setPosition(model.getPosition());
        entity.setCreatedAt(model.getCreatedAt());

        BoardEntity board = new BoardEntity();
        board.setId(model.getBoardId());
        entity.setBoard(board);

        return entity;
    }

    public static Column toModel(ColumnEntity entity) {
        Column model = new Column();
        model.setId(entity.getId());
        model.setName(entity.getName());
        model.setPosition(entity.getPosition());
        model.setBoardId(entity.getBoard().getId());
        model.setCreatedAt(entity.getCreatedAt());
        return model;
    }
}
