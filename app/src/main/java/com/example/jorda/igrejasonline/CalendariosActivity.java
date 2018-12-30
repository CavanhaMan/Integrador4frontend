package com.example.jorda.igrejasonline;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.widget.ListView;

import com.example.jorda.igrejasonline.Adapter.EventoAdapter;
import com.example.jorda.igrejasonline.domain.Evento;
import com.example.jorda.igrejasonline.service.RetrofitService;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CalendariosActivity extends AppCompatActivity {

    ListView listView;
    RetrofitService service;
    List<Evento> listaEventos = new ArrayList<Evento>();
    EventoAdapter eventoAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_eventos);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar); //Mostra a barra para poder mostrar o botao voltar
        setSupportActionBar(toolbar);

        listView = findViewById(R.id.listaE);

        getEventos();

        getSupportActionBar().setDisplayHomeAsUpEnabled(true); //Mostrar o botão
        getSupportActionBar().setHomeButtonEnabled(true);      //Ativar o botão
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) { //Botão adicional na ToolBar
        switch (item.getItemId()) {
            case android.R.id.home:  //ID do seu botão (gerado automaticamente pelo android, usando como está, deve funcionar
                startActivity(new Intent(this, MainActivity.class));  //O efeito ao ser pressionado do botão (no caso abre a activity)
                finishAffinity();  //Método para matar a activity e não deixa-lá indexada na pilhagem
                break;
            default:break;
        }
        return true;
    }

    @Override
    public void onBackPressed(){ //Botão BACK padrão do android
        startActivity(new Intent(this, MainActivity.class)); //O efeito ao ser pressionado do botão (no caso abre a activity)
        finishAffinity(); //Método para matar a activity e não deixa-lá indexada na pilhagem
        return;
    }

    private void getEventos() {
        Call<List<Evento>> call = service.getServico().getEventos();
        call.enqueue(new Callback<List<Evento>>() {
            @Override
            public void onResponse(Call<List<Evento>> call, Response<List<Evento>> response) {
                if (response.isSuccessful()) {
                    listaEventos = response.body();
                    Log.d("EVENTO", "onResponse: "+listaEventos.toString());
                    eventoAdapter = new EventoAdapter(CalendariosActivity.this, R.layout.unica_evento, listaEventos);
                    listView.setAdapter(eventoAdapter);
                }
            }
            @Override
            public void onFailure(Call<List<Evento>> call, Throwable t) {
                Log.e("ERROR: ", t.getMessage());
            }
        });
    }

}