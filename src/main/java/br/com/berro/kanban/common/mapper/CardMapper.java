package br.com.berro.kanban.common.mapper;

import br.com.berro.kanban.core.domain.model.Card;
import br.com.berro.kanban.infrastructure.persistence.entity.CardEntity;
import br.com.berro.kanban.infrastructure.persistence.entity.ColumnEntity;
import br.com.berro.kanban.interfaces.dto.CardDTO;
import org.springframework.stereotype.Component;

@Component
public class CardMapper {

    public static Card toModel(CardDTO cardDTO) {
        Card card = new Card();
        card.setId(cardDTO.getId());
        card.setName(cardDTO.getName());
        card.setDescription(cardDTO.getDescription());
        card.setPosition(cardDTO.getPosition());
        card.setColumnId(cardDTO.getColumnId());
        return card;
    }

    public static CardDTO toDTO(Card card) {
        CardDTO cardDTO = new CardDTO();
        cardDTO.setId(card.getId());
        cardDTO.setName(card.getName());
        cardDTO.setDescription(card.getDescription());
        cardDTO.setPosition(card.getPosition());
        cardDTO.setColumnId(card.getColumnId());
        return cardDTO;
    }

    public static CardEntity toEntity(Card card) {
        CardEntity entity = new CardEntity();
        entity.setId(card.getId());
        entity.setName(card.getName());
        entity.setDescription(card.getDescription());
        entity.setPosition(card.getPosition());

        ColumnEntity columnEntity = new ColumnEntity();
        columnEntity.setId(card.getColumnId());
        entity.setColumn(columnEntity);

        return entity;
    }

    public static Card toModel(CardEntity entity) {
        Card card = new Card();
        card.setId(entity.getId());
        card.setName(entity.getName());
        card.setDescription(entity.getDescription());
        card.setPosition(entity.getPosition());
        card.setColumnId(entity.getColumn().getId());
        return card;
    }

}
