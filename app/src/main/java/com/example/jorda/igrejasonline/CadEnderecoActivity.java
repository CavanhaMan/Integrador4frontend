package com.example.jorda.igrejasonline;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;
import android.os.AsyncTask;

import com.example.jorda.igrejasonline.model.CEP;
import com.example.jorda.igrejasonline.model.ModeloEstado;
import com.example.jorda.igrejasonline.service.RetrofitService;

import com.example.jorda.igrejasonline.db.DB;
import com.example.jorda.igrejasonline.library.HTTPDataHandler;
import com.example.jorda.igrejasonline.model.CEP;

import org.json.JSONException;
import org.json.JSONObject;


import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CadEnderecoActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    String cepEntrada = "";
    String urlapi = "";

    ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        consultaEstados();

        setContentView(R.layout.activity_cad_endereco);

        final Button btnBuscarCEP = (Button) findViewById(R.id.btnBuscarCEP);
        final EditText editTextCep = (EditText) findViewById(R.id.edtCep);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true); //Mostrar o botão
        getSupportActionBar().setHomeButtonEnabled(true);      //Ativar o botão
        //getSupportActionBar().setTitle("Seu titulo aqui");     //Titulo para ser exibido na sua Action Bar em frente à seta

        btnBuscarCEP.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!TemConexao()){
                    CEP cep = new CEP();
                    cepEntrada = editTextCep.getText().toString();
                    editTextCep.setText("");
                    urlapi = "https://viacep.com.br/ws/" + cepEntrada + "/json/";
                    if(cepEntrada.length() == 8){
                        progressDialog =ProgressDialog.show(CadEnderecoActivity.this, "Caregando . . . ","", true);
                        progressDialog.setCancelable(true);
                        new BuscaCep().execute(urlapi);
                    }else{
                        Toast.makeText(getApplicationContext(), "Por favor informe um CEP válido.", Toast.LENGTH_LONG).show();
                    }
                }else{
                    Toast.makeText(getApplicationContext(), "Por favor verifique a conectividade de seu dispositivo.", Toast.LENGTH_LONG).show();
                }
            }
        });

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


    private void consultaEstados() {
        Call<List<ModeloEstado>> call = RetrofitService.getServico().consulta();
        call.enqueue(new Callback<List<ModeloEstado>>() {
            @Override
            public void onResponse(Call<List<ModeloEstado>> call, Response<List<ModeloEstado>> response) {
                List<ModeloEstado> listaEstados = response.body();
                List<String> listaUf = new ArrayList<String>();
                for (ModeloEstado e : listaEstados) {
                    listaUf.add(e.getUf());
                }
                setContentView(R.layout.activity_cad_endereco);
                Button btnCep = (Button) findViewById(R.id.btnBuscarCEP);
                btnCep.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(getApplicationContext(), BuscaCep.class);
                        startActivity(intent);
                    }
                });
                Spinner spinner = findViewById(R.id.estado);
                spinner.setOnItemSelectedListener(CadEnderecoActivity.this);
                ArrayAdapter<String> adapter = new ArrayAdapter<String>(CadEnderecoActivity.this, R.layout.spinner_item, listaUf);
                /*adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);*/

                spinner.setAdapter(adapter);
                //spinner.setOnItemSelectedListener();
            }

            @Override
            public void onFailure(Call<List<ModeloEstado>> call, Throwable t) {

            }
        });
    }

    public void voltarInicio(View view) {
        //voltar a tela principal
        //setContentView(R.layout.activity_main);
        startActivity(new Intent(this, MainActivity.class));  //O efeito ao ser pressionado do botão (no caso abre a activity)
        finishAffinity();  //Método para matar a activity e não deixa-lá indexada na pilhagem
    }

    public void concluir(View view) {
        //salvar no banco de dados e voltar para a tela inicial
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    private boolean TemConexao() {
        boolean lblnRet = false;
        try
        {
            ConnectivityManager cm = (ConnectivityManager)
                    getSystemService(Context.CONNECTIVITY_SERVICE);
            if (cm.getActiveNetworkInfo() != null && cm.getActiveNetworkInfo().isAvailable() && cm.getActiveNetworkInfo().isConnected()) {
                lblnRet = true;
            } else {
                lblnRet = false;
            }
        }catch (Exception e) {

        }
        return lblnRet;
    }

}
