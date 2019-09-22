package com.arifbm.catalogfilm.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.provider.Settings;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.arifbm.catalogfilm.R;
import com.arifbm.catalogfilm.adapter.FilmAdapter;
import com.arifbm.catalogfilm.adapter.ViewPagerAdapter;
import com.arifbm.catalogfilm.data.Film;
import com.arifbm.catalogfilm.data.FilmRepository;
import com.google.android.material.tabs.TabLayout;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setSupportActionBar(findViewById(R.id.toolbar));
    }

        public void setViewPagerTab(ViewPager viewPager, TabLayout tabLayout) {
            ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
            adapter.addFragment( MainFragment.newInstance( FilmRepository.getInstance(this).getFilmData() ), getResources().getString(R.string.movies));
            adapter.addFragment( MainFragment.newInstance( FilmRepository.getInstance(this).getTvShowData() ), getResources().getString(R.string.tv_shows));
            viewPager.setAdapter(adapter);
            tabLayout.setupWithViewPager(viewPager);
            viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
            viewPager.setCurrentItem(0);
            adapter.notifyDataSetChanged();
        }

        @Override
        public boolean onCreateOptionsMenu(Menu menu) {
            getMenuInflater().inflate(R.menu.menu, menu);
            return super.onCreateOptionsMenu(menu);
        }

        @Override
        public boolean onOptionsItemSelected(MenuItem item) {
            if (item.getItemId() == R.id.action_change_settings) {
                startActivity(new Intent(Settings.ACTION_LOCALE_SETTINGS));
            }
            return super.onOptionsItemSelected(item);
        }

        @Override
        protected void onResume() {
            super.onResume();
            setViewPagerTab(findViewById(R.id.view_pager), findViewById(R.id.tab_layout));
        }
}
