package com.apress.isf.spring.test;

import com.apress.isf.java.model.Document;
import com.apress.isf.java.model.Type;
import com.apress.isf.java.service.SearchEngine;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by yoyojyv on 3/17/15.
 */
public class MyDocumentsWithSpringTest {

    // run
    // $ ./gradlew :ch02:test -Dtest.single=MyDocumentsWithSpringTest

    private ClassPathXmlApplicationContext context;
    private SearchEngine engine;
    private Type documentType;

    @Before
    public void setup() {
        context = new ClassPathXmlApplicationContext("META-INF/spring/mydocuments-context.xml");
        engine = context.getBean(SearchEngine.class);
        documentType = context.getBean(Type.class);
    }

    @Test
    public void testWithSpringFindByType() {
        List<Document> documents = engine.findByType(documentType);
        assertNotNull(documents);
        assertTrue(documents.size() == 1);
        assertEquals(documentType.getName(), documents.get(0).getType().getName());
        assertEquals(documentType.getDesc(), documents.get(0).getType().getDesc());
        assertEquals(documentType.getExtension(), documents.get(0).getType().getExtension());
    }

    @Test
    public void testWithSpringListAll() {
        List<Document> documents = engine.findAll();
        assertNotNull(documents);
        assertTrue(documents.size() == 4);
    }

}
