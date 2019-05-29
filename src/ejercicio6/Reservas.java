
package ejercicio6;

import java.util.Objects;

public class Reservas {
    private String usuario;
    private Espacios espacio;
    private Ocupacion Ocupa;

    public Reservas(String usuario, Espacios espacio, Ocupacion Ocupa) {
        this.usuario = usuario;
        this.espacio = espacio;
        this.Ocupa = Ocupa;
    }

    public String getUsuario() {
        return usuario;
    }

    public Espacios getEspacio() {
        return espacio;
    }

    public Ocupacion getOcupa() {
        return Ocupa;
    }

    
    @Override
    public int hashCode() {
        int hash = 5;
        hash = 67 * hash + Objects.hashCode(this.usuario);
        hash = 67 * hash + Objects.hashCode(this.espacio);
        hash = 67 * hash + Objects.hashCode(this.Ocupa);
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
        final Reservas other = (Reservas) obj;
        if (!Objects.equals(this.usuario, other.usuario)) {
            return false;
        }
        if (!Objects.equals(this.espacio, other.espacio)) {
            return false;
        }
        if (!Objects.equals(this.Ocupa, other.Ocupa)) {
            return false;
        }
        return true;
    }
    
    
}
