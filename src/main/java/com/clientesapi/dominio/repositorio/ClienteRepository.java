package com.clientesapi.dominio.repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.clientesapi.dominio.entidade.Cliente;

/**
 * Essa interface extende a interface JpaRepository, com isso o spring cria automaticamente um
 * objeto que salva, busca, deleta, etc clientes do banco de dados
 *
 */
@Repository // @Repository indica pro spring que, ao iniciar o sistema ele deve criar um objeto para lidar com clientes no banco de dados
public interface ClienteRepository extends JpaRepository<Cliente, Integer>{

	// Aqui foi necessario fazer uma consulta no banco manualmente
	// o código dentro de @Query é semelhante com um sql puro
	// Lê-se: Busque tudo da tabela cliente onde, o nome ou o email é igual a chave passada
	// a chave no @Param vai substituir todos os lugares que tem :chave no sql
	@Query("from Cliente c where (c.nome like %:chave%) or (c.email like %:chave%)")
	List<Cliente> filtrar(@Param("chave") String chave);
}
