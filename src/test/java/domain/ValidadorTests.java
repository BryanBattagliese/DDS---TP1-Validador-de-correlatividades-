package domain;
import org.junit.Test;
import java.util.Arrays;
import java.util.List;

public class ValidadorTests {

    private Materia aga;
    private Materia am1;
    private Materia am2;
    private Materia ayed;
    private Materia pdp;
    private Materia ads;
    private Materia dds;
    private Alumno alumno1;
    private Alumno alumno2;
    private Alumno alumno3;

    public void setMaterias() {
        aga = new Materia();
        am1 = new Materia();
        am2 = new Materia();
        ayed = new Materia();
        pdp = new Materia();
        ads = new Materia();
        dds = new Materia();

        aga.setCorrelativas(Arrays.asList());
        am1.setCorrelativas(Arrays.asList());
        am2.setCorrelativas(Arrays.asList(am1, aga));
        ayed.setCorrelativas(Arrays.asList());
        pdp.setCorrelativas(Arrays.asList(ayed));
        ads.setCorrelativas(Arrays.asList(ayed));
        dds.setCorrelativas(Arrays.asList(pdp, ads));
    }

    public void setAlumnos() {
        List<Materia> materiasAprobadas1 = Arrays.asList(aga, am1, ayed);
        List<Materia> materiasAprobadas2 = Arrays.asList(aga, am1, ayed, pdp, ads);
        List<Materia> materiasAprobadas3 = Arrays.asList();

        alumno1 = new Alumno();
        alumno1.setNombre("Bryan A. Battagliese");
        alumno1.setLegajo("203401-3");
        alumno1.setMateriasAprobadas(materiasAprobadas1);

        alumno2 = new Alumno();
        alumno2.setNombre("Charles Leclerc");
        alumno2.setLegajo("163207-5");
        alumno2.setMateriasAprobadas(materiasAprobadas2);

        alumno3 = new Alumno();
        alumno3.setNombre("Lewis Hamilton");
        alumno3.setLegajo("440811-2");
        alumno3.setMateriasAprobadas(materiasAprobadas3);
    }

    @Test
    public void testCumpleCorrelativas() {
        setMaterias();
        setAlumnos();

        //("Alumno cumple con todas las materias solicitadas para poder cursar am2")
        assert(alumno1.cumpleCorrelativas(am2));

        //("Alumno le falta alguna materia para poder cursar dds")
        assert(!(alumno1.cumpleCorrelativas(dds)));

        assert(alumno2.cumpleCorrelativas(dds));
        assert(alumno2.cumpleCorrelativas(am2));

        //("Alumno no necesita tener ninguna materia aprobada para cursar ayed")
        assert(alumno3.cumpleCorrelativas(ayed));

        //("Alumno no cumple con las materias solicitadas para poder cursar am2 o dds")
        assert(!alumno3.cumpleCorrelativas(dds) || alumno3.cumpleCorrelativas(am2));
    }

    @Test
    public void testInscAprobada() {
        setMaterias();
        setAlumnos();

        Inscripcion inscripcion1 = new Inscripcion();
        inscripcion1.setAlumno(alumno1);
        inscripcion1.setMateriasInsc(Arrays.asList(am2, dds));

        Inscripcion inscripcion2 = new Inscripcion();
        inscripcion2.setAlumno(alumno2);
        inscripcion2.setMateriasInsc(Arrays.asList(dds));

        Inscripcion inscripcion4 = new Inscripcion();
        inscripcion4.setAlumno(alumno2);
        inscripcion4.setMateriasInsc(Arrays.asList(am2, dds));

        Inscripcion inscripcion5 = new Inscripcion();
        inscripcion5.setAlumno(alumno3);
        inscripcion5.setMateriasInsc(Arrays.asList(ayed));

        Inscripcion inscripcion6 = new Inscripcion();
        inscripcion6.setAlumno(alumno3);
        inscripcion6.setMateriasInsc(Arrays.asList(dds, am2));

        //("Inscripcion no aprobada para poder cursar las materias solicitadas(solo puede cursar una de ellas)")
        assert(!inscripcion1.aprobada());

        //("Inscripcion aprobada para poder cursar las materias solicitadas")
        assert(inscripcion2.aprobada());
        assert(inscripcion4.aprobada());

        //("Inscripcion aprobada, no necesita ninguna materia aprobada para poder cursar las materias solicitadas")
        assert(inscripcion5.aprobada());

        //("Inscripcion no aprobada para poder cursar las materias solicitadas(no puede cursar ninguna de ellas)")
        assert(!inscripcion6.aprobada());
    }


}
