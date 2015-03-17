package com.apress.isf.java.service;

import com.apress.isf.java.model.Document;
import com.apress.isf.java.model.Type;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yoyojyv on 3/17/15.
 */
public class MySearchEngine implements SearchEngine {

    @Override
    public List<Document> findByType(Type documentType) {

        List<Document> result = new ArrayList<>();
        for (Document d : storage()) {
            if (d.getType().getName().endsWith(documentType.getName())) {
                result.add(d);
            }
        }

        return result;
    }

    @Override
    public List<Document> findAll() {
        return storage();
    }


    private List<Document> storage() {

        List<Document> result = new ArrayList<>();

        Type type = new Type();
        type.setName("PDF");
        type.setDesc("Portable Document Format");
        type.setExtension(".pdf");


        Document document = new Document();
        document.setName("Book Template");
        document.setType(type);
        document.setLocation("/Users/yoyojyv/Temp/Study/Book Template.pdf");

        result.add(document);

        document = new Document();
        document.setName("Sample Contract");
        document.setType(type);
        document.setLocation("/Users/yoyojyv/Temp/Study/Sample Contract.pdf");

        result.add(document);

        type = new Type();
        type.setName("NOTE");
        type.setDesc("Text Notes");
        type.setExtension(".txt");

        document = new Document();
        document.setName("Clustering with RabbitMQ");
        document.setType(type);
        document.setLocation("/Users/yoyojyv/Temp/Study/Clustering with RabbitMQ.txt");

        result.add(document);

        type = new Type();
        type.setName("WEB");
        type.setDesc("Web Link");
        type.setExtension(".url");

        document = new Document();
        document.setName("Pro Spring Security Book");
        document.setType(type);
        document.setLocation("http://www.apress.com/9781430248187");

        result.add(document);

        return result;
    }

}
