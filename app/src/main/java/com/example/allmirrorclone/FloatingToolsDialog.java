package com.example.allmirrorclone;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.Settings;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

import com.example.allmirrorclone.databinding.DialogFloatingToolsBinding;

public class FloatingToolsDialog extends DialogFragment {

    private DialogFloatingToolsBinding binding;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = DialogFloatingToolsBinding.inflate(inflater, container, false);

        binding.btnOpen.setOnClickListener(v -> {
            // This is the code to open the correct settings page
            // We won't handle the result, just send the user there.
            Intent intent = new Intent(Settings.ACTION_MANAGE_OVERLAY_PERMISSION,
                    Uri.parse("package:" + requireActivity().getPackageName()));
            startActivity(intent);

            // Close the dialog
            dismiss();
        });

        return binding.getRoot();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}