package com.example.demo.app;

import java.time.LocalDate;

public class Task {

	private Long id;
	private String titulo;
	private String descricao;
	private LocalDate dataDeCriacao;
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public LocalDate getDataDeCriacao() {
		return dataDeCriacao;
	}
	public void setDataDeCriacao(LocalDate dataDeCriacao) {
		this.dataDeCriacao = dataDeCriacao;
	}
	
	
	
}
