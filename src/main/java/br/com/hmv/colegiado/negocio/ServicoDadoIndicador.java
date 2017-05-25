/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.hmv.colegiado.negocio;

import br.com.hmv.colegiado.exception.DadoIndicadorInexistenteException;
import br.com.hmv.colegiado.exception.DadoIndicadorExistenteException;
import br.com.hmv.colegiado.entidade.DadoIndicador;
import br.com.hmv.colegiado.exception.CabecalhoInexistenteException;
import br.com.hmv.colegiado.exception.CompetenciaInexistenteException;
import br.com.hmv.colegiado.exception.IndicadorInexistenteException;
import br.com.hmv.colegiado.exception.SetorExistenteException;
import br.com.hmv.colegiado.exception.SetorInexistenteException;
import br.com.hmv.colegiado.exception.UsuarioInexistenteException;
import br.com.hmv.colegiado.listar.DadoIndicadorListar;
import java.io.Serializable;
import java.util.List;

/**
 *
 * @author Marcus Vinícius <vinimarcus02@gmail.com>
 */
public interface ServicoDadoIndicador extends Serializable {
    
    public void cadastrar(DadoIndicador dadoIndicador, Long idSetor, Long idCompetencia, Long idUsuario, Long idCabecalho, Long idIndicador) throws DadoIndicadorExistenteException, DadoIndicadorInexistenteException, SetorInexistenteException, CompetenciaInexistenteException, UsuarioInexistenteException, CabecalhoInexistenteException, IndicadorInexistenteException;
    public void atualizar(DadoIndicador dadoIndicador, Long idSetor, Long idCompetencia, Long idUsuario, Long idCabecalho, Long idIndicador) throws DadoIndicadorInexistenteException, SetorInexistenteException, CompetenciaInexistenteException, UsuarioInexistenteException, CabecalhoInexistenteException, IndicadorInexistenteException;
    public void remover(DadoIndicador dadoIndicador) throws DadoIndicadorInexistenteException;
    public List<DadoIndicadorListar> listarTodos();
    public List<DadoIndicadorListar> ConsultarPorNome(String nome) throws DadoIndicadorInexistenteException;
    public List<DadoIndicadorListar> ConsultarPorID(Long id) throws DadoIndicadorInexistenteException;
}
