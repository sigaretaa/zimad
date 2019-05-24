package com.tokovenko.zimad.presentation;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.tokovenko.zimad.R;
import com.tokovenko.zimad.presentation.viewmodels.AnimalListViewModel;
import com.tokovenko.zimad.presentation.viewmodels.DogsListViewModel;

public class DogsListFragment extends AnimalListFragment {

    public static DogsListFragment newInstance() {
        return new DogsListFragment();
    }

    @Override
    protected AnimalListViewModel getViewModel() {
        return getViewModel(DogsListViewModel.class);
    }
}
