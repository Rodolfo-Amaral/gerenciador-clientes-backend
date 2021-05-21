package com.rodolfoamaral.casevsm.entidades.dto;

import java.time.LocalDateTime;

import com.rodolfoamaral.casevsm.entidades.Cliente;
import com.rodolfoamaral.casevsm.entidades.enums.EnumStatus;

public class ClienteDTO {

	private Long id;
	private String nome;
	private String cpfCnpj;
	private String sexo;
	private String cidade;
	private String estado;
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
	
	
	
	public ClienteDTO() {
	}
	
	public ClienteDTO(Cliente cliente) {
		id = cliente.getId();
		nome = cliente.getNome();
		cpfCnpj = cliente.getCpfCnpj();
		status = cliente.getStatus();
	}
	public ClienteDTO(Long id, String nome, String cpfCnpj, String sexo, String cidade, String estado,
			String logradouro, Integer numero, String bairro, String cep, String complemento, String fone, String email,
			String estadoCivil, LocalDateTime dataCadastro, EnumStatus status) {
	
		this.id = id;
		this.nome = nome;
		this.cpfCnpj = cpfCnpj;
		this.sexo = sexo;
		this.cidade = cidade;
		this.estado = estado;
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
	public String getSexo() {
		return sexo;
	}
	public void setSexo(String sexo) {
		this.sexo = sexo;
	}
	public String getCidade() {
		return cidade;
	}
	public void setCidade(String cidade) {
		this.cidade = cidade;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
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
}
