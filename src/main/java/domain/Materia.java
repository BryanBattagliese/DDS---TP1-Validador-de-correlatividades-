package domain;
import java.util.List;

public class Materia {
    private String nombre;
    private List<Materia> correlativas;

    // -------------------------------------------- //

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<Materia> getCorrelativas() {
        return correlativas;
    }

    public void setCorrelativas(List<Materia> correlativas) {
        this.correlativas = correlativas;
    }

    // -------------------------------------------- //

    public boolean tieneCorrelativas() {
        return !correlativas.isEmpty();
    }

}
