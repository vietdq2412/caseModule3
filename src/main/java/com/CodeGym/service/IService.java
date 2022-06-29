package com.CodeGym.service;

import java.util.HashMap;

public interface IService<T> {
    Boolean create(T t);
    HashMap<Integer, T> find(String condition);
    T findById(int id);
    T update(int id);
    T delete(int id);
}
