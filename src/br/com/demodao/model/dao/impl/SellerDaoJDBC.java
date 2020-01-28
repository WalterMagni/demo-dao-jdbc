package br.com.demodao.model.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import br.com.demodao.db.DB;
import br.com.demodao.db.DbException;
import br.com.demodao.model.dao.SellerDao;
import br.com.demodao.model.entities.Department;
import br.com.demodao.model.entities.Seller;

public class SellerDaoJDBC implements SellerDao {
	
	private Connection conn;
	private PreparedStatement st = null;
	private ResultSet rs = null;
	
	public SellerDaoJDBC(Connection conn) {
		this.conn = conn;
	}
	
	

	@Override
	public void insert(Seller obj) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(Seller obj) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteById(Integer id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Seller findById(Integer id) {
		
		try {
			st = conn.prepareStatement("SELECT seller.*,department.Name as DepName FROM seller INNER JOIN department ON seller.DepartmentId = department.Id WHERE seller.Id = ?");
			st.setInt(1, id);
			rs = st.executeQuery();
			if (rs.next()) {			
				Department dept = instantiateDepartment(rs);
				Seller obj = instantiateSeller(rs, dept);
				return obj;
			}
			return null;
		} catch (SQLException e) {
			throw new DbException(e.getMessage());
		} finally {
			DB.closeStatement(st);
			DB.closeResultSet(rs);
		}
	}

	@Override
	public List<Seller> findAll() {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public List<Seller> findByDepartment(Department department) {
		
		try {
			st = conn.prepareStatement("SELECT seller.*,department.Name as DepName FROM seller INNER JOIN department ON seller.DepartmentId = department.Id WHERE DepartmentId = ? ORDER BY Name");
			st.setInt(1, department.getId());
			rs = st.executeQuery();
			
			List<Seller> sellers = new ArrayList<>();
			Map<Integer, Department> map = new HashMap<>();
			
			while(rs.next()) {
				
				Department dept = map.get(rs.getInt("DepartmentId"));
				
				if (dept == null) {
					dept = instantiateDepartment(rs);
					map.put(rs.getInt("DepartmentId"), dept);
				}
				
				Seller obj = instantiateSeller(rs, dept);
				sellers.add(obj);
				
			}
			return sellers;
			
		} catch (SQLException e) {
			throw new DbException(e.getMessage());
		} finally {
			DB.closeStatement(st);
			DB.closeResultSet(rs);
		}
	}
	
	private Department instantiateDepartment(ResultSet rs) throws SQLException {
		Department dept = new Department();
		dept.setId(rs.getInt("DepartmentId"));
		dept.setName(rs.getString("DepName"));		
		return dept;
	}
	
	private Seller instantiateSeller(ResultSet rs, Department dept) throws SQLException {
		Seller obj = new Seller();
		obj.setId(rs.getInt("Id"));
		obj.setName(rs.getString("Name"));
		obj.setEmail(rs.getString("Email"));
		obj.setBaseSalary(rs.getDouble("BaseSalary"));
		obj.setBirthDate(rs.getDate("BirthDate"));
		obj.setDepartment(dept);		
		return obj;
	}

	
}
