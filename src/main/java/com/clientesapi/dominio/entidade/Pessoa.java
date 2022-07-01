package com.clientesapi.dominio.entidade;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

@MappedSuperclass	// Esse @MappedSuperclass indica que o atributo nome vai fazer parte da tabela que que vai ser gerada 
					// com base na classe que estende Pessoa no caso a classe Cliente
public class Pessoa {

	private String nome;
	
	@Column(name = "data_nasc")		// O @Column é uma anotação pra editar o nome das colunas no banco de dados manualmente
									// Se nao tivesse esse @Column o nome da coluna seria dataNasc ao invés de data_nasc
	private String dataNasc;
	
	
	//Métodos getters e setters normais
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
	
	//Esse método converte uma data de nascimento em String para uma data do tipo LocalDate
	//LocalDate é uma classe do java especifica pra trabalhar com datas
	public Integer getIdade() {
		//DateTimeFormatter especifica uma mascara, ou seja, o formato que a data será lida, no caso
		// dd/MM/yyyy, dd é dois digitos de dia, MM dois digitos de mês e yyyy de ano
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy"); 
		
		LocalDate realDataNasc = LocalDate.parse(dataNasc, dtf); // o parse faz a conversao
		
		return LocalDate.now().getYear() - realDataNasc.getYear();  // com a data convertida é só subtrair os anos
	}
}
