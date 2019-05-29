
package ejercicio6;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


public class EspaciosReunion extends Espacios{
       protected Map<String, ArrayList<Reservas> > mapa;

    public EspaciosReunion(String nombre, String ubicacion, int capacidad) {
        super(nombre, ubicacion, capacidad);
        mapa = new  HashMap<String ,ArrayList<Reservas> >();
    }
    public EspaciosReunion(String nombre, String ubicacion) {
        super(nombre, ubicacion);
        mapa = new  HashMap<String ,ArrayList<Reservas> >();
    }

    Reservas reservausuario(String usuario,LocalDate Fecha,Ocupacion auxocupacion) {
        Reservas auxreserva = null;
        ArrayList<Reservas> listares = new ArrayList<Reservas>();
        boolean bandera = false;
        //verificamos que el dia no sea sabado y domingo
        if(!(Fecha.getDayOfWeek().equals(DayOfWeek.SATURDAY) ||Fecha.getDayOfWeek().equals(DayOfWeek.SUNDAY)) )
            //verificamo las reservas del usuario
            if(mapa.containsKey(usuario)){
                listares = mapa.get(usuario);
                for (Reservas listare : listares) {
                    //verificamos cada reserva si esta posterior al hoy
                    if(listare.getOcupa().getFecha().isAfter(LocalDate.now())){
                        bandera = true;
                        break;
                    }
                }
                if(!bandera){
                    auxreserva = new Reservas(usuario, this, auxocupacion);
                    listares.add(auxreserva);
                    mapa.remove(usuario);
                    mapa.put(usuario, listares);
                }
            }else{
                //sino tiene nada reservado aun
                auxreserva = new Reservas(usuario, this, auxocupacion);
                listares.add(auxreserva);
                mapa.put(usuario, listares);
            }
        //mapa
        return auxreserva;
    }
    
    @Override
    public EspaciosReunion clone() throws CloneNotSupportedException 
    { 
        EspaciosReunion aux = (EspaciosReunion)super.clone();
        aux.listareservas.clear();
        return aux; 
    } 
    
}
