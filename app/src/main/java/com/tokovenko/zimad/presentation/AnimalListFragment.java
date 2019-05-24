package com.tokovenko.zimad.presentation;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.tokovenko.zimad.R;
import com.tokovenko.zimad.domain.model.Animal;
import com.tokovenko.zimad.presentation.adapter.AnimalsAdapter;
import com.tokovenko.zimad.presentation.viewmodels.AnimalListViewModel;

import butterknife.BindView;
import timber.log.Timber;

public abstract class AnimalListFragment extends BaseFragment
        implements  AnimalsAdapter.OnAnimalClickListener {

    protected AnimalListViewModel viewModel;
    private AnimalsAdapter.OnAnimalClickListener listener;

    @BindView(R.id.list)
    RecyclerView recyclerView;

    private AnimalsAdapter adapter;

    @Override
    protected int layoutId() {
        return R.layout.fragment_list;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof AnimalsAdapter.OnAnimalClickListener) {
            listener = (AnimalsAdapter.OnAnimalClickListener)context;
        }
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        adapter = new AnimalsAdapter();
        adapter.setCliclListener(this);

        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());

        recyclerView.setLayoutManager(layoutManager);

        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(recyclerView.getContext(),
                layoutManager.getOrientation());
        recyclerView.addItemDecoration(dividerItemDecoration);

        recyclerView.setAdapter(adapter);

        viewModel = getViewModel();
        viewModel.getAnimalsListLiveData().observe(this,animals -> {
            adapter.clearItems();
            adapter.setItems(animals);
        });

        viewModel.getThrowableLiveData().observe(this,throwable -> {
            Timber.e(throwable);
            adapter.clearItems();
        });
    }

    @Override
    public void onAnimalClick(Animal animal) {
        if (listener != null){
            listener.onAnimalClick(animal);
        }
    }

    protected abstract AnimalListViewModel getViewModel();
}
