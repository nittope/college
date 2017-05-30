/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.hmv.colegiado.ui;

import br.com.hmv.colegiado.entidade.DadoIndicador;
import br.com.hmv.colegiado.exception.CabecalhoInexistenteException;
import br.com.hmv.colegiado.exception.CompetenciaInexistenteException;
import br.com.hmv.colegiado.exception.DadoIndicadorExistenteException;
import br.com.hmv.colegiado.exception.DadoIndicadorInexistenteException;
import br.com.hmv.colegiado.exception.FuncaoInexistenteException;
import br.com.hmv.colegiado.exception.IndicadorInexistenteException;
import br.com.hmv.colegiado.exception.SetorInexistenteException;
import br.com.hmv.colegiado.exception.UsuarioInexistenteException;
import br.com.hmv.colegiado.listar.CabecalhoListar;
import br.com.hmv.colegiado.listar.CompetenciaListar;
import br.com.hmv.colegiado.listar.DadoIndicadorListar;
import br.com.hmv.colegiado.listar.IndicadorListar;
import br.com.hmv.colegiado.listar.SetorListar;
import br.com.hmv.colegiado.listar.UsuarioListar;
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
 * @author Marcus Vinícius <vinimarcus02@gmail.com>
 */
@Controller
@RequestMapping("/dadoIndicador")
public class ControllerDadoIndicador {
    static org.apache.log4j.Logger log = org.apache.log4j.Logger.getLogger(ControllerDadoIndicador.class);
    
    @Autowired
    private FachadaServico fachada;
    
