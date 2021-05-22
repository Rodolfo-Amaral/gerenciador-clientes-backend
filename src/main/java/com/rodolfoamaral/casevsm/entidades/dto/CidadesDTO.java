package com.rodolfoamaral.casevsm.entidades.dto;

import java.io.Serializable;

import com.rodolfoamaral.casevsm.entidades.Cidades;

public class CidadesDTO implements Serializable{
		private static final long serialVersionUID = 1L;
		
		private Long id;
		private String nomeCidade;
		private String nomeEstado;
		private String siglaEstado;

		public CidadesDTO() {
		}
		
		public CidadesDTO(Long id, String nomeCidade, String nomeEstado, String siglaEstado) {
			super();
			this.id = id;
			this.nomeCidade = nomeCidade;
			this.nomeEstado = nomeEstado;
			this.siglaEstado = siglaEstado;
		}
		
		public CidadesDTO(Cidades cidade) {
			id = cidade.getId();
			nomeCidade = cidade.getNomeCidade();
			nomeEstado = cidade.getNomeEstado();
			siglaEstado = cidade.getSiglaEstado();
		}

		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

		public String getNomeCidade() {
			return nomeCidade;
		}

		public void setNomeCidade(String nomeCidade) {
			this.nomeCidade = nomeCidade;
		}

		public String getNomeEstado() {
			return nomeEstado;
		}

		public void setNomeEstado(String nomeEstado) {
			this.nomeEstado = nomeEstado;
		}

		public String getSiglaEstado() {
			return siglaEstado;
		}

		public void setSiglaEstado(String siglaEstado) {
			this.siglaEstado = siglaEstado;
		}
}
