package domain;
import java.util.List;

public class Alumno {
    private String nombre;
    private String legajo;
    private List<Materia> materiasAprobadas;

    // -------------------------------------------- //

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getLegajo() {
        return legajo;
    }

    public void setLegajo(String legajo) {
        this.legajo = legajo;
    }

    public List<Materia> getMateriasAprobadas() {
        return materiasAprobadas;
    }

    public void setMateriasAprobadas(List<Materia> materiasAprobadas) {
        this.materiasAprobadas = materiasAprobadas;
    }

    // -------------------------------------------- //

    public Boolean cumpleCorrelativas(Materia materia){

        List<Materia> correlativas = materia.getCorrelativas();

        if (materia.tieneCorrelativas()) {
            for (Materia correlativa : correlativas){
                if (!materiasAprobadas.contains(correlativa) || !cumpleCorrelativas(correlativa)) {
                    return false;
                }
            }
        }
        return true;
    }

}
