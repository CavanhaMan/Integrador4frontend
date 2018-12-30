package com.example.jorda.igrejasonline.domain;

import java.io.Serializable;

public class Igreja implements Serializable {

    private Integer id;
    private String cnpj;
    private String telefone;
    private String nome;
    private Endereco endereco;

    public Igreja(Integer id, String cnpj, String telefone, String nome) {
        this.id = id;
        this.cnpj = cnpj;
        this.telefone = telefone;
        this.nome = nome;
    }

    public Integer getId() {return id;}
    public void setId(Integer id) {this.id = id;}
    public String getCnpj() {return cnpj;}
    public void setCnpj(String cnpj) {this.cnpj = cnpj;}
    public String getNome() { return nome;}
    public void setNome(String nome) {this.nome = nome;}
    public String getTelefone() {return telefone;}
    public void setTelefone(String telefone) {this.telefone = telefone;}

    public Endereco getEndereco() {return endereco;}
    public void setEndereco(Endereco endereco) {this.endereco = endereco;}
}
