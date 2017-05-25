/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.hmv.colegiado.negocio;

import br.com.hmv.colegiado.exception.CompetenciaExistenteException;
import br.com.hmv.colegiado.exception.CompetenciaInexistenteException;
import br.com.hmv.colegiado.entidade.Competencia;
import br.com.hmv.colegiado.listar.CompetenciaListar;
import java.io.Serializable;
import java.util.List;

/**
 *
 * @author vinim
 */
public interface ServicoCompetencia extends Serializable{
    
    public void cadastrar(Competencia competencia) throws CompetenciaExistenteException, CompetenciaInexistenteException;
    public void atualizar(Competencia competencia) throws CompetenciaInexistenteException;
    public void remover(Competencia competencia) throws CompetenciaInexistenteException;
    public List<CompetenciaListar> listarTodos();
    public List<CompetenciaListar> ConsultarPorNome(String nome) throws CompetenciaInexistenteException;
    public List<CompetenciaListar> ConsultarPorID(Long id) throws CompetenciaInexistenteException;
    
    public Competencia ConsultarPorIdU(Long id) throws CompetenciaInexistenteException;
    
}
