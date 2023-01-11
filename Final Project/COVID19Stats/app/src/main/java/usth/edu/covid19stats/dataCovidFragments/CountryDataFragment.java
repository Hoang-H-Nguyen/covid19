package usth.edu.covid19stats.dataCovidFragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.List;

import usth.edu.covid19stats.CountryDataReportModel;
import usth.edu.covid19stats.CovidDataService;
import usth.edu.covid19stats.R;


public class CountryDataFragment extends Fragment { // Fragment show for the total data of a country
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_country_data, container, false);
        Button searchCountryBtn = view.findViewById(R.id.searchCountryBtn);
        EditText searchCountryDataEditText = view.findViewById(R.id.editTextSpecificCountryData);
        ListView countryDataListView = view.findViewById(R.id.countryDataListView);
        searchCountryBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CovidDataService covidDataService = new CovidDataService(getActivity());
                covidDataService.getCovidDataByCountry(searchCountryDataEditText.getText().toString(), new CovidDataService.GetCovidDataByCountryResponseListener() {
                    @Override
                    public void onError(String message) {
                        Toast.makeText(getActivity(), "Something wrong", Toast.LENGTH_SHORT).show();
                    }
                    @Override
                    public void onResponse(List<CountryDataReportModel> countriesDataReports) {
                        ArrayAdapter arrayAdapter = new ArrayAdapter(getActivity(),
                                android.R.layout.simple_list_item_1, countriesDataReports);
                        countryDataListView.setAdapter(arrayAdapter);
                    }
                });
            }
        });

        return view;
    }
}