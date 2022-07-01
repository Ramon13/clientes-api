package com.clientesapi.dominio.servico;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.clientesapi.dominio.entidade.Cliente;
import com.clientesapi.dominio.repositorio.ClienteRepository;

/**
 * Classe de servico, é uma boa pratica só modificar o banco de dados através de uma classe de
 * servico. Entaão o fluxo fica assim:
 * Uma classe de controle acessa uma classe que servico que acessa o repositorio
 *
 */
@Service
public class ClienteServico {

	// O @Autowired diz pro spring injetar um objeto do tipo clienteRepository
	// ou seja o spring ja cria o objeto e deixa pronto pra utilizar
	@Autowired
	ClienteRepository clienteRepository;
	
	public Cliente salvar(Cliente novoCliente) {
		return clienteRepository.save(novoCliente);
	}
	
	public Cliente atualizar(Integer clienteId, String novoNome, String novoEmail, String novaDataNasc) {
		Cliente cliente = encontrarOuGerarErro(clienteId); // Busca o cliente que vai ser atualizado no banco de dados
		
		// Atualiza os dados do cliente
		cliente.setNome(novoNome);
		cliente.setEmail(novoEmail);
		cliente.setDataNasc(novaDataNasc);

		// Salva o cliente com as informações atualizadas
		return clienteRepository.save(cliente);
	}
	
	public Cliente buscar(Integer clienteId) {
		Cliente cliente = encontrarOuGerarErro(clienteId);
		return cliente;
	}

	//Busca um cliente pelo id, se não encontrar gera um erro
	private Cliente encontrarOuGerarErro(Integer clienteId) {
		Cliente cliente = clienteRepository.findById(clienteId).orElseThrow(
				() -> new IllegalArgumentException("Cliente não encontrado com o id: " + clienteId));
		
		return cliente;
	}
}
