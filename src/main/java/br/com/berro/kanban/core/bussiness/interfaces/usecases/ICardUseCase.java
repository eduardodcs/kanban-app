package br.com.berro.kanban.core.bussiness.interfaces.usecases;

import br.com.berro.kanban.core.domain.model.Card;

import java.util.List;
import java.util.UUID;

public interface ICardUseCase {
    Card save(Card card);
    List<Card> findByColumnId(UUID columnId);
    Card findById(UUID id);
    void deleteById(UUID id);
    Card update(Card card);
}
