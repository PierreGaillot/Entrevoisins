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
import com.openclassrooms.entrevoisins.events.ToggleFavoriteNeighbourEvent;
import com.openclassrooms.entrevoisins.model.Neighbour;
import com.openclassrooms.entrevoisins.service.NeighbourApiService;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class FavoriteNeighbourListFragment extends Fragment {

    // Declare recyclerView
    @BindView(R.id.list_favorite_neighbours)
    RecyclerView mRecyclerView;

    //TEST Delete Image Button
//    @BindView(R.id.item_list_delete_button)
//    ImageButton deleteButton;

    // Data
    private List<Neighbour> favoritesNeighbours;
    private FavoriteNeighbourRecyclerViewAdapter mAdapter;
    private NeighbourApiService mNeighbourApiService;
    private List<Neighbour> mFavoriteNeighbours;

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
        this.mAdapter = new FavoriteNeighbourRecyclerViewAdapter(this.favoritesNeighbours);
        this.mRecyclerView.setAdapter(this.mAdapter);
        this.mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
    }


    public static FavoriteNeighbourListFragment newInstance() {
        FavoriteNeighbourListFragment fragment = new FavoriteNeighbourListFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }



    /**TEST
     *
     */

    /**
     * Init the List of favorite neighbours
     */
    private void initFavoriteNeighboursList() {
        mFavoriteNeighbours = mNeighbourApiService.getFavoriteNeighbours();
        mRecyclerView.setAdapter(new FavoriteNeighbourRecyclerViewAdapter(mFavoriteNeighbours));
    }

    @Override
    public void onResume() {
        super.onResume();
        initFavoriteNeighboursList();
    }

    @Override
    public void onStart() {
        super.onStart();
        EventBus.getDefault().register(this);
    }

    @Override
    public void onStop() {
        super.onStop();
        EventBus.getDefault().unregister(this);
    }

    /**
     * Fired if the user clicks on a delete button
     * @param event
     */
    @Subscribe
    public void onToggleFavoriteNeighbour(ToggleFavoriteNeighbourEvent event) {
        initFavoriteNeighboursList();
    }
}