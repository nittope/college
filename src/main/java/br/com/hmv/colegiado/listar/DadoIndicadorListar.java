/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.hmv.colegiado.listar;

/**
 *
 * @author Marcus Vinícius <vinimarcus02@gmail.com>
 */
public class DadoIndicadorListar {
    
    private Long Id;
    private Long setor;
    private String setorNome;
    private Long competencia;
    private String competenciaNome;
    private Long usuario;
    private String usuarioNome;
    private Long cabecalho;
    private String cabecalhoNome;
    private Long indicador;
    private String indicadorNome;
    private String informacao;    
    private boolean ativo;

    public DadoIndicadorListar(Long Id, Long setor, String setorNome, Long competencia, String competenciaNome, Long usuario, String usuarioNome, Long cabecalho, String cabecalhoNome, Long indicador, String indicadorNome, String informacao, boolean ativo) {
        this.Id = Id;
        this.setor = setor;
        this.setorNome = setorNome;
        this.competencia = competencia;
        this.competenciaNome = competenciaNome;
        this.usuario = usuario;
        this.usuarioNome = usuarioNome;
        this.cabecalho = cabecalho;
        this.cabecalhoNome = cabecalhoNome;
        this.indicador = indicador;
        this.indicadorNome = indicadorNome;
        this.informacao = informacao;
        this.ativo = ativo;
    }

    public DadoIndicadorListar() {
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long Id) {
        this.Id = Id;
    }

    public Long getSetor() {
        return setor;
    }

    public void setSetor(Long setor) {
        this.setor = setor;
    }

    public String getSetorNome() {
        return setorNome;
    }

    public void setSetorNome(String setorNome) {
        this.setorNome = setorNome;
    }

    public Long getCompetencia() {
        return competencia;
    }

    public void setCompetencia(Long competencia) {
        this.competencia = competencia;
    }

    public String getCompetenciaNome() {
        return competenciaNome;
    }

    public void setCompetenciaNome(String competenciaNome) {
        this.competenciaNome = competenciaNome;
    }

    public Long getUsuario() {
        return usuario;
    }

    public void setUsuario(Long usuario) {
        this.usuario = usuario;
    }

    public String getUsuarioNome() {
        return usuarioNome;
    }

    public void setUsuarioNome(String usuarioNome) {
        this.usuarioNome = usuarioNome;
    }

    public Long getCabecalho() {
        return cabecalho;
    }

    public void setCabecalho(Long cabecalho) {
        this.cabecalho = cabecalho;
    }

    public String getCabecalhoNome() {
        return cabecalhoNome;
    }

    public void setCabecalhoNome(String cabecalhoNome) {
        this.cabecalhoNome = cabecalhoNome;
    }

    public Long getIndicador() {
        return indicador;
    }

    public void setIndicador(Long indicador) {
        this.indicador = indicador;
    }

    public String getIndicadorNome() {
        return indicadorNome;
    }

    public void setIndicadorNome(String indicadorNome) {
        this.indicadorNome = indicadorNome;
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
    
    
    
}
