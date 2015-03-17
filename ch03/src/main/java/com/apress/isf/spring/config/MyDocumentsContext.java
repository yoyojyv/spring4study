package com.apress.isf.spring.config;

import com.apress.isf.java.model.Document;
import com.apress.isf.java.model.Type;
import com.apress.isf.java.service.SearchEngine;
import com.apress.isf.spring.data.DocumentDao;
import com.apress.isf.spring.data.DocumentRepository;
import com.apress.isf.spring.service.SearchEngineService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by yoyojyv on 3/17/15.
 */
@Configuration
public class MyDocumentsContext {

    private Map<String, Document> documents = new HashMap<>();
    private Map<String, Type> types = new HashMap<>();

    @Bean
    public Type webType(){
        return getTypeFromMap("web");
    }

    @Bean
    public SearchEngine engine(){
        SearchEngineService engine = new SearchEngineService();
        engine.setDocumentDao(documentDao());
        return engine;
    }

    public MyDocumentsContext(){
        Type type = new Type();
        type.setName("PDF");
        type.setDesc("Portable Document Format");
        type.setExtension(".pdf");


        Document document = new Document();
        document.setName("Book Template");
        document.setType(type);
        document.setLocation("/Users/xxx/Documents/Random/Book Template.pdf");

        documents.put("doc1", document);
        types.put("pdf",type);

        document = new Document();
        document.setName("Sample Contract");
        document.setType(type);
        document.setLocation("/Users/xxx/Documents/Contracts/Sample Contract.pdf");

        documents.put("doc2",document);

        type = new Type();
        type.setName("NOTE");
        type.setDesc("Text Notes");
        type.setExtension(".txt");

        document = new Document();
        document.setName("Clustering with RabbitMQ");
        document.setType(type);
        document.setLocation("/Users/xxx/Documents/Random/Clustering with RabbitMQ.txt");

        documents.put("doc3",document);
        types.put("note",type);

        type = new Type();
        type.setName("WEB");
        type.setDesc("Web Link");
        type.setExtension(".url");

        document = new Document();
        document.setName("Pro Spring Security Book");
        document.setType(type);
        document.setLocation("http://www.apress.com/9781430248187");

        documents.put("doc4",document);
        types.put("web",type);
    }

    private DocumentDao documentDao(){
        DocumentRepository documentDao = new DocumentRepository();
        documentDao.setDoc1(getDocumentFromMap("doc1"));
        documentDao.setDoc2(getDocumentFromMap("doc2"));
        documentDao.setDoc3(getDocumentFromMap("doc3"));
        documentDao.setDoc4(getDocumentFromMap("doc4"));
        return documentDao;
    }

    private Document getDocumentFromMap(String documentKey){
        return documents.get(documentKey);
    }

    private Type getTypeFromMap(String typeKey){
        return types.get(typeKey);
    }



}
