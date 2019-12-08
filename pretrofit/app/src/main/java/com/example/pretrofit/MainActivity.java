package com.example.pretrofit;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    Pokeadapter pokeadapter;
    ArrayList<Pokemon_>  pokearray;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
       //pokearray=new ArrayList<>();

        Dataservice service =Retrofitclint.getRetrofitInstance().create(Dataservice.class);
        Call<Pokemon> call=service.getPokemons();
        call.enqueue(new Callback<Pokemon>() {
            @Override
            public void onResponse(Call<Pokemon> call, Response<Pokemon> response) {
                Pokemon p = response.body();
                try {
                       // p.getPokemon();
                pokearray = new ArrayList<>(p.getPokemon());
                  generateRecycle(pokearray);
                }
                catch (NullPointerException e)
                {
                   System.out.println(e.getMessage());
                }

            }

            @Override
            public void onFailure(Call<Pokemon> call, Throwable t) {
                Toast.makeText(getApplicationContext(),"something went wrong!"+t.getMessage(),Toast.LENGTH_LONG).show();
            }
        });
       // System.out.println("Array List size"+pokearray.size());
    }
    public void generateRecycle(ArrayList<Pokemon_> pkarray)
    {
        pokeadapter=new Pokeadapter(pkarray,getApplicationContext());
        LinearLayoutManager manager=new LinearLayoutManager(getApplicationContext(),LinearLayoutManager.VERTICAL,false);
        RecyclerView recyclerView=findViewById(R.id.recycle_poke);
        recyclerView.setLayoutManager(manager);
        recyclerView.setAdapter(pokeadapter);
    }
}
