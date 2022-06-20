package com.clientesapi.api;

import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.clientesapi.dominio.entidade.Cliente;
import com.clientesapi.dominio.repositorio.ClienteRepository;
import com.clientesapi.dominio.servico.ClienteServico;

@RestController
@RequestMapping("/clientes")
public class ClienteControlador {

	@Autowired
	private ClienteServico clienteServico;
	
	@Autowired
	private ClienteRepository clienteRepositorio;
	
	@PostMapping
	public Cliente criar(@RequestBody Cliente novoCliente) {
		return clienteServico.salvar(novoCliente);
	}
	
	@PutMapping("/{clienteId}")
	public Cliente atualizar(@PathVariable("clienteId") Integer clienteId, @RequestBody Cliente atualizarCliente) {
		Cliente clienteAtualizado = clienteServico.atualizar(
			clienteId, 
			atualizarCliente.getNome(), 
			atualizarCliente.getEmail(), 
			atualizarCliente.getDataNasc()
		);
		
		return clienteAtualizado;
	}
	
	@GetMapping
	public List<Cliente> listar() {
		return clienteRepositorio.findAll();
	}
	
	@GetMapping("/buscar/{clienteId}")
	public Cliente buscar(@PathVariable("clienteId") Integer clienteId) {
		return clienteServico.buscar(clienteId);
	}
	
	@GetMapping("/filtrar")
	public List<Cliente> filtrar(@PathParam("chave") String chave) {
		return clienteRepositorio.filtrar(chave);
	}
}
