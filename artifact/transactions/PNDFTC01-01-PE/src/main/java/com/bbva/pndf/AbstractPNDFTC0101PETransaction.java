package com.bbva.pndf;

import com.bbva.elara.transaction.AbstractTransaction;
import com.bbva.pndf.dto.student.ResponseStudentDTO;
import java.util.List;

/**
 * In this class, the input and output data is defined automatically through the setters and getters.
 */
public abstract class AbstractPNDFTC0101PETransaction extends AbstractTransaction {

	public AbstractPNDFTC0101PETransaction(){
	}


	/**
	 * Return value for input parameter grado
	 */
	protected String getGrado(){
		return (String)this.getParameter("grado");
	}

	/**
	 * Return value for input parameter edad
	 */
	protected String getEdad(){
		return (String)this.getParameter("edad");
	}

	/**
	 * Set value for List<ResponseStudentDTO> output parameter estudianteDto
	 */
	protected void setEstudiantedto(final List<ResponseStudentDTO> field){
		this.addParameter("estudianteDto", field);
	}
}
