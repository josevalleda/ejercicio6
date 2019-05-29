
package ejercicio6;

import com.sun.org.apache.xpath.internal.operations.Equals;
import java.time.LocalDate;
import java.util.Objects;



public class Ocupacion {
    private LocalDate Fecha;
    private Jornada tramo;

    public Ocupacion(LocalDate Fecha, Jornada tramo) {
        this.Fecha = Fecha;
        this.tramo = tramo;
    }

    public LocalDate getFecha() {
        return Fecha;
    }

    public Jornada getTramo() {
        return tramo;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 29 * hash + Objects.hashCode(this.Fecha);
        hash = 29 * hash + Objects.hashCode(this.tramo);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Ocupacion other = (Ocupacion) obj;
        if (!Objects.equals(this.Fecha, other.Fecha)) {
            return false;
        }
        if (this.tramo != other.tramo) {
            return false;
        }
        return true;
    }
    
    
    
}
enum Jornada{ Mañana, Tarde}