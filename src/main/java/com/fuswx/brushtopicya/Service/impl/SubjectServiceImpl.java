package com.fuswx.brushtopicya.Service.impl;

import com.fuswx.brushtopicya.Bean.ResponseData;
import com.fuswx.brushtopicya.Bean.Subject;
import com.fuswx.brushtopicya.Mapper.SubjectMapper;
import com.fuswx.brushtopicya.Service.ISubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;

@Service
@Transactional
public class SubjectServiceImpl implements ISubjectService {

    @Autowired
    private SubjectMapper subjectMapper;

    @Override
    public ArrayList<Subject> findAllSubjects() {
        return subjectMapper.findAllSubjects();
    }
}
