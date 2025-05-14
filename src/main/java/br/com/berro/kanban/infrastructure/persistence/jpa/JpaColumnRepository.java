package br.com.berro.kanban.infrastructure.persistence.jpa;

import br.com.berro.kanban.infrastructure.persistence.entity.ColumnEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface JpaColumnRepository extends JpaRepository<ColumnEntity, UUID> {

    List<ColumnEntity> findByBoardId(UUID boardId);

}
