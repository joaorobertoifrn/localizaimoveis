package br.edu.ifrn.localizaimovel.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import br.edu.ifrn.localizaimovel.domain.Imovel;

@Repository
public interface ImovelRepository extends MongoRepository<Imovel, String> {

	List<Imovel> findByDescricaoContainingIgnoreCase(String text);
	
	List<Imovel> findByPrecoContainingIgnoreCase(String text);
	
}
