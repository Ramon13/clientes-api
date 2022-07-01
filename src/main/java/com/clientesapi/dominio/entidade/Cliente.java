package com.clientesapi.dominio.entidade;

import javax.persistence.Entity;			// No pacote javax.persistence.* tem tudo que mapeia uma classe para uma tabela no banco de dados
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity // Essa anotação indica que essa classe irá ser trasformada em uma tabela no banco de dados
public class Cliente extends Pessoa{

	@Id													// @Id indica que esse atributo (id) irá ser a chave primária da tabela
	@GeneratedValue(strategy = GenerationType.IDENTITY) // @GeneratedValue indica que irá ser gerado um id novo pra cada cliente
	private Integer id;
	
	private String email;

	// Métodos getters e setters para o id e o email
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	// O toString() ajuda é uma forma mais fácil de printar todos os dados do cliente
	@Override
	public String toString() {
		return "Cliente [id=" + id + ", email=" + email + ", getNome()=" + getNome() + ", getDataNasc()="
				+ getDataNasc() + ", getIdade()=" + getIdade() + "]";
	}	
}
