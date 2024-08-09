package servicio;

import dao.IDao;
import dao.implementacion.OdontologoDAOH2;
import modelo.Odontologo;
import org.apache.log4j.Logger;

import java.util.List;

public class OdontologoServicio {
    public IDao<Odontologo> getOdontologoIDao() {
        return odontologoIDao;
    }

    public void setOdontologoIDao(IDao<Odontologo> odontologoIDao) {
        this.odontologoIDao = odontologoIDao;
    }

    private IDao<Odontologo> odontologoIDao;
    private static final Logger LOGGER = Logger.getLogger(OdontologoServicio.class);

    public OdontologoServicio() {
        this.odontologoIDao = new OdontologoDAOH2();
    }

    public Odontologo guardar(Odontologo odontologo) {
        return odontologoIDao.guardar(odontologo);
    }

    public List<Odontologo> listarTodos() {
        return odontologoIDao.listarTodos();
    }
}
