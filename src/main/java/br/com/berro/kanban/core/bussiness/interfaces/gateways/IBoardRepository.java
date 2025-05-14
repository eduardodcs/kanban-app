package br.com.berro.kanban.core.bussiness.interfaces.gateways;

import br.com.berro.kanban.core.domain.model.Board;

import java.util.List;
import java.util.UUID;

public interface IBoardRepository {
    Board save(Board board);
    List<Board> findAll();
    Board findById(UUID id);
    void deleteById(UUID id);
    Board update(Board board);
}
