package br.com.berro.kanban.interfaces.controller;

import br.com.berro.kanban.common.mapper.ColumnMapper;
import br.com.berro.kanban.core.bussiness.interfaces.usecases.IColumnUseCase;
import br.com.berro.kanban.interfaces.dto.ColumnDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/columns")
public class ColumnController {

    @Autowired
    private IColumnUseCase columnUseCase;

    @GetMapping("/by-board/{boardId}")
    public List<ColumnDTO> findByBoardId(@PathVariable UUID boardId) {
        return columnUseCase.findByBoardId(boardId).stream().map(ColumnMapper::toDTO).toList();
    }

    @GetMapping("/{id}")
    public ColumnDTO findById(@PathVariable UUID id) {
        return ColumnMapper.toDTO(columnUseCase.findById(id));
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable UUID id) {
        columnUseCase.deleteById(id);
    }

    @PostMapping
    public ColumnDTO save(@RequestBody ColumnDTO columnDto) {
        return ColumnMapper.toDTO(columnUseCase.save(ColumnMapper.toModel(columnDto)));
    }

    @PutMapping
    public ColumnDTO update(@RequestBody ColumnDTO columnDto) {
        return ColumnMapper.toDTO(columnUseCase.update(ColumnMapper.toModel(columnDto)));
    }

}
