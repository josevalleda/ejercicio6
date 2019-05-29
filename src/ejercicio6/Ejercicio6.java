
package ejercicio6;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;


public class Ejercicio6 {


    public static void main(String[] args) throws CloneNotSupportedException {
        
       EspaciosAula a1 = new EspaciosAula("A.01", "Aulario Norte", 165);
       a1.añadirfexamen(LocalDate.of(2019, Month.JANUARY, 10),LocalDate.of(2019, Month.JANUARY, 11));
       EspaciosAula a2 = a1.clone();
       a2.setNombre("A.02");
       EspaciosAula a3 = a1.clone();
       a3.setNombre("A.03");
       EspaciosReunion r1 = new EspaciosReunion("2.01", "Facultad de informatica", 15);
       EspaciosReunion r2 = new EspaciosReunion("2.02", "Facultad de informatica", 15);
       EspaciosReunion r3 = new EspaciosReunion("2.03", "Facultad de informatica");
       ArrayList<Espacios> Lista = new ArrayList<>();
       Lista.add(a1);
       Lista.add(a2);
       Lista.add(a3);
       Lista.add(r1);
       Lista.add(r2);
       Lista.add(r3);
        for (Espacios espacios : Lista) {
            System.out.println("\n\n espacio: "+espacios.toString());
        }
        for (Espacios espacios : Lista) {
            System.out.println("\n\n reservas: ");
            if(espacios.reserva("juan@um.es", LocalDate.of(2019, Month.JANUARY, 9), Jornada.Tarde) != null)
                System.out.println("1.  se pudo hacer la reserva ");else System.out.println("1. No se pudo hacer la reserva "); 
            if(espacios.reserva("pepe@um.es", LocalDate.of(2019, Month.JANUARY, 9), Jornada.Tarde)!= null)
                System.out.println("1.  se pudo hacer la reserva ");else System.out.println("1. No se pudo hacer la reserva "); 
            if(espacios.reserva("pepe@um.es", LocalDate.of(2019, Month.JANUARY, 9))!= null)
                System.out.println("1.  se pudo hacer la reserva ");else System.out.println("1. No se pudo hacer la reserva "); 
            if(espacios.reserva("pepe@um.es", LocalDate.of(2019, Month.JANUARY, 10))!= null)
                System.out.println("1.  se pudo hacer la reserva ");else System.out.println("1. No se pudo hacer la reserva "); 
        }
        for (Espacios espacios : Lista) {
            System.out.println("\n\n\n espacio: "+espacios.toString());
        }
    }
    
}
