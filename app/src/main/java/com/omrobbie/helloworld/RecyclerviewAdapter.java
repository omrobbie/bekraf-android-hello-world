package com.omrobbie.helloworld;

import android.content.Context;
import android.support.v4.widget.TextViewCompat;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.Collections;
import java.util.List;

public class RecyclerviewAdapter extends RecyclerView.Adapter<RecyclerviewAdapter.ViewHolder> {

    private List<String> mData =  Collections.emptyList();
    private LayoutInflater mInflater;
    private ItemClickListener mClickListener;

    /* FUNGSI DIBAWAH INI WAJIB ADA !! -----------------------------------------------------------*/
    // tempat semua data list disimpan
    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        public TextView textView;

        public ViewHolder(View view) {
            super(view);
            textView = (TextView) view.findViewById(R.id.rvList);
            view.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            if(mClickListener != null) mClickListener.onItemClick(view, getAdapterPosition());

        }
    }

    // override fungsi ViewHolder dan inflate dari layout yang sudah dibuat
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.recyclerview_layout, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    // bind setiap data ke layout
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        String animal = mData.get(position);
        holder.textView.setText(animal);
    }

    // dapatkan jumlah total data
    @Override
    public int getItemCount() {
        return mData.size();
    }
    /*--------------------------------------------------------------------------------------------*/

    // bikin interface untuk dipakai di activity utama
    public interface ItemClickListener {
        void onItemClick(View view, int position);
    }

    // cek jika tombol klik ditekan
    public void setClickListener(ItemClickListener itemClickListener) {
        this.mClickListener = itemClickListener;
    }

    // contructor untuk class ini
    public RecyclerviewAdapter(Context context, List<String> data) {
        this.mInflater = LayoutInflater.from(context);
        this.mData = data;
    }
}