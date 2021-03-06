package com.example.sipm;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.example.sipm.adapters.ArticulosViewAdapter;
import com.example.sipm.entities.Articulos;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import org.json.JSONArray;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RequestQueue queue;
    private String url;

    private RecyclerView recyclerView;
    private ArticulosViewAdapter articulosViewAdapter;
    private RecyclerView.LayoutManager layoutManager;
    private ArrayList<Articulos> articulos = new ArrayList<Articulos>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        url = getResources().getString(R.string.host_name);

        queue = Volley.newRequestQueue(this);
        buildRecycleView();

        getMethod(url +"/sipm/articulo");
        Log.d("LOGCAT", "->"  +Integer.toString(articulos.size())  );
    }

    public void getMethod(String url){
        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(url, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {

                Gson gson = new GsonBuilder().create();
                Type listType = new TypeToken<ArrayList<Articulos>>(){}.getType();
                List<Articulos> yourClassList = new Gson().fromJson(response.toString(), listType);

                for(Articulos n : yourClassList){
                    Log.i("LOGCAT", String.valueOf(n.getArt_id()));
                    articulos.add(n);
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
            }
        });
        queue.add(jsonArrayRequest);
    }

    public void buildRecycleView(){
        recyclerView = (RecyclerView)findViewById(R.id.recicler);
        recyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(this);
        articulosViewAdapter = new ArticulosViewAdapter(articulos);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(articulosViewAdapter);

        articulosViewAdapter.setOnItemClickListener(new ArticulosViewAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
                articulos.get(position);
                Intent intent = new Intent(MainActivity.this, DES.class);


                intent.putExtra("Articulos", articulos.get(position));


                startActivity(intent);
            }
        });
    }

}
