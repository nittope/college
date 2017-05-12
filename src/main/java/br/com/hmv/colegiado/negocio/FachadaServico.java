
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.hmv.colegiado.negocio;

import br.com.hmv.colegiado.exception.UsuarioExistenteException;
import br.com.hmv.colegiado.exception.UsuarioInexistenteException;
import br.com.hmv.colegiado.entidade.Cabecalho;
import br.com.hmv.colegiado.entidade.Competencia;
import br.com.hmv.colegiado.entidade.Funcao;
import br.com.hmv.colegiado.entidade.Indicador;
import br.com.hmv.colegiado.entidade.Setor;
import br.com.hmv.colegiado.entidade.Usuario;
import br.com.hmv.colegiado.exception.CabecalhoExistenteException;
import br.com.hmv.colegiado.exception.CabecalhoInexistenteException;
import br.com.hmv.colegiado.exception.CompetenciaExistenteException;
import br.com.hmv.colegiado.exception.CompetenciaInexistenteException;
import br.com.hmv.colegiado.exception.FuncaoExistenteException;
import br.com.hmv.colegiado.exception.FuncaoInexistenteException;
import br.com.hmv.colegiado.exception.IndicadorExistenteException;
import br.com.hmv.colegiado.exception.IndicadorInexistenteException;
import br.com.hmv.colegiado.exception.SetorExistenteException;
import br.com.hmv.colegiado.exception.SetorInexistenteException;
import br.com.hmv.colegiado.listar.CabecalhoListar;
import br.com.hmv.colegiado.listar.CompetenciaListar;
import br.com.hmv.colegiado.listar.FuncaoListar;
import br.com.hmv.colegiado.listar.IndicadorListar;
import br.com.hmv.colegiado.listar.SetorListar;
import br.com.hmv.colegiado.listar.UsuarioListar;
import java.io.Serializable;
import java.util.List;

/**
 *
 * @author Marcus Vinícius <vinimarcus02@gmail.com>
 */
public interface FachadaServico extends Serializable{
    
    //Função
    public void cadastrar(Funcao funcao) throws FuncaoExistenteException, FuncaoInexistenteException;
    public void atualizar(Funcao funcao) throws FuncaoInexistenteException;
    public void remover(String nome) throws FuncaoInexistenteException;
    public List<FuncaoListar> listarTodasFuncoes();
    public List<FuncaoListar> listarTodasFuncoesAtivas();
    public List<FuncaoListar> ConsultarPorNome(String nome) throws FuncaoInexistenteException;
    public List<FuncaoListar> ConsultarPorId(Long id) throws FuncaoInexistenteException;
    public Funcao ConsultarPorIdU(Long id) throws FuncaoInexistenteException;
    public List<FuncaoListar> ConsultarPorIdRetornandoNome(Long id) throws FuncaoInexistenteException;
    
    //Setor
    public void cadastrarSetor(Setor setor) throws SetorExistenteException, SetorInexistenteException;
    public void atualizarSetor(Setor setor) throws SetorInexistenteException;
    public void removerSetor(Setor setor) throws SetorInexistenteException;
    public List<SetorListar> listarTodosSetores();
    public List<SetorListar> ConsultarSetorPorNome(String nome) throws SetorInexistenteException;
    public List<SetorListar> ConsultarSetorPorId(Long id) throws SetorInexistenteException;
    
    //Cabecalho
    public void cadastrarCabecalho(Cabecalho cabecalho) throws CabecalhoExistenteException, CabecalhoInexistenteException;
    public void atualizarCabecalho(Cabecalho cabecalho) throws CabecalhoInexistenteException;
    public void removerCabecalho(Cabecalho cabecalho) throws CabecalhoInexistenteException;
    public List<CabecalhoListar> listarTodosCabecalhos();
    public List<CabecalhoListar> ConsultarCabecalhoPorNome(String nome) throws CabecalhoInexistenteException;
    public List<CabecalhoListar> ConsultarCabecalhoPorId(Long id) throws CabecalhoInexistenteException;
    
     //Indicador
    public void cadastrarIndicador(Indicador indicador) throws IndicadorExistenteException, IndicadorInexistenteException;
    public void atualizarIndicador(Indicador indicador) throws IndicadorInexistenteException;
    public void removerIndicador(Indicador indicador) throws IndicadorInexistenteException;
    public List<IndicadorListar> listarTodosIndicadores();
    public List<IndicadorListar> ConsultarIndicadoresPorNome(String nome) throws IndicadorInexistenteException;
    public List<IndicadorListar> ConsultarIndicadoresPorId(Long id) throws IndicadorInexistenteException;
    
    //Usuario
    public void cadastrarUsuario(Usuario usuario, Long id) throws UsuarioExistenteException, UsuarioInexistenteException, FuncaoInexistenteException;
    public void atualizarUsuario(Usuario usuario, Long id) throws UsuarioInexistenteException, FuncaoInexistenteException;
    public void removerUsuario(Usuario usuario) throws UsuarioInexistenteException;
    public List<UsuarioListar> listarTodosUsuarios();
    public List<UsuarioListar> ConsultarUsuarioPorNome(String nome) throws UsuarioInexistenteException;
    public List<UsuarioListar> ConsultarUsuarioPorID(Long id) throws UsuarioInexistenteException;
    
    //Competencia
    public void cadastrarCompetencia(Competencia competencia) throws CompetenciaExistenteException, CompetenciaInexistenteException;
    public void atualizarCompetencia(Competencia competencia) throws CompetenciaInexistenteException;
    public void removerCompetencia(Competencia competencia) throws CompetenciaInexistenteException;
    public List<CompetenciaListar> listarTodasAsCompetencias();
    public List<CompetenciaListar> ConsultarCompetenciaPorNome(String nome) throws CompetenciaInexistenteException;
    public List<CompetenciaListar> ConsultarCompetenciaPorID(Long id) throws CompetenciaInexistenteException;
}
