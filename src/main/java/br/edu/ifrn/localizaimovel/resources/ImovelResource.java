package br.edu.ifrn.localizaimovel.resources;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.edu.ifrn.localizaimovel.domain.Imovel;
import br.edu.ifrn.localizaimovel.resources.util.URL;
import br.edu.ifrn.localizaimovel.services.ImovelService;

@RestController
@RequestMapping(value="/imoveis")
public class ImovelResource {

	@Autowired
	private ImovelService service;
	
	@RequestMapping(method=RequestMethod.GET)
	public ResponseEntity<List<Imovel>> findAll() {
		List<Imovel> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public ResponseEntity<Imovel> findById(@PathVariable String id) {
		Imovel obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}
	
	@RequestMapping(value="/buscadescricao", method=RequestMethod.GET)
	public ResponseEntity<List<Imovel>> findByDescricao(@RequestParam(value="text",defaultValue="") String text) {
		text = URL.decodeParam(text);
		List<Imovel> list = service.findByDescricao(text);
		return ResponseEntity.ok().body(list);
	}

	@RequestMapping(value="/tipo", method=RequestMethod.GET)
	public ResponseEntity<List<Imovel>> findByTipo(@RequestParam(value="text",defaultValue="") String text) {
		text = URL.decodeParam(text);
		List<Imovel> list = service.findByTipo(text);
		return ResponseEntity.ok().body(list);
	}
	
	@RequestMapping(value="/buscacompleta", method=RequestMethod.GET)
	public ResponseEntity<List<Imovel>> buscaCompleta(@RequestParam(value="text",defaultValue="") String text) {
		text = URL.decodeParam(text);
		List<Imovel> list = service.buscaCompleta(text);
		return ResponseEntity.ok().body(list);
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public ResponseEntity<Void> insert(@RequestBody Imovel imovel) {
		service.insert(imovel);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(imovel.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}

	@RequestMapping(value="/{id}", method=RequestMethod.DELETE)
	public ResponseEntity<Void> delete(@PathVariable String id) {
		service.delete(id);	
		return ResponseEntity.noContent().build();
	}

	@RequestMapping(value="/{id}", method=RequestMethod.PUT)
	public ResponseEntity<Void> update(@RequestBody Imovel imovel, @PathVariable String id) {
		service.update(imovel);
		return ResponseEntity.noContent().build();
	}

}
