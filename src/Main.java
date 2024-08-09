import dao.BD;
import modelo.Odontologo;
import servicio.OdontologoServicio;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        BD.createTable();

        OdontologoServicio odontologoServicio = new OdontologoServicio();
        Odontologo odontologo1 = new Odontologo("123", "Oriana", "Guerrero");
        Odontologo odontologo2 = new Odontologo("456", "Anghelo", "Flores");
        Odontologo odontologo3 = new Odontologo("789", "Pepito", "Gonzales");

        odontologoServicio.guardar(odontologo1);
        odontologoServicio.guardar(odontologo2);
        odontologoServicio.guardar(odontologo3);

        List<Odontologo> odontologos = odontologoServicio.listarTodos();
        System.out.println("Todos los odontologos:");
        for (Odontologo odontologo : odontologos) {
            System.out.println("ID: " + odontologo.getId() +
                    ", Matricula: " + odontologo.getMatricula() +
                    ", Nombre: " + odontologo.getNombre() +
                    ", Apellido: " + odontologo.getApellido());
        }
    }
}
