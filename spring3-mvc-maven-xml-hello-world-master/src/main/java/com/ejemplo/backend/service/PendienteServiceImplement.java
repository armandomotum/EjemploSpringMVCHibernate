/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ejemplo.backend.service;

import com.ejemplo.backend.dao.PendienteDaoInterface;
import com.ejemplo.backend.model.Pendiente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Ejercicioooooooooooo
 */
@Service
public class PendienteServiceImplement extends GenericServiceImplement<Pendiente> implements PendienteServiceInterface{
    
    @Autowired
    public PendienteServiceImplement(PendienteDaoInterface genericDaoInstance) {
        super(genericDaoInstance);
    }
    
}
