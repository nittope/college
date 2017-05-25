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
import br.com.hmv.colegiado.entidade.DadoIndicador;
import br.com.hmv.colegiado.entidade.Funcao;
import br.com.hmv.colegiado.entidade.Indicador;
import br.com.hmv.colegiado.entidade.Setor;
import br.com.hmv.colegiado.entidade.Usuario;
import br.com.hmv.colegiado.exception.CabecalhoExistenteException;
import br.com.hmv.colegiado.exception.CabecalhoInexistenteException;
import br.com.hmv.colegiado.exception.CompetenciaExistenteException;
import br.com.hmv.colegiado.exception.CompetenciaInexistenteException;
import br.com.hmv.colegiado.exception.DadoIndicadorExistenteException;
import br.com.hmv.colegiado.exception.DadoIndicadorInexistenteException;
import br.com.hmv.colegiado.exception.FuncaoExistenteException;
import br.com.hmv.colegiado.exception.FuncaoInexistenteException;
import br.com.hmv.colegiado.exception.IndicadorExistenteException;
import br.com.hmv.colegiado.exception.IndicadorInexistenteException;
import br.com.hmv.colegiado.exception.SetorExistenteException;
import br.com.hmv.colegiado.exception.SetorInexistenteException;
import br.com.hmv.colegiado.listar.CabecalhoListar;
import br.com.hmv.colegiado.listar.CompetenciaListar;
import br.com.hmv.colegiado.listar.DadoIndicadorListar;
import br.com.hmv.colegiado.listar.FuncaoListar;
import br.com.hmv.colegiado.listar.IndicadorListar;
import br.com.hmv.colegiado.listar.SetorListar;
import br.com.hmv.colegiado.listar.UsuarioListar;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Marcus Vinícius <vinimarcus02@gmail.com>
 */
@Service
public class FachadaServicoImpl implements FachadaServico {
    
    @Autowired
    private ServicoFuncao servicoFuncao;
    
    @Autowired
    private ServicoSetor servicoSetor;
    
    @Autowired
    private ServicoCabecalho servicoCabecalho;
    
    @Autowired
    private ServicoIndicador servicoIndicador;
    
    @Autowired
    private ServicoUsuario servicoUsuario;

    @Autowired
    private ServicoCompetencia servicoCompetencia;
    
    @Autowired
    private ServicoDadoIndicador servicoDadoIndicador;
    
    //Função
    @Override
    public void cadastrar(Funcao funcao) throws FuncaoExistenteException, FuncaoInexistenteException {
        servicoFuncao.cadastrar(funcao);
    }

    @Override
    public void atualizar(Funcao funcao) throws FuncaoInexistenteException {
        servicoFuncao.atualizar(funcao);
    }

    @Override
    public void remover(String nome) throws FuncaoInexistenteException {
        servicoFuncao.remover(nome);
    }

    @Override
    public List<FuncaoListar> listarTodasFuncoes() {
        return servicoFuncao.listarTodos();
    }

    @Override
    public List<FuncaoListar> ConsultarPorNome(String nome) throws FuncaoInexistenteException {
        return servicoFuncao.ConsultarPorNome(nome);
    }

    @Override
    public List<FuncaoListar> ConsultarPorId(Long id) throws FuncaoInexistenteException {
        return servicoFuncao.ConsultarPorID(id);
    }
    
     @Override
    public List<FuncaoListar> listarTodasFuncoesAtivas() {
        return servicoFuncao.listarTodasFuncoesAtivas();  
    }

    //Setor
    @Override
    public void cadastrarSetor(Setor setor) throws SetorExistenteException, SetorInexistenteException {
       servicoSetor.cadastrar(setor); 
    }

    @Override
    public void atualizarSetor(Setor setor) throws SetorInexistenteException {
        servicoSetor.atualizar(setor);
    }

    @Override
    public void removerSetor(Setor setor) throws SetorInexistenteException {
        servicoSetor.remover(setor);
    }

    @Override
    public List<SetorListar> listarTodosSetores() {
        return servicoSetor.listarTodos();
    }

    @Override
    public List<SetorListar> ConsultarSetorPorNome(String nome) throws SetorInexistenteException {
        return servicoSetor.ConsultarPorNome(nome);
    }

    @Override
    public List<SetorListar> ConsultarSetorPorId(Long id) throws SetorInexistenteException {
        return servicoSetor.ConsultarPorID(id);
    }

    //Cabeçalho
    @Override
    public void cadastrarCabecalho(Cabecalho cabecalho) throws CabecalhoExistenteException, CabecalhoInexistenteException {
        servicoCabecalho.cadastrar(cabecalho);
    }

    @Override
    public void atualizarCabecalho(Cabecalho cabecalho) throws CabecalhoInexistenteException {
        servicoCabecalho.atualizar(cabecalho);
    }

    @Override
    public void removerCabecalho(Cabecalho cabecalho) throws CabecalhoInexistenteException {
        servicoCabecalho.remover(cabecalho);
    }

    @Override
    public List<CabecalhoListar> listarTodosCabecalhos() {
        return servicoCabecalho.listarTodos();
    }

    @Override
    public List<CabecalhoListar> ConsultarCabecalhoPorNome(String nome) throws CabecalhoInexistenteException {
        return servicoCabecalho.ConsultarPorNome(nome);
    }

    @Override
    public List<CabecalhoListar> ConsultarCabecalhoPorId(Long id) throws CabecalhoInexistenteException {
        return servicoCabecalho.ConsultarPorID(id);
    }

