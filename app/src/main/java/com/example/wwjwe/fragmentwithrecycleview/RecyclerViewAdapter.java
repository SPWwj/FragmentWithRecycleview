package com.example.wwjwe.fragmentwithrecycleview;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder> {

    Context mContext;
    List<Contact> mData;
    Dialog myDialog;
    public RecyclerViewAdapter(Context mContext, List<Contact> mData) {
        this.mContext = mContext;
        this.mData = mData;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        View v;
        v=LayoutInflater.from(mContext).inflate(R.layout.item_contact,viewGroup,false);
        final MyViewHolder viewHolder = new MyViewHolder(v);



        viewHolder.itemContact.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Toast.makeText(mContext,"Test Click"+ String.valueOf(viewHolder.getAdapterPosition()),Toast.LENGTH_SHORT).show();


                //Dialog init
                myDialog = new Dialog(mContext);
                myDialog.setContentView(R.layout.dialog_contact);
                myDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                TextView tvDialogName=myDialog.findViewById(R.id.tvDialogName);
                TextView tvDialogPhoto=myDialog.findViewById(R.id.tvDialogPhone);
                ImageView ivDialog=myDialog.findViewById(R.id.ivDialog);
                tvDialogName.setText(mData.get(viewHolder.getAdapterPosition()).getName());
                tvDialogPhoto.setText(mData.get(viewHolder.getAdapterPosition()).getPhone());
                ivDialog.setImageResource(mData.get(viewHolder.getAdapterPosition()).getPhoto());
                myDialog.show();
            }
        });
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, int i) {
        myViewHolder.tvName.setText(mData.get(i).getName());
        myViewHolder.tvPhone.setText(mData.get(i).getPhone());
        myViewHolder.ivContact.setImageResource(mData.get(i).getPhoto());
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public  static class MyViewHolder extends RecyclerView.ViewHolder{
        private LinearLayout itemContact;
        private TextView tvName;
        private TextView tvPhone;
        private ImageView ivContact;
        public MyViewHolder(View itemView){
            super(itemView);
            itemContact=itemView.findViewById(R.id.itemContact);
            tvName = itemView.findViewById(R.id.tvName);
            tvPhone=itemView.findViewById(R.id.tvPhoneNumber);
            ivContact=itemView.findViewById(R.id.ivContact);
        }
    }
}
