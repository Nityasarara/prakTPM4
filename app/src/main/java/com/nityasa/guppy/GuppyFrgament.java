package com.nityasa.guppy;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class GuppyFrgament extends Fragment {

    @Nullable @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        return inflater.inflate(R.layout.fragment_plants, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        getActivity().setTitle("Ikan Guppy");

        GuppyAdapter agentAdapter = new GuppyAdapter(GuppyData.generateData(),getContext());
        RecyclerView rvPlant = getView().findViewById(R.id.rv_list);
        LinearLayoutManager layoutManager = new GridLayoutManager(getActivity(), 2);

        rvPlant.setItemAnimator(new DefaultItemAnimator());
        rvPlant.setNestedScrollingEnabled(false);

        rvPlant.setLayoutManager(layoutManager);
        rvPlant.setNestedScrollingEnabled(false);
        rvPlant.setHasFixedSize(true);
        rvPlant.setAdapter(agentAdapter);
    }
}
