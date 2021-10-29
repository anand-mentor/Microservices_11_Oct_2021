package com.zensar.stock.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zensar.stock.dto.Stock;
import com.zensar.stock.entity.StockEntity;
import com.zensar.stock.repository.StockRepository;

@Service
public class StockServiceImpl implements StockService {

	@Autowired
	StockRepository stockRepository;
	@Autowired
	ModelMapper modelMapper;
	
	@Override
	public Stock createNewStock(Stock stock) {
		StockEntity stockEntity = this.modelMapper.map(stock, StockEntity.class);
		stockEntity = this.stockRepository.save(stockEntity);
		Stock stockDto = this.modelMapper.map(stockEntity, Stock.class);
		return stockDto;
	}

	@Override
	public boolean deleteAllStocks() {
		stockRepository.deleteAll();
		return true;
	}

	@Override
	public boolean deleteStockById(int stockId) {
		stockRepository.deleteById(stockId);
		return true;
	}

	@Override
	public Stock updateStock(int stockId, Stock stock) {
		Optional<StockEntity> opStockEntity = stockRepository.findById(stockId);
		if(opStockEntity.isPresent()) { //Correct stockId
			StockEntity stockEntity = opStockEntity.get();
			/*
			stockEntity.setMarketName(stock.getMarketName());
			stockEntity.setName(stock.getName());
			stockEntity.setPrice(stock.getPrice());
			*/
			stock.setId(stockId);
			stockEntity = this.modelMapper.map(stock, StockEntity.class);
			stockEntity = stockRepository.save(stockEntity);
			Stock stockDto = this.modelMapper.map(stockEntity, Stock.class);
			return stockDto;
		}
		return null;
	}

	@Override
	public Stock getStockById(int stockId) {
		Optional<StockEntity> opStockEntity = stockRepository.findById(stockId);
		if(opStockEntity.isPresent()) { //Correct stockId
			StockEntity stockEntity = opStockEntity.get();
			Stock stockDto = this.modelMapper.map(stockEntity, Stock.class);
			return stockDto;
		}
		return null;
	}

	@Override
	public List<Stock> getAllStock() {
		List<StockEntity> stockEntityList = stockRepository.findAll();
		List<Stock> stockDtoList = new ArrayList<Stock>();
		for(StockEntity stockEntity: stockEntityList) {
			Stock stockDto = this.modelMapper.map(stockEntity, Stock.class);
			stockDtoList.add(stockDto);
		}
		return stockDtoList;
	}

}
