/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.hmv.colegiado.listar;

import java.util.Date;
import java.util.List;

/**
 *
 * @author vinim
 */
public class CompetenciaListar {
    
    private Long id;
    private String nome;
    private String descricao;
    private Date dataIni;
    private Date dataFim;
    private boolean ativo;
    

    public CompetenciaListar(Long id, String nome, String descricao, Date dataIni, Date dataFim, boolean ativo) {
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
        this.dataIni = dataIni;
        this.dataFim = dataFim;
        this.ativo = ativo;
        
    }

    public CompetenciaListar() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Date getDataIni() {
        return dataIni;
    }

    public void setDataIni(Date dataIni) {
        this.dataIni = dataIni;
    }

    public Date getDataFim() {
        return dataFim;
    }

    public void setDataFim(Date dataFim) {
        this.dataFim = dataFim;
    }

    public boolean isAtivo() {
        return ativo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }

    
    
    
}
