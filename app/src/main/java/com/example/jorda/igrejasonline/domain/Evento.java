package com.example.jorda.igrejasonline.domain;

import java.io.Serializable;

public class Evento implements Serializable {
    
    private Integer id;
    private String titulo;
    private String dataInicio;
    private String horaInicio;
    private String dataTermino;
    private String horaTermino;
    private String descricao;
    private String publico;
    private boolean repete;
    private Endereco endereco;
    private Igreja igreja;

    public Evento(Integer id, String titulo, String dataInicio, String horaInicio, String dataTermino, String horaTermino, String descricao, String publico) {
        this.id = id;
        this.titulo = titulo;
        this.dataInicio = dataInicio;
        this.horaInicio = horaInicio;
        this.dataTermino = dataTermino;
        this.horaTermino = horaTermino;
        this.descricao = descricao;
        this.publico = publico;
    }

    public Integer getId() {return id;}
    public void setId(Integer id) {this.id = id;}
    public String getTitulo() {
        return titulo;
    }
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
    public String getDataInicio() {
        return dataInicio;
    }
    public void setDataInicio(String dataInicio) {
        this.dataInicio = dataInicio;
    }
    public String getHoraInicio() {
        return horaInicio;
    }
    public void setHoraInicio(String horaInicio) {
        this.horaInicio = horaInicio;
    }
    public String getDataTermino() {
        return dataTermino;
    }
    public void setDataTermino(String dataTermino) {
        this.dataTermino = dataTermino;
    }
    public String getHoraTermino() {
        return horaTermino;
    }
    public void setHoraTermino(String horaTermino) {
        this.horaTermino = horaTermino;
    }
    public String getDescricao() {
        return descricao;
    }
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    public String getPublico() {
        return publico;
    }
    public void setPublico(String publico) {
        this.publico = publico;
    }
    public boolean isRepete() {
        return repete;
    }
    public void setRepete(boolean repete) {
        this.repete = repete;
    }

    public Endereco getEndereco() {return endereco;}
    public void setEndereco(Endereco endereco) {this.endereco = endereco;}
    public Igreja getIgreja() {return igreja;}
    public void setIgreja(Igreja igreja) {this.igreja = igreja;}
}
