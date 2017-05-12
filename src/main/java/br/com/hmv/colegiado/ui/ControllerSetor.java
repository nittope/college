/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.hmv.colegiado.ui;

import br.com.hmv.colegiado.entidade.Setor;
import br.com.hmv.colegiado.exception.SetorExistenteException;
import br.com.hmv.colegiado.exception.SetorInexistenteException;
import br.com.hmv.colegiado.listar.SetorListar;
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
@RequestMapping("/setor")
public class ControllerSetor {
  static org.apache.log4j.Logger log = org.apache.log4j.Logger.getLogger(ControllerSetor.class);
    @Autowired
    private FachadaServico fachada;
    
    @RequestMapping(value = "/listar", headers="Accept=*/*", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody List<SetorListar> listarTodos(){
         return fachada.listarTodosSetores();
    }
    
    @RequestMapping(value = "/consultar")
    public @ResponseBody List<SetorListar> consultar(String nome){
        try{
            return fachada.ConsultarSetorPorNome(nome);
        } catch (SetorInexistenteException ex) {
            return null;
        }
    }
    
    @RequestMapping(value = "/consultarPorId", headers="Accept=*/*", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody List<SetorListar> consultarPorId(Long id){
        try{
            return fachada.ConsultarSetorPorId(id);
        } catch (SetorInexistenteException ex) {
            return null;
        }
    }
    
    @RequestMapping(value = "/cadastrar", headers="Accept=*/*", produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody ResponseEntity<?> adicionarSetor(Setor setor) {
        try {
            fachada.cadastrarSetor(setor);
            return new ResponseEntity<String>(HttpStatus.OK);
        } catch (SetorExistenteException ex) {
            return new ResponseEntity<SetorExistenteException>(ex, HttpStatus.BAD_REQUEST);
        } catch (SetorInexistenteException ex1) {
            return new ResponseEntity<SetorInexistenteException>(ex1, HttpStatus.BAD_REQUEST);
        }
    }
    
    @RequestMapping(value = "/atualizar", headers="Accept=*/*", produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody ResponseEntity<?> atualizarSetor(Setor setor) {
        try {
            fachada.atualizarSetor(setor);
            return new ResponseEntity<String>(HttpStatus.OK);
        } catch (SetorInexistenteException ex) {
            return new ResponseEntity<SetorInexistenteException>(ex, HttpStatus.BAD_REQUEST);
        }
    }
    
    @RequestMapping(value = "/deletar", headers="Accept=*/*", produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody ResponseEntity<?> deletarSetor(Setor setor) {
        try {
            fachada.removerSetor(setor);
            return new ResponseEntity<String>(HttpStatus.OK);
        } catch (SetorInexistenteException ex) {
            return new ResponseEntity<SetorInexistenteException>(ex, HttpStatus.BAD_REQUEST);
        }
    }
    
     //---------------------------------------------------------------------
    
    @RequestMapping("/view")
    public String formCadastrar() {
        return "cadastroSetor";
    }
    
    @RequestMapping("/atualiza")
    public String formAtualizar() {
        return "atualizaSetor";
    }
    @RequestMapping("/consulta")
    public String formConsultar() {
        return "consultaSetor";
    }
    @RequestMapping("/deleta")
    public String formDeletar() {
        return "deletaSetor";
    }
    
    @RequestMapping("/list")
    public String formListar() {
        return "listarSetor";
    }
      
}
