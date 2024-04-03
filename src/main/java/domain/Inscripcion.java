package domain;
import java.util.List;

public class Inscripcion {
    private Alumno alumno;
    private List<Materia> materiasInsc;

    // -------------------------------------------- //

    public Alumno getAlumno() {
        return alumno;
    }

    public void setAlumno(Alumno alumno) {
        this.alumno = alumno;
    }

    public List<Materia> getMateriasInsc() {
        return materiasInsc;
    }

    public void setMateriasInsc(List<Materia> materiasInsc) {
        this.materiasInsc = materiasInsc;
    }

    // -------------------------------------------- //

    public Boolean aprobada(){
        for(Materia materia : materiasInsc){
            if(!alumno.cumpleCorrelativas(materia)){
             return false;
            }
        }
        return true;
    }

}
