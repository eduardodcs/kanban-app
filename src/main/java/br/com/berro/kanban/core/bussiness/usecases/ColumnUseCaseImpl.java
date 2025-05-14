package br.com.berro.kanban.core.bussiness.usecases;

import br.com.berro.kanban.common.exception.NotFoundBusinessException;
import br.com.berro.kanban.core.bussiness.interfaces.gateways.IBoardRepository;
import br.com.berro.kanban.core.bussiness.interfaces.gateways.IColumnRepository;
import br.com.berro.kanban.core.bussiness.interfaces.usecases.IColumnUseCase;
import br.com.berro.kanban.core.domain.model.Board;
import br.com.berro.kanban.core.domain.model.Column;

import java.util.List;
import java.util.Objects;
import java.util.UUID;

public class ColumnUseCaseImpl implements IColumnUseCase {

    private final IColumnRepository columnRepository;
    private final IBoardRepository boardRepository;

    public ColumnUseCaseImpl(IColumnRepository columnRepository, IBoardRepository boardRepository) {
        this.columnRepository = columnRepository;
        this.boardRepository = boardRepository;
    }

    @Override
    public Column save(Column column) {
        boardValidate(column.getBoardId());
        column.setId(UUID.randomUUID());
        return columnRepository.save(column);
    }

    @Override
    public List<Column> findByBoardId(UUID boardId) {
        boardValidate(boardId);
        return columnRepository.findByBoardId(boardId);
    }

    @Override
    public Column findById(UUID id) {
        Column column = columnRepository.findById(id);
        if (Objects.isNull(column)) {
            throw new NotFoundBusinessException("Column not found");
        }
        return column;
    }

    @Override
    public void deleteById(UUID id) {
        findById(id);
        columnRepository.deleteById(id);
    }

    @Override
    public Column update(Column updateColumn) {
        boardValidate(updateColumn.getBoardId());
        Column originColumn = findById(updateColumn.getId());
        originColumn.setName(updateColumn.getName());
        originColumn.setBoardId(updateColumn.getBoardId());
        originColumn.setPosition(updateColumn.getPosition());
        return columnRepository.save(originColumn);
    }

    private void boardValidate(UUID boardId) {
        Board board = boardRepository.findById(boardId);
        if (Objects.isNull(board)) {
            throw new NotFoundBusinessException("Board Not Found");
        }
    }

}
