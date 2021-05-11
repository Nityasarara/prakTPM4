package com.nityasa.guppy;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

public class GuppyAdapter extends RecyclerView.Adapter<GuppyAdapter.ViewHolder>{
    private ArrayList<GuppyModel> listGuppy;
    private Context context;

    public GuppyAdapter(ArrayList<GuppyModel> dataList, Context context) {
        this.listGuppy = dataList;
        this.context = context;
    }

    @NonNull @Override
    public ViewHolder onCreateViewHolder(@NotNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.item_list, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        String image        = listGuppy.get(position).getImage();
        String name         = listGuppy.get(position).getName();
        String price        = listGuppy.get(position).getPrice();
        String description  = listGuppy.get(position).getDescription();

        Glide.with(holder.itemView.getContext())
                .load(listGuppy.get(position).getImage())
                .into(holder.image);

        holder.name.setText(name);
        holder.price.setText(price);
        holder.description.setText(description);

        holder.btnPreview.setOnClickListener(v -> {
            Intent i = new Intent(context, DetailGuppyActivity.class);
            i.putExtra("IMAGE_KEY", image);
            i.putExtra("NAME_KEY", name);
            i.putExtra("PRICE_KEY", price);
            i.putExtra("DESCRIPTION_KEY", description);
            context.startActivity(i);
        });
    }

    @Override
    public int getItemCount() {
        return (listGuppy != null) ? listGuppy.size() : 0;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        private final ImageView image;
        private final TextView name, price, description;
        private final Button btnPreview;

        public ViewHolder(View itemView) {
            super(itemView);
            image           = itemView.findViewById(R.id.image);
            name            = itemView.findViewById(R.id.name);
            price           = itemView.findViewById(R.id.price);
            description     = itemView.findViewById(R.id.description);
            btnPreview      = itemView.findViewById(R.id.btnPreview);
        }
    }
}
