package projeto_dao_jdbc;

import java.util.Date;
import java.util.List;
import java.util.Scanner;
import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

public class Projeto_dao_jdbc {
    public static void main(String[] args) {
    SellerDao sellerDao = DaoFactory.createSellerdao();
    
    Scanner sc = new Scanner(System.in);
    
    System.out.println("=== TEST 1: seller findById ====");
    Seller seller = sellerDao.findById(3);
    System.out.println(seller);
    
    System.out.println("");
    System.out.println("------------------------------------------------------------------------------------");
    
    System.out.println("\n === TEST 2: seller findByDepartment ====");
    Department department = new Department(2, null);
    List<Seller> list = sellerDao.findByDepartment(department);
    for(Seller obj: list){
        System.out.println(obj);
    }
        
    
    System.out.println("");
    System.out.println("------------------------------------------------------------------------------------");
    
        System.out.println("\n === TEST 3: seller findAll ====");
    
                list = sellerDao.findAll();
                for(Seller obj: list){
                    System.out.println(obj);
                }
                
    System.out.println("");
    System.out.println("------------------------------------------------------------------------------------");            
                
    System.out.println("=== TEST 4: seller Insert ====");
    Seller newSeller = new Seller(null, "Greg", "greg@gmail.com", new Date(), 4000.0, department);
    sellerDao.insert(newSeller);
    System.out.println("Inserted! New id = " + newSeller.getId());
    
    System.out.println("");
    System.out.println("------------------------------------------------------------------------------------");
    
    System.out.println("=== TEST 5: seller Update ==== ");
    seller = sellerDao.findById(1);
    seller.setName("Marthe Wayne");
    sellerDao.update(seller);
    System.out.println("Update completed");
    
    System.out.println("");
    System.out.println("------------------------------------------------------------------------------------");
    
    
    System.out.println("=== TEST 5: seller Delete ==== ");
    System.out.println("Ebnter id for delete test: ");
    int id = sc.nextInt();
    sellerDao.deleteById(id);
    System.out.println("Deleted completed");
    sc.close();
    
        
    
    
    
    
    
    
    
    
}
}
