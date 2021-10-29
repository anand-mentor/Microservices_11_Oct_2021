package com.zensar.stock.dto;

import lombok.Data;

/*
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
*/
@Data
public class Stock {

	private int id;
	private String name;
	private String marketName;
	private double price;
}
