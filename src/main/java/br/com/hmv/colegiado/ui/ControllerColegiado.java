/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.hmv.colegiado.ui;

import br.com.hmv.colegiado.negocio.FachadaServico;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author Marcus Vinícius <vinimarcus02@gmail.com>
 */
@Controller
@RequestMapping("/colegiadoAssistencia")
public class ControllerColegiado {
    
    static org.apache.log4j.Logger log = org.apache.log4j.Logger.getLogger(ControllerColegiado.class);
    
    @Autowired
    private FachadaServico fachada;
    
    
    @RequestMapping("/view")
    public String formCadastrar() {
        return "colegiadoAssistencia";
    }
    
}
