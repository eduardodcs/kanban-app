package br.com.berro.kanban.interfaces.controller;

import br.com.berro.kanban.common.mapper.CardMapper;
import br.com.berro.kanban.core.bussiness.interfaces.usecases.ICardUseCase;
import br.com.berro.kanban.interfaces.dto.CardDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/cards")
public class CardController {

    @Autowired
    private ICardUseCase cardUseCase;

    @GetMapping("/by-column/{columnId}")
    public List<CardDTO> findByColumnId(@PathVariable UUID columnId) {
        return cardUseCase.findByColumnId(columnId).stream().map(CardMapper::toDTO).toList();
    }

    @GetMapping("/{id}")
    public CardDTO findById(@PathVariable UUID id) {
        return CardMapper.toDTO(cardUseCase.findById(id));
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteById(@PathVariable UUID id) {
        cardUseCase.deleteById(id);
    }

    @PostMapping
    public CardDTO save(@RequestBody CardDTO cardDTO) {
        return CardMapper.toDTO(cardUseCase.save(CardMapper.toModel(cardDTO)));
    }

    @PutMapping
    public CardDTO update(@RequestBody CardDTO cardDTO) {
        return CardMapper.toDTO(cardUseCase.update(CardMapper.toModel(cardDTO)));
    }

}
