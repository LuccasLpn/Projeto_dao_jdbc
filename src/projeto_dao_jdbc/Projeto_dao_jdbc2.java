package projeto_dao_jdbc;
import model.dao.DaoFactory;
import model.dao.DepartmentDao;
import model.entities.Department;
public class Projeto_dao_jdbc2 {
    public static void main(String[] args) {
      
    DepartmentDao depdao = DaoFactory.createDepartmentdao();
    
    
    
    
    System.out.println("=== TEST 1: Department Insert ==== ");
    Department newDepartment = new Department(5,"test");
    depdao.insert(newDepartment);
    System.out.println("Inserted! New id = " + newDepartment.getId());
    
    
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
    }
}