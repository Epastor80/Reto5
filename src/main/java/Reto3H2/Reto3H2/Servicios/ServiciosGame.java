
package Reto3H2.Reto3H2.Servicios;

import Reto3H2.Reto3H2.Repositorio.RepositorioGames;
import Reto3H2.Reto3H2.Modelos.Game;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServiciosGame {
  
    @Autowired
   private RepositorioGames metodosCrud;
   
   public List<Game> getAll(){
       return metodosCrud.getAll();
   }
   
   public Optional <Game> getGame(int idGame){
       return metodosCrud.getGame(idGame);
   }
   
   public Game save(Game game){
    if (game.getId()==null){
        return metodosCrud.save(game);
    }else{
        Optional<Game> evt = metodosCrud.getGame(game.getId());
        if (evt.isEmpty()){
            return metodosCrud.save(game);
        }else {
            return game;
        }
    }
  }

    public Game update(Game game) {
    
        if(game.getId()!=null){
            Optional<Game> e=metodosCrud.getGame(game.getId());
            if(!e.isEmpty()){
                if(game.getName()!=null){
                    e.get().setName(game.getName());
                }
                if(game.getDeveloper()!=null){
                    e.get().setDeveloper(game.getDeveloper());
                }
                if(game.getYear()!=null){
                    e.get().setYear(game.getYear());
                }
                if(game.getDescription()!=null){
                    e.get().setDescription(game.getDescription());
                }
                if(game.getCategory()!=null){
                    e.get().setCategory(game.getCategory());
                }
                metodosCrud.save(e.get());
                return e.get();
            }else{
                return game;
            }
        }else{
            return game;
        }
    }

    public boolean deleteGames(int idGame) {
        
        Boolean aBoolean = getGame(idGame).map(games -> {
            metodosCrud.delete(games);
            return true;
        }).orElse(false);
        return aBoolean;
    }
 }