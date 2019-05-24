package com.tokovenko.zimad.presentation;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;
import android.widget.FrameLayout;

import com.google.android.material.tabs.TabLayout;
import com.tokovenko.zimad.R;
import com.tokovenko.zimad.domain.model.Animal;
import com.tokovenko.zimad.presentation.adapter.AnimalsAdapter;

import butterknife.BindView;
import butterknife.ButterKnife;
import timber.log.Timber;

public class MainActivity extends AppCompatActivity
implements AnimalsAdapter.OnAnimalClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (savedInstanceState == null){
            setupTabs();
        } else {

        }
    }

    @Override
    public void onBackPressed(){
        if (getSupportFragmentManager().getBackStackEntryCount() == 1){
            finish();
        } else {
            super.onBackPressed();
        }
    }

    private void setupTabs(){
        FragmentManager manager = getSupportFragmentManager();
        Fragment fragment = TabFragment.newInstance();
        String backStateName =  fragment.getClass().getName();

        manager.beginTransaction()
                .replace(R.id.content, fragment, backStateName)
                .addToBackStack(backStateName)
                .commit();
    }

    private void showAnimalDetails(Animal animal){
        FragmentManager manager = getSupportFragmentManager();
        manager.beginTransaction()
                .replace(R.id.content, AnimalDetailFragment.newInstance(animal))
                .addToBackStack(null)
                .commit();
    }

    @Override
    public void onAnimalClick(Animal animal) {
        Timber.d("Animal click %s",animal.toString());
        showAnimalDetails(animal);
    }
}
