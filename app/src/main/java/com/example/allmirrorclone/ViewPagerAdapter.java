package com.example.allmirrorclone;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.adapter.FragmentStateAdapter;

// This adapter tells the ViewPager which fragment to show for which tab
public class ViewPagerAdapter extends FragmentStateAdapter {

    public ViewPagerAdapter(@NonNull Fragment fragment) {
        super(fragment);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        // Position 0 is the first tab ("TUTORIAL")
        if (position == 0) {
            return new TutorialPageFragment();
        }
        // Position 1 is the second tab ("FAQ")
        return new FaqPageFragment();
    }

    @Override
    public int getItemCount() {
        // We have 2 tabs in total
        return 2;
    }
}