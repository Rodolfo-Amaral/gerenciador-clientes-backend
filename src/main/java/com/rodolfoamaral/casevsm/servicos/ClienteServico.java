package com.rodolfoamaral.casevsm.servicos;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rodolfoamaral.casevsm.entidades.Cliente;
import com.rodolfoamaral.casevsm.entidades.enums.EnumStatus;
import com.rodolfoamaral.casevsm.exceptions.ClienteNaoEncontrado;
import com.rodolfoamaral.casevsm.repositories.ClienteRepositorio;

@Service
public class ClienteServico {
	
	@Autowired
	private ClienteRepositorio repositorio;
	
	//RETORNAR TODOS OS CLIENTES
	public List<Cliente> listarTodos(){
		return repositorio.findAll();
	}
	
	/*
	public Page<ClienteDTO> listarTodos(Pageable pageable){
		repositorio.listarTodos(pageable);
		Page<ClienteDTO> clientes = repositorio.listarTodos(pageable);
		return clientes.map(x -> new ClienteDTO());
	}*/
	
	public List<Cliente> listarTodosAtivos(){
		return repositorio.listarTodosAtivos(EnumStatus.ATIVO);
	}
	
	//PESQUISAR CLIENT PELA ID
	public Cliente pesquisaID(Long id) {
		Optional<Cliente> clid = repositorio.findById(id);
		return clid.orElseThrow(() -> new ClienteNaoEncontrado(clid));
	}
	
	//PESQUISAR POR CPF
	public Cliente pesquisaCPF(String cpfCnpj) {
		Optional<Cliente> cliCpf = repositorio.findByCpfCnpj(cpfCnpj);
		return cliCpf.get();
	}
	
	
	/*
	//PESQUISAR PELO NOME
	public Cliente pesquisaNome() {
		Optional<Cliente> nomeCliente = repositorio.findAll(pesquisaNome().getNome());
		return nomeCliente.get();
	}*/
	
	//CADASTRAR CLIENTE
	public Cliente cadastrarCliente(Cliente cli) {
		return repositorio.save(cli);
	}
	
	//EDITAR DADOS DO CLIENTE
	public Cliente atualizarCliente(Long id, Cliente cliente) {
		try {
		Cliente cliUp = repositorio.getOne(id); //prepara o obj pra gente mexer
		atualizarDados(cliUp, cliente);
		return repositorio.save(cliUp);
		} catch (EntityNotFoundException e) {
			throw new ClienteNaoEncontrado(id);
		}
	}
	//Campos do cadastro do cliente que permitem edição
	private void atualizarDados(Cliente cliUp, Cliente cliente) {
		cliUp.setNome(cliente.getNome());
		cliUp.setEmail(cliente.getEmail());
		cliUp.setSexo(cliente.getSexo());
		cliUp.setFone(cliente.getFone());
		cliUp.setCep(cliente.getCep());
		cliUp.setLogradouro(cliente.getLogradouro());
		cliUp.setNumero(cliente.getNumero());
		cliUp.setBairro(cliente.getBairro());
		cliUp.setComplemento(cliente.getComplemento());
		cliUp.setStatus(cliente.getStatus());
	}
}
