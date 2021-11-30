package com.spring.controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StockController {

	//URI versioning - example Twitter
	@GetMapping(value="/api/v1/stock", produces=MediaType.APPLICATION_JSON_VALUE)
	public StockV1 getStockV1() {
		return new StockV1("Zensar");
	}
	@GetMapping(value="/api/v2/stock", produces=MediaType.APPLICATION_JSON_VALUE)
	public StockV2 getStockV2() {
		return new StockV2("Zensar", "NSE");
	}

	//Request parameter versioning - example Amazon
	@GetMapping(value="/api/stock", params = "version=v1")
	public StockV1 getStockParamV1() {
		return new StockV1("Zensar");
	}
	@GetMapping(value="/api/stock", params = "version=v2")
	public StockV2 getStockParamV2() {
		return new StockV2("Zensar", "NSE");
	}
	
	//Custom header versioning - example Microsoft
	@GetMapping(value="/api/stock", produces=MediaType.APPLICATION_JSON_VALUE, headers = "X-API-VERSIONS=v1")
	public StockV1 getStockByHeaderV1() {
		return new StockV1("Zensar");
	}
	@GetMapping(value="/api/stock", produces=MediaType.APPLICATION_JSON_VALUE, headers = "X-API-VERSIONS=v2")
	public StockV2 getStockByHeaderV2() {
		return new StockV2("Zensar", "NSE");
	}

	//Media type/accept header/content negotiation versioning - example GitHub
	@GetMapping(value="/api/stock", produces="application/stock.v1+json")
	public @ResponseBody StockV1 getStockAcceptV1() {
		return new StockV1("Zensar");
	}
	@GetMapping(value="/api/stock", produces="application/stock.v2+json")
	public @ResponseBody StockV2 getStockAcceptV2() {
		return new StockV2("Zensar", "NSE");
	}
}

