package br.com.demodao.application;

import br.com.demodao.model.dao.DaoFactory;
import br.com.demodao.model.dao.SellerDao;
import br.com.demodao.model.entities.Seller;

public class Program {

	public static void main(String[] args) {
		
		SellerDao sellerDAO = DaoFactory.createSellerDao();
		
		System.out.println("=== TEST 1: seller FindById ===");
		Seller seller = sellerDAO.findById(3);
		
		System.out.println(seller);

	}

}
