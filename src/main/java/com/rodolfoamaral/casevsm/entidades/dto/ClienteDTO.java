package com.rodolfoamaral.casevsm.entidades.dto;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

import com.rodolfoamaral.casevsm.entidades.Cidades;
import com.rodolfoamaral.casevsm.entidades.Cliente;
import com.rodolfoamaral.casevsm.entidades.enums.EnumStatus;


public class ClienteDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Long id;
	private String nome;
	private String cpfCnpj;
	private LocalDate nascimento;
	private String sexo;
	private String logradouro;
	private Integer numero;
	private String bairro;
	private String cep;
	private String complemento;
	private String fone;
	private String email;
	private String estadoCivil;
	private LocalDateTime dataCadastro;
	private EnumStatus status;
	private Cidades nomeCidade;
	
	public ClienteDTO() {
	}
	
	public ClienteDTO(Cliente cliente) {
		id = cliente.getId();
		nome = cliente.getNome();
		cpfCnpj = cliente.getCpfCnpj();
		nascimento = cliente.getNascimento();
		sexo = cliente.getSexo();
		logradouro = cliente.getLogradouro();
		numero = cliente.getNumero();
		bairro = cliente.getBairro();
		cep = cliente.getCep();
		complemento = cliente.getComplemento();
		fone = cliente.getFone();
		email = cliente.getEmail();
		estadoCivil = cliente.getEstadoCivil();
		dataCadastro = cliente.getDataCadastro();
		status = cliente.getStatus();
		nomeCidade = cliente.getNomeCidade();
	}
	
	public ClienteDTO(Long id, String nome, String cpfCnpj, 
			LocalDate nascimento, String sexo, String logradouro, Integer numero, String bairro, 
			String cep, String complemento, String fone, String email, String estadoCivil, 
			LocalDateTime dataCadastro, EnumStatus status, Cidades nomeCidade) {
		this.id = id;
		this.nome = nome;
		this.cpfCnpj = cpfCnpj;
		this.nascimento = nascimento;
		this.sexo = sexo;
		this.logradouro = logradouro;
		this.numero = numero;
		this.bairro = bairro;
		this.cep = cep;
		this.complemento = complemento;
		this.fone = fone;
		this.email = email;
		this.estadoCivil = estadoCivil;
		this.dataCadastro = dataCadastro;
		this.status = status;
		this.nomeCidade = nomeCidade;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpfCnpj() {
		return cpfCnpj;
	}

	public void setCpfCnpj(String cpfCnpj) {
		this.cpfCnpj = cpfCnpj;
	}

	public LocalDate getNascimento() {
		return nascimento;
	}

	public void setNascimento(LocalDate nascimento) {
		this.nascimento = nascimento;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public String getLogradouro() {
		return logradouro;
	}

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

	public Integer getNumero() {
		return numero;
	}

	public void setNumero(Integer numero) {
		this.numero = numero;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public String getFone() {
		return fone;
	}

	public void setFone(String fone) {
		this.fone = fone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getEstadoCivil() {
		return estadoCivil;
	}

	public void setEstadoCivil(String estadoCivil) {
		this.estadoCivil = estadoCivil;
	}

	public LocalDateTime getDataCadastro() {
		return dataCadastro;
	}

	public void setDataCadastro(LocalDateTime dataCadastro) {
		this.dataCadastro = dataCadastro;
	}

	public EnumStatus getStatus() {
		return status;
	}

	public void setStatus(EnumStatus status) {
		this.status = status;
	}

	public Cidades getNomeCidade() {
		return nomeCidade;
	}

	public void setNomeCidade(Cidades nomeCidade) {
		this.nomeCidade = nomeCidade;
	}
}