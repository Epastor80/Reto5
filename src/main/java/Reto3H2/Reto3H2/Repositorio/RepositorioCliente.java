
package Reto3H2.Reto3H2.Repositorio;

import Reto3H2.Reto3H2.Interfaces.InterfaceCliente;
import Reto3H2.Reto3H2.Modelos.Client;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class RepositorioCliente {
    
    @Autowired
    private InterfaceCliente crud;
    
    public List<Client> getAll(){
        return (List<Client>) crud.findAll();
    }
    public Optional <Client> getClient(int idClient){
        return crud.findById(idClient);
    }        
    
    public Client save(Client client){
        return  crud.save(client);
    }
    
    public void delete(Client client){
        crud.delete(client);
    }
}
