package com.rodolfoamaral.casevsm.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.rodolfoamaral.casevsm.entidades.Cliente;
import com.rodolfoamaral.casevsm.servicos.ClienteServico;

@RestController //indicar que é um recurso web de Clientes
@RequestMapping(value = "/clientes")
public class ClienteController {
	
	@Autowired
	private ClienteServico servico;
	
	//Pesquisar Clientes
	@GetMapping
	public List<Cliente> listarTodos(){
		return servico.listarTodos();
		
	}
	/*public ResponseEntity<Page<ClienteDTO>> listarTodos(Pageable pageable) {
		Page<ClienteDTO> lista = servico.listarTodos(pageable);
		return ResponseEntity.ok(lista);
	}*/
	
	@GetMapping("/listarAtivos")
	public ResponseEntity<List<Cliente>> listarTodosAtivos(){
		List<Cliente> lista = servico.listarTodosAtivos();
		return ResponseEntity.ok().body(lista);
	}
	
	@GetMapping(value = "/{cpfCnpj}")
	public ResponseEntity<Cliente> pesquisaDoc(@PathVariable String cpfCnpj){
		Cliente nomeCli = servico.pesquisaCPF(cpfCnpj);
		return ResponseEntity.ok().body(nomeCli);
	}
	
	//Cadastro
	@PostMapping("/cadastrar")
	public ResponseEntity<Cliente> cadastrar(@RequestBody Cliente cadCli){ //RequestBody = desserializar para um obj
		cadCli = servico.cadastrarCliente(cadCli);
		//gerar endereço do cliente cadastrado
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(cadCli.getId()).toUri();
		return ResponseEntity.created(uri).body(cadCli);
	}
	//Editar
	@PutMapping(value = "/editar/{id}")
	public ResponseEntity<Cliente> editarCliente(@PathVariable Long id, @RequestBody Cliente cli) {
		cli = servico.atualizarCliente(id, cli);
		return ResponseEntity.ok().body(cli);
	}
}
