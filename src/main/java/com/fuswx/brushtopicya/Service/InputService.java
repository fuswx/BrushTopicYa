package com.fuswx.brushtopicya.Service;

import com.fuswx.brushtopicya.Bean.Input;

import java.util.ArrayList;

public interface InputService {

    Input showOne(Integer id);

    Input addOne(Integer id);

    Input initOne(Integer id);

    ArrayList<Input> findAll();
}
