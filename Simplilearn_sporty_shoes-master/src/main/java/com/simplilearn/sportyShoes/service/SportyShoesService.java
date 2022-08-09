package com.simplilearn.sportyShoes.service;

import java.util.Date;
import java.util.List;

import com.simplilearn.sportyShoes.exceptionHandler.ExceptionHandling;
import com.simplilearn.sportyShoes.model.ShoesPurchaseReport;
import com.simplilearn.sportyShoes.model.ShoeInVentory;

public interface SportyShoesService {
	
	public ShoeInVentory createShoe(ShoeInVentory shoeInVentory) throws ExceptionHandling;
	public ShoeInVentory getShoeById(int id) throws ExceptionHandling;
	public ShoeInVentory updateShoe(ShoeInVentory shoeInVentory);
	public void deleteShoeById(int id) throws ExceptionHandling;
	public List<ShoeInVentory> getAllShoes();
	
	public ShoesPurchaseReport createPurchaseReport(ShoesPurchaseReport pr) throws ExceptionHandling;
	public ShoesPurchaseReport getPurchaseReportById(int id) throws ExceptionHandling;
	public ShoesPurchaseReport updatePurchaseReport(ShoesPurchaseReport pr);
	public void deletePurchaseReportById(int id) throws ExceptionHandling;
	public List<ShoesPurchaseReport> getAllPurchaseReports();
	public List<ShoesPurchaseReport> getAllPurchaseReportsByCategory(String category);
	public List<ShoesPurchaseReport> getAllPurchaseReportsByDOP(Date dop);

}
