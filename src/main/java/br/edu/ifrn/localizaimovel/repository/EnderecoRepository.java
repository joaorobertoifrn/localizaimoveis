package br.edu.ifrn.localizaimovel.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import br.edu.ifrn.localizaimovel.domain.Endereco;

@Repository
public interface EnderecoRepository extends MongoRepository<Endereco, String> {

}
