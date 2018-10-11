package com.example.joel.studentportal;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder> {
    private Context context;
    private List<Link> NewUrlList;

    public Adapter(Context context, List<Link> NewUrlList){
        this.context = context;
        this.NewUrlList = NewUrlList;
    }

    @NonNull
    @Override
    public Adapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.view, parent, false);
        return new Adapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Adapter.ViewHolder holder,int position) {
        final Link link = NewUrlList.get(position);
        System.out.println("ONBINDVIEWHOLDER" + link.getTitle() + link.getUrl());
        holder.urlTitle.setText(link.getTitle());
        holder.urlTitle.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, ShowActivity.class);
                intent.putExtra("showUrl", link.getUrl());
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return NewUrlList.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder {
        // each data item is just a string in this case
        public TextView urlTitle;

        public ViewHolder(@NonNull View view) {
            super(view);
            urlTitle = view.findViewById(R.id.pageTitle);
        }
    }

}
