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
import javax.persistence.OneToMany;

/**
 *
 * @author Marcus Vinícius <vinimarcus02@gmail.com>
 */
@Entity
public class Cabecalho implements Serializable {
    
    private Long Id;
    private String Nome;
    private boolean ativo;
    private List<DadoIndicador> dadoIndicador;

    public Cabecalho(String Nome, boolean ativo) {
        this.Nome = Nome;
        this.dadoIndicador = new ArrayList<DadoIndicador>();
        this.ativo = ativo;
    }

    public Cabecalho() {
        
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "cabecalho")
    public List<DadoIndicador> getDadoIndicador() {
        return dadoIndicador;
    }

    public void setDadoIndicador(List<DadoIndicador> dadoIndicador) {
        this.dadoIndicador = dadoIndicador;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 23 * hash + Objects.hashCode(this.Id);
        hash = 23 * hash + Objects.hashCode(this.Nome);
        hash = 23 * hash + (this.ativo ? 1 : 0);
        hash = 23 * hash + Objects.hashCode(this.dadoIndicador);
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
        final Cabecalho other = (Cabecalho) obj;
        if (this.ativo != other.ativo) {
            return false;
        }
        if (!Objects.equals(this.Nome, other.Nome)) {
            return false;
        }
        if (!Objects.equals(this.Id, other.Id)) {
            return false;
        }
        if (!Objects.equals(this.dadoIndicador, other.dadoIndicador)) {
            return false;
        }
        return true;
    }
    
    
    
}
