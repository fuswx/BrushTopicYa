package com.fuswx.brushtopicya.Service.impl;

import com.fuswx.brushtopicya.Bean.Component;
import com.fuswx.brushtopicya.Bean.Form;
import com.fuswx.brushtopicya.Mapper.FormMapper;
import com.fuswx.brushtopicya.Service.IFormService;
import com.fuswx.brushtopicya.Utils.Formatter;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Arrays;

@Service
@Transactional
public class FormServiceImpl implements IFormService {

    @Autowired
    private FormMapper formMapper;

    @Autowired
    private Formatter formatter;

    @Override
    public ArrayList<Integer> saveForm(Form form) {
        formMapper.deleteFormById(form.getId());
        formMapper.deleteComponentByFormId(form.getId());
        formMapper.saveForm(form);
        saveComponents(form.getId(),form.getComponents());
        return new ArrayList<>();
    }

    @Override
    public ArrayList<Integer> saveComponents(String formId,ArrayList<Component> components) {
        for (Component component : components) {
            component.setFormId(formId);
            component.setInitAnswerToString(formatter.getInitToString(component.getInitAnswer()));
            component.setItemsToString(formatter.getInitToString(component.getItems()));
            formMapper.saveComponent(component);
        }
        return new ArrayList<>();
    }

    @Override
    public Form getForm(String formId) {
        Form form=formMapper.getFormById(formId);
        ArrayList<Component> components=formMapper.getAllComponentsByFormId(formId);
        for (Component component : components) {
//            String[] items=component.getItemsToString().split("··");
//            component.setItems(new ArrayList<>(Arrays.asList(items)));
            component.setItems(formatter.getInitStringToItems(component.getItemsToString()));
            //清空答案
            component.setInitAnswer(new ArrayList<>());
            component.setInitAnswerToString("");
        }
        form.setComponents(components);
        return form;
    }

    @Override
    public PageInfo<Form> findAllForm(Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        ArrayList<Form> forms=formMapper.findAllForm();
        PageInfo<Form> pageInfo=new PageInfo<>(forms);
        return pageInfo;
    }
}
