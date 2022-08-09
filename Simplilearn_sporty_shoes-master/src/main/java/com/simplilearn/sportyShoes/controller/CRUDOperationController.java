package com.simplilearn.sportyShoes.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.simplilearn.sportyShoes.exceptionHandler.ExceptionHandling;
import com.simplilearn.sportyShoes.model.ShoesPurchaseReport;
import com.simplilearn.sportyShoes.model.ShoeInVentory;
import com.simplilearn.sportyShoes.service.SportyShoesService;

@RestController
public class CRUDOperationController {

	@Autowired
	private SportyShoesService service;

	private MultiValueMap<String, String> errorMap;

	
	
	@PostMapping("/admin/shoe")
	public ResponseEntity<ShoeInVentory> createShoe(@RequestBody ShoeInVentory shoeInVentory) {
		try {
			return new ResponseEntity<>(service.createShoe(shoeInVentory), HttpStatus.OK);
		} catch (ExceptionHandling e) {
			errorMap = new LinkedMultiValueMap<>();
			errorMap.add("errorMessage:", e.getMessage());
			return new ResponseEntity<>(null, errorMap, HttpStatus.BAD_REQUEST);
		}
	}

	
	@GetMapping("/admin/shoe/{id}")
	public ResponseEntity<ShoeInVentory> getShoeById(@PathVariable int id) {
		try {
			return new ResponseEntity<>(service.getShoeById(id), HttpStatus.OK);
		} catch (ExceptionHandling e) {
			errorMap = new LinkedMultiValueMap<>();
			errorMap.add("errorMessage:", e.getMessage());
			return new ResponseEntity<>(null, errorMap, HttpStatus.NOT_FOUND);
		}
	}

	
	@PutMapping("/admin/shoe")
	public ResponseEntity<ShoeInVentory> updateShoe(@RequestBody ShoeInVentory shoeInVentory) {
		return new ResponseEntity<>(service.updateShoe(shoeInVentory), HttpStatus.OK);
	}

	
	@DeleteMapping("/admin/shoe/{id}")
	public ResponseEntity<String> deleteShoeById(@PathVariable int id) {
		try {
			service.deleteShoeById(id);
			return new ResponseEntity<>("Succesfully deleted shoe with id: " + id, HttpStatus.OK);
		} catch (ExceptionHandling e) {
			errorMap = new LinkedMultiValueMap<>();
			errorMap.add("errorMessage:", e.getMessage());
			return new ResponseEntity<>(e.getMessage(), errorMap, HttpStatus.BAD_REQUEST);
		}
	}

	
	@PostMapping("/admin/purchaseReport")
	public ResponseEntity<ShoesPurchaseReport> createPurchaseReport(@RequestBody ShoesPurchaseReport pr) {
		try {
			return new ResponseEntity<>(service.createPurchaseReport(pr), HttpStatus.OK);
		} catch (ExceptionHandling e) {
			errorMap = new LinkedMultiValueMap<>();
			errorMap.add("errorMessage:", e.getMessage());
			return new ResponseEntity<>(null, errorMap, HttpStatus.BAD_REQUEST);
		}
	}

	
	@GetMapping("/admin/purchaseReport/id/{id}")
	public ResponseEntity<ShoesPurchaseReport> getPurchaseReportById(@PathVariable int id) {
		try {
			return new ResponseEntity<>(service.getPurchaseReportById(id), HttpStatus.OK);
		} catch (ExceptionHandling e) {
			errorMap = new LinkedMultiValueMap<>();
			errorMap.add("errorMessage:", e.getMessage());
			return new ResponseEntity<>(null, errorMap, HttpStatus.NOT_FOUND);
		}
	}

	
	@PutMapping("/admin/purchaseReport")
	public ResponseEntity<ShoesPurchaseReport> updatePurchaseReport(@RequestBody ShoesPurchaseReport pr) {
		return new ResponseEntity<>(service.updatePurchaseReport(pr), HttpStatus.OK);
	}

	@DeleteMapping("/admin/purchaseReport/{id}")
	public ResponseEntity<String> deletePurchaseReportById(@PathVariable int id) {
		try {
			service.deletePurchaseReportById(id);
			return new ResponseEntity<>("Succesfully deleted Purchase Report with id: " + id, HttpStatus.OK);
		} catch (ExceptionHandling e) {
			errorMap = new LinkedMultiValueMap<>();
			errorMap.add("errorMessage:", e.getMessage());
			return new ResponseEntity<>(e.getMessage(), errorMap, HttpStatus.BAD_REQUEST);
		}
	}
}
