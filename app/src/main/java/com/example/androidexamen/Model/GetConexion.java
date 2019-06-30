package com.example.androidexamen.Model;

import android.app.ProgressDialog;
import android.content.Context;
import android.util.Log;
import android.widget.ListView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.androidexamen.Presenter.PeliculasAdapter;
import com.example.androidexamen.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import java.util.ArrayList;
import java.util.Vector;

public class GetConexion {

    private PeliculasAdapter adapter;

    private ArrayList pedirconexion(final String url, final Context context, final ListView lvPeliculas, final ProgressDialog dialog){
        final ArrayList<Peliculas> pelis = new ArrayList<Peliculas>();
        RequestQueue queue = Volley.newRequestQueue(context);
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONObject jObject = new JSONObject(response);
                            JSONArray jArray = jObject.getJSONArray("results");
                            for (int i=0; i <20; i++) {
                                try {
                                    JSONObject objeto = jArray.getJSONObject(i);
                                    String title = objeto.getString("title");
                                    String poster_path = objeto.getString("poster_path");
                                    String original_language = objeto.getString("original_language");
                                    String original_title = objeto.getString("original_title");
                                    String backdrop_path = objeto.getString("backdrop_path");
                                    String overview = objeto.getString("overview");
                                    String release_date = objeto.getString("release_date");
                                    Boolean video = objeto.getBoolean("video");
                                    Boolean adult = objeto.getBoolean("adult");
                                    Integer id = objeto.getInt("id");
                                    Integer vote_count = objeto.getInt("vote_count");
                                    Double vote_average = objeto.getDouble("vote_average");
                                    Double popularity = objeto.getDouble("popularity");
                                    Vector<Integer> genreE = new Vector<Integer>();
                                    String genre = objeto.getString("genre_ids");
                                    genre = genre.replace("[", "").replace("]", "");
                                    String[] genreArray = genre.split(",");
                                    for (int a = 0; a < genreArray.length; a++){
                                        try{
                                            genreE.add(Integer.parseInt(genreArray[a]));
                                        }catch(Exception exc){
                                            Log.e("debug", "error JSON: \"" + exc.getMessage() + "\"");
                                            genreE.add(0);
                                        }
                                    }

                                    Peliculas peliG = new Peliculas(title, poster_path,original_language,original_title,backdrop_path,overview,release_date,video,adult,id,vote_count,vote_average,popularity,genreE);
                                    pelis.add(peliG);
                                    dialog.dismiss();
                                } catch (JSONException e) {
                                    Log.e("debug", "error JSON: \"" + e.getMessage() + "\"");
                                }
                            }
                            adapter = new PeliculasAdapter(context.getApplicationContext(), R.layout.cell_layout_peliculas, pelis);
                            lvPeliculas.setAdapter(adapter);
                        } catch (Throwable t) {
                            Log.e("debug", "error JSON: \"" + t.getMessage() + "\"");
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.d("debug", error.getMessage());
            }
        });
        queue.add(stringRequest);
        return pelis;
    }

    public void consultaServerPublic(String url, Context context, ListView lvPeliculas, ProgressDialog dialog){
        pedirconexion(url, context, lvPeliculas, dialog);
    }

}
