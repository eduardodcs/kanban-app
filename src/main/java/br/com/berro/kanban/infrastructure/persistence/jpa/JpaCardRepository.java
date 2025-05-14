package br.com.berro.kanban.infrastructure.persistence.jpa;

import br.com.berro.kanban.infrastructure.persistence.entity.CardEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface JpaCardRepository extends JpaRepository<CardEntity, UUID> {

    List<CardEntity> findByColumnId(UUID columnId);

}
