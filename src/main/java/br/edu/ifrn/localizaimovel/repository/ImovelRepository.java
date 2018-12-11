package br.edu.ifrn.localizaimovel.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import br.edu.ifrn.localizaimovel.domain.Imovel;

@Repository
public interface ImovelRepository extends MongoRepository<Imovel, String> {

	/* Busca utilizando consulta personalizada MongoDB por expressão regular */
	@Query("{'descricao': {$regex: ?0, $options: 'i' } }")
	List<Imovel> findByDescricao(String text);

	/* Busca utilizando consulta personalizada MongoDB por expressão regular */
	@Query("{'bairro': {$regex: ?0, $options: 'i' } }")
	List<Imovel> findByBairro(String text);

	/* Busca utilizando consulta personalizada MongoDB por expressão regular */
	@Query("{'cidade': {$regex: ?0, $options: 'i' } }")
	List<Imovel> findByCidade(String text);

	/* Busca utilizando consulta personalizada MongoDB por expressão regular */
	@Query("{'estado': {$regex: ?0, $options: 'i' } }")
	List<Imovel> findByEstado(String text);

	/* Busca utilizando consulta personalizada MongoDB por expressão regular */
	@Query("{'preco': {$gte:[?0, ?1]}},{$sort:{'preco':1}}")
	List<Imovel> findByPreco(Double valorInicial, Double valorFinal);

	/* Busca utilizando consulta personalizada MongoDB por expressão regular */
	@Query("{'modalidadeVenda': {$regex: ?0, $options: 'i' } }")
	List<Imovel> findByModalidadeVenda(String text);
	
	/* Busca utilizando consulta personalizada MongoDB por expressão regular com vários critérios */
	@Query("{ $or: [ "
			+ "{'descricao': {$regex: ?0, $options: 'i' } }, "
			+ "{'preco': {$regex: ?0, $options: 'i' } }, "
			+ "{'cidade': {$regex: ?0, $options: 'i' } }, "
			+ "{'estado': {$regex: ?0, $options: 'i' } }, "
			+ "{'endereco': {$regex: ?0, $options: 'i' } }, "
			+ "{'modalidadeVenda': {$regex: ?0, $options: 'i' } }, "
			+ "{'bairro': {$regex: ?0, $options: 'i' } } ] }")
	List<Imovel> buscaCompleta(String text);
	
	/* Busca utilizando consulta padrao do spring Data */
	List<Imovel> findByDescricaoContainingIgnoreCase(String text);

	/* Busca utilizando consulta padrao do spring Data */
	List<Imovel> findByPrecoContainingIgnoreCase(String text);
	
}
