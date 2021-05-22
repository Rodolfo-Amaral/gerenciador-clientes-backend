package com.rodolfoamaral.casevsm.servicos;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.rodolfoamaral.casevsm.entidades.Cidades;
import com.rodolfoamaral.casevsm.exceptions.CidadeNaoEncontrada;
import com.rodolfoamaral.casevsm.repositories.CidadesRepositorio;

@Service
public class CidadeServico {
	
	@Autowired
	private CidadesRepositorio repositorio;
	
	public Page<Cidades> findAll(Pageable pageable){
		return repositorio.findAll(pageable);
	}
	
	public Cidades findNome(String nomeCidade) {
		Optional<Cidades> cidade = repositorio.findByNomeCidade(nomeCidade);
		return cidade.orElseThrow(() -> new CidadeNaoEncontrada(cidade));
	}
}
