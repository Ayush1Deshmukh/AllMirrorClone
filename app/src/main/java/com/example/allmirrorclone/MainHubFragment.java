package com.example.allmirrorclone; // Make sure this matches your package name

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Toast; // We need this for the new buttons

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import com.example.allmirrorclone.databinding.FragmentMainHubBinding;

public class MainHubFragment extends Fragment {

    private FragmentMainHubBinding binding;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentMainHubBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        // --- Set up all click listeners ---

        // 1. "Connect" button (the orange circle)
        binding.btnConnect.setOnClickListener(v -> {
            NavHostFragment.findNavController(this)
                    .navigate(R.id.action_mainHubFragment_to_connectSettingsFragment);
        });

        // 2. "Browser Mirroring" button (the green circle)
        binding.btnBrowserContainer.setOnClickListener(v -> {
            new BrowserMirroringDialog().show(getChildFragmentManager(), "BrowserMirroringDialog");
        });

        // 3. "Tutorial & FAQ" card (bottom left)
        binding.cardTutorial.setOnClickListener(v -> {
            NavHostFragment.findNavController(this)
                    .navigate(R.id.action_mainHubFragment_to_tutorialFaqFragment);
        });

        // 4. "Floating Tools" switch (bottom right)
        binding.switchFloatingTools.setOnCheckedChangeListener((buttonView, isChecked) -> {
            if (isChecked) {
                new FloatingToolsDialog().show(getChildFragmentManager(), "FloatingToolsDialog");
            } else {
                // Logic to stop service
            }
        });

        // 5. Listener for "Join Pro" button in the dialog
        getChildFragmentManager().setFragmentResultListener("showProScreen", this, (requestKey, bundle) -> {
            NavHostFragment.findNavController(this)
                    .navigate(R.id.action_mainHubFragment_to_proPurchaseFragment);
        });

        // 6. Start the pulse animation on the top-right FAB
        Animation pulseAnimation = AnimationUtils.loadAnimation(getContext(), R.anim.anim_pulse);
        binding.fabCast.startAnimation(pulseAnimation);


        // 7. Toolbar button listeners
        binding.toolbarShare.setOnClickListener(v -> {
            Toast.makeText(getContext(), "Share button clicked", Toast.LENGTH_SHORT).show();
        });

        // --- THIS IS THE CHANGE ---
        // 8. "Settings" icon now navigates to the Connect Settings screen
        binding.toolbarSettings.setOnClickListener(v -> {
            NavHostFragment.findNavController(this)
                    .navigate(R.id.action_mainHubFragment_to_connectSettingsFragment);
        });
    }
    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}