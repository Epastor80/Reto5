
package Reto3H2.Reto3H2.Repositorio;

import Reto3H2.Reto3H2.Interfaces.InterfaceCategoria;
import Reto3H2.Reto3H2.Modelos.Category;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class RepositorioCategoria {
    
    @Autowired
    private InterfaceCategoria crud;
    
    public List <Category> getAll(){
        return (List<Category>) crud.findAll();
    }
    public Optional <Category> getCategory(int id){
        return crud.findById(id);
    }        
    
    public Category save(Category category){
        return  crud.save(category);
    }
    
    public void delete(Category Category){
       crud.delete(Category);
    }
}
