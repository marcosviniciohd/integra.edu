package br.com.integra.edu.controller;

import br.com.integra.edu.model.Tema;
import br.com.integra.edu.service.TemaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/temas")
public class TemaController {
    @Autowired
    private TemaService temaService;

    @GetMapping
    public List<Tema> findAll() {
        return temaService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Tema> findById(@PathVariable UUID id) {
        Optional<Tema> tema = temaService.findById(id);
        return tema.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Tema> save(@RequestBody Tema tema) {
        Tema savedTema = temaService.save(tema);
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(savedTema.getId())
                .toUri();
        return ResponseEntity.created(location).body(savedTema);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Tema> update(@PathVariable UUID id, @RequestBody Tema tema) {
        Tema temaAtualizado = temaService.update(id, tema);
        return temaAtualizado != null ? ResponseEntity.ok(temaAtualizado) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable UUID id) {
        temaService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
