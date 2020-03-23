package com.example.digitalattendance.ui.home;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.ViewModelProviders;
import com.example.digitalattendance.R;
import com.example.digitalattendance.SignActivity;
import com.example.digitalattendance.ui.slideshow.SlideshowFragment;
import com.google.android.material.navigation.NavigationView;
import com.google.firebase.auth.FirebaseAuth;

public class HomeFragment extends Fragment{

    private HomeViewModel homeViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        homeViewModel =
                ViewModelProviders.of(this).get(HomeViewModel.class);
        final View root = inflater.inflate(R.layout.fragment_home, container, false);

        View view = inflater.inflate(R.layout.fragment_home,
                container, false);

        Button sld_shw = root.findViewById(R.id.sw_slideshow);
        Button lgn_std = root.findViewById(R.id.sign_in_btn);

        sld_shw.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager fragmentManager = getFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                SlideshowFragment NAME = new SlideshowFragment();
                fragmentTransaction.replace(R.id.nav_host_fragment, NAME);
                NavigationView navigationView = getActivity().findViewById(R.id.nav_view);
                navigationView.getMenu().getItem(1).setChecked(true);
                fragmentTransaction.commit();
            }
        });

        lgn_std.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getContext(), SignActivity.class);
                startActivity(i);
            }
        });

        return root;
    }
}
