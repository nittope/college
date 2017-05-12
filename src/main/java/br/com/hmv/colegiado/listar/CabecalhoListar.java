/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.hmv.colegiado.listar;

import java.io.Serializable;

/**
 *
 * @author vinim
 */
public class CabecalhoListar implements Serializable {
    private Long Id;
    private String Nome;
    private boolean ativo; 

    public CabecalhoListar(Long Id, String Nome, boolean ativo) {
        this.Id = Id;
        this.Nome = Nome;
        this.ativo = ativo;
    }

    public CabecalhoListar() {
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long Id) {
        this.Id = Id;
    }

    public String getNome() {
        return Nome;
    }

    public void setNome(String Nome) {
        this.Nome = Nome;
    }

    public boolean isAtivo() {
        return ativo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }
    
    
}
