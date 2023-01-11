package usth.edu.covid19stats;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import usth.edu.covid19stats.dataCovidFragments.CountryFragment;
import usth.edu.covid19stats.dataCovidFragments.OverallFragment;
import usth.edu.covid19stats.dataCovidFragments.CountryDataFragment;

public class DataCovidViewPagerAdapter extends FragmentStateAdapter {

    public DataCovidViewPagerAdapter(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch (position) {
            case 0:
                return new OverallFragment();
            case 1:
                return new CountryFragment();
            case 2:
                return new CountryDataFragment();
            default:
                return new OverallFragment();
        }
    }

    @Override
    public int getItemCount() {
        return 3;
    }
}
