package br.com.integra.edu.service;

import br.com.integra.edu.model.Tema;
import br.com.integra.edu.repository.TemaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class TemaService {
    @Autowired
    private TemaRepository temaRepository;

    public List<Tema> findAll() {
        return temaRepository.findAll();
    }

    public Optional<Tema> findById(UUID id) {
        return temaRepository.findById(id);
    }

    public Tema save(Tema tema) {
        tema.setId(UUID.randomUUID());
        tema.setDataCriacao(LocalDateTime.now());
        tema.setDataAtualizacao(LocalDateTime.now());
        return temaRepository.save(tema);
    }

    public Tema update(UUID id, Tema tema) {
        if (temaRepository.existsById(id)) {
            tema.setId(id);
            tema.setDataAtualizacao(LocalDateTime.now());
            return temaRepository.save(tema);
        }
        return null;
    }

    public void delete(UUID id) {
        temaRepository.deleteById(id);
    }
}
