package com.bbva.pndf.lib.rc01;

import com.bbva.apx.exception.business.BusinessException;
import com.bbva.apx.exception.db.NoResultException;
import com.bbva.elara.configuration.manager.application.ApplicationConfigurationService;
import com.bbva.elara.domain.transaction.Context;
import com.bbva.elara.domain.transaction.ThreadContext;
import javax.annotation.Resource;

import com.bbva.elara.utility.jdbc.JdbcUtils;
import com.bbva.pndf.dto.student.ResponseStudentDTO;
import com.bbva.pndf.lib.rc01.impl.PNDFRC01Impl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.*;
import org.springframework.aop.framework.Advised;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.*;

import static org.mockito.Mockito.when;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {
		"classpath:/META-INF/spring/PNDFRC01-app.xml",
		"classpath:/META-INF/spring/PNDFRC01-app-test.xml",
		"classpath:/META-INF/spring/PNDFRC01-arc.xml",
		"classpath:/META-INF/spring/PNDFRC01-arc-test.xml" })
public class PNDFRC01Test {

	@Spy
	private Context context;

	@Resource(name = "pndfRC01")
	private PNDFRC01 pndfRC01;

	@InjectMocks
	private PNDFRC01Impl pndfRC01Impl;
	@Mock
	private JdbcUtils jdbcUtils;

	@Resource(name = "applicationConfigurationService")
	private ApplicationConfigurationService applicationConfigurationService;

	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
		context = new Context();
		ThreadContext.set(context);
		getObjectIntrospection();
	}
	
	private Object getObjectIntrospection() throws Exception{
		Object result = this.pndfRC01;
		if(this.pndfRC01 instanceof Advised){
			Advised advised = (Advised) this.pndfRC01;
			result = advised.getTargetSource().getTarget();
		}
		return result;
	}
	
 	@Test
	public void executeTestNotNull(){
		ResponseStudentDTO dummyMap;
		String id="prueba";
		Map<String, Object> request = new HashMap<>();
		request.put("ID",id);
		Mockito.when(jdbcUtils.queryForMap(Matchers.matches("pndf.select.estudiante"), Matchers.anyMap())).thenReturn(request);
		dummyMap = this.pndfRC01Impl.executeGetStudent(id);
		Assert.assertNotNull(dummyMap);
		Assert.assertEquals("prueba", dummyMap.getId());
	}
	@Test
	public void executeTestNotNull2(){
		ResponseStudentDTO dummyMap;
		String id="";
		Map<String, Object> request = new HashMap<>();
		request.put("ID",id);
		Mockito.when(jdbcUtils.queryForMap(Matchers.matches("pndf.select.estudiante"), Matchers.anyMap())).thenReturn(new HashMap<>());
		dummyMap = this.pndfRC01Impl.executeGetStudent(id);
		Assert.assertNotNull(dummyMap);
		Assert.assertEquals("", dummyMap.getId());
	}


}
