package com.example.allmirrorclone;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import com.example.allmirrorclone.databinding.FragmentConnectSettingsBinding;

public class ConnectSettingsFragment extends Fragment {

    private FragmentConnectSettingsBinding binding;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = FragmentConnectSettingsBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        // 1. Set up the "Back" button on the toolbar
        binding.toolbar.setNavigationOnClickListener(v -> {
            // Navigate back to the previous screen
            NavHostFragment.findNavController(this).popBackStack();
        });

        // In a real app, you would add listeners for the switches
        // e.g., binding.switchHideNotifications.setOnCheckedChangeListener(...)
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}