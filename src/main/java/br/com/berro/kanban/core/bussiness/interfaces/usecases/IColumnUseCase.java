package br.com.berro.kanban.core.bussiness.interfaces.usecases;

import br.com.berro.kanban.core.domain.model.Column;

import java.util.List;
import java.util.UUID;

public interface IColumnUseCase {
    Column save(Column column);
    List<Column> findByBoardId(UUID boardId);
    Column findById(UUID id);
    void deleteById(UUID id);
    Column update(Column column);

}
