/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mkyong.web.controller;

import com.ejemplo.backend.model.Pendiente;
import com.ejemplo.backend.service.PendienteServiceInterface;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author Ejercicioooooooooooo
 */
@Controller
@RequestMapping("/pendientes")
public class PendientesController {
    
    @Autowired
    private PendienteServiceInterface servicio;
    
    @RequestMapping(method = RequestMethod.GET)
    public String list(Model model) {
        List<Pendiente> lista = servicio.findAll();
	model.addAttribute("listaPendientes", lista);
	model.addAttribute("pendiente", new Pendiente());
        
        model.addAttribute("TextAgregarActualizar", "Agregar");
        model.addAttribute("actionPathRelativeSaveOrUpdate", "addPendiente");
        
        return "pendientes";
    }
    
    @RequestMapping("/addPendiente")
    public String addPendiente(@ModelAttribute("pendiente") Pendiente pendiente) {
        servicio.save(pendiente);
        return "redirect:/pendientes";
    }
    
    @RequestMapping("/modificarPendiente")
    public String modificarPendiente(@ModelAttribute("pendiente") Pendiente pendiente) {
        servicio.update(pendiente);
        return "redirect:/pendientes";
    }
    
    @RequestMapping("/deletePendiente/{id}")
    public String deletePendiente(@PathVariable("id") Integer id, Model model) {
        Pendiente pendiente = servicio.findById(id);
        servicio.delete(pendiente);
        return "redirect:/pendientes";
    }
    
//    @RequestMapping("/pantallaModificarPendiente/{id}")
//    public String pantallaModificarPendiente(@PathVariable("id") Integer id, Model model) {
//        Pendiente pendiente = servicio.findById(id);
//        model.addAttribute("pendiente", pendiente);
//        
//        return "pendientes_modificar";
//    }
    
    @RequestMapping("/pantallaModificarPendiente/{id}")
    public String pantallaModificarPendiente(@PathVariable("id") Integer id, Model model) {
        Pendiente pendiente = servicio.findById(id);
        
        
        List<Pendiente> lista = servicio.findAll();
	model.addAttribute("listaPendientes", lista);
        model.addAttribute("pendiente", pendiente);
        
        //model.addAttribute("TextAgregarActualizar", "Agregar");
        model.addAttribute("TextAgregarActualizar", "Actualizar");
        //model.addAttribute("actionPathRelativeSaveOrUpdate", "addPendiente");
        model.addAttribute("actionPathRelativeSaveOrUpdate", "modificarPendiente");
        
        return "pendientes";
    }
    
    
}
