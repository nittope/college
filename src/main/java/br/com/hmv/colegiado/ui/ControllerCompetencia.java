/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.hmv.colegiado.ui;

import br.com.hmv.colegiado.entidade.Competencia;
import br.com.hmv.colegiado.exception.CompetenciaExistenteException;
import br.com.hmv.colegiado.exception.CompetenciaInexistenteException;
import br.com.hmv.colegiado.listar.CompetenciaListar;
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
@RequestMapping("/competencia")
public class ControllerCompetencia {
    static org.apache.log4j.Logger log = org.apache.log4j.Logger.getLogger(ControllerCompetencia.class);
    
    @Autowired
    private FachadaServico fachada;
    
    @RequestMapping(value = "/listar", headers="Accept=*/*", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody List<CompetenciaListar> listarTodos(){
         return fachada.listarTodasAsCompetencias();
    }
    
    @RequestMapping(value = "/consultar")
    public @ResponseBody List<CompetenciaListar> consultar(String nome){
        try{
            return fachada.ConsultarCompetenciaPorNome(nome);
        } catch (CompetenciaInexistenteException ex) {
            return null;
        }
    }
    
    @RequestMapping(value = "/consultarPorId", headers="Accept=*/*", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody List<CompetenciaListar> consultarPorId(Long id){
        try{
            return fachada.ConsultarCompetenciaPorID(id);
        } catch (CompetenciaInexistenteException ex) {
            return null;
        }
    }
    
    @RequestMapping(value = "/cadastrar", headers="Accept=*/*", produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody ResponseEntity<?> adicionarSetor(Competencia competencia) {
        try {
            fachada.cadastrarCompetencia(competencia);
            return new ResponseEntity<String>(HttpStatus.OK);
        } catch (CompetenciaExistenteException ex) {
            return new ResponseEntity<CompetenciaExistenteException>(ex, HttpStatus.BAD_REQUEST);
        } catch (CompetenciaInexistenteException ex1) {
            return new ResponseEntity<CompetenciaInexistenteException>(ex1, HttpStatus.BAD_REQUEST);
        }
    }
    
    @RequestMapping(value = "/atualizar", headers="Accept=*/*", produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody ResponseEntity<?> atualizarSetor(Competencia competencia) {
        try {
            fachada.atualizarCompetencia(competencia);
            return new ResponseEntity<String>(HttpStatus.OK);
        } catch (CompetenciaInexistenteException ex) {
            return new ResponseEntity<CompetenciaInexistenteException>(ex, HttpStatus.BAD_REQUEST);
        }
    }
    
    @RequestMapping(value = "/deletar", headers="Accept=*/*", produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody ResponseEntity<?> deletarSetor(Competencia competencia) {
        try {
            fachada.removerCompetencia(competencia);
            return new ResponseEntity<String>(HttpStatus.OK);
        } catch (CompetenciaInexistenteException ex) {
            return new ResponseEntity<CompetenciaInexistenteException>(ex, HttpStatus.BAD_REQUEST);
        }
    }
    
     //---------------------------------------------------------------------
    
    @RequestMapping("/view")
    public String formCadastrar() {
        return "cadastroCompetencia";
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
