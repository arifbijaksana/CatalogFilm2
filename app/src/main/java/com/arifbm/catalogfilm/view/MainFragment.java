package com.arifbm.catalogfilm.view;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

import com.arifbm.catalogfilm.R;
import com.arifbm.catalogfilm.adapter.FilmAdapter;
import com.arifbm.catalogfilm.data.Film;

import java.util.ArrayList;
import java.util.List;
import java.util.zip.Inflater;


public class MainFragment extends Fragment {

    static final String ITEM_EXTRA = "com.arifbm.catalogfilm";
    static final String KEY_DATA = "com.arifbm.dataCatalogfilm";
    private RecyclerView recyclerView;
    private List<Film> films ;

    static MainFragment newInstance(List<Film> films) {

        Bundle args = new Bundle();
        args.putParcelableArrayList(KEY_DATA, (ArrayList <? extends Parcelable >) films);
        MainFragment fragment = new MainFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_main, container,false);
        recyclerView = view.findViewById(R.id.recyclerView);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        if (getArguments() != null ){
            films = getArguments().getParcelableArrayList(KEY_DATA);
        }

        FilmAdapter filmAdapter = new FilmAdapter(getActivity(), films);
        recyclerView.setAdapter(filmAdapter);

            filmAdapter.setItemClickListener((viewRow, position) -> {
            Intent intent = new Intent(getActivity(), DetailActivity.class);
            intent.putExtra(ITEM_EXTRA, films.get(position));
            startActivity(intent);
        });
    }
}
