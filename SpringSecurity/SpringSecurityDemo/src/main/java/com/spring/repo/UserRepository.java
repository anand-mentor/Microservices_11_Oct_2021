package com.spring.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.entity.UserEntity;

public interface UserRepository extends JpaRepository<UserEntity, Integer>{
	List<UserEntity> findByUsername(String username);
}
