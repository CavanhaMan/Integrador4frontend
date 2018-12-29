package com.example.jorda.igrejasonline.service;

import com.example.jorda.igrejasonline.domain.ModeloCalendario;
import com.example.jorda.igrejasonline.domain.ModeloEvento;
import com.example.jorda.igrejasonline.domain.ModeloIgreja;
import com.example.jorda.igrejasonline.model.ModeloCidade;
import com.example.jorda.igrejasonline.model.ModeloEstado;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface ModeloApi {

    @GET("/estados")
    Call<List<ModeloEstado>> consulta();

    @GET("/cidades")
    Call<List<ModeloCidade>> consultaCidade(@Path("id") Integer id_estado);

    // End-point busca igreja
    @GET("/igrejas")
    Call<List<ModeloIgreja>> getIgrejas();

    @GET("/igrejas/{id}")
    Call<ModeloIgreja> consulta(@Path("titulo")  String titulo);

    // End-point busca igreja
    @GET("/eventos")
    Call<List<ModeloEvento>> getEventos();

    @GET("/eventos/{id}")
    Call<ModeloEvento> consulta(@Path("id") Integer id);

    // End-point busca igreja
    @GET("/calendarios")
    Call<List<ModeloCalendario>> getCalendarios();
}
