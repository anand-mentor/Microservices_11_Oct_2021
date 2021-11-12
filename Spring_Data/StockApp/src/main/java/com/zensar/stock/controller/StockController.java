package com.zensar.stock.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;

import com.zensar.stock.dto.Stock;
import com.zensar.stock.exception.InvalidStockIdException;
import com.zensar.stock.service.StockService;

import io.swagger.annotations.ApiOperation;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(value = "/zenmarketapp")
public class StockController {

	@Autowired
	@Qualifier("JPA_SERVICE")
	StockService stockService;
	
	//Local Exception Handler
	@ExceptionHandler(value = {InvalidStockIdException.class})
	public ResponseEntity<Object> handleInvalidStockIdException(RuntimeException exception,
			WebRequest request) {
		return new ResponseEntity<Object>("Local exception handler - Invalid stock id",
				HttpStatus.BAD_REQUEST);
	}
	
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
	
	@PostMapping(value="/stock", consumes = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE }, 
			produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
	@ApiOperation(value="This REST endpoint creates new Stock")
	public @ResponseBody ResponseEntity<Stock> createNewStock(@RequestBody Stock stock) {
		stock = stockService.createNewStock(stock);
		return new ResponseEntity(stock, HttpStatus.CREATED);
	}

	@GetMapping(value="/stock/{id}")
	public Stock getStockById(@PathVariable("id") int stockId) {
		return stockService.getStockById(stockId);
	}

	@GetMapping(value="/stock", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Stock> getAllStock() {
		return stockService.getAllStock();
	}
	/*
	@GetMapping(value="/stock/name/{name}", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Stock> getStocksByName(@PathVariable("name") String name) {
		return stockService.findByName(name);
	}

	@GetMapping(value="/stock/marketname/{marketname}", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Stock> getStocksByMarketName(@PathVariable("marketname") String marketname) {
		return stockService.findByMarketName(marketname);
	}

	@GetMapping(value="/stock/marketname/{marketname}/name/{name}", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Stock> getStocksByNameAndMarketName(@PathVariable("marketname") String marketname, @PathVariable("name") String name) {
		return stockService.findByNameAndMarketName(name, marketname);
	}

	@GetMapping(value="/stock/name/like/{name}", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Stock> getStocksByNameLike(@PathVariable("name") String name) {
		return stockService.findByNameLike(name);
	}

	@GetMapping(value="/stock/name/sort/{sortType}", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Stock> getStocksOrderByName(@PathVariable("sortType") String sortType) {
		return stockService.findByOrderByName(sortType);
	}

	@GetMapping(value="/stock/page/{startIndex}/{records}", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Stock> getStocksByPage(@PathVariable("startIndex") int startIndex, @PathVariable("records") int records) {
		return stockService.findByPage(startIndex, records);
	}
	*/
}




