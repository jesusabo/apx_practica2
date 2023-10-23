package com.bbva.pndf.lib.rc01;

import com.bbva.pndf.dto.student.ResponseStudentDTO;

import java.util.List;

/**
 * The  interface PNDFRC01 class...
 */
public interface PNDFRC01 {

	/**
	 * The execute method...
	 */
	ResponseStudentDTO executeGetStudent(String id);

}
