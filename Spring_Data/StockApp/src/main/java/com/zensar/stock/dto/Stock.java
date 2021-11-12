package com.zensar.stock.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/*
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
*/
@Data
@ApiModel("Stock DTO holding basic stock info")
public class Stock {

	@ApiModelProperty(value="Unique identifier for the stock")
	private int id;
	@ApiModelProperty(value="Stock's name")
	private String name;
	private String marketName;
	private double price;
}
