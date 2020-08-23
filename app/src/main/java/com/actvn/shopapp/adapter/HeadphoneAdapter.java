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
import com.actvn.shopapp.api.model.Headphone;
import com.actvn.shopapp.api.model.Tablet;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class HeadphoneAdapter extends RecyclerView.Adapter<HeadphoneAdapter.ViewHolder> {
    private ArrayList<Headphone> headphones;
    private Context context;

    public HeadphoneAdapter(ArrayList<Headphone> headphones, Context context) {
        this.headphones = headphones;
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
        Headphone headphone = headphones.get(position);
        holder.txtTitle.setText(headphone.getTitle());
        holder.txtCost.setText((headphone.getCost()));
        Picasso.get().load(headphone.getImgUrl()).into(holder.imgItem);
    }


    @Override
    public int getItemCount() {
        return headphones.size();
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
