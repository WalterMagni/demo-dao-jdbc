package br.com.demodao.application;

import java.util.Date;
import java.util.List;
import java.util.Scanner;

import br.com.demodao.model.dao.DaoFactory;
import br.com.demodao.model.dao.DepartmentDao;
import br.com.demodao.model.dao.SellerDao;
import br.com.demodao.model.entities.Department;
import br.com.demodao.model.entities.Seller;

public class Program {

//	public static void main(String[] args) {
//		
//		Scanner sc = new Scanner(System.in);
//		SellerDao sellerDAO = DaoFactory.createSellerDao();
//		List<Seller> list;
//		
//		System.out.println("=== TEST 1: seller FindById ===");
//		Seller seller = sellerDAO.findById(3);		
//		System.out.println(seller);
//		
//		System.out.println();
//		System.out.println("=== TEST 2: Seller FindByDepartment ===");
//		Department department = new Department(2, null);
//		list = sellerDAO.findByDepartment(department);	
//		for (Seller sel : list) {
//			System.out.println(sel);
//		}
//		
//		System.out.println();
//		System.out.println("=== TEST 3: Seller FindAll ===");		
//		list = sellerDAO.findAll();	
//		for (Seller sel : list) {
//			System.out.println(sel);
//		}
//		
//		System.out.println();
//		System.out.println("=== TEST 4: Seller Insert ===");
//		Seller newSeller = new Seller(null, "Greg", "Greg@gmail.com", new Date(), 4000, department);
//		sellerDAO.insert(newSeller);
//		System.out.println("Inserted! new id= " + newSeller.getId());
//		
//		System.out.println();
//		System.out.println("=== TEST 5: Seller Update ===");
//		seller = sellerDAO.findById(1);
//		seller.setName("Martha Wayne");
//		sellerDAO.update(seller);
//		System.out.println("Update completed!");
//		
//		System.out.println();
//		System.out.println("=== TEST 6: Seller Delete ===");
//		System.out.print("Select id for delete: ");
//		int id = sc.nextInt();
//		sellerDAO.deleteById(id);
//		System.out.println("delete completed!");
//		
//		sc.close();
//	}
	
	public static void main(String[] args) {
		
		DepartmentDao departmentDAO = DaoFactory.createDepartmentDao();
		List<Department> list;
		
		System.out.println("=== TEST 1: Department FindById ===");
		Department dept = departmentDAO.findById(1);		
		System.out.println(dept);
	
		System.out.println();
		System.out.println("=== TEST 2: Department FindAll ===");		
		list = departmentDAO.findAll();
		for (Department sel : list) {
			System.out.println(sel);
		}
		
		System.out.println();
		System.out.println("=== TEST 3: Department Insert ===");
		dept = new Department(null, "Livraria");
		departmentDAO.insert(dept);
		System.out.println("Inserted! new id= " + dept.getId());
		
		System.out.println();
		System.out.println("=== TEST 4: Department Update ===");
		dept = departmentDAO.findById(1);
		dept.setName("tecnologia");
		departmentDAO.update(dept);
		System.out.println("Update completed!");
		
		System.out.println();
		System.out.println("=== TEST 5: Department Delete ===");
		departmentDAO.deleteById(1);
		System.out.println("delete completed!");
		
		
	}

}
