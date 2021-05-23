package com.rodolfoamaral.casevsm.servicos;

import java.util.Optional;

import javax.persistence.EntityNotFoundException;

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

	public Page<Cidades> findAll(Pageable pageable) {
		return repositorio.findAll(pageable);
	}

	// Pesquisa por nome da cidade
	public Cidades pesquisaNome(String nomeCidade) {
		Optional<Cidades> nomeCid = repositorio.findByNomeCidade(nomeCidade);
		return nomeCid.orElseThrow(() -> new CidadeNaoEncontrada(nomeCidade));
	}

	// Pesquisa por sigla do estado
	public Page<Cidades> findBySiglaEstado(Pageable pageable, String siglaEstado) {
		return repositorio.findBySiglaEstado(pageable, siglaEstado);
	}

	// CADASTRAR CIDADE
	public Cidades cadastrarCidade(Cidades cidade) {
		return repositorio.save(cidade);
	}

	// EDITAR CIDADE
	public Cidades atualizarCidades(Long id, Cidades cidade) {
		try {
			Cidades cidUp = repositorio.getOne(id); // prepara o obj pra gente mexer
			atualizarDados(cidUp, cidade);
			return repositorio.save(cidUp);
		} catch (EntityNotFoundException e) {
			throw new CidadeNaoEncontrada(id);
		}
	}

	// Campos do cadastro permitem edição
	private void atualizarDados(Cidades cidUp, Cidades cidade) {
		cidUp.setNomeCidade(cidUp.getNomeCidade());
		cidUp.setNomeEstado(cidUp.getNomeEstado());
		cidUp.setSiglaEstado(cidUp.getSiglaEstado());
		
	}
}
