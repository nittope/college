/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.hmv.colegiado.persistencia;

import br.com.hmv.colegiado.entidade.DadoIndicador;
import java.io.Serializable;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

/**
 *
 * @author Marcus Vinícius <vinimarcus02@gmail.com>
 */
public interface RepositorioDadoIndicador extends CrudRepository<DadoIndicador, Long>{
    
 @Query("select d from DadoIndicador d where d.competencia.nome=:nomeCompetencia ")
 public List<DadoIndicador> consultarPorCompetencia(@Param("nomeCompetencia") String nomeCompetencia);
 
 @Query("select d from DadoIndicador d where d.setor.nome=:nomeSetor ")
 public List<DadoIndicador> consultarPorSetor(@Param("nomeSetor") String nomeSetor);   
 
 @Query("select d from DadoIndicador d where d.usuario.nome=:nomeUsuario ")
 public List<DadoIndicador> consultarPorUsuario(@Param("nomeUsuario") String nomeUsuario);
 
 
 public DadoIndicador findById(Long id);
    
}
