/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ejemplo.backend.service;
import com.ejemplo.backend.dao.GenericDaoInterface;
import java.io.Serializable;
import java.util.List;
/**
 *
 * @author Ejercicioooooooooooo
 */
public abstract class GenericServiceImplement<T> implements GenericServiceInterface<T>{
    
    private GenericDaoInterface dao;
    
    public GenericServiceImplement(GenericDaoInterface genericDaoInstance){
        this.dao=genericDaoInstance;
    }

    @Override
    public List<T> findAll() {
        return this.dao.findAll();
    }

    @Override
    public Serializable save(T t) {
        return this.dao.save(t);
    }

    @Override
    public void update(T t) {
        dao.update(t);
    }

    @Override
    public void delete(T t) {
        this.dao.delete(t);
    }

    @Override
    public T findById(Serializable id) {
        return (T)this.dao.findById(id);
    }
    
}
