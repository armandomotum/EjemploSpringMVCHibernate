/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ejemplo.backend.service;

import java.io.Serializable;
import java.util.List;

/**
 *
 * @author Ejercicioooooooooooo
 */
public interface GenericServiceInterface<T> {
    public List<T> findAll();
    public Serializable save(T t);
    public void update(T t);
    public void delete(T t);
    public T findById(Serializable id);
}
