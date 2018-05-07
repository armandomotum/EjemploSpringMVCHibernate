/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ejemplo.backend.dao;

import java.io.Serializable;
import java.util.List;
import org.hibernate.SessionFactory;

/**
 *
 * @author Ejercicioooooooooooo
 */
public interface GenericDaoInterface<T, PK extends Serializable> {
    public List<T> findAll();
    public PK save(T t);
    public void update(T t);
    public void delete(T t);
    public T findById(PK id);
    public SessionFactory getSessionFactory();
    public void setSessionFactory(SessionFactory sessionFactory);
}
