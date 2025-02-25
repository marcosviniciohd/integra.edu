package br.com.integra.edu.controller;

import br.com.integra.edu.model.Questao;
import br.com.integra.edu.service.QuestaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/questoes")
public class QuestaoController {

    @Autowired
    private QuestaoService questaoService;

    @GetMapping
    public ResponseEntity<List<Questao>> findAll() {
        return ResponseEntity.ok(questaoService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Questao> findById(@PathVariable UUID id) {
        Optional<Questao> questao = questaoService.findById(id);
        return questao.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Questao> save(@RequestBody Questao questao) {
        Questao savedQuestao = questaoService.save(questao);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedQuestao);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Questao> update(@PathVariable UUID id, @RequestBody Questao questao) {
        Questao questaoAtualizada = questaoService.update(id, questao);
        return questaoAtualizada != null ? ResponseEntity.ok(questaoAtualizada) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable UUID id) {
        questaoService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
