/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.hmv.colegiado.persistencia;

import br.com.hmv.colegiado.entidade.Competencia;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

/**
 *
 * @author Marcus Vinícius <vinimarcus02@gmail.com>
 */
public interface RepositorioCompetencia extends CrudRepository<Competencia, Long> {
    
    public Competencia findByNome(String nome);
    public Competencia findById(Long id);
    
    @Query("select c from Competencia c where c.nome like '%nomeCompetencia%'")
    public List<Competencia> buscarCompetencias(@Param("nomeCompetencia")String nomeCompetencia);    
    
}
