package br.com.integra.edu.service;

import br.com.integra.edu.model.Questao;
import br.com.integra.edu.repository.QuestaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
        questao.setId(UUID.randomUUID().toString());
        return questaoRepository.save(questao);
    }

    public void delete(UUID id) {
        questaoRepository.deleteById(id);
    }

}
