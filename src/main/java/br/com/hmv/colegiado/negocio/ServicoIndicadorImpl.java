/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.hmv.colegiado.negocio;

import br.com.hmv.colegiado.entidade.Indicador;
import br.com.hmv.colegiado.exception.IndicadorExistenteException;
import br.com.hmv.colegiado.exception.IndicadorInexistenteException;
import br.com.hmv.colegiado.listar.IndicadorListar;
import br.com.hmv.colegiado.persistencia.RepositorioIndicador;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author vinim
 */
@Service
public class ServicoIndicadorImpl implements ServicoIndicador {
    
    @Autowired
    private RepositorioIndicador repositorioIndicador;

    @Override
    public void cadastrar(Indicador indicador) throws IndicadorExistenteException, IndicadorInexistenteException {
        Indicador i = repositorioIndicador.findByNome(indicador.getNome());
        if(i!=null){
            if(!i.isAtivo()){
                i.setAtivo(true);
                i.setNome(indicador.getNome());
                i.setDescricao(indicador.getDescricao());
                
                
            }else{
                throw new IndicadorExistenteException();
            }
        }else{
            repositorioIndicador.save(indicador);
        }
    }

    @Override
    public void atualizar(Indicador indicador) throws IndicadorInexistenteException {
        Indicador indicadorAtualizar = repositorioIndicador.findById(indicador.getId());
        if(indicadorAtualizar==null)
            throw new IndicadorInexistenteException();
        indicadorAtualizar.setNome(indicador.getNome());
        indicadorAtualizar.setDescricao(indicador.getDescricao());
        indicadorAtualizar.setAtivo(indicador.isAtivo());
        repositorioIndicador.save(indicadorAtualizar); 
    }

    @Override
    public void remover(Indicador indicador) throws IndicadorInexistenteException {
        
    }

    @Override
    public List<IndicadorListar> listarTodos() {
      List<IndicadorListar> retorno = new ArrayList<IndicadorListar>();
        List<Indicador> pesquisa = (List<Indicador>) repositorioIndicador.findAll();
        for(int i = 0;i < pesquisa.size(); i++){
            
                IndicadorListar il = new IndicadorListar();
                il.setId(pesquisa.get(i).getId());
                il.setNome(pesquisa.get(i).getNome());
                il.setDescricao(pesquisa.get(i).getDescricao());
                il.setAtivo(pesquisa.get(i).isAtivo());
                
                retorno.add(il);
            
            
        }
        return retorno;  
    }

    @Override
    public List<IndicadorListar> ConsultarPorNome(String nome) throws IndicadorInexistenteException {
       List<IndicadorListar> retorno = new ArrayList<IndicadorListar>();
        List<Indicador> pesquisa = (List<Indicador>) repositorioIndicador.findByNome(nome);
        if(pesquisa==null)
            throw new IndicadorInexistenteException();
        for(int i = 0;i < pesquisa.size(); i++){
            
                IndicadorListar il = new IndicadorListar();
                il.setNome(pesquisa.get(i).getNome());
                
                retorno.add(il);
            }            
    
    return retorno; 
    }

    @Override
    public List<IndicadorListar> ConsultarPorID(Long id) throws IndicadorInexistenteException {
        List<IndicadorListar> retorno = new ArrayList<IndicadorListar>();
        Indicador pesquisa = repositorioIndicador.findById(id);
        if(pesquisa==null)
            throw new IndicadorInexistenteException();
        
        IndicadorListar il = new IndicadorListar();
        il.setId(pesquisa.getId());
        il.setNome(pesquisa.getNome());
        il.setDescricao(pesquisa.getDescricao());
        il.setAtivo(pesquisa.isAtivo());
        
        retorno.add(il);   
        
            
                        
    
    return retorno; 
    }

    @Override
    public Indicador ConsultarPorIdU(Long id) throws IndicadorInexistenteException {
        Indicador indicadorAtualizar = repositorioIndicador.findById(id);
        if(indicadorAtualizar==null || !indicadorAtualizar.isAtivo())
            throw new IndicadorInexistenteException();
        return indicadorAtualizar; 
    }
    }
    

