/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.hmv.colegiado.negocio;

import br.com.hmv.colegiado.exception.UsuarioExistenteException;
import br.com.hmv.colegiado.exception.UsuarioInexistenteException;
import br.com.hmv.colegiado.entidade.Funcao;
import br.com.hmv.colegiado.entidade.Usuario;
import br.com.hmv.colegiado.exception.FuncaoInexistenteException;
import br.com.hmv.colegiado.listar.UsuarioListar;
import java.io.Serializable;
import java.util.List;

/**
 *
 * @author vinim
 */
public interface ServicoUsuario extends Serializable {
    public void cadastrar(Usuario usuario, Long id) throws UsuarioExistenteException, UsuarioInexistenteException, FuncaoInexistenteException;
    public void atualizar(Usuario usuario, Long id) throws UsuarioInexistenteException, FuncaoInexistenteException;
    public void remover(Usuario usuario) throws UsuarioInexistenteException;
    public List<UsuarioListar> listarTodos();
    public List<UsuarioListar> ConsultarPorNome(String nome) throws UsuarioInexistenteException;
    public List<UsuarioListar> ConsultarPorID(Long id) throws UsuarioInexistenteException;
}