    @RequestMapping(value = "/listar", headers="Accept=*/*", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody List<DadoIndicadorListar> listarTodos(){
         return fachada.listarTodosOsDadoIndicadores();
    }
    
    @RequestMapping(value = "/consultarPorId", headers="Accept=*/*", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody List<DadoIndicadorListar> consultarPorId(Long id){
        try{
            return fachada.ConsultarDadoIndicadorPorID(id);
        } catch (DadoIndicadorInexistenteException ex) {
            return null;
        }
    }
    
    @RequestMapping(value = "/cadastrar", headers="Accept=*/*", produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody ResponseEntity<?> adicionarDadoIndicador(DadoIndicador dadoIndicador, Long idSetor, Long idCompetencia, Long idUsuario, Long idCabecalho, Long idIndicador) {
        try {
            fachada.cadastrarDadoIndicador(dadoIndicador,idSetor,idCompetencia,idUsuario,idCabecalho,idIndicador);
            return new ResponseEntity<String>(HttpStatus.OK);
        }  catch (SetorInexistenteException ex) {
            return new ResponseEntity<SetorInexistenteException>(ex, HttpStatus.BAD_REQUEST);
        }  catch (CompetenciaInexistenteException ex1) {
            return new ResponseEntity<CompetenciaInexistenteException>(ex1, HttpStatus.BAD_REQUEST);
        }  catch (UsuarioInexistenteException ex2) {
            return new ResponseEntity<UsuarioInexistenteException>(ex2, HttpStatus.BAD_REQUEST);
        }  catch (CabecalhoInexistenteException ex3) {
            return new ResponseEntity<CabecalhoInexistenteException>(ex3, HttpStatus.BAD_REQUEST);
        }  catch (IndicadorInexistenteException ex4) {
            return new ResponseEntity<IndicadorInexistenteException>(ex4, HttpStatus.BAD_REQUEST);
        }catch (DadoIndicadorExistenteException ex5) {
            return new ResponseEntity<DadoIndicadorExistenteException>(ex5, HttpStatus.BAD_REQUEST);
        } catch (DadoIndicadorInexistenteException ex6) {
            return new ResponseEntity<DadoIndicadorInexistenteException>(ex6, HttpStatus.BAD_REQUEST);
        }
    }
    
    @RequestMapping(value = "/atualizar", headers="Accept=*/*", produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody ResponseEntity<?> atualizarDadoIndicador(DadoIndicador dadoIndicador, Long idSetor, Long idCompetencia, Long idUsuario, Long idCabecalho, Long idIndicador) {
        try {
            fachada.atualizarDadoIndicador(dadoIndicador, idSetor, idCompetencia, idUsuario, idCabecalho, idIndicador);
            return new ResponseEntity<String>(HttpStatus.OK);
        }  catch (SetorInexistenteException ex) {
            return new ResponseEntity<SetorInexistenteException>(ex, HttpStatus.BAD_REQUEST);
        }  catch (CompetenciaInexistenteException ex1) {
            return new ResponseEntity<CompetenciaInexistenteException>(ex1, HttpStatus.BAD_REQUEST);
        }  catch (UsuarioInexistenteException ex2) {
            return new ResponseEntity<UsuarioInexistenteException>(ex2, HttpStatus.BAD_REQUEST);
        }  catch (CabecalhoInexistenteException ex3) {
            return new ResponseEntity<CabecalhoInexistenteException>(ex3, HttpStatus.BAD_REQUEST);
        }  catch (IndicadorInexistenteException ex4) {
            return new ResponseEntity<IndicadorInexistenteException>(ex4, HttpStatus.BAD_REQUEST);
        } catch (DadoIndicadorInexistenteException ex6) {
            return new ResponseEntity<DadoIndicadorInexistenteException>(ex6, HttpStatus.BAD_REQUEST);
        }
        
    }
    
    @RequestMapping(value = "/consultarSetorPorId", headers="Accept=*/*", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody List<SetorListar> consultarSetorPorId(Long id){
        try{
            return fachada.ConsultarSetorPorId(id);
        } catch (SetorInexistenteException ex) {
            return null;
        }
    }
    
    @RequestMapping(value = "/consultarCompetenciaPorId", headers="Accept=*/*", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody List<CompetenciaListar> consultarCompetenciaPorId(Long id){
        try{
            return fachada.ConsultarCompetenciaPorID(id);
        } catch (CompetenciaInexistenteException ex) {
            return null;
        }
    }
    
    @RequestMapping(value = "/consultarUsuarioPorId", headers="Accept=*/*", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody List<UsuarioListar> consultarUsuarioPorId(Long id){
        try{
            return fachada.ConsultarUsuarioPorID(id);
        } catch (UsuarioInexistenteException ex) {
            return null;
        }
    }
    
    @RequestMapping(value = "/consultarCabecalhoPorId", headers="Accept=*/*", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody List<CabecalhoListar> consultarCabecalhoPorId(Long id){
        try{
            return fachada.ConsultarCabecalhoPorId(id);
        } catch (CabecalhoInexistenteException ex) {
            return null;
        }
    }
    
    @RequestMapping(value = "/consultarIndicadorPorId", headers="Accept=*/*", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody List<IndicadorListar> consultarIndicadorPorId(Long id){
        try{
            return fachada.ConsultarIndicadoresPorId(id);
        } catch (IndicadorInexistenteException ex) {
            return null;
        }
    }
    
    @RequestMapping(value = "/listarIndicadoresAtivos", headers="Accept=*/*", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody List<IndicadorListar> listarIndicadoresAtivos(){
         return fachada.listarTodosIndicadores();
    }
    
    
    @RequestMapping(value = "/listarCabecalhosAtivos", headers="Accept=*/*", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody List<CabecalhoListar> listarCabecalhosAtivos(){
         return fachada.listarTodosCabecalhos();
    }
    
     @RequestMapping(value = "/listarCompetenciasAtivas", headers="Accept=*/*", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody List<CompetenciaListar> listarCompetenciasAtivas(){
         return fachada.listarTodasAsCompetencias();
    }
    
    @RequestMapping(value = "/listarUsuariosAtivos", headers="Accept=*/*", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody List<UsuarioListar> listarUsuariosAtivos(){
         return fachada.listarTodosUsuarios();
    }
    
    @RequestMapping(value = "/listarSetoresAtivos", headers="Accept=*/*", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody List<SetorListar> listarSetoresAtivos(){
         return fachada.listarTodosSetores();
    }
    
    @RequestMapping("/view")
    public String formCadastrar() {
        return "cadastroInformacao";
    }
    
        
        
    
    
    
}
