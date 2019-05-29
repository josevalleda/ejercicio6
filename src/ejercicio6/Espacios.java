
package ejercicio6;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;


abstract class Espacios implements Cloneable {
    
    protected String nombre;
    protected String ubicacion;
    protected String descripcion;
    protected int capacidad;
    protected ArrayList<Reservas> listareservas;

    public void setNombre(String nombre) {
        this.nombre = nombre;
        descripcion = nombre+" - "+ubicacion;
    }

    public Espacios(String nombre, String ubicacion, int capacidad) {
        this.capacidad = capacidad;
        iniciar(nombre,ubicacion);
    }
    public Espacios(String nombre, String ubicacion) {
        this.capacidad = 30;
        iniciar(nombre,ubicacion);
    }
    protected void iniciar(String nombre, String ubicacion){
        this.nombre = nombre;
        this.ubicacion = ubicacion;
        this.descripcion = nombre+" - "+ubicacion;
        listareservas = new ArrayList<Reservas>();
    }
    public boolean Consultar(Ocupacion ocu){
        boolean auxbool = false;
        for (Reservas listareserva : listareservas) {
            if(listareserva.getOcupa().equals(ocu)){
                auxbool = true;
            }
        }
        return auxbool;
    }
    
    public Reservas reserva(String usuario,LocalDate Fecha, Jornada tramo){
        Ocupacion auxocupacion = new Ocupacion(Fecha, tramo);
        Reservas auxreserva = null;
        boolean bandera = false;
        //verificamos si hhay disponibilidad
        for (Reservas listareserva : listareservas) {
            if(listareserva.getOcupa().equals(auxocupacion)){
                bandera = true;
            }
        }
        if(!bandera){
            // verificamos si esta permitido que el usuario haga reserva
            auxreserva = reservausuario(usuario,Fecha,auxocupacion);
            
            if(auxreserva != null){    
                listareservas.add(auxreserva);
            }
        }
        return auxreserva;
    }
    abstract Reservas reservausuario(String usuario,LocalDate Fecha, Ocupacion auxocupacion);
    // sobre cargamos el metodo 
    public Reservas reserva(String usuario,LocalDate Fecha){
        return reserva(usuario, Fecha, Jornada.Mañana);
    }
    public boolean eliminarreserva(Reservas res){
        return listareservas.remove(res);
    }
    
    @Override
    public Espacios clone() throws CloneNotSupportedException 
    { 
        Espacios aux = (Espacios) super.clone();
        return aux; 
    } 
}
