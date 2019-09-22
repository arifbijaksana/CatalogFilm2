package com.arifbm.catalogfilm.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.arifbm.catalogfilm.R;
import com.arifbm.catalogfilm.data.Film;

import java.util.List;

public class FilmAdapter extends RecyclerView.Adapter<FilmAdapter.ViewHolder> {

    private final Context context;
    private List<Film> films;
    private ItemClickListener onItemClickListener;

    public FilmAdapter(Context context, List<Film> films) {

        this.context = context;
        this.films = films;

    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(context).inflate(R.layout.item_film, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Film film = this.films.get(position);
        holder.txtTitle.setText(film.getTitle());
        holder.txtYear.setText(String.valueOf(film.getYear()));
        holder.imgBanner.setImageResource(film.getBanner());
        holder.rating.setRating(film.getRating());
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public int getItemCount() {
        return films.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private TextView txtTitle;
        private TextView txtYear;
        private ImageView imgBanner;
        private RatingBar rating;

        ViewHolder(View view) {
            super(view);
            txtTitle = view.findViewById(R.id.title);
            txtYear = view.findViewById(R.id.year);
            imgBanner = view.findViewById(R.id.banner);
            rating = view.findViewById(R.id.ratingBar);

            view.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            onItemClickListener.onClick(v, getAdapterPosition());
        }
    }

    public void setItemClickListener(ItemClickListener clickListener) {
        onItemClickListener = clickListener;
    }

    public interface ItemClickListener {
        void onClick(View v, int i);
    }


}
