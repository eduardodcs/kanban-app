package br.com.berro.kanban.common.exception;

public class NotFoundBusinessException extends RuntimeException {

    public NotFoundBusinessException(String message) {
        super(message);
    }
}
