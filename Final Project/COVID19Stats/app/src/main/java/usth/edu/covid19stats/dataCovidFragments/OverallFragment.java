package usth.edu.covid19stats.dataCovidFragments;

import android.graphics.Color;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.charts.HorizontalBarChart;
import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.components.Description;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.formatter.IndexAxisValueFormatter;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import usth.edu.covid19stats.CountryDataReportModel;
import usth.edu.covid19stats.CovidDataService;
import usth.edu.covid19stats.EvedydayCountryData;
import usth.edu.covid19stats.EverydayWorld;
import usth.edu.covid19stats.R;

public class OverallFragment extends Fragment {

    PieChart pieChartTotal;
    PieChart pieChartToday;
    BarChart barChart;
    ArrayList<BarEntry> barEntryArrayList;
    ArrayList<String> labelNames;


    ArrayList<EverydayWorld> everydayReportArrayList;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_overall, container, false);

        barChart = view.findViewById(R.id.overallChart1);

        everydayReportArrayList = new ArrayList<>();

        CovidDataService covidDataService = new CovidDataService(getActivity());
        covidDataService.getOverallHistorical(new CovidDataService.GetOverallHistoricalResponseListener() {
            @Override
            public void onError(String message) {
            }

            @Override
            public void onResponse(List<EvedydayCountryData> everydayReport) {
                everydayReportArrayList.add(new EverydayWorld(everydayReport.get(0).getDay(), everydayReport.get(0).getCases() ));
                everydayReportArrayList.add(new EverydayWorld(everydayReport.get(1).getDay(), everydayReport.get(1).getCases()));
                everydayReportArrayList.add(new EverydayWorld(everydayReport.get(2).getDay(), everydayReport.get(2).getCases()));
                everydayReportArrayList.add(new EverydayWorld(everydayReport.get(3).getDay(), everydayReport.get(3).getCases()));
                everydayReportArrayList.add(new EverydayWorld(everydayReport.get(4).getDay(), everydayReport.get(4).getCases()));
                everydayReportArrayList.add(new EverydayWorld(everydayReport.get(5).getDay(), everydayReport.get(5).getCases()));
                everydayReportArrayList.add(new EverydayWorld(everydayReport.get(6).getDay(), everydayReport.get(6).getCases()));
//                Toast.makeText(getActivity(), everydayReportArrayList.toString(), Toast.LENGTH_SHORT).show();

                barEntryArrayList = new ArrayList<>();
                labelNames = new ArrayList<>();

                for(int i = 0; i < everydayReportArrayList.size(); i++) {
                    String day = everydayReportArrayList.get(i).getDay();
                    int cases = everydayReportArrayList.get(i).getCases();
                    barEntryArrayList.add(new BarEntry(i, cases));
                    labelNames.add(day);
                }

                BarDataSet barDataSet = new BarDataSet(barEntryArrayList, "Cases Days");
                barDataSet.setColors(ColorTemplate.COLORFUL_COLORS);
//
                Description description = new Description();
                description.setText("Days");
//
                barChart.setDescription(description);
                BarData barData = new BarData(barDataSet);
                barChart.setData(barData);
                barChart.setFitBars(true);
//
                XAxis xAxis = barChart.getXAxis();
                xAxis.setValueFormatter(new IndexAxisValueFormatter(labelNames));
                xAxis.setPosition(XAxis.XAxisPosition.TOP);
                xAxis.setDrawGridLines(false);
                xAxis.setGranularity(1f);
                xAxis.setLabelCount(labelNames.size());
                xAxis.setLabelRotationAngle(270);
                barChart.animateY(2000);
                barChart.invalidate();
            }
        });

        covidDataService.getGlobalTotalToday(new CovidDataService.GetGlobalTotalTodayResponseListener() {
            @Override
            public void onError(String message) {
                Toast.makeText(getActivity(), "Something Wrong", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onResponse(CountryDataReportModel worldReport) {
                pieChartTotal = view.findViewById(R.id.overallChart2);
                 drawPieChart(pieChartTotal,
                            worldReport.getCases(), "Total cases",
                         worldReport.getDeaths(), "Total deaths",
                         worldReport.getRecovered(), "Total recovered");

                 pieChartToday = view.findViewById(R.id.overallChart3);
                drawPieChart(pieChartToday,
                        worldReport.getTodayCases(), "Today cases",
                        worldReport.getTodayDeaths(), "Today deaths",
                        worldReport.getTodayRecovered(), "Today recovered");
            }
        });

        return view;
    }

    public void drawPieChart(PieChart pieChart,
                             int cases, String casesLabel,
                             int deaths, String deathsLabel,
                             int recovered, String recoveredLabel) {

        ArrayList<PieEntry> patients = new ArrayList<>();
        patients.add(new PieEntry(cases, casesLabel));
        patients.add(new PieEntry(deaths, deathsLabel));
        patients.add(new PieEntry(recovered, recoveredLabel));

        PieDataSet pieDataSet = new PieDataSet(patients, "Patients");
        pieDataSet.setColors(ColorTemplate.COLORFUL_COLORS);
        pieDataSet.setValueTextColor(Color.BLACK);
        pieDataSet.setValueTextSize(16f);

        PieData pieData = new PieData(pieDataSet);
        pieChart.setData(pieData);
        pieChart.getDescription().setEnabled(false);
        pieChart.setCenterText("COVID Patients");
        pieChart.animate();
    }
}