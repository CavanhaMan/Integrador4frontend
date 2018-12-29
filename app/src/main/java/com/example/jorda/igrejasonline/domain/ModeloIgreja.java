package com.example.jorda.igrejasonline.domain;

public class ModeloIgreja {

    private String cnpj;
    private String telefone;
    private String nome;
    private Integer id;
    private String logradouro;
    private String numero;
    private String complemento;
    private String bairro;
    private String cep;
    private String nomeCidade;
    private String nomeEstado;
    private String uf;

    public String getCnpj() {return cnpj;}
    public void setCnpj(String cnpj) {this.cnpj = cnpj;}

    public String getTelefone() {return telefone;}
    public void setTelefone(String telefone) {this.telefone = telefone;}

    public String getNome() { return nome;}
    public void setNome(String nome) {this.nome = nome;}

    public Integer getId() {return id;}
    public void setId(Integer id) {this.id = id;}

    public String getLogradouro() { return logradouro;}
    public void setLogradouro(String logradouro) {this.logradouro = logradouro;}

    public String getNumero() {return numero;}
    public void setNumero(String numero) {this.numero = numero;}

    public String getComplemento() { return complemento;}
    public void setComplemento(String complemento) {this.complemento = complemento;}

    public String getBairro() {return bairro;}
    public void setBairro(String bairro) {this.bairro = bairro;}

    public String getCep() {return cep;}
    public void setCep(String cep) {this.cep = cep;}

    public String getNomeCidade() {return nomeCidade; }
    public void setNomeCidade(String nomeCidade) {this.nomeCidade = nomeCidade;}

    public String getNomeEstado() {return nomeEstado;}
    public void setNomeEstado(String nomeEstado) {this.nomeEstado = nomeEstado;}

    public String getUf() {return uf;}
    public void setUf(String uf) {this.uf = uf;}
}
