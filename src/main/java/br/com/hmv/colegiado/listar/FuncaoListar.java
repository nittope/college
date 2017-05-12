/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.hmv.colegiado.listar;

import java.util.List;

/**
 *
 * @author Marcus Vinícius <vinimarcus02@gmail.com>
 */
public class FuncaoListar {
    
    private Long id;
    private String nome;
    private List<String> usuarios;

    public FuncaoListar() {
    }

   
    public FuncaoListar(Long id, String nome, List<String> usuarios) {
        this.id = id;
        this.nome = nome;
        this.usuarios = usuarios;
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

    public List<String> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(List<String> usuarios) {
        this.usuarios = usuarios;
    }
    
    
    
}
