import dao.BD;
import dao.IDao;
import dao.implementacion.OdontologoDAOEnMemoria;
import dao.implementacion.OdontologoDAOH2;
import modelo.Odontologo;
import org.junit.Test;
import servicio.OdontologoServicio;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

public class OdontologoServicioTest {
    private IDao<Odontologo> odontologoDaoEnMemoria = new OdontologoDAOEnMemoria(new ArrayList());
    private IDao<Odontologo> odontologoDaoH2 = new OdontologoDAOH2();
    private OdontologoServicio odontologoServicio = new OdontologoServicio();

    @Test
    public void listarTodosOdontologosEnMemoria() {
        System.out.println("***********************************************************");

        odontologoServicio.setOdontologoIDao(odontologoDaoEnMemoria);

        // arrange
        Odontologo odontologo1 = new Odontologo("123", "Oriana", "Guerrero");
        Odontologo odontologo2 = new Odontologo("456", "Anghelo", "Flores");
        Odontologo odontologo3 = new Odontologo("789", "Pepito", "Gonzales");

        // act
        odontologoServicio.guardar(odontologo1);
        odontologoServicio.guardar(odontologo2);
        odontologoServicio.guardar(odontologo3);

        List<Odontologo> odontologos = odontologoServicio.listarTodos();
        System.out.println("Todos los odontologos en Memoria:");
        for (Odontologo odontologo : odontologos) {
            Integer index = odontologos.indexOf(odontologo) + 1;
            System.out.println("ID: " + index +
                    ", Matricula: " + odontologo.getMatricula() +
                    ", Nombre: " + odontologo.getNombre() +
                    ", Apellido: " + odontologo.getApellido());
        }

        // assert
        assertFalse(odontologos.isEmpty());
        assertEquals(3, odontologos.size());
    }


    @Test
    public void listarTodosOdontologosH2() {
        System.out.println("***********************************************************");
        odontologoServicio.setOdontologoIDao(odontologoDaoH2);

        // arrange
        BD.createTable();

        Odontologo odontologo1 = new Odontologo("123", "Oriana", "Guerrero");
        Odontologo odontologo2 = new Odontologo("456", "Anghelo", "Flores");
        Odontologo odontologo3 = new Odontologo("789", "Pepito", "Gonzales");

        // act
        odontologoServicio.guardar(odontologo1);
        odontologoServicio.guardar(odontologo2);
        odontologoServicio.guardar(odontologo3);

        List<Odontologo> odontologos = odontologoServicio.listarTodos();
        System.out.println("Todos los odontologos en H2:");
        for (Odontologo odontologo : odontologos) {
            System.out.println("ID: " + odontologo.getId() +
                    ", Matricula: " + odontologo.getMatricula() +
                    ", Nombre: " + odontologo.getNombre() +
                    ", Apellido: " + odontologo.getApellido());
        }

        // assert
        assertFalse(odontologos.isEmpty());
        assertEquals(3, odontologos.size());
    }
}