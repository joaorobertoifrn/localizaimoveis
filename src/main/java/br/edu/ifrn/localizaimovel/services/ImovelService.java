package br.edu.ifrn.localizaimovel.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.ifrn.localizaimovel.domain.Imovel;
import br.edu.ifrn.localizaimovel.repository.ImovelRepository;
import br.edu.ifrn.localizaimovel.services.exception.ObjectNotFoundException;

@Service
public class ImovelService {
	
	@Autowired
	private ImovelRepository repo;
	
	public List<Imovel> findAll() {
		return repo.findAll();
	}
	
	public Imovel findById(String id) {
		Optional<Imovel> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Imovel não encontrado"));
	}
	
	public List<Imovel> findByDescricao(String text) {
		return repo.findByDescricao(text);
	}

	public List<Imovel> findByTipo(String text) {
		return repo.findByTipo(text);
	}
	
	public List<Imovel> buscaCompleta(String text) {
		return repo.buscaCompleta(text);
	}

	public List<Imovel> buscaPorPreco(Double valorInicial, Double valorFinal) {
		return repo.findByPreco(valorInicial, valorFinal);
	}
	
	public Imovel insert(Imovel obj) {
		return repo.insert(obj);
	}
	
	public void delete(String id) {
		findById(id);
		repo.deleteById(id);
	}
	
	public Imovel update(Imovel obj) {
		Imovel newObj = findById(obj.getId());
		updateData(newObj,obj);
		return repo.save(newObj);
	}
	
	private void updateData(Imovel newObj, Imovel obj) {
		newObj.setDescricao(obj.getDescricao());
		newObj.setFoto(obj.getFoto());
		newObj.setLink(obj.getLink());
		newObj.setPreco(obj.getPreco());
	}


}
