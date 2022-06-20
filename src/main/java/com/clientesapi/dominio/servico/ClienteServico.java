package com.clientesapi.dominio.servico;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.clientesapi.dominio.entidade.Cliente;
import com.clientesapi.dominio.repositorio.ClienteRepository;

@Service
public class ClienteServico {

	@Autowired
	ClienteRepository clienteRepository;
	
	public Cliente salvar(Cliente novoCliente) {
		return clienteRepository.save(novoCliente);
	}
	
	public Cliente atualizar(Integer clienteId, String novoNome, String novoEmail, String novaDataNasc) {
		Cliente cliente = encontrarOuGerarErro(clienteId);
		
		cliente.setNome(novoNome);
		cliente.setEmail(novoEmail);
		cliente.setDataNasc(novaDataNasc);

		return clienteRepository.save(cliente);
	}
	
	public Cliente buscar(Integer clienteId) {
		Cliente cliente = encontrarOuGerarErro(clienteId);
		return cliente;
	}
	
	private Cliente encontrarOuGerarErro(Integer clienteId) {
		Cliente cliente = clienteRepository.findById(clienteId).orElseThrow(
				() -> new IllegalArgumentException("Cliente não encontrado com o id: " + clienteId));
		
		return cliente;
	}
}
