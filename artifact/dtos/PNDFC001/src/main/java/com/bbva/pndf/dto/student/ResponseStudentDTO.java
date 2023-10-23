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
	private String grado;
	private String matricula;


    public ResponseStudentDTO() {
    }

    public ResponseStudentDTO(String id, String grado, String matricula) {
		this.id = id;
		this.grado = grado;
		this.matricula = matricula;
	}


	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getGrado() {
		return grado;
	}

	public void setGrado(String grado) {
		this.grado = grado;
	}

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}
}
