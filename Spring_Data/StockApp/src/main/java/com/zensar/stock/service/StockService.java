package com.zensar.stock.service;

import java.util.List;

import com.zensar.stock.dto.Stock;
import com.zensar.stock.entity.StockEntity;

public interface StockService {
	public Stock createNewStock(Stock stock);
	public boolean deleteAllStocks();
	public boolean deleteStockById(int stockId);
	public Stock updateStock(int stockId, Stock stock);
	public Stock getStockById(int stockId);
	public List<Stock> getAllStock();
/*
	List<Stock> findByMarketName(String marketName);
	List<Stock> findByName(String name);
	List<Stock> findByNameAndMarketName(String name, String marketName);

	
	
	
	List<Stock> findByNameLike(String name);	
	List<Stock> findByOrderByName(String sortType);
	List<Stock> findByPage(int startIndex, int records);
*/	
}
	
