package com.example.jorda.igrejasonline;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.jorda.igrejasonline.db.DB;
import com.example.jorda.igrejasonline.model.CEP;

/**
 * Created by Digitador01 on 21/11/2015.
 */
public class Detalhes extends AppCompatActivity {

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cad_endereco);

        Intent intent = getIntent();

        EditText txtCep = (EditText) findViewById(R.id.edtCep);
        EditText txtLogradouro = (EditText) findViewById(R.id.logradouro);
        EditText txtComplemento = (EditText) findViewById(R.id.complemento);
        EditText txtBairro = (EditText) findViewById(R.id.bairro);
        EditText txtLocalidade = (EditText) findViewById(R.id.cidade);
        Spinner spEstado = (Spinner) findViewById(R.id.estado);

        if(intent != null){
            Bundle paramns = intent.getExtras();
            String itemId = paramns.getString("itemId");

            if(paramns != null){
                DB db = new DB(Detalhes.this);
                
                CEP cep = db.getSingleCep(Integer.parseInt(itemId));
                txtCep.setText(cep.getCep());
                txtLogradouro.setText(cep.getLogradouro());
                txtComplemento.setText(cep.getComplemento());
                txtBairro.setText(cep.getBairro());
                txtLocalidade.setText(cep.getLocalidade());
                spEstado.setSelection(((ArrayAdapter<String>)spEstado.getAdapter()).getPosition(cep.getUf()));
            }
        }

    }
}
