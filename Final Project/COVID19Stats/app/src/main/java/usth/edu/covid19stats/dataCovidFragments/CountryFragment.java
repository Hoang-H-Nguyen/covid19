package usth.edu.covid19stats.dataCovidFragments;

import android.graphics.Color;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.utils.ColorTemplate;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import usth.edu.covid19stats.CovidDataService;
import usth.edu.covid19stats.EvedydayCountryData;
import usth.edu.covid19stats.MySingleton;
import usth.edu.covid19stats.R;

public class CountryFragment extends Fragment {// Fragment for recent day data

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_country, container, false);
        Button demo1Btn = view.findViewById(R.id.searchRecent7daysBtn);
        EditText editTextDemo = view.findViewById(R.id.editTextDemo);
        ListView recentdayListView = view.findViewById(R.id.recentDaysListView);

        demo1Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CovidDataService covidDataService = new CovidDataService(getActivity());
                covidDataService.getCountry(editTextDemo.getText().toString(), new CovidDataService.GetCountryResponseListener() {
                    @Override
                    public void onError(String message) {
                        Toast.makeText(getActivity(), "Something wrong", Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onResponse(List<EvedydayCountryData> everydayReport) {
                        ArrayAdapter arrayAdapter = new ArrayAdapter(getActivity(),
                                android.R.layout.simple_list_item_1, everydayReport);
                        recentdayListView.setAdapter(arrayAdapter);
                    }
                });
            }
        });
        return view;
    }

}