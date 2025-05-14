package br.com.berro.kanban.infrastructure.persistence.repository;

import br.com.berro.kanban.common.mapper.BoardMapper;
import br.com.berro.kanban.core.bussiness.interfaces.gateways.IBoardRepository;
import br.com.berro.kanban.core.domain.model.Board;
import br.com.berro.kanban.infrastructure.persistence.jpa.JpaBoardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;

@Component
public class BoardRepositoryImpl implements IBoardRepository {

    @Autowired
    private JpaBoardRepository jpaBoardRepository;

    @Override
    public Board save(Board board) {
        return BoardMapper.toModel(jpaBoardRepository.save(BoardMapper.toEntity(board)));
    }

    @Override
    public List<Board> findAll() {
        return jpaBoardRepository.findAll().stream().map(BoardMapper::toModel).toList();
    }

    @Override
    public Board findById(UUID id) {
        return jpaBoardRepository.findById(id).map(BoardMapper::toModel).orElse(null);
    }

    @Override
    public void deleteById(UUID id) {
        jpaBoardRepository.deleteById(id);
    }

    @Override
    public Board update(Board board) {
        return BoardMapper.toModel(jpaBoardRepository.save(BoardMapper.toEntity(board)));
    }
}
