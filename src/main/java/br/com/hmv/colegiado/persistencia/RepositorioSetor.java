/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.hmv.colegiado.persistencia;

import br.com.hmv.colegiado.entidade.Setor;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

/**
 *
 * @author Marcus Vinícius <vinimarcus02@gmail.com>
 */
public interface RepositorioSetor extends CrudRepository<Setor, Long> {
    
    public Setor findByNome(String nome);
    public Setor findById(Long id);
    
    @Query("select s from Setor s where s.nome like '%nomeSetor%'")
    public List<Setor> buscarSetores(@Param("nomeSetor")String nomeSetor);
    
}
