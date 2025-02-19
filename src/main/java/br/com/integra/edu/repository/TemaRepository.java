package br.com.integra.edu.repository;

import br.com.integra.edu.model.Tema;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface TemaRepository extends MongoRepository<Tema, UUID> {
}
