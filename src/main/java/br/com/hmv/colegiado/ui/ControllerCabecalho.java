/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.hmv.colegiado.ui;

import br.com.hmv.colegiado.entidade.Cabecalho;
import br.com.hmv.colegiado.exception.CabecalhoExistenteException;
import br.com.hmv.colegiado.exception.CabecalhoInexistenteException;
import br.com.hmv.colegiado.listar.CabecalhoListar;
import br.com.hmv.colegiado.negocio.FachadaServico;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author vinim
 */
@Controller
@RequestMapping("/cabecalho")
public class ControllerCabecalho {
    static org.apache.log4j.Logger log = org.apache.log4j.Logger.getLogger(ControllerCabecalho.class);
    
    @Autowired
    private FachadaServico fachada;
    
    @RequestMapping(value = "/listar", headers="Accept=*/*", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody List<CabecalhoListar> listarTodos(){
         return fachada.listarTodosCabecalhos();
    }
    
    @RequestMapping(value = "/consultar")
    public @ResponseBody List<CabecalhoListar> consultar(String nome){
        try{
            return fachada.ConsultarCabecalhoPorNome(nome);
        } catch (CabecalhoInexistenteException ex) {
            return null;
        }
    }
    
    @RequestMapping(value = "/consultarPorId", headers="Accept=*/*", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody List<CabecalhoListar> consultarPorId(Long id){
        try{
            return fachada.ConsultarCabecalhoPorId(id);
        } catch (CabecalhoInexistenteException ex) {
            return null;
        }
    }
    
    @RequestMapping(value = "/cadastrar", headers="Accept=*/*", produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody ResponseEntity<?> adicionarSetor(Cabecalho cabecalho) {
        try {
            fachada.cadastrarCabecalho(cabecalho);
            return new ResponseEntity<String>(HttpStatus.OK);
        } catch (CabecalhoExistenteException ex) {
            return new ResponseEntity<CabecalhoExistenteException>(ex, HttpStatus.BAD_REQUEST);
        } catch (CabecalhoInexistenteException ex1) {
            return new ResponseEntity<CabecalhoInexistenteException>(ex1, HttpStatus.BAD_REQUEST);
        }
    }
    
    @RequestMapping(value = "/atualizar", headers="Accept=*/*", produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody ResponseEntity<?> atualizarSetor(Cabecalho cabecalho) {
        try {
            fachada.atualizarCabecalho(cabecalho);
            return new ResponseEntity<String>(HttpStatus.OK);
        } catch (CabecalhoInexistenteException ex) {
            return new ResponseEntity<CabecalhoInexistenteException>(ex, HttpStatus.BAD_REQUEST);
        }
    }
    
    @RequestMapping(value = "/deletar", headers="Accept=*/*", produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody ResponseEntity<?> deletarSetor(Cabecalho cabecalho) {
        try {
            fachada.removerCabecalho(cabecalho);
            return new ResponseEntity<String>(HttpStatus.OK);
        } catch (CabecalhoInexistenteException ex) {
            return new ResponseEntity<CabecalhoInexistenteException>(ex, HttpStatus.BAD_REQUEST);
        }
    }
    
     //---------------------------------------------------------------------
    
    @RequestMapping("/view")
    public String formCadastrar() {
        return "cadastroCabecalho";
    }
    
    @RequestMapping("/atualiza")
    public String formAtualizar() {
        return "atualizaCabecalho";
    }
    @RequestMapping("/consulta")
    public String formConsultar() {
        return "consultaCabecalho";
    }
    @RequestMapping("/deleta")
    public String formDeletar() {
        return "deletaCabecalho";
    }
    
    @RequestMapping("/list")
    public String formListar() {
        return "listarCabecalho";
    }
}
