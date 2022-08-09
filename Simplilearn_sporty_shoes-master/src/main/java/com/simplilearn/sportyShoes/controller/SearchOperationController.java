package com.simplilearn.sportyShoes.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.simplilearn.sportyShoes.model.ShoesPurchaseReport;
import com.simplilearn.sportyShoes.model.ShoeInVentory;
import com.simplilearn.sportyShoes.service.SportyShoesService;

@RestController
public class SearchOperationController {
	
	@Autowired
	private SportyShoesService service;
	
	
	@GetMapping("/admin/shoe/all")
	public ResponseEntity<List<ShoeInVentory>> getAllShoes(){
		return new ResponseEntity<List<ShoeInVentory>>(service.getAllShoes(), HttpStatus.OK);
	}
	
	
	@GetMapping("/admin/purchaseReport/category/{category}")
	public ResponseEntity<List<ShoesPurchaseReport>> getAllPurchaseReportsByCategory(@PathVariable String category){
		return new ResponseEntity<List<ShoesPurchaseReport>>(service.getAllPurchaseReportsByCategory(category), HttpStatus.OK);
	}
	
	
	@GetMapping("/admin/purchaseReport/date/{dateInMs}")
	public ResponseEntity<List<ShoesPurchaseReport>> getAllPurchaseReportsByDop(@PathVariable Long dateInMs){
		Date dop = new Date(dateInMs);
		return new ResponseEntity<List<ShoesPurchaseReport>>(service.getAllPurchaseReportsByDOP(dop), HttpStatus.OK);
	}
	
	
	@GetMapping("/admin/purchaseReport/all")
	public ResponseEntity<List<ShoesPurchaseReport>> getAllPurchaseReport(){
		return new ResponseEntity<List<ShoesPurchaseReport>>(service.getAllPurchaseReports(), HttpStatus.OK);
	}
}
