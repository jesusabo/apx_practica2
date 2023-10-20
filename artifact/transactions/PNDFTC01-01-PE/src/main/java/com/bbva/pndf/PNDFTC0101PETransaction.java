package com.bbva.pndf;

import com.bbva.elara.domain.transaction.Severity;
import com.bbva.elara.domain.transaction.response.HttpResponseCode;
import com.bbva.pndf.dto.student.ResponseStudentDTO;
import com.bbva.pndf.lib.rc01.PNDFRC01;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

/**
 * MOSTRAR EL DOMINIO
 *
 */
public class PNDFTC0101PETransaction extends AbstractPNDFTC0101PETransaction {

	private static final Logger LOGGER = LoggerFactory.getLogger(PNDFTC0101PETransaction.class);

	/**
	 * The execute method...
	 */
	@Override
	public void execute() {
		PNDFRC01 pndfRC01 = this.getServiceLibrary(PNDFRC01.class);
		String grado = this.getGrado();
		String edad = this.getEdad();
		List<ResponseStudentDTO> estudianteDTOList = pndfRC01.executeGetStudent(grado,edad);
		if(estudianteDTOList!=null){
			this.setEstudiantedto(estudianteDTOList);
			this.setSeverity( Severity.OK);
			this.setHttpResponseCode(HttpResponseCode.HTTP_CODE_200);
		} else {
			this.setSeverity(Severity.ENR);
		}
	}

}
