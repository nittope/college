/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.hmv.colegiado.negocio;

import br.com.hmv.colegiado.exception.IndicadorInexistenteException;
import br.com.hmv.colegiado.exception.IndicadorExistenteException;
import br.com.hmv.colegiado.entidade.Indicador;
import br.com.hmv.colegiado.listar.IndicadorListar;
import java.io.Serializable;
import java.util.List;

/**
 *
 * @author vinim
 */
public interface ServicoIndicador extends Serializable{
    
    public void cadastrar(Indicador indicador) throws IndicadorExistenteException, IndicadorInexistenteException;
    public void atualizar(Indicador indicador) throws IndicadorInexistenteException;
    public void remover(Indicador indicador) throws IndicadorInexistenteException;
    public List<IndicadorListar> listarTodos();
    public List<IndicadorListar> ConsultarPorNome(String nome) throws IndicadorInexistenteException;
    public List<IndicadorListar> ConsultarPorID(Long id) throws IndicadorInexistenteException;
    
}
