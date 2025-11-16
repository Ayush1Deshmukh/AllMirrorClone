package com.example.allmirrorclone;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.allmirrorclone.databinding.FragmentFaqPageBinding;

import java.util.ArrayList;

public class FaqPageFragment extends Fragment {

    private FragmentFaqPageBinding binding;
    private FaqAdapter adapter;
    private ArrayList<FaqAdapter.FaqItem> faqList;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = FragmentFaqPageBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        // 1. Set up the RecyclerView's layout manager
        binding.faqRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        // 2. Create the list of sample questions and answers
        loadFaqData();

        // 3. Create and set the adapter
        adapter = new FaqAdapter(faqList);
        binding.faqRecyclerView.setAdapter(adapter);
    }

    // This method creates our sample data
    private void loadFaqData() {
        faqList = new ArrayList<>();

        faqList.add(new FaqAdapter.FaqItem(
                "My phone gets stuck at \"Connecting\" when pairing up with TV.",
                "- Restart the smartphone's Wi-Fi and see if the connection is successful.\n- Turn off the TV and remove its power cord from the socket as well. Wait 1 minute and restart the TV.\n- Shorten the distance between your phone and the TV. Take it up close."
        ));

        faqList.add(new FaqAdapter.FaqItem(
                "It worked for me before, but it doesn't work now.",
                "Please try clearing the app's cache or reinstalling the app. Also, ensure your TV's firmware is up to date."
        ));

        faqList.add(new FaqAdapter.FaqItem(
                "It shows that my device is not supported.",
                "Please check our 'Supported Devices' list in the Tutorial tab. Your device must support Miracast or be a DLNA-certified Smart TV."
        ));

        faqList.add(new FaqAdapter.FaqItem(
                "My TV is an old TV and does not support Wi-Fi.",
                "You will need a wireless display adapter, such as a Chromecast or AnyCast, plugged into your TV's HDMI port."
        ));

        faqList.add(new FaqAdapter.FaqItem(
                "TV has sound but no picture.",
                "This can be a codec issue. Please try restarting the stream. If the problem persists, try lowering the video quality settings in the app."
        ));
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}