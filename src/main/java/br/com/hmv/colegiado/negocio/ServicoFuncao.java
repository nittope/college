/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.hmv.colegiado.negocio;

import br.com.hmv.colegiado.exception.FuncaoInexistenteException;
import br.com.hmv.colegiado.exception.FuncaoExistenteException;
import br.com.hmv.colegiado.entidade.Funcao;
import br.com.hmv.colegiado.listar.FuncaoListar;
import java.io.Serializable;
import java.util.List;

/**
 *
 * @author Marcus Vinícius <vinimarcus02@gmail.com>
 */
public interface ServicoFuncao extends Serializable {
    
public void cadastrar(Funcao funcao) throws FuncaoExistenteException, FuncaoInexistenteException;
public void atualizar(Funcao funcao) throws FuncaoInexistenteException;
public void remover(String nome) throws FuncaoInexistenteException;
public List<FuncaoListar> listarTodos();
public List<FuncaoListar> listarTodasFuncoesAtivas();
public List<FuncaoListar> ConsultarPorNome(String nome) throws FuncaoInexistenteException;
public List<FuncaoListar> ConsultarPorID(Long id) throws FuncaoInexistenteException;
public Funcao ConsultarPorIdU(Long id) throws FuncaoInexistenteException;
public List<FuncaoListar> ConsultarPorIDRetornandoSomenteNome(Long id) throws FuncaoInexistenteException;    
}
