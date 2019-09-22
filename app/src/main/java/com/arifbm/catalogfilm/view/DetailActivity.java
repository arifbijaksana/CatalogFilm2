package com.arifbm.catalogfilm.view;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.arifbm.catalogfilm.R;
import com.arifbm.catalogfilm.data.Film;

public class DetailActivity extends AppCompatActivity {

    private TextView textTitle, textYear, textDescription;
    private RatingBar ratingBar;
    private ImageView imgBanner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        setToolbar();

        textTitle = findViewById(R.id.title);
        textYear = findViewById(R.id.year);
        textDescription = findViewById(R.id.description);
        ratingBar = findViewById(R.id.ratingBar);
        imgBanner = findViewById(R.id.banner);

        if (getIntent().getParcelableExtra(MainFragment.ITEM_EXTRA) != null) {
                    setItem(getIntent().getParcelableExtra(MainFragment.ITEM_EXTRA));
        }
    }

    private void setToolbar() {
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }
    }

        void setItem (Film film){
        textTitle.setText(film.getTitle());
        textYear.setText(String.valueOf(film.getYear()));
        textDescription.setText(film.getDescription());
        imgBanner.setImageResource(film.getBanner());
        ratingBar.setRating(film.getRating());

        }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home)
            onBackPressed();
        return super.onOptionsItemSelected(item);
    }
}
