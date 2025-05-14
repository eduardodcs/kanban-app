package br.com.berro.kanban.infrastructure.persistence.jpa;

import br.com.berro.kanban.infrastructure.persistence.entity.BoardEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface JpaBoardRepository  extends JpaRepository<BoardEntity, UUID> {
}
