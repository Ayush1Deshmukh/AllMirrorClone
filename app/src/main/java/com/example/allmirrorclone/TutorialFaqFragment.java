package com.example.allmirrorclone;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import com.example.allmirrorclone.databinding.FragmentTutorialFaqBinding;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

public class TutorialFaqFragment extends Fragment {

    private FragmentTutorialFaqBinding binding;
    private ViewPagerAdapter viewPagerAdapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = FragmentTutorialFaqBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        // 1. Set up the ViewPager adapter
        viewPagerAdapter = new ViewPagerAdapter(this);
        binding.viewPager.setAdapter(viewPagerAdapter);

        // 2. Link the TabLayout to the ViewPager
        // This also sets the text for each tab
        new TabLayoutMediator(binding.tabLayout, binding.viewPager, (tab, position) -> {
            if (position == 0) {
                tab.setText("TUTORIAL");
            } else {
                tab.setText("FAQ");
            }
        }).attach();

        // 3. Set up the "Back" button on the toolbar
        binding.toolbar.setNavigationOnClickListener(v -> {
            // Navigate back to the previous screen (MainHubFragment)
            NavHostFragment.findNavController(this).popBackStack();
        });

        // 4. (Optional) Set up the "Feedback" button
        binding.textFeedback.setOnClickListener(v -> {
            // Add code here to send feedback (e.g., open email)
        });
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}