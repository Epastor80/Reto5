
package Reto3H2.Reto3H2.Repositorio;

import Reto3H2.Reto3H2.Interfaces.InterfaceGames;
import Reto3H2.Reto3H2.Modelos.Game;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class RepositorioGames {
    
    @Autowired
    private InterfaceGames crud;
    
    public List <Game> getAll(){
        return (List<Game>) crud.findAll();
    }
    public Optional <Game> getGame(int id){
        return crud.findById(id);
    }        
    
    public Game save(Game game){
        return  crud.save(game);
    }
     
    public void delete(Game game){
        crud.delete(game);
    }
}
