/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.hmv.colegiado.negocio;

import br.com.hmv.colegiado.exception.UsuarioExistenteException;
import br.com.hmv.colegiado.exception.UsuarioInexistenteException;
import br.com.hmv.colegiado.entidade.Funcao;
import br.com.hmv.colegiado.entidade.Usuario;
import br.com.hmv.colegiado.exception.FuncaoInexistenteException;
import br.com.hmv.colegiado.listar.UsuarioListar;
import br.com.hmv.colegiado.persistencia.RepositorioUsuario;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author vinim
 */
@Service
public class ServicoUsuarioImpl implements ServicoUsuario{

    @Autowired
    private RepositorioUsuario repositorioUsuario;
    
    @Autowired
    private ServicoFuncao servicoFuncao;
    
    @Override
    public void cadastrar(Usuario usuario, Long id) throws UsuarioExistenteException, UsuarioInexistenteException, FuncaoInexistenteException {
        Funcao funcao = servicoFuncao.ConsultarPorIdU(id);   
        
        
            
                usuario.setAtivo(usuario.isAtivo());
                usuario.setNome(usuario.getNome());
                usuario.setCpf(usuario.getCpf());
                usuario.setSenha(usuario.getSenha());
                usuario.setAuthority(usuario.getAuthority());
                usuario.setFuncao(funcao);
                repositorioUsuario.save(usuario);             
            
            
        
            
        
    }

    @Override
    public void atualizar(Usuario usuario, Long id) throws UsuarioInexistenteException, FuncaoInexistenteException {
        Funcao funcao = servicoFuncao.ConsultarPorIdU(id); 
        Usuario usuarioAtualizar = repositorioUsuario.findById(usuario.getId());        
        if(usuarioAtualizar==null)
            throw new UsuarioInexistenteException();
        usuarioAtualizar.setNome(usuario.getNome());        
        usuarioAtualizar.setAtivo(usuario.isAtivo());
        usuarioAtualizar.setCpf(usuario.getCpf());
        usuarioAtualizar.setSenha(usuario.getSenha());
        usuarioAtualizar.setAuthority(usuario.getAuthority());
        usuarioAtualizar.setFuncao(funcao);
        repositorioUsuario.save(usuarioAtualizar); 
    }

    @Override
    public void remover(Usuario usuario) throws UsuarioInexistenteException {
        
    }

    @Override
    public List<UsuarioListar> listarTodos() {
        List<UsuarioListar> retorno = new ArrayList<UsuarioListar>();
        List<Usuario> pesquisa = (List<Usuario>) repositorioUsuario.findAll();
        for(int i = 0;i < pesquisa.size(); i++){
            
                UsuarioListar ul = new UsuarioListar();
                ul.setId(pesquisa.get(i).getId());
                ul.setNome(pesquisa.get(i).getNome());                
                ul.setAtivo(pesquisa.get(i).isAtivo());
                ul.setCpf(pesquisa.get(i).getCpf());
                ul.setSenha(pesquisa.get(i).getSenha());
                ul.setAuthority(pesquisa.get(i).getAuthority());
                ul.setFuncao(pesquisa.get(i).getFuncao().getId());
                ul.setFuncaoNome(pesquisa.get(i).getFuncao().getNome());
                if(pesquisa.get(i).getSetores()!=null){
                    List<String> setores = new ArrayList<String>();
                    for(int j = 0; j < pesquisa.get(i).getSetores().size(); j++){
                        String nome = pesquisa.get(i).getSetores().get(j).getNome();
                        setores.add(nome);
                    }
                    ul.setSetores(setores);
                }
                retorno.add(ul);
            
            
        }
        return retorno;  
    }

    @Override
    public List<UsuarioListar> ConsultarPorNome(String nome) throws UsuarioInexistenteException {
        List<UsuarioListar> retorno = new ArrayList<UsuarioListar>();
        List<Usuario> pesquisa = (List<Usuario>) repositorioUsuario.findByNome(nome);
        if(pesquisa==null)
            throw new UsuarioInexistenteException();
        for(int i = 0;i < pesquisa.size(); i++){
            
                UsuarioListar ul = new UsuarioListar();
                ul.setNome(pesquisa.get(i).getNome());
                
                retorno.add(ul);
            }            
    
    return retorno; 
    }

    @Override
    public List<UsuarioListar> ConsultarPorID(Long id) throws UsuarioInexistenteException {
        List<UsuarioListar> retorno = new ArrayList<UsuarioListar>();
        Usuario pesquisa = repositorioUsuario.findById(id);
        if(pesquisa==null)
            throw new UsuarioInexistenteException();
        
        UsuarioListar ul = new UsuarioListar();
        ul.setId(pesquisa.getId());
        ul.setNome(pesquisa.getNome());        
        ul.setAtivo(pesquisa.isAtivo());
        ul.setCpf(pesquisa.getCpf());
        ul.setSenha(pesquisa.getSenha());
        ul.setAuthority(pesquisa.getAuthority());
        ul.setFuncao(pesquisa.getFuncao().getId());
        ul.setFuncaoNome(pesquisa.getFuncao().getNome());
        if(pesquisa.getSetores()!=null){
                    List<String> setores = new ArrayList<String>();
                    for(int j = 0; j < pesquisa.getSetores().size(); j++){
                        String nomeeee = pesquisa.getSetores().get(j).getNome();
                        setores.add(nomeeee);
                    }
                    ul.setSetores(setores);
                }
        
        retorno.add(ul);
        return retorno; 
    }
    
}
