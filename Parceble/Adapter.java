package com.example.parceble;

import android.content.Intent;
import android.graphics.ColorSpace;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class Adapter   extends  RecyclerView.Adapter<Adapter.MyViewHolder> {

    List<Model> models;
    public Adapter(List<Model> list){
        this.models = list;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
       View view= inflater.inflate(R.layout.row,parent,false);

        MyViewHolder myViewHolder = new MyViewHolder(view);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        holder.imageView.setImageResource(models.get(position).getImage());
        holder.t1.setText(models.get(position).getText1());
        holder.t2.setText(models.get(position).getText2());
    }

    @Override
    public int getItemCount() {
        return models.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder{

        ImageView imageView ;
        TextView t1,t2;
        public MyViewHolder(@NonNull final View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.imageView);
            t1 = itemView.findViewById(R.id.textView);
            t2 = itemView.findViewById(R.id.textView2);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    Intent intent =  new Intent(itemView.getContext(),Main2Activity.class);
                    intent.putExtra("ITEM",models.get(getAdapterPosition()));
                    itemView.getContext().startActivity(intent);
                }
            });
        }
    }
}

