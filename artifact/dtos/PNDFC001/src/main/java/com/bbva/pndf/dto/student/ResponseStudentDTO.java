package com.bbva.pndf.dto.student;

import java.io.Serializable;
import java.util.Date;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

/**
 * The PresponseStudentDTO class...
 */
public class ResponseStudentDTO implements Serializable  {
	private static final long serialVersionUID = 2931699728946643245L;

	private String id;
	private Date fechaIngreso;
	private Date fechaSalida;
	private String edad;
	private String grado;
	private String estado;

	public ResponseStudentDTO(){}
	public ResponseStudentDTO(String id, Date fechaIngreso, Date fechaSalida, String edad, String grado, String estado) {
		this.id = id;
		this.fechaIngreso = fechaIngreso;
		this.fechaSalida = fechaSalida;
		this.edad = edad;
		this.grado = grado;
		this.estado = estado;
	}

	public Date getFechaIngreso() {
		return fechaIngreso;
	}

	public void setFechaIngreso(Date fechaIngreso) {
		this.fechaIngreso = fechaIngreso;
	}

	public Date getFechaSalida() {
		return fechaSalida;
	}

	public void setFechaSalida(Date fechaSalida) {
		this.fechaSalida = fechaSalida;
	}

	public String getEdad() {
		return edad;
	}

	public void setEdad(String edad) {
		this.edad = edad;
	}

	public String getGrado() {
		return grado;
	}

	public void setGrado(String grado) {
		this.grado = grado;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
}
