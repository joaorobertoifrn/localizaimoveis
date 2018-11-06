package br.edu.ifrn.localizaimovel.dto;

import java.io.Serializable;

import br.edu.ifrn.localizaimovel.domain.Cidade;
import br.edu.ifrn.localizaimovel.domain.Endereco;
import br.edu.ifrn.localizaimovel.domain.Imovel;

public class ImovelDTO implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private String id;
	private String descricao;
	private String preco;
	private String foto;
	private String link;
	
	private Cidade cidade;
	
	private Endereco endereco;
	
	public ImovelDTO() {
		
	}
	
	public ImovelDTO(Imovel obj) {
		id = obj.getId();
		descricao = obj.getDescricao();
		preco = obj.getPreco();
		foto = obj.getFoto();
		link = obj.getLink();
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getPreco() {
		return preco;
	}

	public void setPreco(String preco) {
		this.preco = preco;
	}

	public String getFoto() {
		return foto;
	}

	public void setFoto(String foto) {
		this.foto = foto;
	}

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}

	public Cidade getCidade() {
		return cidade;
	}

	public void setCidade(Cidade cidade) {
		this.cidade = cidade;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}
	
}
