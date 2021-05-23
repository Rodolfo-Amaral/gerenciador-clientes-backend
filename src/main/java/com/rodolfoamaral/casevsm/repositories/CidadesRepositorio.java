package com.rodolfoamaral.casevsm.repositories;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.rodolfoamaral.casevsm.entidades.Cidades;

public interface CidadesRepositorio extends JpaRepository<Cidades, Long> {

	Optional<Cidades> findByNomeCidade(String nomeCidade);
	Page<Cidades> findBySiglaEstado(Pageable pageable, String siglaEstado);
}
