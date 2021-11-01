
package Reto3H2.Reto3H2.Servicios;

import Reto3H2.Reto3H2.Repositorio.RepositorioCategoria;
import Reto3H2.Reto3H2.Modelos.Category;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServiciosCategoria {
   
   @Autowired
   private RepositorioCategoria metodosCrud;
   
   public List<Category> getAll(){
       return metodosCrud.getAll();
   }
   
   public Optional <Category> getCategory(int idCategory){
       return metodosCrud.getCategory(idCategory);
   }
   
   public Category save(Category category){
    if (category.getId()==null){
        return metodosCrud.save(category);
    }else{
        Optional<Category> evt = metodosCrud.getCategory(category.getId());
        if (evt.isEmpty()){
            return metodosCrud.save(category);
        }else {
            return category;
        }
    }
  }

    public Category update(Category category) {
        if(category.getId()!=null){
            Optional<Category>evt=metodosCrud.getCategory(category.getId());
            if(!evt.isEmpty()){
                if(category.getDescription()!=null){
                    evt.get().setDescription(category.getDescription());
                }
                if(category.getName()!=null){
                    evt.get().setName(category.getName());
                }
                return metodosCrud.save(evt.get());
            }
        }
        return category;
    }

    public boolean deletecategoria(int id) {
        
        Boolean d=getCategory(id).map(category -> {
            metodosCrud.delete(category);
            return true;
        }).orElse(false);
        return d;
    }
}
    
