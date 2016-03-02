package edu.uag.iidis.scec.servicios;

import java.util.Collection;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import edu.uag.iidis.scec.modelo.Lugar;
import edu.uag.iidis.scec.excepciones.*;
import edu.uag.iidis.scec.persistencia.LugarDAO;
import edu.uag.iidis.scec.persistencia.hibernate.*;

public class ManejadorLugares {
    private Log log = LogFactory.getLog(ManejadorLugares.class);
    private LugarDAO dao;

    public ManejadorLugares() {
        dao = new LugarDAO();
    }


    public Collection listarLugares() {
        Collection resultado;

        if (log.isDebugEnabled()) {
            log.debug(">guardarUsuario(usuario)");
        }

        try {
            HibernateUtil.beginTransaction();
            resultado = dao.buscarTodos();
            HibernateUtil.commitTransaction();
            return resultado;         
        } catch (ExcepcionInfraestructura e) {
            HibernateUtil.rollbackTransaction();
            return null;
        } finally {
            HibernateUtil.closeSession();
        }
    }
	
	public Collection buscarLugares(String lugarBuscar) {
        Collection resultado;

        if (log.isDebugEnabled()) {
            log.debug(">guardarUsuario(usuario)");
        }

        try {
            HibernateUtil.beginTransaction();
            resultado = dao.buscarPorNombre(lugarBuscar);
            HibernateUtil.commitTransaction();
            return resultado;         
        } catch (ExcepcionInfraestructura e) {
            HibernateUtil.rollbackTransaction();
            return null;
        } finally {
            HibernateUtil.closeSession();
        }
    }

	

    public void eliminarLugar(Long id) {
        if (log.isDebugEnabled()) {
            log.debug(">eliminarLugar(lugar)");
        }
        try {
            HibernateUtil.beginTransaction();           
            Lugar lugar = dao.buscarPorId(id, true);
            if (lugar != null) {
              dao.hazTransitorio(lugar);
            }
            HibernateUtil.commitTransaction();
        } catch (ExcepcionInfraestructura e) {
            HibernateUtil.rollbackTransaction();
            if (log.isWarnEnabled()) {
                log.warn("<ExcepcionInfraestructura");
            }
        } finally {
            HibernateUtil.closeSession();
        }

    }

    public int crearLugar(Lugar lugar) {

        int resultado;

        if (log.isDebugEnabled()) {
            log.debug(">guardarLugar(lugar)");
        }

        try {
            HibernateUtil.beginTransaction();           
            
            if (dao.existeLugar(lugar.getNombre())) {
               resultado = 1; // Excepción. El nombre de ciudad ya existe
            } else {

               dao.hazPersistente(lugar);

               resultado = 0; // Exito. El ciudad se creo satisfactoriamente.
            }

            HibernateUtil.commitTransaction();

        } catch (ExcepcionInfraestructura e) {
            HibernateUtil.rollbackTransaction();

            if (log.isWarnEnabled()) {
                log.warn("<ExcepcionInfraestructura");
            }
            resultado = 2;    // Excepción. Falla en la infraestructura
        } finally {
            HibernateUtil.closeSession();
        }
        return resultado;
    }    
}
