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
	private static final String ID = "id";
	private static final String ERR_NO_RESULTADOS = "Error";

	@Override
	public ResponseStudentDTO executeGetStudent(String id) {
		ResponseStudentDTO estudianteDTO;
		LOGGER.info("[PNDFRC01-executeGetCodigo] entrada id: {} ",id);
		Map<String, Object> request = new HashMap<>();
		request.put(ID, id);
		Map<String, Object> objResponseSQL = this.jdbcUtils.queryForMap(SELECT_ESTUDIANTE,request);
		if(objResponseSQL.size()>0){
			estudianteDTO = new ResponseStudentDTO((String) objResponseSQL.get("ID"),
					(String) objResponseSQL.get("GRADO"),(String) objResponseSQL.get("ESTADO_MATRICULA"));
		} else {
			//Dado que no hay resultados devolvemos un objeto vacío
			estudianteDTO = new ResponseStudentDTO("","","");
			LOGGER.info("[PNDFRC01-executeGetCodigo] No existe el id: {}",id);
			this.addAdvice(ERR_NO_RESULTADOS);
		}
		return estudianteDTO;
	}



}
