
package Reto3H2.Reto3H2.Servicios;

import Reportes.ContadorClientes;
import Reportes.StatusReservas;
import Reto3H2.Reto3H2.Repositorio.RepositorioReservacion;
import Reto3H2.Reto3H2.Modelos.Reservation;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//Anotacion JPA para deficion de Servicio
@Service
public class ServiciosReservacion {
    //Anotacion Variable del Repositorio
   @Autowired
   private RepositorioReservacion metodosCrud;
   
   //Metodo con el cual se obtienen los datos de la Tabla Reservaciones
   public List<Reservation> getAll(){
       return metodosCrud.getAll();
   }
   
   //Metodo para Obtener las Reservaciones por el ID
   public Optional <Reservation> getReservation(int idReservation){
       return metodosCrud.getReservation(idReservation);
   }
   
   //Metodo para guardar Reservacines
   public Reservation save(Reservation reservation){
    if (reservation.getIdReservation()==null){
        return metodosCrud.save(reservation);
    }else{
        Optional<Reservation> evt =metodosCrud.getReservation(reservation.getIdReservation());
        if (evt.isEmpty()){
            return metodosCrud.save(reservation);
        }else {
            return reservation;
        }
    }
  }

   //Metodo para Actualizar Reservaciones
    public Reservation update(Reservation reservation) {
       
        if(reservation.getIdReservation()!=null){
            Optional<Reservation> e= metodosCrud.getReservation(reservation.getIdReservation());
            if(!e.isEmpty()){

                if(reservation.getStartDate()!=null){
                    e.get().setStartDate(reservation.getStartDate());
                }
                if(reservation.getDevolutionDate()!=null){
                    e.get().setDevolutionDate(reservation.getDevolutionDate());
                }
                if(reservation.getStatus()!=null){
                    e.get().setStatus(reservation.getStatus());
                }
                metodosCrud.save(e.get());
                return e.get();
            }else{
                return reservation;
            }
        }else{
            return reservation;
        }
    }

    //Metodo para Borrar Reservaciones
    public boolean deleteReservation(int idReservation) {
        
        Boolean aBoolean = getReservation(idReservation).map(reservation -> {
            metodosCrud.delete(reservation);
            return true;
        }).orElse(false);
        return aBoolean;
    }
    
    //Metodo para Obtener el status de las Reservaciones
    public StatusReservas getReservationsStatusReport(){
        List<Reservation>completed=metodosCrud.getReservationByStatus("completed");
        List<Reservation>cancelled=metodosCrud.getReservationByStatus("cancelled");
    return new StatusReservas(completed.size(), cancelled.size());
    }
    
    //Metodo para Obtener Reservaciones en un Intervalo de tiempo
    public List<Reservation> getReservationPeriod(String dateA, String dateB){
        SimpleDateFormat parser=new SimpleDateFormat("yyyy-MM-dd");
        Date aDate= new Date();
        Date bDate= new Date();
        
       try {
           aDate = parser.parse(dateA);
           bDate = parser.parse(dateB);
       }catch(ParseException evt){
           evt.printStackTrace();
       }
       if(aDate.before(bDate)){
           return metodosCrud.getReservationPeriod(aDate, bDate);
       }else{
           return new ArrayList<>();
       } 
    
    }
    
    //Metodo para contar el numero de Clientes
    public List<ContadorClientes> getTopClients(){
        return metodosCrud.getTopClients();
    }
}
