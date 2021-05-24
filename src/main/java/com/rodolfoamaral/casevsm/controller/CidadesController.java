package com.rodolfoamaral.casevsm.controller;

import java.net.URI;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.rodolfoamaral.casevsm.entidades.Cidades;
import com.rodolfoamaral.casevsm.entidades.dto.FiltroDTO;
import com.rodolfoamaral.casevsm.servicos.CidadeServico;

@RestController
@RequestMapping(value = "/cidades")
public class CidadesController {

	@Autowired
	private CidadeServico servico;

	@GetMapping("/listar")
	public ResponseEntity<Page<Cidades>> findAll(FiltroDTO<Cidades> id, Pageable pageable) {
		Page<Cidades> lista = servico.findAll(pageable);
		return ResponseEntity.ok().body(lista);
	}

	@GetMapping(value = "/{nomeCidade}")
	public Cidades findByNomeCidade(@PathVariable String nomeCidade) {
		return servico.pesquisaNome(nomeCidade);
	}

	@GetMapping(value = "/estados/{siglaEstado}")
	public ResponseEntity<Page<Cidades>> findBySiglaEstado(@PathVariable String siglaEstado, Pageable pageable) {
		Page<Cidades> siglas = servico.findBySiglaEstado(pageable, siglaEstado);
		return ResponseEntity.ok().body(siglas);
	}

	//Cadastro de Cidades
	@PostMapping("/cadastrar")
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<Cidades> cadastrarCidade(@RequestBody Cidades cadCid) { // RequestBody = desserializar para um obj
		cadCid = servico.cadastrarCidade(cadCid);
		// gerar endereço do cidente cadastrado
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(cadCid.getId()).toUri();
		return ResponseEntity.created(uri).body(cadCid);
	}

	// Editar
	@PutMapping("/editar/{id}")
	public ResponseEntity<Cidades> editarTopico(@RequestBody Cidades cidade, @PathVariable Long id) {
		Cidades editarCid = servico.atualizarCidades(id, cidade);		
		BeanUtils.copyProperties(cidade, editarCid, "id");
		servico.atualizarCidades(id, cidade);
	
		return ResponseEntity.ok(editarCid);
	}

}
