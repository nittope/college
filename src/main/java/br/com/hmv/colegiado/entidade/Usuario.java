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
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

/**
 *
 * @author Marcus Vinícius <vinimarcus02@gmail.com>
 */
@Entity
public class Usuario implements Serializable{
    
    private Long id;
    private String nome;
    private String cpf;
    private String senha;
    private boolean ativo;
    private String authority;
    private Funcao funcao;
    private List<Setor> setores;
    private List<DadoIndicador> dadoIndicador;

    public Usuario(String nome, String cpf, String senha, boolean ativo, String authority, Funcao funcao) {
        this.nome = nome;
        this.cpf = cpf;
        this.senha = senha;
        this.ativo = ativo;
        this.setores = new ArrayList<Setor>();        
        this.dadoIndicador = new ArrayList<DadoIndicador>();
        this.authority = authority;
    }

    public Usuario() {
      
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

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public boolean isAtivo() {
        return ativo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }

    public String getAuthority() {
        return authority;
    }

    public void setAuthority(String authority) {
        this.authority = authority;
    }    

    @ManyToMany(fetch = FetchType.EAGER)
    public List<Setor> getSetores() {
        return setores;
    }
    
    @ManyToOne(fetch = FetchType.EAGER)
    public Funcao getFuncao() {
        return funcao;
    }

    public void setFuncao(Funcao funcao) {
        this.funcao = funcao;
    }

    public void setSetores(List<Setor> setores) {
        this.setores = setores;
    }

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "usuario")
    public List<DadoIndicador> getDadoIndicador() {
        return dadoIndicador;
    }

    public void setDadoIndicador(List<DadoIndicador> dadoIndicador) {
        this.dadoIndicador = dadoIndicador;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 67 * hash + Objects.hashCode(this.id);
        hash = 67 * hash + Objects.hashCode(this.nome);
        hash = 67 * hash + Objects.hashCode(this.cpf);
        hash = 67 * hash + Objects.hashCode(this.senha);
        hash = 67 * hash + (this.ativo ? 1 : 0);
        hash = 67 * hash + Objects.hashCode(this.authority);
        hash = 67 * hash + Objects.hashCode(this.funcao);
        hash = 67 * hash + Objects.hashCode(this.setores);
        hash = 67 * hash + Objects.hashCode(this.dadoIndicador);
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
        final Usuario other = (Usuario) obj;
        if (this.ativo != other.ativo) {
            return false;
        }
        if (!Objects.equals(this.nome, other.nome)) {
            return false;
        }
        if (!Objects.equals(this.cpf, other.cpf)) {
            return false;
        }
        if (!Objects.equals(this.senha, other.senha)) {
            return false;
        }
        if (!Objects.equals(this.authority, other.authority)) {
            return false;
        }
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        if (!Objects.equals(this.funcao, other.funcao)) {
            return false;
        }
        if (!Objects.equals(this.setores, other.setores)) {
            return false;
        }
        if (!Objects.equals(this.dadoIndicador, other.dadoIndicador)) {
            return false;
        }
        return true;
    }
  
    
     
}
