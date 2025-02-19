package br.com.integra.edu.controller;

import br.com.integra.edu.model.Questao;
import br.com.integra.edu.service.QuestaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
public class QuestaoController {

    @Autowired
    private QuestaoService questaoService;

    @GetMapping
    public List<Questao> findAll() {
        return questaoService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Questao> findById(@PathVariable UUID id) {
        Optional<Questao> questao = questaoService.findById(id);
        return questao.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public Questao save(@RequestBody Questao questao) {
        return questaoService.save(questao);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable UUID id) {
        questaoService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
