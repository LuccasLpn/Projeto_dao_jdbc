package projeto_dao_jdbc;
import model.dao.DaoFactory;
import model.dao.DepartmentDao;
import model.entities.Department;
public class Projeto_dao_jdbc2 {
    public static void main(String[] args) {
      
    DepartmentDao depdao = DaoFactory.createDepartmentdao();
  
    
    
    
    
    /*System.out.println("=== TEST 1: Department Insert ==== ");
    Department newDepartment = new Department(null, "Music");
    depdao.insert(newDepartment);
    System.out.println("Inserted! New id = " + newDepartment.getId());*/
    
    System.out.println("");
    System.out.println("--------------------------------------------");
    
    System.out.println("=== TEST 2: findById =======");
    Department dep = depdao.findById(7);
    System.out.println(dep);
    
    
    System.out.println("");
    System.out.println("--------------------------------------------");
    
    
    System.out.println("=== TEST 3: Update =======");
    dep = depdao.findById(6);
    dep.setName("Dev");
    depdao.update(dep);
    System.out.println("Update completed");
    
    
    
        
        
        
        
        
        
        
        
        
        
        
        
        
        
    }
}