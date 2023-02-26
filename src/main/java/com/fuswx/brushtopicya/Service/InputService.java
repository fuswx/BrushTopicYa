package com.fuswx.brushtopicya.Service;

import com.fuswx.brushtopicya.Bean.Input;

import java.util.ArrayList;

public interface InputService {

    Input showOne(Integer id);

    ArrayList<Input> findAll();
}
