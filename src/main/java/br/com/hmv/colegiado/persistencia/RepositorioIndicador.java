/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.hmv.colegiado.persistencia;

import br.com.hmv.colegiado.entidade.Indicador;
import java.io.Serializable;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

/**
 *
 * @author Marcus Vinícius <vinimarcus02@gmail.com>
 */
public interface RepositorioIndicador extends CrudRepository<Indicador, Long> {
    
    public Indicador findByNome(String nome);
    public Indicador findById(Long id);
    
    @Query("select i from Indicador i where i.nome like '%nomeIndicador%'")
    public List<Indicador> buscarIndicadores(@Param("nomeIndicador")String nomeIndicador);
    
}
