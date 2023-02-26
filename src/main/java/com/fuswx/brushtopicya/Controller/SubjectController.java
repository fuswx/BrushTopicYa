package com.fuswx.brushtopicya.Controller;

import com.fuswx.brushtopicya.Bean.Code;
import com.fuswx.brushtopicya.Bean.ResponseData;
import com.fuswx.brushtopicya.Bean.Subject;
import com.fuswx.brushtopicya.Service.ISubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.lang.reflect.Array;
import java.util.ArrayList;

@Controller
@RequestMapping("/api/subject")
public class SubjectController {

    @Autowired
    private ISubjectService subjectService;

    //查询所有科目
    @GetMapping("/findAllSubjects.do")
    @ResponseBody
    public ResponseData<ArrayList<Subject>> getAllSubjects(){
        return new ResponseData<>(Code.okk.getCode(), subjectService.findAllSubjects());
    };


}
