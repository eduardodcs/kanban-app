package br.com.berro.kanban.core.bussiness.usecases;

import br.com.berro.kanban.common.exception.NotFoundBusinessException;
import br.com.berro.kanban.core.bussiness.interfaces.gateways.IBoardRepository;
import br.com.berro.kanban.core.bussiness.interfaces.usecases.IBoardUseCase;
import br.com.berro.kanban.core.domain.model.Board;

import java.util.List;
import java.util.Objects;
import java.util.UUID;

public class BoardUseCaseImpl implements IBoardUseCase {

    private final IBoardRepository boardRepository;

    public BoardUseCaseImpl(IBoardRepository boardRepository) {
        this.boardRepository = boardRepository;
    }

    @Override
    public Board save(Board board) {
        board.setId(UUID.randomUUID());
        return boardRepository.save(board);
    }

    @Override
    public List<Board> findAll() {
        return boardRepository.findAll();
    }

    @Override
    public Board findById(UUID id) {
        Board model = boardRepository.findById(id);
        if (Objects.isNull(model)){
            throw new NotFoundBusinessException("Board not found");
        }
        return model;
    }

    @Override
    public void deleteById(UUID id) {
        findById(id);
        boardRepository.deleteById(id);
    }

    @Override
    public Board update(Board updateBoard) {
        Board originBoard = findById(updateBoard.getId());
        originBoard.setName(updateBoard.getName());
        originBoard.setDescription(updateBoard.getDescription());
        return boardRepository.save(originBoard);
    }
}
