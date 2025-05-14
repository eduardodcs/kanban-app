package br.com.berro.kanban.infrastructure.persistence.repository;

import br.com.berro.kanban.common.mapper.CardMapper;
import br.com.berro.kanban.core.bussiness.interfaces.gateways.ICardRepository;
import br.com.berro.kanban.core.domain.model.Card;
import br.com.berro.kanban.infrastructure.persistence.jpa.JpaCardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;

@Component
public class CardRepositoryImpl implements ICardRepository {

    @Autowired
    private JpaCardRepository jpaCardRepository;

    @Override
    public Card save(Card card) {
        return CardMapper.toModel(jpaCardRepository.save(CardMapper.toEntity(card)));
    }

    @Override
    public List<Card> findByColumnId(UUID columnId) {
        return jpaCardRepository.findByColumnId(columnId).stream().map(CardMapper::toModel).toList();
    }

    @Override
    public Card findById(UUID id) {
        return jpaCardRepository.findById(id).map(CardMapper::toModel).orElse(null);
    }

    @Override
    public void deleteById(UUID id) {
        jpaCardRepository.deleteById(id);
    }

    @Override
    public Card update(Card card) {
        return CardMapper.toModel(jpaCardRepository.save(CardMapper.toEntity(card)));
    }
}
