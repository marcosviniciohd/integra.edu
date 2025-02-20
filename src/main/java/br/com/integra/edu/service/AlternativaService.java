package br.com.integra.edu.service;

import br.com.integra.edu.model.Alternativa;
import br.com.integra.edu.repository.AlternativaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class AlternativaService {
    @Autowired
    private AlternativaRepository alternativaRepository;

    public List<Alternativa> findAll() {
        return alternativaRepository.findAll();
    }

    public Optional<Alternativa> findById(UUID id) {
        return alternativaRepository.findById(id);
    }

    public Alternativa save(Alternativa alternativa) {
        alternativa.setId(UUID.randomUUID());
        alternativa.setDataCriacao(LocalDateTime.now());
        alternativa.setDataAtualizacao(LocalDateTime.now());
        return alternativaRepository.save(alternativa);
    }

    public Alternativa update(UUID id, Alternativa alternativa) {
        if (alternativaRepository.existsById(id)) {
            alternativa.setId(id);
            alternativa.setDataAtualizacao(LocalDateTime.now());
            return alternativaRepository.save(alternativa);
        }
        return null;
    }

    public void delete(UUID id) {
        alternativaRepository.deleteById(id);
    }
}
