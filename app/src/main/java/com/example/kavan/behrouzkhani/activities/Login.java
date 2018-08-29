package com.example.kavan.behrouzkhani.activities;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.kavan.behrouzkhani.R;
import com.example.kavan.behrouzkhani.model.Users;
import com.example.kavan.behrouzkhani.retrofit.APIInterface;
import com.example.kavan.behrouzkhani.retrofit.ApiClient;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Login extends AppCompatActivity {

    private EditText usernameEditText, passwordEditText;
    private Button loginButton;
    private String username, password;
    private Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        init();
    }

    private void init() {
        intent = new Intent(Login.this, Main2Activity.class);
        usernameEditText = findViewById(R.id.usernameEditText);
        passwordEditText = findViewById(R.id.passEditText);
        loginButton = findViewById(R.id.loginButton);
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                username = usernameEditText.getText().toString();
                password = passwordEditText.getText().toString();
                registerRequest();
                startActivity(intent);
                finish();
            }
        });
    }

    private void registerRequest() {

        APIInterface apiInterface = ApiClient.getClient().create(APIInterface.class);
        Call<Users> call = apiInterface.registerUser(username, password);
        call.enqueue(new Callback<Users>() {
            @Override
            public void onResponse(retrofit2.Call<Users> call, Response<Users> response) {

                if (!username.equals("") && !password.equals("")) {

                    intent.putExtra("text", username);
                    startActivity(intent);
                    finish();
                } else {
                    Toast.makeText(Login.this, "username or password is not valid", Toast.LENGTH_SHORT).show();

                }
            }

            @Override
            public void onFailure(retrofit2.Call<Users> call, Throwable t) {
                Toast.makeText(Login.this, "pleas check your connection", Toast.LENGTH_SHORT).show();

            }
        });
    }
}
