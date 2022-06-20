package com.clientesapi.dominio.repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.clientesapi.dominio.entidade.Cliente;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Integer>{

	@Query("from Cliente c where (c.nome like %:chave%) or (c.email like %:chave%)")
	List<Cliente> filtrar(@Param("chave") String chave);
}
