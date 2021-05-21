package com.rodolfoamaral.casevsm.entidades.dto;

import org.springframework.data.domain.Sort;

public class FiltroDTO<T> {
	
	private T objeto;
	private int page = 0;
	private int size = 9;
	private Sort sort;
		
	public T getObjeto() {
		return objeto;
	}
	public void setObjeto(T objeto) {
		this.objeto = objeto;
	}
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	public int getSize() {
		return size;
	}
	public void setSize(int size) {
		this.size = size;
	}
	public Sort getSort() {
		return sort;
	}
	public void setSort(Sort sort) {
		this.sort = sort;
	}
}
