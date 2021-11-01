
package Reto3H2.Reto3H2.Repositorio;

import Reto3H2.Reto3H2.Interfaces.InterfaceMensaje;
import Reto3H2.Reto3H2.Modelos.Message;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class RepositorioMensaje {
    
    @Autowired
    private InterfaceMensaje crud;
    
    public List <Message> getAll(){
        return (List<Message>) crud.findAll();
    }
    public Optional <Message> getMessage(int idMessage){
        return crud.findById(idMessage);
    }        
    
    public Message save(Message message){
        return  crud.save(message);
    }
    
    public void delete(Message message){
        crud.delete(message);
    }
}
