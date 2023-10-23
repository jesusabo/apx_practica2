package com.bbva.pndf.lib.rc01.impl;

import com.bbva.apx.exception.db.NoResultException;
import com.bbva.pndf.dto.student.ResponseStudentDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.*;

/**
 * The PNDFRC01Impl class...
 */
public class PNDFRC01Impl extends PNDFRC01Abstract {

	private static final Logger LOGGER = LoggerFactory.getLogger(PNDFRC01Impl.class);

	private static final String SELECT_ESTUDIANTE = "pndf.select.estudiante";
	private static final String ERR_NO_RESULTADOS = "Error";

	@Override
	public List<ResponseStudentDTO> executeGetStudent(String id) {

		LOGGER.info("[PNDFRC01-executeGetCodigo] entrada id: {} ",id);

		Map<String, Object> objResponseSQL = null;

		objResponseSQL = this.jdbcUtils.getQuery(SELECT_ESTUDIANTE, id);

		if(objResponseSQL!=null){
			estudianteDTOList = fromMapData(objResponseSQL);
		}else{
			LOGGER.info("[PNDFRC01-executeGetCodigo] No existe el id: {}",id);
			this.addAdvice(ERR_NO_RESULTADOS);
		}

		return estudianteDTOList;
	}

	public ResponseStudentDTO fromMapData(Map<String, Object> data) {
		ResponseStudentDTO responseStudentDTO = new ResponseStudentDTO();

		responseStudentDTO.setId((String) data.get("ID"));
		responseStudentDTO.setGrado((String) data.get("GRADO"));
		responseStudentDTO.setMatricula((String) data.get("ESTADO_MATRICULA"));

		return responseStudentDTO;
	}

}
