package br.edu.ifrn.localizaimovel.domain;

import java.io.Serializable;
import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="pesquisa")
public class Pesquisa implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	private String id;
	
	private User usuario;
	
	@DBRef(lazy=true)
	private Imovel imovel;
	
	private Date data;
	
	public Pesquisa() {
		
	}

	public Pesquisa(String id, User usuario, Imovel imovel, Date data) {
		super();
		this.id = id;
		this.usuario = usuario;
		this.imovel = imovel;
		this.data = data;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public User getUsuario() {
		return usuario;
	}

	public void setUsuario(User usuario) {
		this.usuario = usuario;
	}

	public Imovel getImovel() {
		return imovel;
	}

	public void setImovel(Imovel imovel) {
		this.imovel = imovel;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}
	
	
	
}
