/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.hmv.colegiado.negocio;

import br.com.hmv.colegiado.entidade.Competencia;
import br.com.hmv.colegiado.exception.CompetenciaExistenteException;
import br.com.hmv.colegiado.exception.CompetenciaInexistenteException;
import br.com.hmv.colegiado.listar.CompetenciaListar;
import br.com.hmv.colegiado.persistencia.RepositorioCompetencia;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author vinim
 */
@Service
public class ServicoCompetenciaImpl implements ServicoCompetencia {
    
    @Autowired
    private RepositorioCompetencia repositorioCompetencia;

    @Override
    public void cadastrar(Competencia competencia) throws CompetenciaExistenteException, CompetenciaInexistenteException {
         Competencia c = repositorioCompetencia.findByNome(competencia.getNome());
        if(c!=null){
            if(!c.isAtivo()){
                c.setAtivo(competencia.isAtivo());
                c.setNome(competencia.getNome());
                c.setDescricao(competencia.getDescricao());
                c.setDataIni(competencia.getDataIni());
                c.setDataFim(competencia.getDataFim());
                
            }else{
                throw new CompetenciaExistenteException();
            }
        }else{
            repositorioCompetencia.save(competencia);
        }
    }

    @Override
    public void atualizar(Competencia competencia) throws CompetenciaInexistenteException {
        Competencia competenciaAtualizar = repositorioCompetencia.findById(competencia.getId());
        if(competenciaAtualizar==null)
            throw new CompetenciaInexistenteException();
        competenciaAtualizar.setNome(competencia.getNome());
        competenciaAtualizar.setAtivo(competencia.isAtivo());
        competenciaAtualizar.setDescricao(competencia.getDescricao());
        competenciaAtualizar.setDataIni(competencia.getDataIni());
        competenciaAtualizar.setDataFim(competencia.getDataFim());
        
        repositorioCompetencia.save(competenciaAtualizar); 
    }

    @Override
    public void remover(Competencia competencia) throws CompetenciaInexistenteException {
        
    }

    @Override
    public List<CompetenciaListar> listarTodos() {
        List<CompetenciaListar> retorno = new ArrayList<CompetenciaListar>();
        List<Competencia> pesquisa = (List<Competencia>) repositorioCompetencia.findAll();
        for(int i = 0;i < pesquisa.size(); i++){
            
                CompetenciaListar cl = new CompetenciaListar();
                cl.setId(pesquisa.get(i).getId());
                cl.setNome(pesquisa.get(i).getNome());
                cl.setAtivo(pesquisa.get(i).isAtivo());
                cl.setDescricao(pesquisa.get(i).getDescricao());
                cl.setDataIni(pesquisa.get(i).getDataIni());
                cl.setDataFim(pesquisa.get(i).getDataFim());
                
                retorno.add(cl);
            
            
        }
        return retorno;
    }

    @Override
    public List<CompetenciaListar> ConsultarPorNome(String nome) throws CompetenciaInexistenteException {
        List<CompetenciaListar> retorno = new ArrayList<CompetenciaListar>();
        List<Competencia> pesquisa = (List<Competencia>) repositorioCompetencia.findByNome(nome);
        if(pesquisa==null)
            throw new CompetenciaInexistenteException();
        for(int i = 0;i < pesquisa.size(); i++){
            
                CompetenciaListar cl = new CompetenciaListar();
                
                cl.setId(pesquisa.get(i).getId());
                cl.setNome(pesquisa.get(i).getNome());
                cl.setAtivo(pesquisa.get(i).isAtivo());
                cl.setDescricao(pesquisa.get(i).getDescricao());
                cl.setDataIni(pesquisa.get(i).getDataIni());
                cl.setDataFim(pesquisa.get(i).getDataFim());
                
                retorno.add(cl);
            }            
    
    return retorno;
    }

    @Override
    public List<CompetenciaListar> ConsultarPorID(Long id) throws CompetenciaInexistenteException {
        List<CompetenciaListar> retorno = new ArrayList<CompetenciaListar>();
        Competencia pesquisa = repositorioCompetencia.findById(id);
        if(pesquisa==null)
            throw new CompetenciaInexistenteException();
        
        CompetenciaListar cl = new CompetenciaListar();
        cl.setId(pesquisa.getId());
        cl.setNome(pesquisa.getNome());
        cl.setAtivo(pesquisa.isAtivo());
        cl.setDescricao(pesquisa.getDescricao());
        cl.setDataIni(pesquisa.getDataIni());
        cl.setDataFim(pesquisa.getDataFim());
        
        
        retorno.add(cl);   
        
            
                        
    
    return retorno; 
    }

    @Override
    public Competencia ConsultarPorIdU(Long id) throws CompetenciaInexistenteException {
        Competencia competenciaAtualizar = repositorioCompetencia.findById(id);
        if(competenciaAtualizar==null || !competenciaAtualizar.isAtivo())
            throw new CompetenciaInexistenteException();
        return competenciaAtualizar; 
    }

    @Override
    public List<CompetenciaListar> listarTodasCompetenciasAtivas() {
        List<CompetenciaListar> retorno = new ArrayList<CompetenciaListar>();
        List<Competencia> pesquisa = (List<Competencia>) repositorioCompetencia.findAll();
        for(int i = 0;i < pesquisa.size(); i++){
            if(pesquisa.get(i).isAtivo()==true){
                 CompetenciaListar cl = new CompetenciaListar();
                cl.setId(pesquisa.get(i).getId());
                cl.setNome(pesquisa.get(i).getNome());
                cl.setAtivo(pesquisa.get(i).isAtivo());
                cl.setDescricao(pesquisa.get(i).getDescricao());
                cl.setDataIni(pesquisa.get(i).getDataIni());
                cl.setDataFim(pesquisa.get(i).getDataFim());
                
                retorno.add(cl);    }
            
        }
        return retorno;
    }
    
}
