package com.zensar.stock.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zensar.stock.dto.Stock;
import com.zensar.stock.service.StockService;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(value = "/zenmarketapp")
public class StockController {

	@Autowired
	StockService stockService;
	
	
	@DeleteMapping(value="/stock")
	public boolean deleteAllStocks() {
		return stockService.deleteAllStocks();
	}
	
	@DeleteMapping(value="/stock/{id}")
	public boolean deleteStockById(@PathVariable("id") int stockId) {
		return stockService.deleteStockById(stockId);
	}
	
	@PutMapping(value="/stock/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public Stock updateStock(@PathVariable("id") int stockId, @RequestBody Stock stock) {
		return stockService.updateStock(stockId, stock);
	}
	
	@PostMapping(value="/stock", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public Stock createNewStock(@RequestBody Stock stock) {
		return stockService.createNewStock(stock);
	}

	/*
	///stock/id?stockId=2
	@GetMapping(value="/stock/id", produces = MediaType.APPLICATION_JSON_VALUE)
	public Stock getStockById(@RequestParam("stockId") int stockId, @RequestHeader("auth-token") String authToken) {
		System.out.println("AUTH-TOKEN - " + authToken);
		for(Stock stock: stocks) {
			if(stock.getId() == stockId) { //Stock found
				return stock;
			}
		}
		return null;
	}
	*/
	
	
	@GetMapping(value="/stock/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public Stock getStockById(@PathVariable("id") int stockId) {
		return stockService.getStockById(stockId);
	}
	
	@GetMapping(value="/stock", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Stock> getAllStock() {
		return stockService.getAllStock();
	}
	
	
}




