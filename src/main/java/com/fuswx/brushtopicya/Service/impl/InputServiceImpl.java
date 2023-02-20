package com.fuswx.brushtopicya.Service.impl;

import com.fuswx.brushtopicya.Bean.Input;
import com.fuswx.brushtopicya.Mapper.InputMapper;
import com.fuswx.brushtopicya.Service.InputService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;

@Service
@Transactional
public class InputServiceImpl implements InputService {

    @Autowired
    private InputMapper inputMapper;

    @Override
    public Input showOne(Integer id) {
        return inputMapper.showOne(id);
    }

    @Override
    public Input addOne(Integer id) {
        return inputMapper.addOne(id);
    }

    @Override
    public Input initOne(Integer id) {
        return inputMapper.initOne(id);
    }

    @Override
    public ArrayList<Input> findAll() {
        return inputMapper.findAll();
    }
}
