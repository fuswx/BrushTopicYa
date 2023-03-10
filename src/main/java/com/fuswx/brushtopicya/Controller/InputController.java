package com.fuswx.brushtopicya.Controller;

import com.fuswx.brushtopicya.Bean.Code;
import com.fuswx.brushtopicya.Bean.Input;
import com.fuswx.brushtopicya.Bean.ResponseData;
import com.fuswx.brushtopicya.Service.InputService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;

@Controller
@RequestMapping("/api/input")
public class InputController {
    @Autowired
    private InputService inputService;

    @GetMapping("/findAll.do")
    public @ResponseBody ResponseData<ArrayList<Input>> findAll(){
        return new ResponseData<>(Code.okk.getCode(), inputService.findAll());
    }

}
