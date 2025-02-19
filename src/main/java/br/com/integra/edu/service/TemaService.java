package br.com.integra.edu.service;

import br.com.integra.edu.model.Tema;
import br.com.integra.edu.repository.TemaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
        return temaRepository.save(tema);
    }

    public void delete(UUID id) {
        temaRepository.deleteById(id);
    }
}
