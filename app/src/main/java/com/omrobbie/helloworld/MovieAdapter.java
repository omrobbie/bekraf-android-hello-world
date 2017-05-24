package com.omrobbie.helloworld;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.ViewHolder> {

    private ArrayList<HashMap<String, String>> mData = new ArrayList<>();
    private LayoutInflater mInflater;
    private ItemClickListener mClickListener;

    /* FUNGSI DIBAWAH INI WAJIB ADA !! -----------------------------------------------------------*/
    // tempat semua data list disimpan
    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        public ImageView movieImg;
        public TextView movieTitle;
        public TextView movieDescription;

        public ViewHolder(View view) {
            super(view);
            movieImg = (ImageView) view.findViewById(R.id.movieImg);
            movieTitle = (TextView) view.findViewById(R.id.movieTitle);
            movieDescription = (TextView) view.findViewById(R.id.movieDescription);
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
        View view = mInflater.inflate(R.layout.movie_listitem, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    // bind setiap data ke layout
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        HashMap<String, String> item = mData.get(position);
        holder.movieTitle.setText(item.get("title"));
        holder.movieDescription.setText(item.get("overview"));
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
    public MovieAdapter(Context context, ArrayList<HashMap<String, String>> data) {
        this.mInflater = LayoutInflater.from(context);
        this.mData = data;
    }

    // dapatkan data per klik
    public String getItem(int id) {
        HashMap<String,String> item = mData.get(id);
        return item.get("title");
    }
}