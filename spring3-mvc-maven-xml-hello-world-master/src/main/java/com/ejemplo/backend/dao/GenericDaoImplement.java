/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ejemplo.backend.dao;

import java.io.Serializable;
import org.hibernate.SessionFactory;
import java.lang.reflect.Type;
import java.lang.reflect.ParameterizedType;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author Ejercicioooooooooooo
 */
public abstract class GenericDaoImplement<T, PK extends Serializable> implements GenericDaoInterface<T, PK> {
    
    private SessionFactory sessionFactory;
    private Class<T> type;
    
    public GenericDaoImplement(SessionFactory sessionFactory){
        this.sessionFactory = sessionFactory;
        Type t = getClass().getGenericSuperclass();
        ParameterizedType pt = (ParameterizedType) t;
        this.type = (Class) pt.getActualTypeArguments()[0];
    }
    
    @Override
    public List<T> findAll() {
        Session sesssion = this.getSessionFactory().openSession();
        List<T> lista_elementos = sesssion.createCriteria(this.type).list();
        sesssion.close();
        return lista_elementos;
    }

    @Override
    public PK save(T t) {
        Session sesssion = this.getSessionFactory().openSession();
        Transaction transaction=sesssion.beginTransaction();        
        PK pk = (PK) sesssion.save(t);
        transaction.commit();
        sesssion.close();
        return pk;
    }

    @Override
    public void update(T t) {
        Session sesssion = this.getSessionFactory().openSession();
        Transaction transaction=sesssion.beginTransaction();        
        sesssion.update(t);
        transaction.commit();
        sesssion.close();
    }

    @Override
    public void delete(T t) {
        Session sesssion = this.getSessionFactory().openSession();
        Transaction transaction=sesssion.beginTransaction();        
        sesssion.delete(t);
        transaction.commit();
        sesssion.close();
    }

    @Override
    public T findById(PK id) {
        Session sesssion = this.getSessionFactory().openSession();
        Object find = sesssion.get(type, id);
        sesssion.close();
        return (T) find;
    }

    @Override
    public SessionFactory getSessionFactory() {
        return this.sessionFactory;
    }
    
    @Override
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
}
