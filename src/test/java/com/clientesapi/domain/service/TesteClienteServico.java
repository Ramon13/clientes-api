package com.clientesapi.domain.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.clientesapi.dominio.entidade.Cliente;
import com.clientesapi.dominio.repositorio.ClienteRepository;
import com.clientesapi.dominio.servico.ClienteServico;

@SpringBootTest
public class TesteClienteServico {

	@Autowired
	private ClienteServico clienteServico;
	
	@Autowired
	private ClienteRepository clienteRepositorio;
	
	private final String NOME_PADRAO = "Nome qualquer";
	
	@Test
	void quandoSalvarUmCliente_entaoOClienteSeraPersistido() {
		long clientesCount = clienteRepositorio.count();
		Assertions.assertEquals(3, clientesCount);
		
		Cliente cliente = new Cliente();
		cliente.setNome("nome de teste");
		cliente.setDataNasc("01/01/1970");
		cliente.setEmail("a@a.com");
		
		clienteServico.salvar(cliente);
		
		clientesCount = clienteRepositorio.count();
		Assertions.assertEquals(4, clientesCount);
	}
	
	@Test
	void quandoAtualizarNome_entaoONovoNomeDeveSerPersistido() {
		Cliente cliente = clienteRepositorio.findById(1).get();
		Assertions.assertEquals(cliente.getNome(), "José Antonio");
		
		clienteServico.atualizar(
			cliente.getId(), 
			NOME_PADRAO,
			cliente.getEmail(),
			cliente.getDataNasc()
		);
		
		cliente = clienteRepositorio.findById(1).get();
		Assertions.assertEquals(cliente.getNome(), NOME_PADRAO);
	}
}
