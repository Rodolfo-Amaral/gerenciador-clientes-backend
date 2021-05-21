package com.rodolfoamaral.casevsm.exceptions;

public class ClienteNaoEncontrado extends RuntimeException{
	private static final long serialVersionUID = 1L;

	public ClienteNaoEncontrado(Object id) {
		super("Cliente não encontrado: " + id + " não está cadastrado!");
	}

}
