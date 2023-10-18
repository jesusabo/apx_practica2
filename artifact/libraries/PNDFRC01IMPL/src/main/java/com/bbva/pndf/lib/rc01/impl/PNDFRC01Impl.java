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
	private static final String SELECT_ESTUDIANTE2 = "pndf.select.estudiante2";
	private static final String GRADO = "grado";
	private static final String EDAD = "edad";
	private static final String ERR_NO_RESULTADOS = "Error";

	@Override
	public List<ResponseStudentDTO> executeGetStudent(String grado, String edad) {
		// TODO - Implementation of business logic
		//LOGGER.info("[PNDFRC01-executeGetCodio] entrada codigo: {} ",codigo);

		List<Map<String, Object>> objResponseSQL = null;
		List<ResponseStudentDTO> estudianteDTOList = null;
		Map<String, Object> request = new HashMap<>();


		if(!grado.isEmpty() && grado!=null && !edad.isEmpty() && edad!=null) {
			request.put(GRADO, grado);
			request.put(EDAD, edad);
			LOGGER.info("[PNDFRC01] entro a la opcion 1 ");
			try {
				objResponseSQL =  this.jdbcUtils.queryForList(SELECT_ESTUDIANTE, request);
				estudianteDTOList = fromMapData(objResponseSQL);
			} catch (NoResultException noResultException) {
				LOGGER.info(ERR_NO_RESULTADOS, noResultException.getMessage());
				this.addAdvice(ERR_NO_RESULTADOS);
			}
		} else {
			LOGGER.info("[PNDFRC01] entro a la opcion 2 ");
			try {
				objResponseSQL =  this.jdbcUtils.queryForList(SELECT_ESTUDIANTE2, request);
				estudianteDTOList = fromMapData(objResponseSQL);
			} catch (NoResultException noResultException) {
				LOGGER.info(ERR_NO_RESULTADOS, noResultException.getMessage());
				this.addAdvice(ERR_NO_RESULTADOS);
			}
		}

		return estudianteDTOList;
	}

	public List<ResponseStudentDTO> fromMapData(List<Map<String, Object>> data) {
		List<ResponseStudentDTO> dataEstudianteDTOList = new ArrayList<>();
		for (Map<String, Object> obj : data) {
			LOGGER.info("fromMapData{} ",obj);
			dataEstudianteDTOList.add(fromMapData2(obj));
		}
		return dataEstudianteDTOList;
	}

	public ResponseStudentDTO fromMapData2(Map<String, Object> data) {
		ResponseStudentDTO accessParameters = new ResponseStudentDTO();
		if(data!=null){
			LOGGER.info("fromMapData2{} ",data);
			accessParameters.setFechaIngreso((Date) data.get("FECHA_INGRESO"));
			accessParameters.setFechaSalida((Date) data.get("FECHA_SALIDA"));
			accessParameters.setEdad((String) data.get("EDAD"));
			accessParameters.setGrado((String) data.get("GRADO"));
			accessParameters.setEstado((String) data.get("ESTADO_MATRICULA"));
		}
		return accessParameters;
	}
}
