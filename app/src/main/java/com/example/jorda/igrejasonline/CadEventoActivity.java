package com.example.jorda.igrejasonline;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class CadEventoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_evento_cad);
    }

    public void CadEndereco(View view) {
        setContentView(R.layout.activity_cad_endereco);
    }

    public void voltarInicio(View view) {
        setContentView(R.layout.activity_main);
    }
}
