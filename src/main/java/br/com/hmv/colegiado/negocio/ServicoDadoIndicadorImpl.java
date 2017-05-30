/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.hmv.colegiado.negocio;

import br.com.hmv.colegiado.entidade.Cabecalho;
import br.com.hmv.colegiado.entidade.Competencia;
import br.com.hmv.colegiado.entidade.DadoIndicador;
import br.com.hmv.colegiado.entidade.Indicador;
import br.com.hmv.colegiado.entidade.Setor;
import br.com.hmv.colegiado.entidade.Usuario;
import br.com.hmv.colegiado.exception.CabecalhoInexistenteException;
import br.com.hmv.colegiado.exception.CompetenciaInexistenteException;
import br.com.hmv.colegiado.exception.DadoIndicadorExistenteException;
import br.com.hmv.colegiado.exception.DadoIndicadorInexistenteException;
import br.com.hmv.colegiado.exception.IndicadorInexistenteException;
import br.com.hmv.colegiado.exception.SetorInexistenteException;
import br.com.hmv.colegiado.exception.UsuarioInexistenteException;
import br.com.hmv.colegiado.listar.DadoIndicadorListar;
import br.com.hmv.colegiado.persistencia.RepositorioDadoIndicador;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Marcus Vinícius <vinimarcus02@gmail.com>
 */
@Service
public class ServicoDadoIndicadorImpl implements ServicoDadoIndicador{

    @Autowired
    private RepositorioDadoIndicador repositorioDadoIndicador;
    
    @Autowired
    private ServicoSetor servicoSetor;
    
    @Autowired
    private ServicoCompetencia servicoCompetencia;
    
    @Autowired
    private ServicoUsuario servicoUsuario;
    
    @Autowired
    private ServicoCabecalho servicoCabecalho;
    
    @Autowired
    private ServicoIndicador servicoIndicador;
    
    
    @Override
    public void cadastrar(DadoIndicador dadoIndicador, Long idSetor, Long idCompetencia, Long idUsuario, Long idCabecalho, Long idIndicador) throws DadoIndicadorExistenteException, DadoIndicadorInexistenteException, SetorInexistenteException, CompetenciaInexistenteException, UsuarioInexistenteException, CabecalhoInexistenteException, IndicadorInexistenteException {
        Setor setor = servicoSetor.ConsultarPorIdU(idSetor);
        Competencia competencia = servicoCompetencia.ConsultarPorIdU(idCompetencia);
        Usuario usuario = servicoUsuario.ConsultarPorIdU(idUsuario);
        Cabecalho cabecalho = servicoCabecalho.ConsultarPorIdU(idCabecalho);
        Indicador indicador = servicoIndicador.ConsultarPorIdU(idIndicador);
        
        dadoIndicador.setAtivo(dadoIndicador.isAtivo());
        dadoIndicador.setInformacao(dadoIndicador.getInformacao());      
        dadoIndicador.setSetor(setor);
        dadoIndicador.setCompetencia(competencia);
        dadoIndicador.setUsuario(usuario);
        dadoIndicador.setCabecalho(cabecalho);
        dadoIndicador.setIndicador(indicador);
        repositorioDadoIndicador.save(dadoIndicador);  
        
    }

    @Override
    public void atualizar(DadoIndicador dadoIndicador, Long idSetor, Long idCompetencia, Long idUsuario, Long idCabecalho, Long idIndicador) throws DadoIndicadorInexistenteException, SetorInexistenteException, CompetenciaInexistenteException, UsuarioInexistenteException, CabecalhoInexistenteException, IndicadorInexistenteException {
    
        Setor setor = servicoSetor.ConsultarPorIdU(idSetor);
        Competencia competencia = servicoCompetencia.ConsultarPorIdU(idCompetencia);
        Usuario usuario = servicoUsuario.ConsultarPorIdU(idUsuario);
        Cabecalho cabecalho = servicoCabecalho.ConsultarPorIdU(idCabecalho);
        Indicador indicador = servicoIndicador.ConsultarPorIdU(idIndicador);
        
        DadoIndicador dadoIndicadorAtualizar = repositorioDadoIndicador.findById(dadoIndicador.getId());
        if(dadoIndicadorAtualizar==null)
            throw new DadoIndicadorInexistenteException();
        dadoIndicadorAtualizar.setAtivo(dadoIndicador.isAtivo());
        dadoIndicadorAtualizar.setInformacao(dadoIndicador.getInformacao());        
        dadoIndicadorAtualizar.setSetor(setor);
        dadoIndicadorAtualizar.setCompetencia(competencia);
        dadoIndicadorAtualizar.setUsuario(usuario);
        dadoIndicadorAtualizar.setCabecalho(cabecalho);
        dadoIndicadorAtualizar.setIndicador(indicador);
        repositorioDadoIndicador.save(dadoIndicadorAtualizar);
    }

