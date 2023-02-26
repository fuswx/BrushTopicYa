package com.fuswx.brushtopicya.Service;

import com.fuswx.brushtopicya.Bean.Component;
import com.fuswx.brushtopicya.Bean.Form;
import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;

public interface IFormService {
    ArrayList<Integer> saveForm(Form form);

    ArrayList<Integer> saveComponents(String formId,ArrayList<Component> components);

    Form getForm(String formId);

    PageInfo<Form> findAllForm(Integer pageNum, Integer pageSize);
}
