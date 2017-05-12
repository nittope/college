/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.hmv.colegiado.persistencia;

import br.com.hmv.colegiado.entidade.Funcao;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

/**
 *
 * @author Marcus Vinícius <vinimarcus02@gmail.com>
 */
public interface RepositorioFuncao extends CrudRepository<Funcao, Long> {
    
    //public List<Funcao> findByNome(String nome);
    
    public Funcao findByNome(String nome);
    public Funcao findById(Long id);
    
    @Query("select f from Funcao f where f.nome like '%nomeFuncao%'")
    public List<Funcao> buscarFuncoes(@Param("nomeFuncao")String nomeFuncao);
    
      
}
