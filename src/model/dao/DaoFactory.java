package model.dao;

import ex.DB;
import model.dao.Impl.DepartmentDaoJDBC;
import model.dao.Impl.SellerDaoJDBC;

public class DaoFactory {
    
    public static SellerDao createSellerdao(){
        return new SellerDaoJDBC(DB.getConnection());
        
    }
    
    public static DepartmentDao createDepartmentdao(){
        return new DepartmentDaoJDBC(DB.getConnection());
    }
    
    
}
