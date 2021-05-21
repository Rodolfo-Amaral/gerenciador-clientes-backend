package com.rodolfoamaral.casevsm.exceptions;

public class CidadeNaoEncontrada extends RuntimeException{
	private static final long serialVersionUID = 1L;

	public CidadeNaoEncontrada(Object id) {
		super("UF não encontrada!");
	}

}
