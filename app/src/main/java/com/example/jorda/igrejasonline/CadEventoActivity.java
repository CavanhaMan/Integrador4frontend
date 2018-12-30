package com.example.jorda.igrejasonline;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.jorda.igrejasonline.domain.Evento;
import com.example.jorda.igrejasonline.domain.Igreja;
import com.example.jorda.igrejasonline.service.RetrofitService;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CadEventoActivity extends AppCompatActivity {

    private RetrofitService retrofitService;

    /*String[] opcoessp = {"Não","Semanalmente","Quinzenalmente","Mensalmente","Bimestralmente","Semestralmente","Anualmente"};*/

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_evento_cad);

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

    public void cadastrarEvento(View view) {
        TextView temptitulo = findViewById(R.id.titulo);
        String ttitulo = temptitulo.getText().toString();
        TextView tempdatainicio = findViewById(R.id.dataInicio);
        String tdatainicio = tempdatainicio.getText().toString();
        TextView temphorainicio = findViewById(R.id.horaInicio);
        String thorainicio = temphorainicio.getText().toString();
        TextView tempdatatermino = findViewById(R.id.dataTermino);
        String tdatatermino = tempdatatermino.getText().toString();
        TextView temphoratermino = findViewById(R.id.horaTermino);
        String thoratermino = temphoratermino.getText().toString();
        TextView tempdescricao = findViewById(R.id.descricao);
        String tdescricao = tempdescricao.getText().toString();
        TextView temppublico = findViewById(R.id.publico);
        String tpublico = temppublico.getText().toString();


        Evento evento = new Evento(null,ttitulo, tdatainicio, thorainicio, tdatatermino, thoratermino, tdescricao, tpublico);

        Call call = retrofitService.getServico().cadastrarEvento(evento);
        call.enqueue(new Callback<Evento>() {
            @Override
            public void onResponse(Call<Evento> call, Response<Evento> response) {
                Log.i("teste","Entrou Post!");
                Intent i = new Intent(CadEventoActivity.this, MainActivity.class);
                startActivity(i);
            }

            @Override
            public void onFailure(Call<Evento> call, Throwable t) {
                Toast.makeText(CadEventoActivity.this, t.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void CadEndereco(View view) {
        setContentView(R.layout.activity_cad_endereco);
    }

    public void voltarInicio(View view) {
        //setContentView(R.layout.activity_main);
        startActivity(new Intent(this, MainActivity.class));  //O efeito ao ser pressionado do botão (no caso abre a activity)
        finishAffinity();  //Método para matar a activity e não deixa-lá indexada na pilhagem
    }
}
