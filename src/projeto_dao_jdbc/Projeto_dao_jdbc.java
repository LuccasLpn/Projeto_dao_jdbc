package projeto_dao_jdbc;

import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entities.Seller;

public class Projeto_dao_jdbc {
    public static void main(String[] args) {
    SellerDao sellerDao = DaoFactory.createSellerdao();
    
    Seller seller = sellerDao.findById(3);
    
        System.out.println(seller);
    
    

        
        
        
        
        
        
    
}
}
