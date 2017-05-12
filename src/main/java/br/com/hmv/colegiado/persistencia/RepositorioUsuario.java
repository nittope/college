/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.hmv.colegiado.persistencia;

import br.com.hmv.colegiado.entidade.Usuario;
import java.io.Serializable;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

/**
 *
 * @author Marcus Vinícius <vinimarcus02@gmail.com>
 */
public interface RepositorioUsuario extends CrudRepository<Usuario, Long> {
    
    public Usuario findById(Long id);
    public Usuario findByCpf(String cpf);
    public Usuario findByNome (String nome);
    
    @Query("select u from Usuario u where u.nome like '%nomeUsuario%'")
    public List<Usuario> buscarUsuarios(@Param("nomeUsuario") String nomeUsuario);
    
    
    
}
