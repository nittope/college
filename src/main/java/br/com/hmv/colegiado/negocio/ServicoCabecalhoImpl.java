/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.hmv.colegiado.negocio;

import br.com.hmv.colegiado.entidade.Cabecalho;
import br.com.hmv.colegiado.exception.CabecalhoExistenteException;
import br.com.hmv.colegiado.exception.CabecalhoInexistenteException;
import br.com.hmv.colegiado.listar.CabecalhoListar;
import br.com.hmv.colegiado.persistencia.RepositorioCabecalho;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author vinim
 */
@Service
public class ServicoCabecalhoImpl implements ServicoCabecalho {

    @Autowired
    private RepositorioCabecalho repositorioCabecalho;
    
    @Override
    public void cadastrar(Cabecalho cabecalho) throws CabecalhoExistenteException, CabecalhoInexistenteException {
        Cabecalho s = repositorioCabecalho.findByNome(cabecalho.getNome());
        if(s!=null){
            if(!s.isAtivo()){
                s.setAtivo(true);
                s.setNome(cabecalho.getNome());                
            }else{
                throw new CabecalhoExistenteException();
            }
        }else{
            repositorioCabecalho.save(cabecalho);
        }
    }

    @Override
    public void atualizar(Cabecalho cabecalho) throws CabecalhoInexistenteException {
       Cabecalho cabecalhoAtualizar = repositorioCabecalho.findById(cabecalho.getId());
        if(cabecalhoAtualizar==null)
            throw new CabecalhoInexistenteException();
        cabecalhoAtualizar.setNome(cabecalho.getNome());
        cabecalhoAtualizar.setAtivo(cabecalho.isAtivo());
        repositorioCabecalho.save(cabecalhoAtualizar); 
    }

    @Override
    public void remover(Cabecalho cabecalho) throws CabecalhoInexistenteException {
        
    }

    @Override
    public List<CabecalhoListar> listarTodos() {
        List<CabecalhoListar> retorno = new ArrayList<CabecalhoListar>();
        List<Cabecalho> pesquisa = (List<Cabecalho>) repositorioCabecalho.findAll();
        for(int i = 0;i < pesquisa.size(); i++){
            
                CabecalhoListar cl = new CabecalhoListar();
                cl.setId(pesquisa.get(i).getId());
                cl.setNome(pesquisa.get(i).getNome());
                cl.setAtivo(pesquisa.get(i).isAtivo());
                
                retorno.add(cl);
            
            
        }
        return retorno;
    }

    @Override
    public List<CabecalhoListar> ConsultarPorNome(String nome) throws CabecalhoInexistenteException {
        List<CabecalhoListar> retorno = new ArrayList<CabecalhoListar>();
        List<Cabecalho> pesquisa = (List<Cabecalho>) repositorioCabecalho.findByNome(nome);
        if(pesquisa==null)
            throw new CabecalhoInexistenteException();
        for(int i = 0;i < pesquisa.size(); i++){
            
                CabecalhoListar cl = new CabecalhoListar();
                cl.setNome(pesquisa.get(i).getNome());
                
                retorno.add(cl);
            }            
    
    return retorno;
    }

    @Override
    public List<CabecalhoListar> ConsultarPorID(Long id) throws CabecalhoInexistenteException {
       List<CabecalhoListar> retorno = new ArrayList<CabecalhoListar>();
        Cabecalho pesquisa = repositorioCabecalho.findById(id);
        if(pesquisa==null)
            throw new CabecalhoInexistenteException();
        
        CabecalhoListar cl = new CabecalhoListar();
        cl.setId(pesquisa.getId());
        cl.setNome(pesquisa.getNome());
        cl.setAtivo(pesquisa.isAtivo());
        
        retorno.add(cl);   
        
            
                        
    
    return retorno; 
    }

    @Override
    public Cabecalho ConsultarPorIdU(Long id) throws CabecalhoInexistenteException {
        Cabecalho cabecalhoAtualizar = repositorioCabecalho.findById(id);
        if(cabecalhoAtualizar==null || !cabecalhoAtualizar.isAtivo())
            throw new CabecalhoInexistenteException();
        return cabecalhoAtualizar; 
    }
    
}
