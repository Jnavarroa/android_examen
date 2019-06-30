package com.example.androidexamen.Presenter;

import android.app.ProgressDialog;
import android.content.Context;
import android.widget.ListView;
import com.example.androidexamen.Model.GetConexion;

public class MainPresenter{

    private GetConexion conexion = new GetConexion();

    public void solicitarDatos(String url, final Context context, ListView lvPeliculas, ProgressDialog dialog) {
        conexion.consultaServerPublic(url, context, lvPeliculas, dialog);
    }

}