    @Override
    public void remover(DadoIndicador dadoIndicador) throws DadoIndicadorInexistenteException {
        
    }

    @Override
    public List<DadoIndicadorListar> listarTodos() {
        List<DadoIndicadorListar> retorno = new ArrayList<DadoIndicadorListar>();
        List<DadoIndicador> pesquisa = (List<DadoIndicador>) repositorioDadoIndicador.findAll();
        
        for(int i = 0;i < pesquisa.size(); i++){
            
                DadoIndicadorListar dl = new DadoIndicadorListar();
                dl.setId(pesquisa.get(i).getId());
                dl.setSetor(pesquisa.get(i).getSetor().getId());
                dl.setSetorNome(pesquisa.get(i).getSetor().getNome());
                dl.setCompetencia(pesquisa.get(i).getCompetencia().getId());
                dl.setCompetenciaNome(pesquisa.get(i).getCompetencia().getNome());
                dl.setUsuario(pesquisa.get(i).getUsuario().getId());
                dl.setUsuarioNome(pesquisa.get(i).getUsuario().getNome());
                dl.setCabecalho(pesquisa.get(i).getCabecalho().getId());
                dl.setCabecalhoNome(pesquisa.get(i).getCabecalho().getNome());
                dl.setIndicador(pesquisa.get(i).getIndicador().getId());
                dl.setIndicadorNome(pesquisa.get(i).getIndicador().getNome());                              
                dl.setInformacao(pesquisa.get(i).getInformacao());
                dl.setAtivo(pesquisa.get(i).isAtivo());  
                
                retorno.add(dl);
            
            
        }
        return retorno;  
    }

    @Override
    public List<DadoIndicadorListar> ConsultarPorNome(String nome) throws DadoIndicadorInexistenteException {
        List<DadoIndicadorListar> retorno = new ArrayList<DadoIndicadorListar>();
        //List<DadoIndicador> pesquisa = (List<DadoIndicador>) repositorioDadoIndicador.findByNome(nome);
        return retorno;
    }

    @Override
    public List<DadoIndicadorListar> ConsultarPorID(Long id) throws DadoIndicadorInexistenteException {
        List<DadoIndicadorListar> retorno = new ArrayList<DadoIndicadorListar>();
        DadoIndicador pesquisa = repositorioDadoIndicador.findById(id);
        if(pesquisa==null)
            throw new DadoIndicadorInexistenteException();
        DadoIndicadorListar dl = new DadoIndicadorListar();
        dl.setId(pesquisa.getId());
        dl.setSetor(pesquisa.getSetor().getId());
        dl.setSetorNome(pesquisa.getSetor().getNome());
        dl.setCompetencia(pesquisa.getCompetencia().getId());
        dl.setCompetenciaNome(pesquisa.getCompetencia().getNome());
        dl.setUsuario(pesquisa.getUsuario().getId());
        dl.setUsuarioNome(pesquisa.getUsuario().getNome());
        dl.setCabecalho(pesquisa.getCabecalho().getId());
        dl.setCabecalhoNome(pesquisa.getCabecalho().getNome());
        dl.setIndicador(pesquisa.getIndicador().getId());
        dl.setIndicadorNome(pesquisa.getIndicador().getNome());                              
        dl.setInformacao(pesquisa.getInformacao());
        dl.setAtivo(pesquisa.isAtivo());  

        retorno.add(dl);
        return retorno; 
        
    }
    
}
