package com.actvn.shopapp.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.actvn.shopapp.R;
import com.actvn.shopapp.api.model.Laptop;
import com.actvn.shopapp.api.model.Phone;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class LaptopAdapter extends RecyclerView.Adapter<LaptopAdapter.ViewHolder> {
    private ArrayList<Laptop> laptops ;
    private Context context;

    public LaptopAdapter(ArrayList<Laptop> laptops, Context context) {
        this.laptops = laptops;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.parse_item, null);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Laptop laptop = laptops.get(position);
        holder.txtTitle.setText(laptop.getTitle());
        holder.txtCost.setText((laptop.getCost()));
        Picasso.get().load(laptop.getImgUrl()).into(holder.imgItem);
    }



    @Override
    public int getItemCount() {
        return laptops.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imgItem;
        TextView txtTitle;
        TextView txtCost;
        CardView cardView;

        public ViewHolder(View itemView) {
            super(itemView);
            cardView = itemView.findViewById(R.id.cardviewPhone);
            imgItem = itemView.findViewById(R.id.imgItemPhone);
            txtTitle = itemView.findViewById(R.id.txtTitlePhone);
            txtCost = itemView.findViewById(R.id.txtCostPhone);
        }
    }
}
