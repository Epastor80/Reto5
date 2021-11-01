
package Reto3H2.Reto3H2.ControladorWeb;

import Reto3H2.Reto3H2.Servicios.ServiciosGame;
import Reto3H2.Reto3H2.Modelos.Game;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/Game")
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE})

public class WebGames {
   
    @Autowired
    private ServiciosGame servicios;
    
    @GetMapping("/all")
    public List<Game> getGame(){
        return servicios.getAll();
    }
    @GetMapping("/{id}")
	    public Optional<Game> getGame(@PathVariable("id") int idGame) {
	        return servicios.getGame(idGame);
	    }
    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Game save(@RequestBody Game game) {
        return servicios.save(game);
    }
    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Game update(@RequestBody Game game) {
        return servicios.update(game);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable("id") int idGame) {
        return servicios.deleteGames(idGame);
    }

}
