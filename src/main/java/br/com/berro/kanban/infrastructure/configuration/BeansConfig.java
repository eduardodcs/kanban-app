package br.com.berro.kanban.infrastructure.configuration;

import br.com.berro.kanban.core.bussiness.interfaces.gateways.IBoardRepository;
import br.com.berro.kanban.core.bussiness.interfaces.gateways.ICardRepository;
import br.com.berro.kanban.core.bussiness.interfaces.gateways.IColumnRepository;
import br.com.berro.kanban.core.bussiness.interfaces.usecases.IBoardUseCase;
import br.com.berro.kanban.core.bussiness.interfaces.usecases.ICardUseCase;
import br.com.berro.kanban.core.bussiness.interfaces.usecases.IColumnUseCase;
import br.com.berro.kanban.core.bussiness.usecases.BoardUseCaseImpl;
import br.com.berro.kanban.core.bussiness.usecases.CardUseCaseImpl;
import br.com.berro.kanban.core.bussiness.usecases.ColumnUseCaseImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeansConfig {

    @Bean
    public IBoardUseCase boardUseCaseImpl(IBoardRepository boardRepository) {
        return new BoardUseCaseImpl(boardRepository);
    }

    @Bean
    public IColumnUseCase columnUseCaseImpl(IColumnRepository columnRepository, IBoardRepository boardRepository) {
        return new ColumnUseCaseImpl(columnRepository, boardRepository);
    }

    @Bean
    public ICardUseCase cardUseCaseImpl(ICardRepository cardRepository, IColumnRepository columnRepository) {
        return new CardUseCaseImpl(cardRepository, columnRepository);
    }
}


