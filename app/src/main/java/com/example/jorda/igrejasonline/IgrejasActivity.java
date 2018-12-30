package com.example.jorda.igrejasonline;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.widget.ListView;

import com.example.jorda.igrejasonline.Adapter.IgrejaAdapter;
import com.example.jorda.igrejasonline.domain.Igreja;
import com.example.jorda.igrejasonline.service.RetrofitService;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class IgrejasActivity extends AppCompatActivity {

    ListView listView;
    RetrofitService service;
    List<Igreja> listaIgrejas = new ArrayList<Igreja>();
    IgrejaAdapter igrejaAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_igrejas);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        listView = findViewById(R.id.listaI);

        getIgrejas();

        getSupportActionBar().setDisplayHomeAsUpEnabled(true); //Mostrar o botão
        getSupportActionBar().setHomeButtonEnabled(true);      //Ativar o botão
        //getSupportActionBar().setTitle("Seu titulo aqui");     //Titulo para ser exibido na sua Action Bar em frente à seta
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

    private void getIgrejas() {
        Call<List<Igreja>> call = service.getServico().getIgrejas();
        call.enqueue(new Callback<List<Igreja>>() {
            @Override
            public void onResponse(Call<List<Igreja>> call, Response<List<Igreja>> response) {
                if (response.isSuccessful()) {
                    listaIgrejas = response.body();
                    igrejaAdapter = new IgrejaAdapter(IgrejasActivity.this, R.layout.unica_igreja, listaIgrejas);
                    listView.setAdapter(igrejaAdapter);
                }
            }
            @Override
            public void onFailure(Call<List<Igreja>> call, Throwable t) {
                Log.e("ERROR: ", t.getMessage());
            }
        });
    }

}
