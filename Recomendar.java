package edu.uag.iidis.scec.modelo;

import java.io.Serializable;
import java.util.*;


/**
 * Esta clase es usada para representar un rol de un
 * usuario. 
 *
 * <p><a href="Recomendar.java.html"><i>Ver código fuente</i></a></p>
 *
 * @author <a href="mailto:vramos@uag.mx">Victor Ramos</a>
 * @version 1.0
 */
public class Recomendar extends ClaseBase 
        implements Serializable {

    private Long id;
    private String nombre;
    private String fecha;
	private String comentario;
	private String calificacion;
	private Long idLugar;


    public Recomendar() {
    }

    public Recomendar(Long id){
        this.id = id;
		
    }

    public Recomendar(String nombre, String fecha, String comentario, String calificacion, Long idLugar){
        this.nombre=nombre;
        this.fecha=fecha;
		this.comentario=comentario;
		this.calificacion=calificacion;
		this.idLugar=idLugar;

    }

    /**
     * Regresa el id del rol.
     * @return Long
     */
    public Long getId() {
        return this.id;
    }

    /**
     * Establece el id del rol.
     * @return void
     */
    public void setId(Long id) {
        this.id = id;
    }


    /**
     * Regresa el nombre del rol.
     * @return String
     */
    public String getNombre() {
        return this.nombre;
    }

    /**
     * Establece el nombre del rol.
     * @return void
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    
    /**
     * Regresa la descripción del rol.
     * @return String
     */
    public String getFecha() {
        return this.fecha;
    }

    /**
     * Establece la descripción del rol.
     * @return void
     */
    public void setFecha(String fecha) {
        this.fecha = fecha;
    }
	    /**
     * Regresa la poblacion del rol.
     * @return String
     */
	 
    public String getComentario() {
        return this.comentario;
    }

    /**
     * Establece la poblacion del rol.
     * @return void
     */
    public void setComentario(String comentario) {
        this.comentario = comentario;
    }
		    /**
     * Regresa la coordenada del rol.
     * @return String
     */
    public String getCalificacion() {
        return this.calificacion;
    }

    /**
     * Establece la coordenada del rol.
     * @return void
     */
    public void setCalificacion(String calificacion) {
        this.calificacion = calificacion;
    }
	
	public Long getidLugar() {
        return this.idLugar;
    }

    public void setidLugar(Long id) {
        this.idLugar = id;
    }


}
