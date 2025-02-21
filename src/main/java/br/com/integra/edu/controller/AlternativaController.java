package br.com.integra.edu.controller;

import br.com.integra.edu.model.Alternativa;
import br.com.integra.edu.service.AlternativaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/alternativas")
public class AlternativaController {
    @Autowired
    private AlternativaService alternativaService;

    @GetMapping
    public ResponseEntity<List<Alternativa>> findAll() {
        return ResponseEntity.ok(alternativaService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Alternativa> findById(@PathVariable UUID id) {
        Optional<Alternativa> alternativa = alternativaService.findById(id);
        return alternativa.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Alternativa> save(@RequestBody Alternativa alternativa) {
        Alternativa saved = alternativaService.save(alternativa);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(saved.getId()).toUri();
        return ResponseEntity.created(location).body(saved);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Alternativa> update(@PathVariable UUID id, @RequestBody Alternativa alternativa) {
        Alternativa alternativaAtualizada = alternativaService.update(id, alternativa);
        return alternativaAtualizada != null ? ResponseEntity.ok(alternativaAtualizada) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable UUID id) {
        alternativaService.delete(id);
        return ResponseEntity.noContent().build();
    }

}
