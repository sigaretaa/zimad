package com.tokovenko.zimad.presentation;

import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import butterknife.BindView;

import com.squareup.picasso.Picasso;
import com.tokovenko.zimad.R;
import com.tokovenko.zimad.domain.model.Animal;

public class AnimalDetailFragment extends BaseFragment {

    private static final String EXTRA_ANIMAL = "animal";

    @BindView(R.id.icon)
    ImageView icon;

    @BindView(R.id.text)
    TextView tvText;

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        Bundle bundle = getArguments();
        if (bundle != null){
            Parcelable parcelable = getArguments().getParcelable(EXTRA_ANIMAL);
            if (parcelable instanceof Animal){
                setAnimalDetails((Animal)parcelable);
            }
        }
    }

    @Override
    protected int layoutId() {
        return R.layout.fragment_animal_details;
    }

    private void setAnimalDetails(Animal animal){
        Picasso.get()
                .load(animal.getUrl())
                .into(icon);
        tvText.setText(animal.getTitle());
    }

    public static AnimalDetailFragment newInstance(Animal animal){
        AnimalDetailFragment fragment = new AnimalDetailFragment();
        Bundle arguments = new Bundle();
        arguments.putParcelable(EXTRA_ANIMAL,animal);
        fragment.setArguments(arguments);
        return fragment;
    }
}
