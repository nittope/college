/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.hmv.colegiado.negocio;

import br.com.hmv.colegiado.exception.SetorExistenteException;
import br.com.hmv.colegiado.exception.SetorInexistenteException;
import br.com.hmv.colegiado.entidade.Setor;
import br.com.hmv.colegiado.listar.SetorListar;
import java.io.Serializable;
import java.util.List;

/**
 *
 * @author vinim
 */
public interface ServicoSetor extends Serializable{
    
public void cadastrar(Setor setor) throws SetorExistenteException, SetorInexistenteException;
public void atualizar(Setor setor) throws SetorInexistenteException;
public void remover(Setor setor) throws SetorInexistenteException;
public List<SetorListar> listarTodos();
public List<SetorListar> ConsultarPorNome(String nome) throws SetorInexistenteException;
public List<SetorListar> ConsultarPorID(Long id) throws SetorInexistenteException;
    
}
