package br.fatec.filmes.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
public class Filme extends AbstractEntity {
	private static final long serialVersionUID = 1L;
	
	private String titulo;
	
	private Integer ano;
	
	@ManyToMany
	private List<Ator> atores;
	
	public Filme() {}

	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public Integer getAno() {
		return ano;
	}
	public void setAno(Integer ano) {
		this.ano = ano;
	}
	@JsonIgnore
	public List<Ator> getAtores() {
		return atores;
	}
	@JsonProperty
	public void setAtores(List<Ator> atores) {
		this.atores = atores;
	}
}
