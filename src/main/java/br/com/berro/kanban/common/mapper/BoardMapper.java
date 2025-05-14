package br.com.berro.kanban.common.mapper;

import br.com.berro.kanban.core.domain.model.Board;
import br.com.berro.kanban.infrastructure.persistence.entity.BoardEntity;
import br.com.berro.kanban.interfaces.dto.BoardDTO;
import org.springframework.stereotype.Component;

@Component
public class BoardMapper {

    public static Board toModel(BoardEntity entity) {
        Board board = new Board();
        board.setId(entity.getId());
        board.setDescription(entity.getDescription());
        board.setName(entity.getName());
        board.setCreatedAt(entity.getCreatedAt());
        return board;
    }

    public static BoardEntity toEntity(Board board) {
        BoardEntity entity = new BoardEntity();
        entity.setId(board.getId());
        entity.setDescription(board.getDescription());
        entity.setName(board.getName());
        entity.setCreatedAt(board.getCreatedAt());
        return entity;
    }

    public static BoardDTO toDTO(Board board) {
        BoardDTO boardDTO = new BoardDTO();
        boardDTO.setId(board.getId());
        boardDTO.setDescription(board.getDescription());
        boardDTO.setName(board.getName());
        return boardDTO;
    }

    public static Board toModel(BoardDTO boardDTO) {
        Board board = new Board();
        board.setId(boardDTO.getId());
        board.setDescription(boardDTO.getDescription());
        board.setName(boardDTO.getName());
        return board;
    }
}
