package br.com.berro.kanban.infrastructure.persistence.repository;

import br.com.berro.kanban.common.mapper.ColumnMapper;
import br.com.berro.kanban.core.bussiness.interfaces.gateways.IColumnRepository;
import br.com.berro.kanban.core.domain.model.Column;
import br.com.berro.kanban.infrastructure.persistence.entity.ColumnEntity;
import br.com.berro.kanban.infrastructure.persistence.jpa.JpaColumnRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;

@Component
public class ColumnRepositoryImpl implements IColumnRepository {

    @Autowired
    private JpaColumnRepository jpaColumnRepository;

    @Override
    public Column save(Column column) {
        return ColumnMapper.toModel(jpaColumnRepository.save(ColumnMapper.toEntity(column)));
    }

    @Override
    public List<Column> findByBoardId(UUID boardId) {
        return jpaColumnRepository.findByBoardId(boardId).stream().map(ColumnMapper::toModel).toList();
    }

    @Override
    public Column findById(UUID id) {
        return jpaColumnRepository.findById(id).map(ColumnMapper::toModel).orElse(null);
    }

    @Override
    public void deleteById(UUID id) {
        jpaColumnRepository.deleteById(id);
    }

    @Override
    public Column update(Column column) {
        return ColumnMapper.toModel(jpaColumnRepository.save(ColumnMapper.toEntity(column)));
    }
}
