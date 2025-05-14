package br.com.berro.kanban.interfaces.controller;

import br.com.berro.kanban.common.mapper.BoardMapper;
import br.com.berro.kanban.core.bussiness.interfaces.usecases.IBoardUseCase;
import br.com.berro.kanban.interfaces.dto.BoardDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/boards")
public class BoardController {

    @Autowired
    private IBoardUseCase boardUseCase;

    @GetMapping
    public List<BoardDTO> findAll() {
        return boardUseCase.findAll().stream().map(BoardMapper::toDTO).toList();
    }

    @GetMapping("/{id}")
    public BoardDTO findById(@PathVariable UUID id) {
        return BoardMapper.toDTO(boardUseCase.findById(id));
    }

    @PostMapping
    public BoardDTO save(@RequestBody BoardDTO boardDTO) {
        return BoardMapper.toDTO(boardUseCase.save(BoardMapper.toModel(boardDTO)));
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable UUID id) {
        boardUseCase.deleteById(id);
    }

    @PutMapping
    public BoardDTO update(@RequestBody BoardDTO boardDTO) {
        return BoardMapper.toDTO(boardUseCase.update(BoardMapper.toModel(boardDTO)));
    }
}
