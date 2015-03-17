package com.apress.isf.spring.service;

import com.apress.isf.java.model.Document;
import com.apress.isf.java.model.Type;
import com.apress.isf.java.service.SearchEngine;
import com.apress.isf.spring.data.DocumentDao;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by yoyojyv on 3/17/15.
 */
public class SearchEngineService implements SearchEngine {

    private DocumentDao documentDao;

    public void setDocumentDao(DocumentDao documentDao) {
        this.documentDao = documentDao;
    }


    @Override
    public List<Document> findByType(Type documentType) {

        List<Document> result = new ArrayList<>();

        for (Document d : findAll()) {
            if (d.getType().getName().equals(documentType.getName())) {
                result.add(d);
            }
        }

        return result;
    }

    @Override
    public List<Document> findAll() {
        return Arrays.asList(documentDao.getAll());
    }
}
