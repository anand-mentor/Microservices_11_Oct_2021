package com.zensar.stock.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.zensar.stock.entity.StockEntity;

public interface StockRepository extends JpaRepository<StockEntity, Integer>{

}
