//Oriana Valentina Guerrero Torrado
package dao.implementacion;

import dao.IDao;
import modelo.Odontologo;
import org.apache.log4j.Logger;

import java.util.List;

public class OdontologoDAOEnMemoria implements IDao<Odontologo> {
    private List<Odontologo> odontologoRepositorio;
    private static final Logger LOGGER = Logger.getLogger(OdontologoDAOEnMemoria.class);

    public OdontologoDAOEnMemoria(List<Odontologo> odontologoRepositorio) {
        this.odontologoRepositorio = odontologoRepositorio;
    }

    @Override
    public Odontologo guardar(Odontologo odontologo) {
        odontologoRepositorio.add(odontologo);
        LOGGER.info("Odontologo guardado en memoria " + odontologo.getNombre());
        return odontologo;
    }

    @Override
    public List<Odontologo> listarTodos() {
        LOGGER.info("Lista de odontologos en memoria");
        return odontologoRepositorio;
    }
}
