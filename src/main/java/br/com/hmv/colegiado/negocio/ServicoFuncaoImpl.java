/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.hmv.colegiado.negocio;

import br.com.hmv.colegiado.entidade.Funcao;
import br.com.hmv.colegiado.exception.FuncaoExistenteException;
import br.com.hmv.colegiado.exception.FuncaoInexistenteException;
import br.com.hmv.colegiado.listar.FuncaoListar;
import br.com.hmv.colegiado.persistencia.RepositorioFuncao;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Marcus Vinícius <vinimarcus02@gmail.com>
 */
@Service
public class ServicoFuncaoImpl implements ServicoFuncao {
    
    @Autowired
    private RepositorioFuncao repositorioFuncao;

    @Override
    public void cadastrar(Funcao funcao) throws FuncaoExistenteException, FuncaoInexistenteException {
     
        Funcao f = repositorioFuncao.findByNome(funcao.getNome());
        if(f!=null){
            if(!f.isAtivo()){
                f.setAtivo(true);
                f.setNome(funcao.getNome());                
            }else{
                throw new FuncaoExistenteException();
            }
        }else{
            repositorioFuncao.save(funcao);
        }
        
    }

    @Override
    public void atualizar(Funcao funcao) throws FuncaoInexistenteException {
        Funcao funcaoAtualizar = repositorioFuncao.findById(funcao.getId());
        if(funcaoAtualizar==null)
            throw new FuncaoInexistenteException();
        funcaoAtualizar.setNome(funcao.getNome());        
        repositorioFuncao.save(funcaoAtualizar);
    }

    @Override
    public void remover(String nome) throws FuncaoInexistenteException {
        Funcao funcaoAtualizar = repositorioFuncao.findByNome(nome);
        if(funcaoAtualizar==null)
            throw new FuncaoInexistenteException();
    }

    @Override
    public List<FuncaoListar> listarTodos() {
        List<FuncaoListar> retorno = new ArrayList<FuncaoListar>();
        List<Funcao> pesquisa = (List<Funcao>) repositorioFuncao.findAll();
        for(int i = 0;i < pesquisa.size(); i++){
            if(pesquisa.get(i).isAtivo()){
                FuncaoListar fl = new FuncaoListar();
                fl.setId(pesquisa.get(i).getId());
                fl.setNome(pesquisa.get(i).getNome());
                if(pesquisa.get(i).getUsuarios()!=null){
                    List<String> usuarios = new ArrayList<String>();
                    for(int j = 0; j < pesquisa.get(i).getUsuarios().size(); j++){
                        String nome = pesquisa.get(i).getUsuarios().get(j).getNome();
                        usuarios.add(nome);
                    }
                    fl.setUsuarios(usuarios);
                }
                retorno.add(fl);
            }
            
        }
        return retorno;
    }

    @Override
    public List<FuncaoListar> ConsultarPorNome(String nome) throws FuncaoInexistenteException {
        List<FuncaoListar> retorno = new ArrayList<FuncaoListar>();
        List<Funcao> pesquisa = (List<Funcao>) repositorioFuncao.findByNome(nome);
        if(pesquisa==null)
            throw new FuncaoInexistenteException();
        for(int i = 0;i < pesquisa.size(); i++){
            if(pesquisa.get(i).isAtivo()){
                FuncaoListar fl = new FuncaoListar();
                fl.setNome(pesquisa.get(i).getNome());
                if(pesquisa.get(i).getUsuarios()!=null){
                    List<String> usuarios = new ArrayList<String>();
                    for(int j = 0; j < pesquisa.get(i).getUsuarios().size(); j++){
                        String nomee = pesquisa.get(i).getUsuarios().get(j).getNome();
                        usuarios.add(nomee);
                    }
                    fl.setUsuarios(usuarios);
                }
                retorno.add(fl);
            }             
    }
    return retorno;
}

    @Override
    public List<FuncaoListar> ConsultarPorID(Long id) throws FuncaoInexistenteException {
        List<FuncaoListar> retorno = new ArrayList<FuncaoListar>();
        Funcao pesquisa = repositorioFuncao.findById(id);
        if(pesquisa==null)
            throw new FuncaoInexistenteException();
        
        FuncaoListar fl = new FuncaoListar();
        fl.setId(pesquisa.getId());
        fl.setNome(pesquisa.getNome());
        if(pesquisa.getUsuarios()!=null){
                    List<String> usuarios = new ArrayList<String>();
                    for(int j = 0; j < pesquisa.getUsuarios().size(); j++){
                        String nomeee = pesquisa.getUsuarios().get(j).getNome();
                        usuarios.add(nomeee);
                    }
                    fl.setUsuarios(usuarios);
                }
        retorno.add(fl);
        
        
            
                        
    
    return retorno;
        
    }

    @Override
    public List<FuncaoListar> listarTodasFuncoesAtivas() {
        List<FuncaoListar> retorno = new ArrayList<FuncaoListar>();
        List<Funcao> pesquisa = (List<Funcao>) repositorioFuncao.findAll();
        for(int i = 0;i < pesquisa.size(); i++){
            if(pesquisa.get(i).isAtivo()==true){
                FuncaoListar fl = new FuncaoListar();
                fl.setId(pesquisa.get(i).getId());
                fl.setNome(pesquisa.get(i).getNome());
                if(pesquisa.get(i).getUsuarios()!=null){
                    List<String> usuarios = new ArrayList<String>();
                    for(int j = 0; j < pesquisa.get(i).getUsuarios().size(); j++){
                        String nomeeeee = pesquisa.get(i).getUsuarios().get(j).getNome();
                        usuarios.add(nomeeeee);
                    }
                    fl.setUsuarios(usuarios);
                }
                retorno.add(fl);
            }
            
        }
        return retorno;
    }

    @Override
    public List<FuncaoListar> ConsultarPorIDRetornandoSomenteNome(Long id) throws FuncaoInexistenteException {
        List<FuncaoListar> retorno = new ArrayList<FuncaoListar>();
        Funcao pesquisa = repositorioFuncao.findById(id);
        if(pesquisa==null)
            throw new FuncaoInexistenteException();
        
        FuncaoListar fl = new FuncaoListar();       
        fl.setNome(pesquisa.getNome());
       
        retorno.add(fl);
        
        
            
                        
    
    return retorno;
        
    }

    @Override
    public Funcao ConsultarPorIdU(Long id) throws FuncaoInexistenteException {
       Funcao funcaoAtualizar = repositorioFuncao.findById(id);
        if(funcaoAtualizar==null || !funcaoAtualizar.isAtivo())
            throw new FuncaoInexistenteException();
        return funcaoAtualizar; 
    }
}
