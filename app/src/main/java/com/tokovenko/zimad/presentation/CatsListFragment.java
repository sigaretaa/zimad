package com.tokovenko.zimad.presentation;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.tokovenko.zimad.presentation.viewmodels.AnimalListViewModel;
import com.tokovenko.zimad.presentation.viewmodels.CatsListViewModel;

public class CatsListFragment extends AnimalListFragment {

    public static CatsListFragment newInstance() {
        return new CatsListFragment();
    }

    @Override
    protected AnimalListViewModel getViewModel() {
        return getViewModel(CatsListViewModel.class);
    }
}
