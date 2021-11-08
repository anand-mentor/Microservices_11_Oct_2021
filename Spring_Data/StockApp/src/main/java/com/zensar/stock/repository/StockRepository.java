package com.zensar.stock.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.zensar.stock.dto.Stock;
import com.zensar.stock.entity.StockEntity;

public interface StockRepository extends JpaRepository<StockEntity, Integer>{

	List<StockEntity> findByName(String name);
	List<StockEntity> findByMarketName(String marketName);
	List<StockEntity> findByNameAndMarketName(String name, String marketName);
	
	@Query(value="SELECT * FROM Stock ORDER BY current_value", nativeQuery = true)
	List<StockEntity> sortStocksByPriceDesc();
	
	
	@Query(value = "SELECT se from StockEntity se WHERE se.name LIKE %:name%")
	List<StockEntity> findByNameLike(@Param("name")String stockName);
	
	List<StockEntity> findByNameContaining(String name);
	List<StockEntity> findByNameIsContaining(String name);
	List<StockEntity> findByNameContains(String name);
	
	List<StockEntity> findByOrderByNameAsc();
	List<StockEntity> findByOrderByNameDesc();
	
}
