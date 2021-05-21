package com.rodolfoamaral.casevsm.servicos;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rodolfoamaral.casevsm.entidades.Cidades;
import com.rodolfoamaral.casevsm.exceptions.CidadeNaoEncontrada;
import com.rodolfoamaral.casevsm.repositories.CidadesRepositorio;

@Service
public class CidadeServico {
	
	@Autowired
	private CidadesRepositorio repositorio;
	
	public List<Cidades> pesquisaTodos(){
		return repositorio.findAll();
	}
	
	public Cidades findNome(String nome) {
		Optional<Cidades> cidade = repositorio.findByNome(nome);
		return cidade.orElseThrow(() -> new CidadeNaoEncontrada(cidade));
	}
}
