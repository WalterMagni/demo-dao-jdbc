package br.com.demodao.application;

import java.util.List;

import br.com.demodao.model.dao.DaoFactory;
import br.com.demodao.model.dao.SellerDao;
import br.com.demodao.model.entities.Department;
import br.com.demodao.model.entities.Seller;

public class Program {

	public static void main(String[] args) {
		
		SellerDao sellerDAO = DaoFactory.createSellerDao();
		
		System.out.println("=== TEST 1: seller FindById ===");
		Seller seller = sellerDAO.findById(3);		
		System.out.println(seller);
		
		System.out.println();
		System.out.println("=== TEST 2: Department FindById ===");
		Department department = new Department(2, null);
		List<Seller> list = sellerDAO.findByDepartment(department);
		
		for (Seller sel : list) {
			System.out.println(sel);
		}

	}

}
