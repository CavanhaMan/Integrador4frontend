package com.example.jorda.igrejasonline.service;

import com.example.jorda.igrejasonline.domain.Calendario;
import com.example.jorda.igrejasonline.domain.Evento;
import com.example.jorda.igrejasonline.domain.Igreja;
import com.example.jorda.igrejasonline.model.ModeloCidade;
import com.example.jorda.igrejasonline.model.ModeloEstado;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface ModeloApi {

    @GET("/estados")
    Call<List<ModeloEstado>> consulta();

    @GET("/cidades")
    Call<List<ModeloCidade>> consultaCidade(@Path("id") Integer id_estado);

    // End-point busca igreja
    @GET("/igrejas")
    Call<List<Igreja>> getIgrejas();

    @GET("/igrejas/{id}")
    Call<Igreja> consulta(@Path("titulo")  String titulo);

    // End-point busca igreja
    @GET("/eventos")
    Call<List<Evento>> getEventos();

    @GET("/eventos/{id}")
    Call<Evento> consulta(@Path("id") Integer id);

/*  // End-point busca igreja
    @GET("/calendarios")
    Call<List<Calendario>> getCalendarios(); */
    @POST("/igrejas")
    Call<Void> cadastrarIgreja(@Body Igreja igreja); // post sem retorno
}
