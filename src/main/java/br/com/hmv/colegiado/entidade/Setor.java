/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.hmv.colegiado.entidade;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

/**
 *
 * @author Marcus Vinícius <vinimarcus02@gmail.com>
 */
@Entity
public class Setor implements Serializable {
    
    private Long id;
    private String nome;
    private boolean ativo;
    private List<Usuario> usuarios;
    private List<DadoIndicador> dadoIndicador;    

    public Setor(String nome, List<Usuario> usuarios, boolean ativo) {
        this.nome = nome;
        this.usuarios = usuarios;
        this.dadoIndicador = new ArrayList<DadoIndicador>();
        this.ativo = ativo;
    }

    public Setor() {
       
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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

    @ManyToMany(fetch = FetchType.EAGER, mappedBy = "setores")
    public List<Usuario> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(List<Usuario> usuarios) {
        this.usuarios = usuarios;
    }

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "setor")
    public List<DadoIndicador> getDadoIndicador() {
        return dadoIndicador;
    }

    public void setDadoIndicador(List<DadoIndicador> dadoIndicador) {
        this.dadoIndicador = dadoIndicador;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 59 * hash + Objects.hashCode(this.id);
        hash = 59 * hash + Objects.hashCode(this.nome);
        hash = 59 * hash + (this.ativo ? 1 : 0);
        hash = 59 * hash + Objects.hashCode(this.usuarios);
        hash = 59 * hash + Objects.hashCode(this.dadoIndicador);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Setor other = (Setor) obj;
        if (this.ativo != other.ativo) {
            return false;
        }
        if (!Objects.equals(this.nome, other.nome)) {
            return false;
        }
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        if (!Objects.equals(this.usuarios, other.usuarios)) {
            return false;
        }
        if (!Objects.equals(this.dadoIndicador, other.dadoIndicador)) {
            return false;
        }
        return true;
    }
    
    

    
}
