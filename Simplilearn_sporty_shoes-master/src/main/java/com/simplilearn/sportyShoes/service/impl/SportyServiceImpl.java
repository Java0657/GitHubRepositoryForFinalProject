package com.simplilearn.sportyShoes.service.impl;

import java.util.Date;
import java.util.List;
import java.util.NoSuchElementException;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.simplilearn.sportyShoes.exceptionHandler.ExceptionHandling;
import com.simplilearn.sportyShoes.model.ShoesPurchaseReport;
import com.simplilearn.sportyShoes.model.ShoeInVentory;
import com.simplilearn.sportyShoes.repository.ShoesPurchaseReportRepository;
import com.simplilearn.sportyShoes.repository.ShoesInventoryRepository;
import com.simplilearn.sportyShoes.service.SportyShoesService;

import lombok.NoArgsConstructor;

@Service
@NoArgsConstructor
public class SportyServiceImpl implements SportyShoesService{
	
	@Autowired
	private ShoesInventoryRepository shoesRepo;
	
	@Autowired
	private ShoesPurchaseReportRepository prRepo;
	
	@PostConstruct
	public void init() {
		ShoeInVentory s1 = new ShoeInVentory(1,"Shoe Name 1","Basketball",1000.24);
		ShoeInVentory s2 = new ShoeInVentory(2,"Shoe Name 2","Cricket",1100.24);
		ShoeInVentory s3 = new ShoeInVentory(3,"Shoe Name 3","Running",900.24);
		ShoeInVentory s4 = new ShoeInVentory(4,"Shoe Name 4","Football",1900.24);
		
		shoesRepo.save(s1);
		shoesRepo.save(s2);
		shoesRepo.save(s3);
		shoesRepo.save(s4);
		
		Date d = new Date(0);
		ShoesPurchaseReport pr1 = new ShoesPurchaseReport(5,"user_1","Running",d,"adidas_runner:5,nike_airmax:10");
		ShoesPurchaseReport pr2 = new ShoesPurchaseReport(6,"user_2","Cricket",d,"adidas_cricket:5,nike_cricket:10");
		ShoesPurchaseReport pr3 = new ShoesPurchaseReport(7,"user_3","Basketball",d,"adidas_basketball:5,nike_basketball:10");
		ShoesPurchaseReport pr4 = new ShoesPurchaseReport(8,"user_4","Football",d,"adidas_football:5,nike_football:10");
		
		prRepo.save(pr1);
		prRepo.save(pr2);
		prRepo.save(pr3);
		prRepo.save(pr4);
	}

	public ShoeInVentory createShoe(ShoeInVentory shoeInVentory) throws ExceptionHandling {
		int id = shoeInVentory.getId();
		ShoeInVentory oldShoe = null;
		try {
			oldShoe = shoesRepo.findById(id).get();
		}catch(NoSuchElementException e) {
			
		}
		if(oldShoe!=null) throw new ExceptionHandling("Shoe already exists with id: "+id);
		return shoesRepo.save(shoeInVentory);
	}

	public ShoeInVentory getShoeById(int id) throws ExceptionHandling {
		ShoeInVentory shoeInVentory = null;
		try {
			if(id<=0) throw new ExceptionHandling("Shoe Id can not be negative or zero");
			shoeInVentory = shoesRepo.findById(id).get();
		}catch(NoSuchElementException e) {
			throw new ExceptionHandling("Shoe not found with Id: "+id);
		}
		return shoeInVentory;
	}
	
	public ShoeInVentory updateShoe(ShoeInVentory shoeInVentory) {
		return shoesRepo.save(shoeInVentory);
	}

	public void deleteShoeById(int id) throws ExceptionHandling {
		try {
			shoesRepo.deleteById(id);
		}catch(IllegalArgumentException e) {
			throw new ExceptionHandling("Invalid id: "+id);
		}catch(EmptyResultDataAccessException e) {
			throw new ExceptionHandling("SHoe does not exist with id: "+id);
		}
	}

	public List<ShoeInVentory> getAllShoes() {
		return shoesRepo.findAll();
	}

	public ShoesPurchaseReport createPurchaseReport(ShoesPurchaseReport pr) throws ExceptionHandling {
		int id = pr.getId();
		ShoesPurchaseReport oldPr = null;
		try {
			oldPr = prRepo.findById(id).get();
		}catch(NoSuchElementException e) {
			
		}
		if(oldPr!=null) throw new ExceptionHandling("Purchase report already exists with id: "+id);
		return prRepo.save(pr);	
	}

	public ShoesPurchaseReport getPurchaseReportById(int id) throws ExceptionHandling {
		ShoesPurchaseReport pr = null;
		try {
			if(id<=0) throw new ExceptionHandling("Purchase Report Id can not be negative or zero");
			pr = prRepo.findById(id).get();
		}catch(NoSuchElementException e) {
			throw new ExceptionHandling("Purchase Report not found with Id: "+id);
		}
		return pr;
	}
	
	public ShoesPurchaseReport updatePurchaseReport(ShoesPurchaseReport pr) {
		return prRepo.save(pr);
	}
	
	public void deletePurchaseReportById(int id) throws ExceptionHandling {
		try {
			prRepo.deleteById(id);
		}catch(IllegalArgumentException e) {
			throw new ExceptionHandling("Invalid id: "+id);
		}catch(EmptyResultDataAccessException e) {
			throw new ExceptionHandling("Puchase Report does not exist with Id: "+id);
		}
	}


	public List<ShoesPurchaseReport> getAllPurchaseReports() {
		return prRepo.findAll();
	}

	public List<ShoesPurchaseReport> getAllPurchaseReportsByCategory(String category) {
		return prRepo.findByCategory(category);
	}
	

	public List<ShoesPurchaseReport> getAllPurchaseReportsByDOP(Date dop) {
		return prRepo.findByDop(dop);
	}

}
