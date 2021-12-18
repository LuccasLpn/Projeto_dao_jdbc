package model.dao.Impl;

import ex.DB;
import ex.DbException;
import java.sql.Connection;
import java.util.List;
import java.sql.*;
import java.util.ArrayList;
import model.dao.DepartmentDao;
import model.entities.Department;

public class DepartmentDaoJDBC implements DepartmentDao{
    private Connection conn;

    public DepartmentDaoJDBC(Connection conn) {
        this.conn = conn;
    }

    @Override
    public void insert(Department obj) {
        
        PreparedStatement st = null;
        
        try {
            
            st = conn.prepareStatement("INSERT INTO department (Name) VALUES (?)", Statement.RETURN_GENERATED_KEYS);
            st.setString(1, obj.getName());
            
            int rowsaffected = st.executeUpdate();
            
            if(rowsaffected > 0){
                
                ResultSet rs = st.getGeneratedKeys();
                
                if(rs.next()){
                    
                    int id = rs.getInt(1);
                    obj.setId(id);
                    DB.CloseResultSet(rs);
                    
                }
                
            }else{
                throw  new DbException("Unexpected Error! No rows affected! ");
            }
            
                                       
            
        } catch (SQLException e) {
            throw new DbException(e.getMessage());
            
        }
        finally{
            DB.CloseStatement(st);
        }
    
    }

    @Override
    public void update(Department obj) {
        PreparedStatement st = null;
        
        try {
            st = conn.prepareStatement("UPDATE department SET Id = ?, Name = ? WHERE Id = ? ", Statement.RETURN_GENERATED_KEYS);
            
            st.setInt(1, obj.getId());
            st.setString(2, obj.getName());
            st.setInt(3, obj.getId());
            st.executeUpdate();
            
        } catch (SQLException e) {
            throw new DbException(e.getMessage());
            
        }
        finally{
            DB.CloseStatement(st);
        }
       
    }

    @Override
    public void deleteById(Integer id) {
           PreparedStatement st = null;
           
        try {
            st = conn.prepareStatement("DELETE FROM department \n" +
                                       "WHERE Id = ?");
            
            st.setInt(1, id);
            st.executeUpdate();
            
            
        } catch (SQLException e) {
            
            throw new DbException(e.getMessage());
            
        }
        finally{
            DB.CloseStatement(st);
        }
    }

   @Override
	public Department findById(Integer id) {
		PreparedStatement st = null;
		ResultSet rs = null;
		try {
			st = conn.prepareStatement(
				"SELECT * FROM department WHERE Id = ?");
			st.setInt(1, id);
			rs = st.executeQuery();
			if (rs.next()) {
				Department obj = new Department();
				obj.setId(rs.getInt("Id"));
				obj.setName(rs.getString("Name"));
				return obj;
			}
			return null;
		}
		catch (SQLException e) {
			throw new DbException(e.getMessage());
		}
		finally {
			DB.CloseStatement(st);
			DB.CloseResultSet(rs);
		}
	}

    @Override
    public List<Department> findAll() {
        PreparedStatement st = null;
        ResultSet rs = null;
        
    try {
            st = conn.prepareStatement("select * from department order by Name");
            rs = st.executeQuery();
            
            List<Department> list = new ArrayList<>();

            
            while (rs.next()) {
                                  Department obj = new Department();
                                  obj.setId(rs.getInt("Id"));
                                  obj.setName(rs.getString("Name"));
                                  list.add(obj);
                          }
            
                          return list;
            
      
            
        } catch (SQLException e) {
            
            throw new DbException(e.getMessage());
        }
        
        finally{
            
            DB.CloseStatement(st);
            DB.closeConnection();
            
        }
    }



    
    
    
}
