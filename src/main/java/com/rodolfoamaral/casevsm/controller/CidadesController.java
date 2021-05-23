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
		Page<Cidades> listaEst = servico.findAll(pageable);
		return ResponseEntity.ok().body(listaEst); 
	}
	
	@GetMapping(value = "/{nomeCidade}")
	public ResponseEntity<Cidades> pesquisaDoc(@PathVariable String nomeCidade){
		Cidades nomeCid = servico.pesquisaNome(nomeCidade);
		return ResponseEntity.ok().body(nomeCid);
	}
	
}
