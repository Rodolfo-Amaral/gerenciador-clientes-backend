package com.rodolfoamaral.casevsm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rodolfoamaral.casevsm.entidades.Cidades;
import com.rodolfoamaral.casevsm.entidades.dto.FiltroDTO;
import com.rodolfoamaral.casevsm.servicos.CidadeServico;

@RestController
@RequestMapping(value = "/cidades")
public class CidadesController {
	
	@Autowired
	private CidadeServico servico;
	
	@GetMapping
	public ResponseEntity<Page<Cidades>> findAll(FiltroDTO<Cidades> id, Pageable pageable){
		Page<Cidades> lista = servico.findAll(pageable);
		return ResponseEntity.ok().body(lista); 
	}
	
	@GetMapping(value = "/{nomeCidade}")
	public Cidades findByNomeCidade(@PathVariable String nomeCidade){
		return servico.pesquisaNome(nomeCidade);
	}
	
	@GetMapping(value = "/estados/{siglaEstado}")
	public ResponseEntity<Page<Cidades>> findBySiglaEstado(@PathVariable String siglaEstado, Pageable pageable){
		Page<Cidades> siglas = servico.findBySiglaEstado(pageable, siglaEstado);
		return ResponseEntity.ok().body(siglas);
	}
	
}
