/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ejemplo.backend.dao;

import com.ejemplo.backend.model.Pendiente;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Ejercicioooooooooooo
 */
@Repository
public class PendienteDaoImplement extends GenericDaoImplement<Pendiente,Integer> implements PendienteDaoInterface{
    
//    public FamiliarDaoImplement(SessionFactory sf) {
//        super(sf);
//    }
    public PendienteDaoImplement() {
        super(NewHibernateUtil.getSessionFactory());
    }
    
}
