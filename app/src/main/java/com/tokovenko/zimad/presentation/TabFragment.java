package com.tokovenko.zimad.presentation;

import android.os.Bundle;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import com.google.android.material.tabs.TabLayout;
import com.tokovenko.zimad.R;

import butterknife.BindView;
import timber.log.Timber;

public class TabFragment extends BaseFragment
        implements TabLayout.BaseOnTabSelectedListener  {

    @BindView(R.id.tabs)
    TabLayout tabLayout;

    private static final String EXTRA_TAB = "position";
    private static final int UNKNOWN_TAB = -1;
    private static final int CATS_TAB = 0;
    private static final int DOGS_TAB = 1;


    private int current_tab = UNKNOWN_TAB;

    @Override
    protected int layoutId() {
        return R.layout.fragment_tab;
    }


    public static TabFragment newInstance() {
        return new TabFragment();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        int selected = CATS_TAB;

        if (savedInstanceState != null){
            selected = savedInstanceState.getInt(EXTRA_TAB,CATS_TAB);
        }

        setupTabs(selected);
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt(EXTRA_TAB,current_tab);
    }

    private void setupTabs(int selected){
        tabLayout.addOnTabSelectedListener(this);
        int selectedTab = tabLayout.getSelectedTabPosition();

        if (selectedTab < 0 || selectedTab != selected){
            TabLayout.Tab tab = tabLayout.getTabAt(selected);
            if (tab != null){
                tab.select();
            } else {
                setTabContent(CATS_TAB);
            }
        } else {
            setTabContent(selectedTab);
        }
    }

    @Override
    public void onTabSelected(TabLayout.Tab tab) {
        setTabContent(tab.getPosition());
    }

    @Override
    public void onTabUnselected(TabLayout.Tab tab) {}

    @Override
    public void onTabReselected(TabLayout.Tab tab) {}


    private void setTabContent(int position){
        if (position != current_tab){
            current_tab = position;

            switch (current_tab){
                case CATS_TAB:
                    replaceTabContent(CatsListFragment.class);
                    break;
                case DOGS_TAB:
                    replaceTabContent(DogsListFragment.class);
                    break;
            }
        }
    }

    private <T extends BaseFragment>  void replaceTabContent(Class<T> fragmentClass){
        String backStateName =  fragmentClass.getName();
        FragmentManager manager = getChildFragmentManager();

        Fragment fragment = manager.findFragmentByTag(backStateName);

        try{
            if (fragment == null){
                fragment = fragmentClass.newInstance();
            }

        }catch (IllegalAccessException| java.lang.InstantiationException ex){
            Timber.e(ex);
        }

        if (fragment != null){
            manager.beginTransaction()
                    .replace(R.id.content, fragment, backStateName)
                    .addToBackStack(null)
                    .commit();
        }
    }
}
