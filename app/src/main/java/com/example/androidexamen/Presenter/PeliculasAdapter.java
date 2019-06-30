package com.example.androidexamen.Presenter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.androidexamen.DetallePelicula;
import com.example.androidexamen.Model.Peliculas;
import com.example.androidexamen.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class PeliculasAdapter extends ArrayAdapter<Peliculas> {

    Context context;
    int resource;
    ArrayList<Peliculas> cellList;

    public PeliculasAdapter(Context context, int resource, ArrayList<Peliculas> objects) {
        super(context, resource, objects);
        this.context = context;
        this.resource = resource;
        cellList = objects;
    }

    @Override
    public View getView(final int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View view = null;
        view = LayoutInflater.from(context).inflate(resource, parent, false);
        ImageView img = (ImageView) view.findViewById(R.id.imgCell);
        TextView txtFecha = (TextView) view.findViewById(R.id.txtFecha);
        TextView txtNombre = (TextView) view.findViewById(R.id.txtNombre);
        final Peliculas peli = cellList.get(position);
        txtNombre.setText(peli.getTitle());
        txtFecha.setText(context.getResources().getString(R.string.estreno)+" "+peli.getRelease_date());
        Picasso.with(context.getApplicationContext()).load(context.getResources().getString(R.string.basePathPelicula)+peli.getPoster_path()).into(img);
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent eli = new Intent(getContext(), DetallePelicula.class);
                eli.putExtra("titulo", peli.getTitle());
                eli.putExtra("url", context.getResources().getString(R.string.basePathPelicula)+peli.getPoster_path());
                eli.putExtra("info", peli.getOverview());
                eli.putExtra("original", peli.getOriginal_title());
                context.startActivity(eli);
            }
        });
        return view;
    }
}

