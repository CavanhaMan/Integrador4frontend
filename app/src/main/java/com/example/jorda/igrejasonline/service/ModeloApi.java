package com.example.jorda.igrejasonline.service;

import com.example.jorda.igrejasonline.domain.Calendario;
import com.example.jorda.igrejasonline.domain.Evento;
import com.example.jorda.igrejasonline.domain.Igreja;
import com.example.jorda.igrejasonline.model.ModeloCidade;
import com.example.jorda.igrejasonline.model.ModeloEstado;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
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

    // End-point busca Eventos
    @GET("/eventos")
    Call<List<Evento>> getEventos();

    @GET("/eventos/{id}")
    Call<Evento> consulta(@Path("id") Integer id);


    @POST("/igrejas")
    Call<Void> cadastrarIgreja(@Body Igreja igreja); // post sem retorno

    @PUT("/igrejas/{id}")
    Call<Igreja> editarIgreja(@Path("id") Integer id, @Body Igreja igreja);

    @DELETE("/igrejas/{id}")
    Call<Igreja> excluirIgreja(@Path("id") int id);

    @POST("/eventos")
    Call<Void> cadastrarEvento(@Body Evento evento);

    @PUT("/eventos/{id}")
    Call<Evento> editarEvento(@Path("id") Integer id, @Body Evento evento);

    @DELETE("/eventos/{id}")
    Call<Evento> excluirEvento(@Path("id") int id);


}
