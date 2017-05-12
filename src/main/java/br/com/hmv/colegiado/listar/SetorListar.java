/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.hmv.colegiado.listar;

import java.util.List;

/**
 *
 * @author vinim
 */
public class SetorListar {
    private Long id;
    private String nome;
    private boolean ativo;
    private List<String> usuarios;
    

    public SetorListar(Long id, String nome, boolean ativo, List<String> usuarios) {
        this.id = id;
        this.nome = nome;
        this.ativo = ativo;
        this.usuarios = usuarios;
        
    }

    public SetorListar() {
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

    public boolean isAtivo() {
        return ativo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }

    public List<String> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(List<String> usuarios) {
        this.usuarios = usuarios;
    }

    
    
    
}
