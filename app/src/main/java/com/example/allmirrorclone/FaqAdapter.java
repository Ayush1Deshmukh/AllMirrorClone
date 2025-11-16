package com.example.allmirrorclone;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.allmirrorclone.databinding.ItemFaqBinding;
import java.util.ArrayList;

// This adapter handles the FAQ list data
public class FaqAdapter extends RecyclerView.Adapter<FaqAdapter.FaqViewHolder> {

    // A list to hold our questions and answers
    private final ArrayList<FaqItem> faqList;

    // Constructor: a simple data class to hold the text
    public static class FaqItem {
        String question;
        String answer;
        boolean isExpanded = false; // Tracks if the item is expanded

        public FaqItem(String question, String answer) {
            this.question = question;
            this.answer = answer;
        }
    }

    // The adapter's constructor
    public FaqAdapter(ArrayList<FaqItem> faqList) {
        this.faqList = faqList;
    }

    // This creates the view for each row
    @NonNull
    @Override
    public FaqViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // Inflate the layout using View Binding
        ItemFaqBinding binding = ItemFaqBinding.inflate(
                LayoutInflater.from(parent.getContext()),
                parent,
                false
        );
        return new FaqViewHolder(binding);
    }

    // This binds the data to the views in each row
    @Override
    public void onBindViewHolder(@NonNull FaqViewHolder holder, int position) {
        FaqItem currentItem = faqList.get(position);

        // Set the text
        holder.binding.textQuestion.setText(currentItem.question);
        holder.binding.textAnswer.setText(currentItem.answer);

        // Set the visibility based on the "isExpanded" state
        boolean isExpanded = currentItem.isExpanded;
        holder.binding.textAnswer.setVisibility(isExpanded ? View.VISIBLE : View.GONE);
        holder.binding.imageArrow.setRotation(isExpanded ? 180f : 0f); // Rotate arrow

        // --- This is the click-to-expand logic ---
        holder.binding.questionLayout.setOnClickListener(v -> {
            // Toggle the expanded state
            currentItem.isExpanded = !currentItem.isExpanded;
            // Tell the adapter to re-draw this item with the new state
            notifyItemChanged(position);
        });
    }

    // Returns the total number of items in the list
    @Override
    public int getItemCount() {
        return faqList.size();
    }

    // This "ViewHolder" class holds the references to the views in item_faq.xml
    public static class FaqViewHolder extends RecyclerView.ViewHolder {
        public final ItemFaqBinding binding;

        public FaqViewHolder(@NonNull ItemFaqBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }
}