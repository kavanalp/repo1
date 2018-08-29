package com.example.kavan.behrouzkhani.activities;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Toast;

import com.example.kavan.behrouzkhani.R;
import com.example.kavan.behrouzkhani.RecyclerView.Adapter;
import com.example.kavan.behrouzkhani.RecyclerView.ItemClass;
import com.example.kavan.behrouzkhani.model.LoginModel;
import com.example.kavan.behrouzkhani.model.Users;
import com.example.kavan.behrouzkhani.retrofit.APIInterface;
import com.example.kavan.behrouzkhani.retrofit.ApiClient;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView ;
    private List<ItemClass> myList = new ArrayList<ItemClass>();
    private ItemClass iClass ;
    Adapter adapter ;
    Toolbar toolbar;
    FloatingActionButton fab;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initializer();
        userRequest();

    }

    private void initializer() {
        toolbar  = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        recyclerView = findViewById(R.id.recycler);
        adapter = new Adapter(this , myList);
        RecyclerView.LayoutManager manager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(manager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(adapter);
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
                        iClass = new ItemClass(user.getId(),user.getName(),user.getPass(),user.getIsLike());
                        myList.add(iClass);
                    }
                    adapter.notifyDataSetChanged();
                }
            }

            @Override
            public void onFailure(Call<LoginModel> call, Throwable t) {
                Toast.makeText(MainActivity.this, "Connection failed !", Toast.LENGTH_SHORT).show();

            }
        });
    }



}

