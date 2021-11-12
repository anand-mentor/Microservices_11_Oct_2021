package com.zensar.stock.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.zensar.stock.dto.Stock;
import com.zensar.stock.entity.StockEntity;
import com.zensar.stock.exception.InvalidStockIdException;
import com.zensar.stock.repository.StockRepository;

@Service(value = "JPA_SERVICE")
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
		throw new InvalidStockIdException(""+stockId);
	}

	@Override
	public Stock getStockById(int stockId) {
		Optional<StockEntity> opStockEntity = stockRepository.findById(stockId);
		if(opStockEntity.isPresent()) { //Correct stockId
			StockEntity stockEntity = opStockEntity.get();
			Stock stockDto = this.modelMapper.map(stockEntity, Stock.class);
			return stockDto;
		}
		throw new InvalidStockIdException(""+stockId);
		//return null;
	}

	@Override
	public List<Stock> getAllStock() {
		List<StockEntity> stockEntityList = stockRepository.findAll();
		return getStockDtoList(stockEntityList);
	}

	private List<Stock> getStockDtoList(List<StockEntity> stockEntityList) {
		List<Stock> stockDtoList = new ArrayList<Stock>();
		for(StockEntity stockEntity: stockEntityList) {
			Stock stockDto = this.modelMapper.map(stockEntity, Stock.class);
			stockDtoList.add(stockDto);
		}
		return stockDtoList;
	}

	//@Override
	public List<Stock> findByMarketName(String marketName) {
		List<StockEntity> stockEntityList = stockRepository.findByMarketName(marketName);
		return getStockDtoList(stockEntityList);
	}

	//@Override
	public List<Stock> findByName(String name) {
		List<StockEntity> stockEntityList = stockRepository.findByName(name);
		return getStockDtoList(stockEntityList);
	}

	//@Override
	public List<Stock> findByNameAndMarketName(String name, String marketName) {
		List<StockEntity> stockEntityList = stockRepository.findByNameAndMarketName(name, marketName);
		return getStockDtoList(stockEntityList);
	}

	//@Override
	public List<Stock> findByNameLike(String name) {
		List<StockEntity> stockEntityList = stockRepository.findByNameLike(name);
		return getStockDtoList(stockEntityList);
	}

	//@Override
	public List<Stock> findByOrderByName(String sortType) {
		List<StockEntity> stockEntityList = null;
		if("ASC".equalsIgnoreCase(sortType)) {
			stockEntityList = stockRepository.findByOrderByNameAsc();
			/*
			List<Sort.Order> sortOrders = new ArrayList<Sort.Order>();
			Sort.Order order_1 = new Sort.Order(Sort.Direction.ASC, "name");
			Sort.Order order_2 = new Sort.Order(Sort.Direction.DESC, "marketName");
			sortOrders.add(order_1);
			sortOrders.add(order_2);
			stockEntityList = stockRepository.findAll(Sort.by(sortOrders));
			stockEntityList = stockRepository.findAll(Sort.by(new Sort.Order(Sort.Direction.DESC, "price")));
			*/
		}
		if("DESC".equalsIgnoreCase(sortType)) {
			stockEntityList = stockRepository.findByOrderByNameDesc();
		}
		return getStockDtoList(stockEntityList);
	}

	//@Override
	public List<Stock> findByPage(int startIndex, int records) {
		Pageable pageWithFewRecords = PageRequest.of(startIndex, records);
		Page<StockEntity> stockEntityPage = stockRepository.findAll(pageWithFewRecords);
		List<StockEntity> stockEntityList = stockEntityPage.getContent();
		return getStockDtoList(stockEntityList);
	}

}






