/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.hmv.colegiado.entidade;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

/**
 *
 * @author Marcus Vinícius <vinimarcus02@gmail.com>
 */
@Entity
public class DadoIndicador implements Serializable{
    
    private Long Id;
    private Setor setor;
    private Competencia competencia;
    private Usuario usuario;
    private Cabecalho cabecalho;
    private Indicador indicador;
    private String informacao;
    private boolean ativo;

    public DadoIndicador(Setor setor, Competencia competencia, Usuario usuario, Cabecalho cabecalho, Indicador indicador, String informacao) {
        this.setor = setor;
        this.competencia = competencia;
        this.usuario = usuario;
        this.cabecalho = cabecalho;
        this.indicador = indicador;
        this.informacao = informacao;
    }

    public DadoIndicador() {
        
        this.ativo = true;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getId() {
        return Id;
    }

    public void setId(Long Id) {
        this.Id = Id;
    }
    @ManyToOne(fetch = FetchType.EAGER)
    public Setor getSetor() {
        return setor;
    }

    public void setSetor(Setor setor) {
        this.setor = setor;
    }

    @ManyToOne(fetch = FetchType.EAGER)
    public Competencia getCompetencia() {
        return competencia;
    }

    public void setCompetencia(Competencia competencia) {
        this.competencia = competencia;
    }

    @ManyToOne(fetch = FetchType.EAGER)
    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    @ManyToOne(fetch = FetchType.EAGER)
    public Cabecalho getCabecalho() {
        return cabecalho;
    }

    public void setCabecalho(Cabecalho cabecalho) {
        this.cabecalho = cabecalho;
    }

    public String getInformacao() {
        return informacao;
    }

    public void setInformacao(String informacao) {
        this.informacao = informacao;
    }

    public boolean isAtivo() {
        return ativo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }

    @ManyToOne(fetch = FetchType.EAGER)
    public Indicador getIndicador() {
        return indicador;
    }

    public void setIndicador(Indicador indicador) {
        this.indicador = indicador;
    }
    

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 79 * hash + Objects.hashCode(this.Id);
        hash = 79 * hash + Objects.hashCode(this.setor);
        hash = 79 * hash + Objects.hashCode(this.competencia);
        hash = 79 * hash + Objects.hashCode(this.usuario);
        hash = 79 * hash + Objects.hashCode(this.cabecalho);
        hash = 79 * hash + Objects.hashCode(this.informacao);
        hash = 79 * hash + (this.ativo ? 1 : 0);
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
        final DadoIndicador other = (DadoIndicador) obj;
        if (this.ativo != other.ativo) {
            return false;
        }
        if (!Objects.equals(this.informacao, other.informacao)) {
            return false;
        }
        if (!Objects.equals(this.Id, other.Id)) {
            return false;
        }
        if (!Objects.equals(this.setor, other.setor)) {
            return false;
        }
        if (!Objects.equals(this.competencia, other.competencia)) {
            return false;
        }
        if (!Objects.equals(this.usuario, other.usuario)) {
            return false;
        }
        if (!Objects.equals(this.cabecalho, other.cabecalho)) {
            return false;
        }
        return true;
    }
    
    
    
}
