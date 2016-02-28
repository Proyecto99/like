package edu.uag.iidis.scec.modelo;

import java.io.Serializable;
import java.util.*;


/**
 * Esta clase es usada para representar un rol de un
 * usuario. 
 *
 * <p><a href="Lugar.java.html"><i>Ver código fuente</i></a></p>
 *
 * @author <a href="mailto:vramos@uag.mx">Victor Ramos</a>
 * @version 1.0
 */
public class Lugar extends ClaseBase 
        implements Serializable {

    private Long id;
    private String nombre;
    private String descripcion;
	private String poblacion;
	private String coordenada;
	private Long idEstado;


    public Lugar() {
    }

    public Lugar(Long id){
        this.id = id;
		
    }

    public Lugar(String nombre, String descripcion, String poblacion, String coordenada, Long idEstado){
        this.nombre=nombre;
        this.descripcion=descripcion;
		this.poblacion=poblacion;
		this.coordenada=coordenada;
		this.idEstado=idEstado;

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
    public String getDescripcion() {
        return this.descripcion;
    }

    /**
     * Establece la descripción del rol.
     * @return void
     */
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
	    /**
     * Regresa la poblacion del rol.
     * @return String
     */
	 
    public String getPoblacion() {
        return this.poblacion;
    }

    /**
     * Establece la poblacion del rol.
     * @return void
     */
    public void setPoblacion(String poblacion) {
        this.poblacion = poblacion;
    }
		    /**
     * Regresa la coordenada del rol.
     * @return String
     */
    public String getCoordenada() {
        return this.coordenada;
    }

    /**
     * Establece la coordenada del rol.
     * @return void
     */
    public void setCoordenada(String coordenada) {
        this.coordenada = coordenada;
    }
	
	public Long getidEstado() {
        return this.idEstado;
    }

    public void setidEstado(Long id) {
        this.idEstado = id;
    }


}
