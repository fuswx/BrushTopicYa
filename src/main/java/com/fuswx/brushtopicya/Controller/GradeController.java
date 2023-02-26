package com.fuswx.brushtopicya.Controller;

import com.fuswx.brushtopicya.Bean.Code;
import com.fuswx.brushtopicya.Bean.Grade;
import com.fuswx.brushtopicya.Bean.ResponseData;
import com.fuswx.brushtopicya.Bean.Subject;
import com.fuswx.brushtopicya.Service.IGradeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;

@Controller
@RequestMapping("/api/grade")
public class GradeController {
    @Autowired
    private IGradeService gradeService;

    //查找所有学科
    @GetMapping("/findAllGrades.do")
    @ResponseBody
    public ResponseData<ArrayList<Grade>> findAllGrades(){
        return new ResponseData<ArrayList<Grade>>(Code.okk.getCode(), gradeService.findAllGrades());
    };

    @PostMapping("/findAllGradeByCategory.do")
    @ResponseBody
    public ResponseData<ArrayList<Grade>> findAllGradeByCategory(String category){
        return new ResponseData<ArrayList<Grade>>(Code.okk.getCode(), gradeService.findAllGradeByCategory(category));
    }
}
