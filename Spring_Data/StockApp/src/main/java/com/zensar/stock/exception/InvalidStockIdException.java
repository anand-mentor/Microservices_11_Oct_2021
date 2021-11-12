package com.zensar.stock.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value=HttpStatus.BAD_REQUEST)
public class InvalidStockIdException extends RuntimeException {

	private String msg;
	public InvalidStockIdException() {
		this.msg = "";
	}
	public InvalidStockIdException(String msg) {
		this.msg = msg;
	}
	@Override
	public String toString() {
		return "Invalid stock id " + this.msg;
	}
}
