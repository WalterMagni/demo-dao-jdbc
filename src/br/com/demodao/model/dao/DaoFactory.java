package br.com.demodao.model.dao;

import br.com.demodao.db.DB;
import br.com.demodao.model.dao.impl.SellerDaoJDBC;

public class DaoFactory {

	public static SellerDao createSellerDao() {
		return new SellerDaoJDBC(DB.getConnection());
	}
	
}
