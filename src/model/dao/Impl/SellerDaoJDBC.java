package model.dao.Impl;

import ex.DB;
import ex.DbException;
import java.util.List;
import model.dao.SellerDao;
import model.entities.Seller;
import java.sql.*;
import model.entities.Department;

public class SellerDaoJDBC implements SellerDao{
    
    private Connection conn;
    
    public SellerDaoJDBC(Connection conn){
        this.conn = conn;
    }

    @Override
    public void insert(Seller obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void update(Seller obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void deleteById(Integer id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Seller findById(Integer id) {
        
        PreparedStatement st = null;
        ResultSet rs = null;
        try {
            st = conn.prepareStatement("SELECT seller.*,department.Name as DepName \n" +
                                       "FROM seller INNER JOIN department \n" +
                                       "ON seller.DepartmentId = department.Id \n" +
                                       "WHERE seller.Id = ?");
            st.setInt(1, id);
            rs = st.executeQuery();
            
            if(rs.next()){
              Department dep = new Department();
              dep.setId(rs.getInt("DepartmentId"));
              dep.setName(rs.getString("DepName"));
              
              Seller obj = new Seller();
              obj.setId(rs.getInt("Id"));
              obj.setName(rs.getString("Name"));
              obj.setEmail(rs.getString("Email"));
              obj.setBirDate(rs.getDate("BirthDate"));
              obj.setBaseSalary(rs.getDouble("BaseSalary"));
              obj.setDepartment(dep);
              return obj;
            }
            return null;
            
        } catch (SQLException e) {
            throw new DbException(e.getMessage());
        }
        
        finally{
            
            DB.CloseStatement(st);
            DB.closeConnection();
            
        }
        
        
   
    }

    @Override
    public List<Seller> findAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

  
    
    
    
    
    
}
