package com.clientesapi.dominio.entidade;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public class Pessoa {

	private String nome;
	
	@Column(name = "data_nasc")
	private String dataNasc;
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getDataNasc() {
		return dataNasc;
	}
	public void setDataNasc(String dataNasc) {
		this.dataNasc = dataNasc;
	}
	public Integer getIdade() {
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		LocalDate realDataNasc = LocalDate.parse(dataNasc, dtf);
		
		return LocalDate.now().getYear() - realDataNasc.getYear();
	}
}
