package com.openclassrooms.entrevoisins.ui.neighbour_list;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.openclassrooms.entrevoisins.R;
import com.openclassrooms.entrevoisins.di.DI;
import com.openclassrooms.entrevoisins.model.Neighbour;
import com.openclassrooms.entrevoisins.service.NeighbourApiService;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class FavoriteNeighbourListFragment extends Fragment {

    // Declare recyclerView
    @BindView(R.id.list_favorite_neighbours)
    RecyclerView mRecyclerView;

    // Data
    private List<Neighbour> favoritesNeighbours;
    private MyNeighbourRecyclerViewAdapter mAdapter;
    private NeighbourApiService mNeighbourApiService;

    // Empty Constructor
    public FavoriteNeighbourListFragment() {}


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mNeighbourApiService = DI.getNeighbourApiService();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_favorite_neighbour_list, container, false);
        ButterKnife.bind(this, view);
        this.configureRecyclerView();
        // add divider decoration
        mRecyclerView.addItemDecoration(new DividerItemDecoration(getContext(), DividerItemDecoration.VERTICAL));
        return view;
    }

    // To configure the RecyclerView
    private void configureRecyclerView() {
        this.favoritesNeighbours = new ArrayList<>(mNeighbourApiService.getFavoriteNeighbours());
        this.mAdapter = new MyNeighbourRecyclerViewAdapter(this.favoritesNeighbours);
        this.mRecyclerView.setAdapter(this.mAdapter);
        this.mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
    }


    public static FavoriteNeighbourListFragment newInstance() {
        FavoriteNeighbourListFragment fragment = new FavoriteNeighbourListFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

}