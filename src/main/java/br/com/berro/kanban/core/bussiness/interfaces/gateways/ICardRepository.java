package br.com.berro.kanban.core.bussiness.interfaces.gateways;

import br.com.berro.kanban.core.domain.model.Card;

import java.util.List;
import java.util.UUID;

public interface ICardRepository {
    Card save(Card card);
    List<Card> findByColumnId(UUID columnId);
    Card findById(UUID id);
    void deleteById(UUID id);
    Card update(Card card);
}
