package com.apress.isf.spring.annotated.service;

import com.apress.isf.java.model.Document;
import com.apress.isf.java.model.Type;
import com.apress.isf.java.service.SearchEngine;
import com.apress.isf.spring.data.DocumentDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by yoyojyv on 3/17/15.
 */
@Service("engine")
public class AnnotatedSearchEngine implements SearchEngine {

    @Autowired
    private DocumentDao documentDao;

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
