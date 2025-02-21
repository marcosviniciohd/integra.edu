package br.com.integra.edu.service;

import br.com.integra.edu.model.Questao;
import br.com.integra.edu.repository.QuestaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class QuestaoService {

    @Autowired
    private QuestaoRepository questaoRepository;

    public List<Questao> findAll() {
        return questaoRepository.findAll();
    }

    public Optional<Questao> findById(UUID id) {
        return questaoRepository.findById(id);
    }

    public Questao save(Questao questao) {
        questao.setId(UUID.randomUUID());
        questao.setDataCriacao(LocalDateTime.now());
        questao.setDataAtualizacao(LocalDateTime.now());
        return questaoRepository.save(questao);
    }

    public Questao update(UUID id, Questao questao) {
        if (questaoRepository.existsById(id)) {
            questao.setId(id);
            questao.setDataAtualizacao(LocalDateTime.now());
            return questaoRepository.save(questao);
        }
        return null;
    }

    public void delete(UUID id) {
        questaoRepository.deleteById(id);
    }

}
