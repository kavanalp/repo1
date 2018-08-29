package com.example.kavan.behrouzkhani.RecyclerView;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.kavan.behrouzkhani.R;
import com.example.kavan.behrouzkhani.activities.Main3Activity;

import java.util.List;

public class Adapter extends RecyclerView.Adapter<Adapter.MyViewHolder> {
    Context context;
    List<ItemClass> users;

    public Adapter(Context context, List<ItemClass> users) {
        this.context = context;
        this.users = users;
    }


    @NonNull
    @Override
    public Adapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        return new Adapter.MyViewHolder(LayoutInflater.from(context).inflate(R.layout.items , parent ,false));

    }

    @Override
    public void onBindViewHolder(@NonNull Adapter.MyViewHolder holder, @SuppressLint("RecyclerView") final int position) {
        holder.id.setText(String.valueOf(users.get(position).getId()));
        holder.username.setText(String.valueOf(users.get(position).getUsername()));
        holder.password.setText(users.get(position).getPassword());
        holder.isLike.setText(String.valueOf(users.get(position).getIsLike()));
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context , Main3Activity.class);
                intent.putExtra("id",users.get(position).getId());
                context.startActivity(intent);


            }
        });
    }


    @Override
    public int getItemCount() {
        return users.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {
        private TextView id;
        private TextView username;
        private TextView password;
        private TextView isLike;

        public MyViewHolder(View itemView) {
            super(itemView);
            id = itemView.findViewById(R.id.textId);
            username = itemView.findViewById(R.id.textUserName);
            password = itemView.findViewById(R.id.textPassword);
            isLike = itemView.findViewById(R.id.textIsLike);
        }
    }
}
