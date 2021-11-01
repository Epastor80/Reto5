
package Reto3H2.Reto3H2.Servicios;

import Reto3H2.Reto3H2.Repositorio.RepositorioCliente;
import Reto3H2.Reto3H2.Modelos.Client;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service      
public class ServiciosCliente {
    
   @Autowired
   private RepositorioCliente metodosCrud;
   
   public List<Client> getAll(){
       return metodosCrud.getAll();
   }
   
   public Optional <Client> getClient(int idClient){
       return metodosCrud.getClient(idClient);
   }
   
   public Client save(Client client){
    if (client.getIdClient()==null){
        return metodosCrud.save(client);
    }else{
        Optional<Client> evt = metodosCrud.getClient(client.getIdClient());
        if (evt.isEmpty()){
            return metodosCrud.save(client);
        }else {
            return client;
        }
    }
  }

    public Client update(Client client) {
    
        if(client.getIdClient()!=null){
            Optional<Client> e= metodosCrud.getClient(client.getIdClient());
            if(!e.isEmpty()){
                if(client.getName()!=null){
                    e.get().setName(client.getName());
                }
                if(client.getAge()!=null){
                    e.get().setAge(client.getAge());
                }
                if(client.getPassword()!=null){
                    e.get().setPassword(client.getPassword());
                }
                metodosCrud.save(e.get());
                return e.get();
            }else{
                return client;
            }
        }else{
            return client;
        }
        
    }

    public boolean deleteClient(int idClient) {
        
        Boolean aBoolean = getClient(idClient).map(client -> {
            metodosCrud.delete(client);
            return true;
        }).orElse(false);
        return aBoolean;
    }

}
