package usth.edu.covid19stats.dataCovidFragments;

import android.graphics.Color;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;

import usth.edu.covid19stats.R;

///**
// * A simple {@link Fragment} subclass.
// * Use the {@link OverallFragment#newInstance} factory method to
// * create an instance of this fragment.
// */
public class OverallFragment extends Fragment {

//    // TODO: Rename parameter arguments, choose names that match
//    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
//    private static final String ARG_PARAM1 = "param1";
//    private static final String ARG_PARAM2 = "param2";
//
//    // TODO: Rename and change types of parameters
//    private String mParam1;
//    private String mParam2;
//
//    public OverallFragment() {
//        // Required empty public constructor
//    }
//
//    /**
//     * Use this factory method to create a new instance of
//     * this fragment using the provided parameters.
//     *
//     * @param param1 Parameter 1.
//     * @param param2 Parameter 2.
//     * @return A new instance of fragment OverallFragment.
//     */
//    // TODO: Rename and change types and number of parameters
//    public static OverallFragment newInstance(String param1, String param2) {
//        OverallFragment fragment = new OverallFragment();
//        Bundle args = new Bundle();
//        args.putString(ARG_PARAM1, param1);
//        args.putString(ARG_PARAM2, param2);
//        fragment.setArguments(args);
//        return fragment;
//    }
//
//    @Override
//    public void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        if (getArguments() != null) {
//            mParam1 = getArguments().getString(ARG_PARAM1);
//            mParam2 = getArguments().getString(ARG_PARAM2);
//        }
//    }

    ArrayList barArrayList;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_overall, container, false);
        BarChart barChart = view.findViewById(R.id.overall_bar_chart);

        getData();
        BarDataSet barDataSet = new BarDataSet(barArrayList, "Demo");
        BarData barData = new BarData(barDataSet);
        barChart.setData(barData);

        // color bar data set
        barDataSet.setColors(ColorTemplate.COLORFUL_COLORS);

        // text color
        barDataSet.setValueTextColor(Color.BLACK);
        // text size
        barDataSet.setValueTextSize(15f);
        barChart.getDescription().setEnabled(true);
        return view;
    }

    private void getData() {
        barArrayList = new ArrayList();
        barArrayList.add(new BarEntry(2f, 10));
        barArrayList.add(new BarEntry(3f, 20));
        barArrayList.add(new BarEntry(4f, 30));
        barArrayList.add(new BarEntry(5f, 40));
        barArrayList.add(new BarEntry(6f, 50));

    }
    // https://anant-raman.medium.com/graphs-in-android-apps-3f2bf8baa4cf
}