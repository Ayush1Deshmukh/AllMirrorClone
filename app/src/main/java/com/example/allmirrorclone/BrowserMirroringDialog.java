package com.example.allmirrorclone;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

import com.example.allmirrorclone.databinding.DialogBrowserMirroringBinding;

public class BrowserMirroringDialog extends DialogFragment {

    private DialogBrowserMirroringBinding binding;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = DialogBrowserMirroringBinding.inflate(inflater, container, false);

        // Set click listener for "Join Pro"
        binding.btnJoinPro.setOnClickListener(v -> {
            // Send a signal back to MainHubFragment to navigate
            // "showProScreen" is the key, MainHubFragment is listening for it
            getParentFragmentManager().setFragmentResult("showProScreen", new Bundle());

            // Close the dialog
            dismiss();
        });

        // Set click listener for "Watch Ad"
        binding.btnWatchAd.setOnClickListener(v -> {
            // Backend logic for showing a rewarded ad would go here

            // For now, just close the dialog
            dismiss();
        });

        return binding.getRoot();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

    @Override
    public void onStart() {
        super.onStart();
        // This makes the dialog's corners transparent, which is needed
        // for our two-part (blue and gray) layout.
        if (getDialog() != null && getDialog().getWindow() != null) {
            getDialog().getWindow().setBackgroundDrawableResource(android.R.color.transparent);
        }
    }
}