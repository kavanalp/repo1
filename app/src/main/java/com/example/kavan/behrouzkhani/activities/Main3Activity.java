package com.example.kavan.behrouzkhani.activities;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.kavan.behrouzkhani.R;
import com.example.kavan.behrouzkhani.model.LoginModel;
import com.example.kavan.behrouzkhani.model.Users;
import com.example.kavan.behrouzkhani.retrofit.APIInterface;
import com.example.kavan.behrouzkhani.retrofit.ApiClient;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Main3Activity extends AppCompatActivity {
    int test;
    Intent intent;
    TextView id, name, pass, isLike;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        intent = getIntent();
        init();
        userRequest();


    }

    private void init() {
        test = intent.getIntExtra("id", 0);
        id = findViewById(R.id.textId1);
        name = findViewById(R.id.textUserName1);
        pass = findViewById(R.id.textPassword1);
        isLike = findViewById(R.id.textIsLike1);
    }


    private void userRequest() {
        APIInterface apiInterface = ApiClient.getClient().create(APIInterface.class);
        Call<LoginModel> call = apiInterface.getUser();
        call.enqueue(new Callback<LoginModel>() {
            @Override
            public void onResponse(Call<LoginModel> call, Response<LoginModel> response) {
                if (response.isSuccessful()) {
                    List<Users> users = response.body().getLogin();
                    for (Users user : users) {
                        if (user.getId() == test) {
                            id.setText(String.valueOf(user.getId()));
                            name.setText(user.getName());
                            pass.setText(user.getPass());
                            isLike.setText(String.valueOf(user.getIsLike()));
                            if (test == 5)
                                name.setOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View v) {

                                        startActivity(new Intent(Main3Activity.this, Login.class));
                                    }
                                });
                        }
                    }

                }
            }

            @Override
            public void onFailure(Call<LoginModel> call, Throwable t) {
                Toast.makeText(Main3Activity.this, "Connection failed !", Toast.LENGTH_SHORT).show();

            }
        });
    }

}
