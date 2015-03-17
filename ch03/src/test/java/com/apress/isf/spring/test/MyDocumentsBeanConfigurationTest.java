package com.apress.isf.spring.test;

import com.apress.isf.java.model.Document;
import com.apress.isf.java.model.Type;
import com.apress.isf.java.service.SearchEngine;
import com.apress.isf.spring.config.MyDocumentsContext;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by yoyojyv on 3/17/15.
 */
public class MyDocumentsBeanConfigurationTest {

	private ApplicationContext context;
	private SearchEngine engine;
	private Type webType;
	
	@Before
	public void setup(){
		context = new AnnotationConfigApplicationContext(MyDocumentsContext.class);
		engine = context.getBean(SearchEngine.class);
		webType = context.getBean(Type.class);
	}
	
	@Test
	public void testWithBeanConfigurationFindByType() {	
		List<Document> documents = engine.findByType(webType);
		assertNotNull(documents);
		assertTrue(documents.size() == 1);
		assertEquals(webType.getName(),documents.get(0).getType().getName());
		assertEquals(webType.getDesc(),documents.get(0).getType().getDesc());
		assertEquals(webType.getExtension(),documents.get(0).getType().getExtension());
	}

	@Test
	public void testWithBeanConfigurationListAll() {		
		List<Document> documents = engine.findAll();
		assertNotNull(documents);
		assertTrue(documents.size() == 4);
	}

}
