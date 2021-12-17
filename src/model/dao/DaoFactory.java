package model.dao;

import ex.DB;
import model.dao.Impl.SellerDaoJDBC;

public class DaoFactory {
    
    public static SellerDao createSellerdao(){
        return new SellerDaoJDBC(DB.getConnection());
        
    }
    
}
