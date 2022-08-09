package com.simplilearn.sportyShoes.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.simplilearn.sportyShoes.model.ShoesPurchaseReport;

@Repository
public interface ShoesPurchaseReportRepository extends JpaRepository<ShoesPurchaseReport, Integer>{
	public List<ShoesPurchaseReport> findByDop(Date dop);
	public List<ShoesPurchaseReport> findByCategory(String category);

}
