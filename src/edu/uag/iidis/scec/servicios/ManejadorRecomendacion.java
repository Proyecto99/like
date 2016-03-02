package edu.uag.iidis.scec.servicios;

import java.util.Collection;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import edu.uag.iidis.scec.modelo.Recomendar;
import edu.uag.iidis.scec.excepciones.*;
import edu.uag.iidis.scec.persistencia.RecomendarDAO;
import edu.uag.iidis.scec.persistencia.hibernate.*;

public class ManejadorRecomendacion {
    private Log log = LogFactory.getLog(ManejadorRecomendacion.class);
    private RecomendarDAO dao;

    public ManejadorRecomendacion() {
        dao = new RecomendarDAO();
    }


    public Collection listarRecomendacion() {
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
	
	public Collection buscarRecomendacion(String recomendarBuscar) {
        Collection resultado;

        if (log.isDebugEnabled()) {
            log.debug(">guardarUsuario(usuario)");
        }

        try {
            HibernateUtil.beginTransaction();
            resultado = dao.buscarPorNombre(recomendarBuscar);
            HibernateUtil.commitTransaction();
            return resultado;         
        } catch (ExcepcionInfraestructura e) {
            HibernateUtil.rollbackTransaction();
            return null;
        } finally {
            HibernateUtil.closeSession();
        }
    }

	

    public void eliminarRecomendar(Long id) {
        if (log.isDebugEnabled()) {
            log.debug(">eliminarRecomendar(recomendacion)");
        }
        try {
            HibernateUtil.beginTransaction();           
            Recomendar recomendar = dao.buscarPorId(id, true);
            if (recomendar != null) {
              dao.hazTransitorio(recomendar);
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

    public int crearRecomendar(Recomendar recomendar) {

        int resultado;

        if (log.isDebugEnabled()) {
            log.debug(">guardarRecomendar(recomendacion)");
        }

        try {
            HibernateUtil.beginTransaction();           
            
            if (dao.existeRecomendar(recomendar.getNombre())) {
               resultado = 1; // Excepción. El nombre de ciudad ya existe
            } else {

               dao.hazPersistente(recomendar);

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
