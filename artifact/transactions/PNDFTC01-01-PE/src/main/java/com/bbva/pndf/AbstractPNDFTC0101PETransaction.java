package com.bbva.pndf;

import com.bbva.elara.transaction.AbstractTransaction;
import com.bbva.pndf.dto.student.ResponseStudentDTO;

/**
 * In this class, the input and output data is defined automatically through the setters and getters.
 */
public abstract class AbstractPNDFTC0101PETransaction extends AbstractTransaction {

	public AbstractPNDFTC0101PETransaction(){
	}


	/**
	 * Return value for input parameter id
	 */
	protected String getId(){
		return (String)this.getParameter("id");
	}

	/**
	 * Set value for ResponseStudentDTO output parameter estudianteDTO
	 */
	protected void setEstudiantedto(final ResponseStudentDTO field){
		this.addParameter("estudianteDTO", field);
	}
}
