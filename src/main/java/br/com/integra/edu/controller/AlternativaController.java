package br.com.integra.edu.controller;

import br.com.integra.edu.model.Alternativa;
import br.com.integra.edu.service.AlternativaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/alternativas")
public class AlternativaController {
    @Autowired
    private AlternativaService alternativaService;

    @GetMapping
    public List<Alternativa> findAll() {
        return alternativaService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Alternativa> findById(@PathVariable UUID id) {
        Optional<Alternativa> alternativa = alternativaService.findById(id);
        return alternativa.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public Alternativa save(@RequestBody Alternativa alternativa) {
        return alternativaService.save(alternativa);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable UUID id) {
        alternativaService.delete(id);
        return ResponseEntity.noContent().build();
    }

}
