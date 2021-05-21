package com.rodolfoamaral.casevsm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rodolfoamaral.casevsm.entidades.Cidades;
import com.rodolfoamaral.casevsm.exceptions.CidadeNaoEncontrada;
import com.rodolfoamaral.casevsm.servicos.CidadeServico;

@RestController
@RequestMapping(value = "/cidades")
public class CidadesController {
	
	@Autowired
	private CidadeServico servEst;
	
	@GetMapping
	public ResponseEntity<List<Cidades>> findAll(){
		List<Cidades> listaEst = servEst.pesquisaTodos();
		return ResponseEntity.ok().body(listaEst); 
	}
	
	@GetMapping(value = "/{nome}")
	public ResponseEntity<Cidades> findById(@PathVariable String nome) throws CidadeNaoEncontrada{
		Cidades est = servEst.findNome(nome);
		return ResponseEntity.ok().body(est);
	}
}
