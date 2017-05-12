/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.hmv.colegiado.negocio;

import br.com.hmv.colegiado.exception.CabecalhoInexistenteException;
import br.com.hmv.colegiado.exception.CabecalhoExistenteException;
import br.com.hmv.colegiado.entidade.Cabecalho;
import br.com.hmv.colegiado.listar.CabecalhoListar;
import java.io.Serializable;
import java.util.List;

/**
 *
 * @author vinim
 */
public interface ServicoCabecalho extends Serializable {
    
    public void cadastrar(Cabecalho cabecalho) throws CabecalhoExistenteException, CabecalhoInexistenteException;
    public void atualizar(Cabecalho cabecalho) throws CabecalhoInexistenteException;
    public void remover(Cabecalho cabecalho) throws CabecalhoInexistenteException;
    public List<CabecalhoListar> listarTodos();
    public List<CabecalhoListar> ConsultarPorNome(String nome) throws CabecalhoInexistenteException;
    public List<CabecalhoListar> ConsultarPorID(Long id) throws CabecalhoInexistenteException;
    
}
