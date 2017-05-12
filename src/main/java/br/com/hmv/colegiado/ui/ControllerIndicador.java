/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.hmv.colegiado.ui;

import br.com.hmv.colegiado.entidade.Indicador;
import br.com.hmv.colegiado.exception.IndicadorExistenteException;
import br.com.hmv.colegiado.exception.IndicadorInexistenteException;
import br.com.hmv.colegiado.listar.IndicadorListar;
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
@RequestMapping("/indicador")
public class ControllerIndicador {
    static org.apache.log4j.Logger log = org.apache.log4j.Logger.getLogger(ControllerIndicador.class);
    
    @Autowired
    private FachadaServico fachada;
    
    @RequestMapping(value = "/listar", headers="Accept=*/*", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody List<IndicadorListar> listarTodos(){
         return fachada.listarTodosIndicadores();
    }
    
    @RequestMapping(value = "/consultar")
    public @ResponseBody List<IndicadorListar> consultar(String nome){
        try{
            return fachada.ConsultarIndicadoresPorNome(nome);
        } catch (IndicadorInexistenteException ex) {
            return null;
        }
    }
    
    @RequestMapping(value = "/consultarPorId", headers="Accept=*/*", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody List<IndicadorListar> consultarPorId(Long id){
        try{
            return fachada.ConsultarIndicadoresPorId(id);
        } catch (IndicadorInexistenteException ex) {
            return null;
        }
    }
    
    @RequestMapping(value = "/cadastrar", headers="Accept=*/*", produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody ResponseEntity<?> adicionarSetor(Indicador indicador) {
        try {
            fachada.cadastrarIndicador(indicador);
            return new ResponseEntity<String>(HttpStatus.OK);
        } catch (IndicadorExistenteException ex) {
            return new ResponseEntity<IndicadorExistenteException>(ex, HttpStatus.BAD_REQUEST);
        } catch (IndicadorInexistenteException ex1) {
            return new ResponseEntity<IndicadorInexistenteException>(ex1, HttpStatus.BAD_REQUEST);
        }
    }
    
    @RequestMapping(value = "/atualizar", headers="Accept=*/*", produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody ResponseEntity<?> atualizarSetor(Indicador indicador) {
        try {
            fachada.atualizarIndicador(indicador);
            return new ResponseEntity<String>(HttpStatus.OK);
        } catch (IndicadorInexistenteException ex) {
            return new ResponseEntity<IndicadorInexistenteException>(ex, HttpStatus.BAD_REQUEST);
        }
    }
    
    @RequestMapping(value = "/deletar", headers="Accept=*/*", produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody ResponseEntity<?> deletarSetor(Indicador indicador) {
        try {
            fachada.removerIndicador(indicador);
            return new ResponseEntity<String>(HttpStatus.OK);
        } catch (IndicadorInexistenteException ex) {
            return new ResponseEntity<IndicadorInexistenteException>(ex, HttpStatus.BAD_REQUEST);
        }
    }
    
     //---------------------------------------------------------------------
    
    @RequestMapping("/view")
    public String formCadastrar() {
        return "cadastroIndicador";
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
