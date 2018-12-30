package com.example.jorda.igrejasonline.domain;

import java.io.Serializable;

public class Endereco implements Serializable {

    private Integer id;
    private String logradouro;
    private String numero;
    private String complemento;
    private String bairro;
    private String cep;

    public Endereco(Integer id, String logradouro, String numero, String complemento, String bairro, String cep) {
        this.id = id;
        this.logradouro = logradouro;
        this.numero = numero;
        this.complemento = complemento;
        this.bairro = bairro;
        this.cep = cep;
    }

    public Integer getId() {return id;}
    public void setId(Integer id) {this.id = id;}
    public String getLogradouro() {return logradouro;}
    public void setLogradouro(String logradouro) {this.logradouro = logradouro;}
    public String getNumero() {return numero;}
    public void setNumero(String numero) {this.numero = numero;}
    public String getComplemento() {return complemento;}
    public void setComplemento(String complemento) {this.complemento = complemento;}
    public String getBairro() {return bairro;}
    public void setBairro(String bairro) {this.bairro = bairro;}
    public String getCep() {return cep;}
    public void setCep(String cep) {this.cep = cep;}
}
