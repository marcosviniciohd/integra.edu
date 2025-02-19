package br.com.integra.edu.repository;

import br.com.integra.edu.model.Questao;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;
@Repository
public interface QuestaoRepository extends MongoRepository<Questao, UUID> {
}
