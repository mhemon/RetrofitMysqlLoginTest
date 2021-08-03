package com.xploreict.retrofitmysqllogintest;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Dassboard extends AppCompatActivity {

    TextView tv;
    Button btn;
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dassboard);
        tv=(TextView)findViewById(R.id.uemail);
        btn=(Button)findViewById(R.id.btnlogout);
        recyclerView = findViewById(R.id.recycler);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        checkuserexistence();
        setuprecycler();


        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences sp=getSharedPreferences("credentials",MODE_PRIVATE);
                sp.edit().remove("username").apply();
                sp.edit().remove("password").apply();
                sp.edit().apply();
                startActivity(new Intent(getApplicationContext(),MainActivity.class));
                finish();
            }
        });

    }

    void setuprecycler(){
        Call<List<fetchdatamodel>> call = controller
                .getInstance()
                .getapi()
                .getdata();
        call.enqueue(new Callback<List<fetchdatamodel>>() {
            @Override
            public void onResponse(Call<List<fetchdatamodel>> call, Response<List<fetchdatamodel>> response) {
                List<fetchdatamodel> data = response.body();
                RecyclerAdapter adapter = new RecyclerAdapter(data);
                recyclerView.setAdapter(adapter);
            }

            @Override
            public void onFailure(Call<List<fetchdatamodel>> call, Throwable t) {
                Toast.makeText(Dassboard.this, t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void checkuserexistence()
    {
        SharedPreferences sp=getSharedPreferences("credentials",MODE_PRIVATE);
        if(sp.contains("username"))
            tv.setText(sp.getString("username",""));
        else
            startActivity(new Intent(getApplicationContext(),MainActivity.class));
    }
}