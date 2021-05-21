package com.rodolfoamaral.casevsm.exceptions;

import java.time.Instant;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ResourceExceptionHandler {
	
	@ExceptionHandler(ClienteNaoEncontrado.class)
	public ResponseEntity<StandardError> clienteNaoEncontrado(ClienteNaoEncontrado e, HttpServletRequest request){
		String erro = "Recurso não encontrado!";
		HttpStatus status = HttpStatus.NOT_FOUND;
		StandardError se = new StandardError(Instant.now(), status.value(), erro, e.getMessage(), request.getRequestURI());
		return ResponseEntity.status(status).body(se);
	}

	@ExceptionHandler(CidadeNaoEncontrada.class)
	public ResponseEntity<StandardError> ufNaoEncontrada(CidadeNaoEncontrada e, HttpServletRequest request){
		String erro = "Não encontrado!";
		HttpStatus status = HttpStatus.NOT_ACCEPTABLE;
		StandardError se = new StandardError(Instant.now(), status.value(), erro, e.getMessage(), request.getRequestURI());
		return ResponseEntity.status(status).body(se);
	}
}
