
package ejercicio6;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class EspaciosAula extends Espacios{
    private ArrayList<LocalDate> fexamenes;

    public EspaciosAula(String nombre, String ubicacion, int capacidad) {
        super(nombre, ubicacion, capacidad);
        fexamenes = new ArrayList<LocalDate>();
    }

    public void añadirfexamen (LocalDate ... fecha){
        for (LocalDate localDate : fecha) {
            fexamenes.add(localDate);
        }
    }
    public ArrayList<LocalDate> Consultafexamenes (LocalDate fecha){
        return fexamenes;
    }
    Reservas reservausuario(String usuario, LocalDate Fecha, Ocupacion auxocupacion) {
        Reservas auxreserva = null;
        // verificamos que la nueva reserva no coincida con una fecha de examen
        for (LocalDate fexamene : fexamenes) {
            if(fexamene.equals(Fecha)){
                return auxreserva;
            }
        }
        //verificamos que el usuario no tenga reserva en el mismo dia
        for (Reservas reserva : listareservas) {
            if(reserva.getOcupa().getFecha().equals(Fecha)){
                return auxreserva;
            }
        }
        // si supera las anteriores limitaciones procedemos a realizar la reserva
        auxreserva =  new Reservas(usuario, this, auxocupacion);
        listareservas.add(auxreserva);
        return auxreserva;
    }
    
    @Override
    public EspaciosAula clone() throws CloneNotSupportedException 
    { 
        EspaciosAula aux = (EspaciosAula)super.clone();
        aux.listareservas.clear();
        return aux; 
    } 
}
