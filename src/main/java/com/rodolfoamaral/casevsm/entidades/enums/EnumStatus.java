package com.rodolfoamaral.casevsm.entidades.enums;

public enum EnumStatus {
	
	ATIVO("A", "Ativo"),
	INATIVO("I", "Inativo");
	private String codigo;
	private String descricao;
		
	private EnumStatus(String codigo, String descricao) {
		this.codigo = codigo;
		this.descricao = descricao;
	}
	
	public static EnumStatus get(String valor) {
		if (valor == null) {
			return null;
		}
		for (EnumStatus status : EnumStatus.values()) {
			if (status.codigo.equals(valor)) {
				return status;
			}
		}
		return null;
	}
	
	public String getCodigo() {
		return codigo;
	}
	public String getDescricao() {
		return descricao;
	}
	
	
}
