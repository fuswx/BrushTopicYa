package com.fuswx.brushtopicya.Controller;

import com.fuswx.brushtopicya.Bean.Code;
import com.fuswx.brushtopicya.Bean.Component;
import com.fuswx.brushtopicya.Bean.Form;
import com.fuswx.brushtopicya.Bean.ResponseData;
import com.fuswx.brushtopicya.Service.IFormService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@Controller
@RequestMapping("/api/form")
public class FormController {

    @Autowired
    private IFormService formService;

    @PostMapping("/saveForm.do")
    public @ResponseBody ResponseData<ArrayList<Integer>> saveForm(@RequestBody Form form){
        return new ResponseData<>(Code.okk.getCode(), formService.saveForm(form));
    }

    @GetMapping("/getForm.do")
    public @ResponseBody ResponseData<Form> getForm(String formId){
        return new ResponseData<Form>(Code.okk.getCode(), formService.getForm(formId));
    }

    @GetMapping("/getAllForm.do")
    public @ResponseBody ResponseData<PageInfo<Form>> getAllForm(@RequestParam(name = "pageNum",defaultValue = "1")Integer pageNum,
                                                       @RequestParam(name = "pageSize",defaultValue = "10")Integer pageSize){
        return new ResponseData<>(Code.okk.getCode(), formService.findAllForm(pageNum, pageSize));
    }

}
