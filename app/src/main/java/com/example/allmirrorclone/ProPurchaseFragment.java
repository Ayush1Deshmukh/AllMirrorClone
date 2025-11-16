package com.example.allmirrorclone;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

// You need to import the View Binding class
import com.example.allmirrorclone.databinding.FragmentProPurchaseBinding;

public class ProPurchaseFragment extends Fragment {

    // 1. Declare the binding variable
    private FragmentProPurchaseBinding binding;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        // 2. Inflate the layout using View Binding
        binding = FragmentProPurchaseBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        // 3. Set up the "Back" button on the toolbar
        binding.toolbar.setNavigationOnClickListener(v -> {
            // Navigate back to the previous screen
            NavHostFragment.findNavController(this).popBackStack();
        });

        // 4. Set up the "Continue" button
        binding.btnContinue.setOnClickListener(v -> {
            // In a real app, this would start the Google Play Billing flow.
            // For now, we'll just show a message.
            Toast.makeText(getContext(), "Starting purchase flow...", Toast.LENGTH_SHORT).show();

            // We can also navigate back to the main screen
            NavHostFragment.findNavController(this).popBackStack();
        });
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        // 5. Set binding to null to avoid memory leaks
        binding = null;
    }

    // You can delete all the old newInstance() and onCreate() methods
}