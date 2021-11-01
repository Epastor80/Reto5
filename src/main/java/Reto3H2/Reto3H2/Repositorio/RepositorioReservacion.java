
package Reto3H2.Reto3H2.Repositorio;

import Reportes.ContadorClientes;
import Reto3H2.Reto3H2.Interfaces.InterfaceReservacion;
import Reto3H2.Reto3H2.Modelos.Client;
import Reto3H2.Reto3H2.Modelos.Reservation;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class RepositorioReservacion {
 
    @Autowired
    private InterfaceReservacion crud;
    
    public List <Reservation> getAll(){
        return (List<Reservation>) crud.findAll();
    }
    public Optional <Reservation> getReservation(int idReservation){
        return crud.findById(idReservation);
    }        
    
    public Reservation save(Reservation reservation){
        return  crud.save(reservation);
    }
    public void delete(Reservation reservation){
        crud.delete(reservation);
    }
    
    public List<Reservation> getReservationByStatus(String status){
        return crud.findAllByStatus(status);
    }
    
   public List<Reservation> getReservationPeriod(Date a, Date b){
       return crud.findAllByStartDateAfterAndStartDateBefore(a, b);
   } 
   
   public List<ContadorClientes> getTopClients(){
       List<ContadorClientes> res= new ArrayList<>();
       List<Object[]> report = crud.countTotalReservationByClient();
       for(int i=0;i<report.size();i++){
           res.add(new ContadorClientes((Long)report.get(i)[1],(Client) report.get(i)[0]));
       }
       return res;
   }
    
 }
