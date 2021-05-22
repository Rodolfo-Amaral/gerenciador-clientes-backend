package com.rodolfoamaral.casevsm.repositories;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.rodolfoamaral.casevsm.entidades.Cliente;
import com.rodolfoamaral.casevsm.entidades.enums.EnumStatus;

@Repository
public interface ClienteRepositorio extends JpaRepository<Cliente, Long>{
	
	Optional<Cliente> findByCpfCnpj(String cpfCnpj);

	@Query("SELECT c.nome FROM Cliente c WHERE c.status =:status")
	Page<Cliente> listarTodosAtivos(Pageable pageable, EnumStatus status);

	@Query("SELECT new com.rodolfoamaral.casevsm.entidades.dto.ClienteDTO(c.id, c.nome, c.cpfCnpj, c.nascimento, c.sexo, "
			+ " c.logradouro, c.numero, c.bairro, c.cep, c.complemento, c.fone, c.email, c.estadoCivil, c.dataCadastro, c.status, "
			+ "c.nomeCidade) "
			+ " FROM Cliente c ")
	Page<Cliente> listarTodos(Pageable pageable);	
}