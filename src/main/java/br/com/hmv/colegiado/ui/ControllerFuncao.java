/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.hmv.colegiado.ui;

import br.com.hmv.colegiado.entidade.Funcao;
import br.com.hmv.colegiado.exception.FuncaoExistenteException;
import br.com.hmv.colegiado.exception.FuncaoInexistenteException;
import br.com.hmv.colegiado.listar.FuncaoListar;
import br.com.hmv.colegiado.negocio.FachadaServico;
import java.util.List;
import javax.swing.text.html.parser.DTDConstants;
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
 * @author Marcus Vinícius <vinimarcus02@gmail.com>
 */
@Controller
@RequestMapping("/funcao")
public class ControllerFuncao {
    
    static org.apache.log4j.Logger log = org.apache.log4j.Logger.getLogger(ControllerFuncao.class);
    @Autowired
    private FachadaServico fachada;
    
    @RequestMapping(value = "/listar", headers="Accept=*/*", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody List<FuncaoListar> listarTodos(){
         return fachada.listarTodasFuncoes();
    }
    
    @RequestMapping(value = "/consultar")
    public @ResponseBody List<FuncaoListar> consultar(String nome){
        try{
            return fachada.ConsultarPorNome(nome);
        } catch (FuncaoInexistenteException ex) {
            return null;
        }
    }
    
    @RequestMapping(value = "/consultarPorId", headers="Accept=*/*", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody List<FuncaoListar> consultarPorId(Long id){
        try{
            return fachada.ConsultarPorId(id);
        } catch (FuncaoInexistenteException ex) {
            return null;
        }
    }
    
    @RequestMapping(value = "/cadastrar", headers="Accept=*/*", produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody ResponseEntity<?> adicionarFuncao(Funcao funcao) {
        try {
            fachada.cadastrar(funcao);
            return new ResponseEntity<String>(HttpStatus.OK);
        } catch (FuncaoExistenteException ex) {
            return new ResponseEntity<FuncaoExistenteException>(ex, HttpStatus.BAD_REQUEST);
        } catch (FuncaoInexistenteException ex1) {
            return new ResponseEntity<FuncaoInexistenteException>(ex1, HttpStatus.BAD_REQUEST);
        }
    }
    
    @RequestMapping(value = "/atualizar", headers="Accept=*/*", produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody ResponseEntity<?> atualizarFuncao(Funcao funcao) {
        try {
            fachada.atualizar(funcao);
            return new ResponseEntity<String>(HttpStatus.OK);
        } catch (FuncaoInexistenteException ex) {
            return new ResponseEntity<FuncaoInexistenteException>(ex, HttpStatus.BAD_REQUEST);
        }
    }
    
    @RequestMapping(value = "/deletar", headers="Accept=*/*", produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody ResponseEntity<?> deletarFuncao(String nome) {
        try {
            fachada.remover(nome);
            return new ResponseEntity<String>(HttpStatus.OK);
        } catch (FuncaoInexistenteException ex) {
            return new ResponseEntity<FuncaoInexistenteException>(ex, HttpStatus.BAD_REQUEST);
        }
    }
    
     //---------------------------------------------------------------------
    
    @RequestMapping("/cadastro")
    public String formCadastrar() {
        return "cadastroFuncao";
    }
    
    @RequestMapping("/atualiza")
    public String formAtualizar() {
        return "atualizaFuncao";
    }
    @RequestMapping("/consulta")
    public String formConsultar() {
        return "consultaFuncao";
    }
    @RequestMapping("/deleta")
    public String formDeletar() {
        return "deletaFuncao";
    }
    
    @RequestMapping("/list")
    public String formListar() {
        return "listarFuncao";
    }
    
}
