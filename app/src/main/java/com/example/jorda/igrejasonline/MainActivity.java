package com.example.jorda.igrejasonline;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private DrawerLayout dl;
    private ActionBarDrawerToggle t;
    private NavigationView nv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dl = (DrawerLayout) findViewById(R.id.activity_main);
        t = new ActionBarDrawerToggle(this, dl, R.string.abrir, R.string.fechar);

        dl.addDrawerListener(t);
        t.syncState();

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        nv = (NavigationView) findViewById(R.id.nv);
        nv.setNavigationItemSelectedListener(this);

        final ImageView botaoIgrejas = findViewById(R.id.imigreja);
        final ImageView botaoEventos = findViewById(R.id.imagenda);
//        final ImageView botaoCalendario = findViewById(R.id.imcalendario);

        botaoIgrejas.setOnClickListener(new View.OnClickListener()   {
            public void onClick(View v)  {
                try {
                    Toast.makeText(getApplicationContext(), "Igrejas", Toast.LENGTH_SHORT).show();
                    // abrindo um nova activity [ Tela de listar igrejas ]
                    Intent intentIgrejas = new Intent(getApplicationContext(), IgrejasActivity.class);
                    startActivity(intentIgrejas);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

        botaoEventos.setOnClickListener(new View.OnClickListener()   {
            public void onClick(View v)  {
                try {
                    Toast.makeText(getApplicationContext(), "Agenda", Toast.LENGTH_SHORT).show();
                    // abrindo um nova activity [ Tela de listar Eventos ]
                    Intent intentEventos = new Intent(getApplicationContext(), EventosActivity.class);
                    startActivity(intentEventos);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

/*        botaoCalendario.setOnClickListener(new View.OnClickListener()   {
            public void onClick(View v)  {
                try {
                    Toast.makeText(getApplicationContext(), "Calendário", Toast.LENGTH_SHORT).show();
                    // abrindo um nova activity [ Tela de listar Calendario ]
                    Intent intentCalendarios = new Intent(getApplicationContext(), CalendariosActivity.class);
                    startActivity(intentCalendarios);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });*/

    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (t.onOptionsItemSelected(item))
            return true;
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        int id = menuItem.getItemId();
        switch (id) {
            case R.id.confCadIgreja:
                Toast.makeText(MainActivity.this, "Cadastrar Igrejas", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(MainActivity.this,CadIgrejaActivity.class));
                break;
            case R.id.confEdIgreja:
                Toast.makeText(MainActivity.this, "Editar Igrejas", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(MainActivity.this,EdIgrejaActivity.class));
                break;
            case R.id.confExIgreja:
                Toast.makeText(MainActivity.this, "Apagar Igrejas", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(MainActivity.this,ExIgrejaActivity.class));
                break;
            case R.id.confCadEvento:
                Toast.makeText(MainActivity.this, "Cadastrar Eventos", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(MainActivity.this,CadEventoActivity.class));
                break;
            case R.id.confEdEvento:
                Toast.makeText(MainActivity.this, "Editar Eventos", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(MainActivity.this,EdEventoActivity.class));
                break;
            case R.id.confExEvento:
                Toast.makeText(MainActivity.this, "Apagar Eventos", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(MainActivity.this,ExEventoActivity.class));
                break;
            /*case R.id.configConta:
                Toast.makeText(MainActivity.this, "Usuários", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(MainActivity.this,CadUsuarioActivity.class));
                break;*/
            /*case R.id.configCalendario:
                Toast.makeText(MainActivity.this, "Celendário", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(MainActivity.this,CadEventoActivity.class));
                break;*/
            /*case R.id.confCadEntidade:
                Toast.makeText(MainActivity.this, "Entidades", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(MainActivity.this,CadEntidadeActivity.class));
                break;*/
            /*case R.id.confCadEdereco:
                Toast.makeText(MainActivity.this, "Cadastro de Endereço", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(MainActivity.this,CadEnderecoActivity.class));
                break;*/
            default:
                return true;
        }
        return false;
    }
}

