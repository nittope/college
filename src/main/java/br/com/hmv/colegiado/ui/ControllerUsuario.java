/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.hmv.colegiado.ui;

import br.com.hmv.colegiado.entidade.Funcao;
import br.com.hmv.colegiado.entidade.Usuario;
import br.com.hmv.colegiado.exception.FuncaoInexistenteException;
import br.com.hmv.colegiado.listar.FuncaoListar;
import br.com.hmv.colegiado.listar.UsuarioListar;
import br.com.hmv.colegiado.negocio.FachadaServico;
import br.com.hmv.colegiado.exception.UsuarioExistenteException;
import br.com.hmv.colegiado.exception.UsuarioInexistenteException;
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
@RequestMapping("/usuario")
public class ControllerUsuario {
    static org.apache.log4j.Logger log = org.apache.log4j.Logger.getLogger(ControllerUsuario.class);
    @Autowired
    private FachadaServico fachada;
    
    @RequestMapping(value = "/listar", headers="Accept=*/*", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody List<UsuarioListar> listarTodos(){
         return fachada.listarTodosUsuarios();
    }
    
    @RequestMapping(value = "/consultar")
    public @ResponseBody List<UsuarioListar> consultar(String nome){
        try{
            return fachada.ConsultarUsuarioPorNome(nome);
        } catch (UsuarioInexistenteException ex) {
            return null;
        }
    }
    
    @RequestMapping(value = "/consultarPorId", headers="Accept=*/*", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody List<UsuarioListar> consultarPorId(Long id){
        try{
            return fachada.ConsultarUsuarioPorID(id);
        } catch (UsuarioInexistenteException ex) {
            return null;
        }
    }
    
    @RequestMapping(value = "/cadastrar", headers="Accept=*/*", produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody ResponseEntity<?> adicionarUsuario(Usuario usuario,Long idFuncao) {
        try {
            fachada.cadastrarUsuario(usuario,idFuncao);
            return new ResponseEntity<String>(HttpStatus.OK);
        }  catch (FuncaoInexistenteException ex) {
            return new ResponseEntity<FuncaoInexistenteException>(ex, HttpStatus.BAD_REQUEST);
        }catch (UsuarioExistenteException ex1) {
            return new ResponseEntity<UsuarioExistenteException>(ex1, HttpStatus.BAD_REQUEST);
        } catch (UsuarioInexistenteException ex2) {
            return new ResponseEntity<UsuarioInexistenteException>(ex2, HttpStatus.BAD_REQUEST);
        }
    }
    
    @RequestMapping(value = "/atualizar", headers="Accept=*/*", produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody ResponseEntity<?> atualizarSetor(Usuario usuario,Long idFuncao) {
        try {
            fachada.atualizarUsuario(usuario,idFuncao);
            return new ResponseEntity<String>(HttpStatus.OK);
        } catch (UsuarioInexistenteException ex) {
            return new ResponseEntity<UsuarioInexistenteException>(ex, HttpStatus.BAD_REQUEST);
        }catch (FuncaoInexistenteException ex1) {
            return new ResponseEntity<FuncaoInexistenteException>(ex1, HttpStatus.BAD_REQUEST);
        }
        
    }
    
    @RequestMapping(value = "/deletar", headers="Accept=*/*", produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody ResponseEntity<?> deletarSetor(Usuario usuario) {
        try {
            fachada.removerUsuario(usuario);
            return new ResponseEntity<String>(HttpStatus.OK);
        } catch (UsuarioInexistenteException ex) {
            return new ResponseEntity<UsuarioInexistenteException>(ex, HttpStatus.BAD_REQUEST);
        }
    }
    
    @RequestMapping(value = "/listarFuncoesAtivas", headers="Accept=*/*", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody List<FuncaoListar> listarFuncoesAtivas(){
         return fachada.listarTodasFuncoesAtivas();
    }
    
    @RequestMapping(value = "/consultarFuncaoPorId", headers="Accept=*/*", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody List<FuncaoListar> consultarFuncaoPorId(Long id){
        try{
            return fachada.ConsultarPorId(id);
        } catch (FuncaoInexistenteException ex) {
            return null;
        }
    }
    
    @RequestMapping(value = "/consultarFuncaoPorIdRetornandoNome", headers="Accept=*/*", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody List<FuncaoListar> consultarFuncaoPorIdRetornandoNome(Long id){
        try{
            return fachada.ConsultarPorIdRetornandoNome(id);
        } catch (FuncaoInexistenteException ex) {
            return null;
        }
    }
     //---------------------------------------------------------------------
    
    @RequestMapping("/view")
    public String formCadastrar() {
        return "cadastroUsuario";
    }
    
    
    @RequestMapping("/usuarioSetor")
    public String formCadastrarUsuarioSetor() {
        return "cadastroUsuarioSetor";
    }
    
    
}
