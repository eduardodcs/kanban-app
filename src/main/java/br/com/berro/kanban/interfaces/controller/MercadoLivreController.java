package br.com.berro.kanban.interfaces.controller;


import com.fasterxml.jackson.databind.JsonNode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/ml")
public class MercadoLivreController {

    private static final Logger logger = LoggerFactory.getLogger(MercadoLivreController.class);

    @GetMapping
    public void mercadoLivreGet(@RequestBody JsonNode corpo) {
        logger.info("GET Objeto recebido: {}", corpo.toPrettyString());
    }

    @PostMapping
    public void mercadoLivrePost(@RequestBody JsonNode corpo) {
        logger.info("POST Objeto recebido: {}", corpo.toPrettyString());
    }


}
