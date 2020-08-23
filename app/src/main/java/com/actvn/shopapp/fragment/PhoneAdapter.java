package com.actvn.shopapp.fragment;

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
import com.actvn.shopapp.api.model.Phone;
import com.squareup.picasso.Picasso;

import java.text.DecimalFormat;
import java.util.ArrayList;

public class PhoneAdapter extends RecyclerView.Adapter<PhoneAdapter.ViewHolder> {
    private ArrayList<Phone> phoneList;
    private Context context;

    public PhoneAdapter(ArrayList<Phone> phoneList, Context context) {
        this.phoneList = phoneList;
        this.context = context;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_product, null);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        DecimalFormat decimalFormat = new DecimalFormat("###,###,###");
        Phone phone = phoneList.get(position);
        holder.txtTitle.setText(phone.getTitle());
        holder.txtCost.setText((phone.getCost()));
        Picasso.get().load(phone.getImgUrl()).into(holder.imgItem);

    }

    @Override
    public int getItemCount() {
        return phoneList.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imgItem;
        TextView txtTitle;
        TextView txtCost;
        CardView cardView;

        public ViewHolder(View itemView) {
            super(itemView);
            cardView = itemView.findViewById(R.id.cardViewProduct);
            imgItem = itemView.findViewById(R.id.img);
            txtTitle = itemView.findViewById(R.id.txtTitle);
            txtCost = itemView.findViewById(R.id.txtCost);
        }
    }
}
