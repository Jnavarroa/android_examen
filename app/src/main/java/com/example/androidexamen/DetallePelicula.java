package com.example.androidexamen;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.media.Image;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class DetallePelicula extends AppCompatActivity {

    TextView txtTitutlo, txtInfo;
    ImageView img;
    String titulo = "", url = "", info = "", tituloOriginal = "";
    ProgressDialog dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle_pelicula);
        dialog = ProgressDialog.show(this, getResources().getString(R.string.espere),
                getResources().getString(R.string.solicitando), true);
        Bundle extras = getIntent().getExtras();
        if(extras != null) {
            titulo = extras.getString("titulo");
            url = extras.getString("url");
            info = extras.getString("info");
            tituloOriginal = extras.getString("original");
        }else{
            finish();
        }
        img = (ImageView)findViewById(R.id.imgPelicula);
        Picasso.with(getApplicationContext()).load(url).into(img);
        txtTitutlo = (TextView)findViewById(R.id.txtNombre);
        txtTitutlo.setText(titulo);
        txtInfo = (TextView)findViewById(R.id.txtInfo);
        txtInfo.setText(getResources().getString(R.string.originalTitulo)+"\n"+tituloOriginal+"\n\n"+getResources().getString(R.string.infoPelicula)+"\n"+info);
        dialog.dismiss();
    }
}
