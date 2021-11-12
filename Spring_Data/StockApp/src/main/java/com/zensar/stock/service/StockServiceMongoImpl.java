package com.zensar.stock.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service(value = "MONGO_SERVICE")
public class StockServiceMongoImpl { //implements StockService {

	//@Autowired
	//StockMongoRepo stockMongoRepository;
	@Autowired
	ModelMapper modelMapper;
/*	
	@Override
	public Stock createNewStock(Stock stock) {
		StockDocument stockDocument = this.modelMapper.map(stock, StockDocument.class);
		stockDocument = this.stockMongoRepository.save(stockDocument);
		Stock stockDto = this.modelMapper.map(stockDocument, Stock.class);
		return stockDto;
	}

	@Override
	public boolean deleteAllStocks() {
		stockMongoRepository.deleteAll();
		return true;
	}

	@Override
	public boolean deleteStockById(int stockId) {
		stockMongoRepository.deleteById(stockId);
		return true;
	}

	@Override
	public Stock updateStock(int stockId, Stock stock) {
		Optional<StockDocument> opStockDocument = stockMongoRepository.findById(stockId);
		if(opStockDocument.isPresent()) { //Correct stockId
			StockDocument stockDocument = opStockDocument.get();
			
			stockDocument.setMarketName(stock.getMarketName());
			stockDocument.setName(stock.getName());
			stockDocument.setPrice(stock.getPrice());
			
			stock.setId(stockId);
			stockDocument = this.modelMapper.map(stock, StockDocument.class);
			stockDocument = stockMongoRepository.save(stockDocument);
			Stock stockDto = this.modelMapper.map(stockDocument, Stock.class);
			return stockDto;
		}
		return null;
	}

	@Override
	public Stock getStockById(int stockId) {
		Optional<StockDocument> opStockDocument = stockMongoRepository.findById(stockId);
		if(opStockDocument.isPresent()) { //Correct stockId
			StockDocument stockDocument = opStockDocument.get();
			Stock stockDto = this.modelMapper.map(stockDocument, Stock.class);
			return stockDto;
		}
		return null;
	}

	@Override
	public List<Stock> getAllStock() {
		List<StockDocument> stockDocumentList = stockMongoRepository.findAll();
		return getStockDtoList(stockDocumentList);
	}

	private List<Stock> getStockDtoList(List<StockDocument> stockDocumentList) {
		List<Stock> stockDtoList = new ArrayList<Stock>();
		for(StockDocument stockDocument: stockDocumentList) {
			Stock stockDto = this.modelMapper.map(stockDocument, Stock.class);
			stockDtoList.add(stockDto);
		}
		return stockDtoList;
	}
*/
}
