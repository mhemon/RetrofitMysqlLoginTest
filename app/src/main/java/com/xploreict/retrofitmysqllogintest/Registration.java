package com.xploreict.retrofitmysqllogintest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class Registration extends AppCompatActivity {

    EditText e1,e2,e3;
    Button uploadbtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

        e1 = findViewById(R.id.e1);
        e2 = findViewById(R.id.e2);
        e3 = findViewById(R.id.e3);
        uploadbtn = findViewById(R.id.uploadbtn);

        uploadbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                processregi();
            }
        });

    }

    void processregi(){
        String username=e1.getText().toString();
        String password=e2.getText().toString();
        String email=e3.getText().toString();

        Call<reg_model> call = controller
                .getInstance()
                .getapi()
                .reguser(username,password,email);

        call.enqueue(new Callback<reg_model>() {
            @Override
            public void onResponse(Call<reg_model> call, Response<reg_model> response) {
                e1.setText("");
                e2.setText("");
                e3.setText("");
                Toast.makeText(Registration.this, response.message(), Toast.LENGTH_SHORT).show();
                SharedPreferences sp=getSharedPreferences("credentials",MODE_PRIVATE);
                SharedPreferences.Editor editor=sp.edit();
                editor.putString("username",e1.getText().toString());
                editor.putString("password",e2.getText().toString());
                editor.putString("email",e3.getText().toString());
                editor.commit();
                editor.apply();

                startActivity(new Intent(getApplicationContext(),Dassboard.class));
                finish();
            }

            @Override
            public void onFailure(Call<reg_model> call, Throwable t) {

            }
        });
    }
}