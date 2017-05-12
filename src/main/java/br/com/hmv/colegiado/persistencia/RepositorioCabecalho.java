/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.hmv.colegiado.persistencia;

import br.com.hmv.colegiado.entidade.Cabecalho;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

/**
 *
 * @author Marcus Vinícius <vinimarcus02@gmail.com>
 */
public interface RepositorioCabecalho extends CrudRepository<Cabecalho, Long> {
    
    public Cabecalho findByNome(String nome);
    public Cabecalho findById(Long id);
    
    @Query("select c from Cabecalho c where c.nome like '%nomeCabecalho%'")
    public List<Cabecalho> buscarCabecalhos(@Param("nomeCabecalho")String nomeCabecalho);
    
}
