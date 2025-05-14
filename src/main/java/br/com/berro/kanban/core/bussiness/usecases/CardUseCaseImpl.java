package br.com.berro.kanban.core.bussiness.usecases;

import br.com.berro.kanban.common.exception.NotFoundBusinessException;
import br.com.berro.kanban.core.bussiness.interfaces.gateways.ICardRepository;
import br.com.berro.kanban.core.bussiness.interfaces.gateways.IColumnRepository;
import br.com.berro.kanban.core.bussiness.interfaces.usecases.ICardUseCase;
import br.com.berro.kanban.core.domain.model.Card;
import br.com.berro.kanban.core.domain.model.Column;

import java.util.List;
import java.util.Objects;
import java.util.UUID;

public class CardUseCaseImpl implements ICardUseCase {

    private final ICardRepository cardRepository;
    private final IColumnRepository columnRepository;

    public CardUseCaseImpl(ICardRepository cardRepository, IColumnRepository columnRepository) {
        this.cardRepository = cardRepository;
        this.columnRepository = columnRepository;
    }

    @Override
    public Card save(Card card) {
        columnValidate(card.getColumnId());
        card.setId(UUID.randomUUID());
        return cardRepository.save(card);
    }

    @Override
    public List<Card> findByColumnId(UUID columnId) {
        columnValidate(columnId);
        return cardRepository.findByColumnId(columnId);
    }

    @Override
    public Card findById(UUID id) {
        Card card = cardRepository.findById(id);
        if (Objects.isNull(card)) {
            throw new NotFoundBusinessException("Card not found");
        }
        return card;
    }

    @Override
    public void deleteById(UUID id) {
        findById(id);
        cardRepository.deleteById(id);
    }

    @Override
    public Card update(Card updateCard) {
        columnValidate(updateCard.getColumnId());
        Card originCard = findById(updateCard.getId());
        originCard.setName(updateCard.getName());
        originCard.setDescription(updateCard.getDescription());
        originCard.setPosition(updateCard.getPosition());
        originCard.setColumnId(updateCard.getColumnId());
        return cardRepository.save(originCard);
    }

    private void columnValidate(UUID columnId) {
        Column column = columnRepository.findById(columnId);
        if (Objects.isNull(column)) {
            throw new NotFoundBusinessException("Board Not Found");
        }
    }
}
