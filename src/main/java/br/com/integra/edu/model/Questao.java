package br.com.integra.edu.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Data
@Document(collection = "questoes")
public class Questao {
    @Id
    private String id;
    private String titulo;
    private String enunciado;
    private UUID temaId;
    private Integer dificuldade;
    private List<UUID> alternativasId;
    private Boolean visivel;
    private LocalDate dataCriacao;
    private LocalDate dataAtualizacao;
    private Boolean ativo;
}
