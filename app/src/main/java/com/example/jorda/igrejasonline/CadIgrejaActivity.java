package com.example.jorda.igrejasonline;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.jorda.igrejasonline.domain.Endereco;
import com.example.jorda.igrejasonline.domain.Igreja;
import com.example.jorda.igrejasonline.service.RetrofitService;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CadIgrejaActivity extends AppCompatActivity {

    private RetrofitService retrofitService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cad_igreja);

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


    public void cadastrarIgreja(View view) {
        TextView tempCnpj = findViewById(R.id.cnpj);
        String tcnpj = tempCnpj.getText().toString();
        TextView tempTelefone = findViewById(R.id.telefone);
        String ttelefone = tempTelefone.getText().toString();
        TextView tempNomeIgreja = findViewById(R.id.nomeIgreja);
        String tigreja = tempNomeIgreja.getText().toString();

        Igreja igreja = new Igreja(null, tcnpj, ttelefone, tigreja);

        Call call = retrofitService.getServico().cadastrarIgreja(igreja);
        call.enqueue(new Callback<Igreja>() {
            @Override
            public void onResponse(Call<Igreja> call, Response<Igreja> response) {
                Log.i("teste","Entrou Post!");
                Intent i = new Intent(CadIgrejaActivity.this, MainActivity.class);
                startActivity(i);
            }

            @Override
            public void onFailure(Call<Igreja> call, Throwable t) {
                Toast.makeText(CadIgrejaActivity.this, t.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void voltarInicio(View view) {
        //setContentView(R.layout.activity_main);
        startActivity(new Intent(this, MainActivity.class));  //O efeito ao ser pressionado do botão (no caso abre a activity)
        finishAffinity();  //Método para matar a activity e não deixa-lá indexada na pilhagem
    }
}
/*
{
	"cnpj"     : "06164253000000",
	"telefone" : "3432565000",
	"nome"     : "Igreja do Teste Sagrado",
    "endereco" : {"id" : 4}

    '{"id" : 4}'
}
*/
