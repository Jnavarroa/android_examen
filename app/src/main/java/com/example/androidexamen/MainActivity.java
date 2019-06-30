package com.example.androidexamen;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.CompoundButton;
import android.widget.ListView;
import android.widget.Switch;
import android.widget.Toast;

import com.example.androidexamen.Model.Peliculas;
import com.example.androidexamen.Presenter.MainPresenter;
import com.example.androidexamen.Presenter.PeliculasAdapter;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private MainPresenter mainPresenter = new MainPresenter();
    private Switch swFiltro;
    private ListView lvPeliculas;
    ProgressDialog dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        dialog = ProgressDialog.show(this, getResources().getString(R.string.espere),
                getResources().getString(R.string.solicitando), true);
        lvPeliculas = (ListView)findViewById(R.id.lvListadoPeliculas);
        swFiltro = (Switch)findViewById(R.id.swFiltro);
        swFiltro.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(b){
                    mainPresenter.solicitarDatos("https://api.themoviedb.org/3/movie/top_rated?api_key=34738023d27013e6d1b995443764da44", getApplicationContext(), lvPeliculas, dialog);
                }else{
                    mainPresenter.solicitarDatos("https://api.themoviedb.org/3/movie/popular?api_key=34738023d27013e6d1b995443764da44", getApplicationContext(), lvPeliculas, dialog);
                }
            }
        });
        mainPresenter.solicitarDatos("https://api.themoviedb.org/3/movie/popular?api_key=34738023d27013e6d1b995443764da44", getApplicationContext(), lvPeliculas, dialog);
    }


}
