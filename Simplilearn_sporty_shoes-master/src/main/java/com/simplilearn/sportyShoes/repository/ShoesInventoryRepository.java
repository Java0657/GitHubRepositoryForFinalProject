package com.simplilearn.sportyShoes.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.simplilearn.sportyShoes.model.ShoeInVentory;

@Repository
public interface ShoesInventoryRepository extends JpaRepository<ShoeInVentory, Integer>{
	
}
