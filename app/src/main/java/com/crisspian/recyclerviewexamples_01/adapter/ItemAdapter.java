package com.crisspian.recyclerviewexamples_01.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.crisspian.recyclerviewexamples_01.databinding.ItemListDataBinding;
import com.crisspian.recyclerviewexamples_01.model.Item;

import java.util.List;

public class ItemAdapter extends RecyclerView.Adapter<ItemAdapter.ItemViewHolder> {

    private List<Item> itemList;
    private PassElementSelected mListener;

 public ItemAdapter(List<Item> itemList, PassElementSelected mElementSelected){
     this.itemList = itemList;
     this.mListener = mElementSelected;
 }

    @NonNull
    @Override
    public ItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemListDataBinding mBinding = ItemListDataBinding.inflate(LayoutInflater.from(parent.getContext()),parent,false);
        return new ItemViewHolder(mBinding);

    }

    @Override
    public void onBindViewHolder(@NonNull ItemViewHolder holder, int position) {
    Item item = itemList.get(position);
    holder.tv.setText(item.getItemDescription());
        Glide.with(holder.itemView.getContext()).load(item.getUrlImage()).into(holder.img); //Implemtacion de Glide con la imagen

    }

    @Override
    public int getItemCount() {
        return itemList.size();
    }


    public class  ItemViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

     private ImageView img;
     private TextView tv;

     public ItemViewHolder(@NonNull ItemListDataBinding mBinding) {
           super(mBinding.getRoot());
           img = mBinding.ivItem;
           tv = mBinding.tvItem;
           itemView.setOnClickListener(this);
     }

       @Override
       public void onClick(View view) {
        int position = getLayoutPosition();
        Item element = itemList.get(position);
        mListener.passElement(element);
       }
   }


    public interface PassElementSelected {
        void passElement(Item item);

    }

}