    @Override
    public void cadastrarIndicador(Indicador indicador) throws IndicadorExistenteException, IndicadorInexistenteException {
        servicoIndicador.cadastrar(indicador);
    }

    @Override
    public void atualizarIndicador(Indicador indicador) throws IndicadorInexistenteException {
        servicoIndicador.atualizar(indicador);
    }

    @Override
    public void removerIndicador(Indicador indicador) throws IndicadorInexistenteException {
        servicoIndicador.remover(indicador);
    }

    @Override
    public List<IndicadorListar> listarTodosIndicadores() {
        return servicoIndicador.listarTodos();
    }

    @Override
    public List<IndicadorListar> ConsultarIndicadoresPorNome(String nome) throws IndicadorInexistenteException {
        return servicoIndicador.ConsultarPorNome(nome);
    }

    @Override
    public List<IndicadorListar> ConsultarIndicadoresPorId(Long id) throws IndicadorInexistenteException {
        return servicoIndicador.ConsultarPorID(id);
    }

    @Override
    public void cadastrarUsuario(Usuario usuario, Long id) throws UsuarioExistenteException, UsuarioInexistenteException, FuncaoInexistenteException {
        servicoUsuario.cadastrar(usuario, id);
    }

    @Override
    public void atualizarUsuario(Usuario usuario, Long id) throws UsuarioInexistenteException, FuncaoInexistenteException {
        servicoUsuario.atualizar(usuario,id);
    }

    @Override
    public void removerUsuario(Usuario usuario) throws UsuarioInexistenteException {
        servicoUsuario.remover(usuario);
    }

    @Override
    public List<UsuarioListar> listarTodosUsuarios() {
        return servicoUsuario.listarTodos();
    }

    @Override
    public List<UsuarioListar> ConsultarUsuarioPorNome(String nome) throws UsuarioInexistenteException {
        return servicoUsuario.ConsultarPorNome(nome);
    }

    @Override
    public List<UsuarioListar> ConsultarUsuarioPorID(Long id) throws UsuarioInexistenteException {
        return servicoUsuario.ConsultarPorID(id);
    }

    @Override
    public List<FuncaoListar> ConsultarPorIdRetornandoNome(Long id) throws FuncaoInexistenteException {
        return servicoFuncao.ConsultarPorIDRetornandoSomenteNome(id);
    }

    @Override
    public Funcao ConsultarPorIdU(Long id) throws FuncaoInexistenteException {
        return servicoFuncao.ConsultarPorIdU(id);
    }

    @Override
    public void cadastrarCompetencia(Competencia competencia) throws CompetenciaExistenteException, CompetenciaInexistenteException {
        servicoCompetencia.cadastrar(competencia);
    }

    @Override
    public void atualizarCompetencia(Competencia competencia) throws CompetenciaInexistenteException {
        servicoCompetencia.atualizar(competencia);
    }

    @Override
    public void removerCompetencia(Competencia competencia) throws CompetenciaInexistenteException {
        
    }

    @Override
    public List<CompetenciaListar> listarTodasAsCompetencias() {
        return servicoCompetencia.listarTodos();
    }

    @Override
    public List<CompetenciaListar> ConsultarCompetenciaPorNome(String nome) throws CompetenciaInexistenteException {
        return servicoCompetencia.ConsultarPorNome(nome);
    }

    @Override
    public List<CompetenciaListar> ConsultarCompetenciaPorID(Long id) throws CompetenciaInexistenteException {
        return servicoCompetencia.ConsultarPorID(id);
    }

    @Override
    public void cadastrarDadoIndicador(DadoIndicador dadoIndicador, Long idSetor, Long idCompetencia, Long idUsuario, Long idCabecalho, Long idIndicador) throws DadoIndicadorExistenteException, DadoIndicadorInexistenteException, SetorInexistenteException, CompetenciaInexistenteException, UsuarioInexistenteException, CabecalhoInexistenteException, IndicadorInexistenteException {
        servicoDadoIndicador.cadastrar(dadoIndicador, idSetor, idCompetencia, idUsuario, idCabecalho, idIndicador);
    }

    @Override
    public void atualizarDadoIndicador(DadoIndicador dadoIndicador, Long idSetor, Long idCompetencia, Long idUsuario, Long idCabecalho, Long idIndicador) throws DadoIndicadorInexistenteException, SetorInexistenteException, CompetenciaInexistenteException, UsuarioInexistenteException, CabecalhoInexistenteException, IndicadorInexistenteException {
        servicoDadoIndicador.atualizar(dadoIndicador, idSetor, idCompetencia, idUsuario, idCabecalho, idIndicador);
    }

    @Override
    public void removerDadoIndicador(DadoIndicador dadoIndicador) throws DadoIndicadorInexistenteException {
        
    }

    @Override
    public List<DadoIndicadorListar> listarTodosOsDadoIndicadores() {
        return servicoDadoIndicador.listarTodos();
    }

    @Override
    public List<DadoIndicadorListar> ConsultarDadoIndicadorPorNome(String nome) throws DadoIndicadorInexistenteException {
        return servicoDadoIndicador.ConsultarPorNome(nome);
    }

    @Override
    public List<DadoIndicadorListar> ConsultarDadoIndicadorPorID(Long id) throws DadoIndicadorInexistenteException {
        return servicoDadoIndicador.ConsultarPorID(id);
    }

   
    
}
