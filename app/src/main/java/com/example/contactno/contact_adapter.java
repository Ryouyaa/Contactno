package com.example.contactno;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class contact_adapter extends RecyclerView.Adapter <contact_adapter.contactViewHolder> {
    private ArrayList<contacts_item> mContactList;

    public static class contactViewHolder extends RecyclerView.ViewHolder {
        public TextView mtextView1;
        public TextView mtextView2;


        public contactViewHolder(@NonNull View itemView) {
            super(itemView);
            mtextView1 = itemView.findViewById(R.id.nama);
            mtextView2 = itemView.findViewById(R.id.nomor);
        }
    }

    public contact_adapter (ArrayList<contacts_item> contactList) {
        mContactList = contactList;
    }

    @NonNull
    @Override
    public contactViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.contacts_item, parent, false);
        contactViewHolder cvh = new contactViewHolder(v);
        return cvh;
    }

    @Override
    public void onBindViewHolder(@NonNull contactViewHolder holder, int position) {
        contacts_item currentItem = mContactList.get(position);

        holder.mtextView1.setText(currentItem.getNama());
        holder.mtextView2.setText(currentItem.getNomor());
    }

    @Override
    public int getItemCount() {
        return mContactList.size();
    }
}
