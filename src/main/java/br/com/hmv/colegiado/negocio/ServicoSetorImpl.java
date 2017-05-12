/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.hmv.colegiado.negocio;

import br.com.hmv.colegiado.entidade.Setor;
import br.com.hmv.colegiado.exception.SetorExistenteException;
import br.com.hmv.colegiado.exception.SetorInexistenteException;
import br.com.hmv.colegiado.listar.SetorListar;
import br.com.hmv.colegiado.persistencia.RepositorioSetor;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author vinim
 */
@Service
public class ServicoSetorImpl implements ServicoSetor{
    
    @Autowired
    private RepositorioSetor repositorioSetor;
    
    

    @Override
    public void cadastrar(Setor setor) throws SetorExistenteException, SetorInexistenteException {
         Setor s = repositorioSetor.findByNome(setor.getNome());
        if(s!=null){
            if(!s.isAtivo()){
                s.setAtivo(true);
                s.setNome(setor.getNome());                
            }else{
                throw new SetorExistenteException();
            }
        }else{
            repositorioSetor.save(setor);
        }
    }

    @Override
    public void atualizar(Setor setor) throws SetorInexistenteException {
        Setor setorAtualizar = repositorioSetor.findById(setor.getId());
        if(setorAtualizar==null)
            throw new SetorInexistenteException();
        setorAtualizar.setNome(setor.getNome());
        setorAtualizar.setAtivo(setor.isAtivo());
        repositorioSetor.save(setorAtualizar);
    }

    @Override
    public void remover(Setor setor) throws SetorInexistenteException {
        Setor setorAtualizar = repositorioSetor.findById(setor.getId());
        if(setorAtualizar==null)
            throw new SetorInexistenteException();
        setorAtualizar.setAtivo(false);        
        repositorioSetor.save(setorAtualizar);
    }

    @Override
    public List<SetorListar> listarTodos() {
        List<SetorListar> retorno = new ArrayList<SetorListar>();
        List<Setor> pesquisa = (List<Setor>) repositorioSetor.findAll();
        for(int i = 0;i < pesquisa.size(); i++){
            
                SetorListar sl = new SetorListar();
                sl.setId(pesquisa.get(i).getId());
                sl.setNome(pesquisa.get(i).getNome());
                sl.setAtivo(pesquisa.get(i).isAtivo());
                if(pesquisa.get(i).getUsuarios()!=null){
                    List<String> usuarios = new ArrayList<String>();
                    for(int j = 0; j < pesquisa.get(i).getUsuarios().size(); j++){
                        String nome = pesquisa.get(i).getUsuarios().get(j).getNome();
                        usuarios.add(nome);
                    }
                    sl.setUsuarios(usuarios);
                }
                retorno.add(sl);
            
            
        }
        return retorno;
    }

    @Override
    public List<SetorListar> ConsultarPorNome(String nome) throws SetorInexistenteException {
        List<SetorListar> retorno = new ArrayList<SetorListar>();
        List<Setor> pesquisa = (List<Setor>) repositorioSetor.findByNome(nome);
        if(pesquisa==null)
            throw new SetorInexistenteException();
        for(int i = 0;i < pesquisa.size(); i++){
            
                SetorListar sl = new SetorListar();
                sl.setNome(pesquisa.get(i).getNome());
                if(pesquisa.get(i).getUsuarios()!=null){
                    List<String> usuarios = new ArrayList<String>();
                    for(int j = 0; j < pesquisa.get(i).getUsuarios().size(); j++){
                        String nomee = pesquisa.get(i).getUsuarios().get(j).getNome();
                        usuarios.add(nomee);
                    }
                    sl.setUsuarios(usuarios);
                }
                retorno.add(sl);
            }            
    
    return retorno;
    }

    @Override
    public List<SetorListar> ConsultarPorID(Long id) throws SetorInexistenteException {
        List<SetorListar> retorno = new ArrayList<SetorListar>();
        Setor pesquisa = repositorioSetor.findById(id);
        if(pesquisa==null)
            throw new SetorInexistenteException();
        
        SetorListar sl = new SetorListar();
        sl.setId(pesquisa.getId());
        sl.setNome(pesquisa.getNome());
        sl.setAtivo(pesquisa.isAtivo());
        if(pesquisa.getUsuarios()!=null){
                    List<String> usuarios = new ArrayList<String>();
                    for(int j = 0; j < pesquisa.getUsuarios().size(); j++){
                        String nomeee = pesquisa.getUsuarios().get(j).getNome();
                        usuarios.add(nomeee);
                    }
                    sl.setUsuarios(usuarios);
                }
        retorno.add(sl);
        
        
            
                        
    
    return retorno;
    }
    
}
