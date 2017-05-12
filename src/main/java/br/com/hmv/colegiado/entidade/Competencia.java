/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.hmv.colegiado.entidade;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Marcus Vinícius <vinimarcus02@gmail.com>
 */
@Entity
public class Competencia implements Serializable{ 
    
    private Long id;
    private String nome;
    private String descricao;
    private Date dataIni;
    private Date dataFim;
    private boolean ativo;
    private List<DadoIndicador> dadoIndicador;

    public Competencia(String nome, String descricao, Date dataIni, Date dataFim, boolean ativo) {
        this.nome = nome;
        this.descricao = descricao;
        this.dataIni = dataIni;
        this.dataFim = dataFim;
        this.dadoIndicador = new ArrayList<DadoIndicador>();  
        this.ativo = ativo;
    }

    public Competencia() {
        
        
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

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    @Temporal(TemporalType.DATE)
    public Date getDataIni() {
        return dataIni;
    }

    public void setDataIni(Date dataIni) {
        this.dataIni = dataIni;
    }

    @Temporal(TemporalType.DATE)
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

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "competencia")
    public List<DadoIndicador> getDadoIndicador() {
        return dadoIndicador;
    }

    public void setDadoIndicador(List<DadoIndicador> dadoIndicador) {
        this.dadoIndicador = dadoIndicador;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 29 * hash + Objects.hashCode(this.id);
        hash = 29 * hash + Objects.hashCode(this.nome);
        hash = 29 * hash + Objects.hashCode(this.descricao);
        hash = 29 * hash + Objects.hashCode(this.dataIni);
        hash = 29 * hash + Objects.hashCode(this.dataFim);
        hash = 29 * hash + (this.ativo ? 1 : 0);
        hash = 29 * hash + Objects.hashCode(this.dadoIndicador);
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
        final Competencia other = (Competencia) obj;
        if (this.ativo != other.ativo) {
            return false;
        }
        if (!Objects.equals(this.nome, other.nome)) {
            return false;
        }
        if (!Objects.equals(this.descricao, other.descricao)) {
            return false;
        }
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        if (!Objects.equals(this.dataIni, other.dataIni)) {
            return false;
        }
        if (!Objects.equals(this.dataFim, other.dataFim)) {
            return false;
        }
        if (!Objects.equals(this.dadoIndicador, other.dadoIndicador)) {
            return false;
        }
        return true;
    }
    
    
    
    
    
    
}
