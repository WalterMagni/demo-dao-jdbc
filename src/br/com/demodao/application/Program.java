package br.com.demodao.application;

import java.util.List;

import br.com.demodao.model.dao.DaoFactory;
import br.com.demodao.model.dao.SellerDao;
import br.com.demodao.model.entities.Department;
import br.com.demodao.model.entities.Seller;

public class Program {

	public static void main(String[] args) {
		
		SellerDao sellerDAO = DaoFactory.createSellerDao();
		List<Seller> list;
		
		System.out.println("=== TEST 1: seller FindById ===");
		Seller seller = sellerDAO.findById(3);		
		System.out.println(seller);
		
		System.out.println();
		System.out.println("=== TEST 2: Seller FindByDepartment ===");
		Department department = new Department(2, null);
		list = sellerDAO.findByDepartment(department);
		
		for (Seller sel : list) {
			System.out.println(sel);
		}
		
		System.out.println();
		System.out.println("=== TEST 3: Seller FindAll ===");
		
		list = sellerDAO.findAll();	
		for (Seller sel : list) {
			System.out.println(sel);
		}

	}

}
