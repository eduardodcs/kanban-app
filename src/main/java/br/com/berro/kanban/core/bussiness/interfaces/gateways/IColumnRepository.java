package br.com.berro.kanban.core.bussiness.interfaces.gateways;

import br.com.berro.kanban.core.domain.model.Column;
import br.com.berro.kanban.infrastructure.persistence.entity.ColumnEntity;

import java.util.List;
import java.util.UUID;

public interface IColumnRepository {
    Column save(Column column);
    List<Column> findByBoardId(UUID boardId);
    Column findById(UUID id);
    void deleteById(UUID id);
    Column update(Column column);
}
