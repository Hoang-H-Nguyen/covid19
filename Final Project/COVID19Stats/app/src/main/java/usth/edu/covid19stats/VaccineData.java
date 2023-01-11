package usth.edu.covid19stats;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.widget.Toast;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;
import java.util.List;

public class VaccineData extends AppCompatActivity {

    BarChart barChart;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vaccine_data);


        CovidDataService covidDataService = new CovidDataService(VaccineData.this);
        covidDataService.getVaccineData(new CovidDataService.GetVaccineDataResponseListener() {
            @Override
            public void onError(String message) {
                Toast.makeText(VaccineData.this, "Something Wrong", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onResponse(List<Integer> everydayVaccinedose) {
                barChart = findViewById(R.id.vaccineDataChart);
                ArrayList<BarEntry> vaccineDoses = new ArrayList<>();

                vaccineDoses.add(new BarEntry(1, everydayVaccinedose.get(0)));
                vaccineDoses.add(new BarEntry(2, everydayVaccinedose.get(1)));
                vaccineDoses.add(new BarEntry(3, everydayVaccinedose.get(2)));
                vaccineDoses.add(new BarEntry(4, everydayVaccinedose.get(3)));
                vaccineDoses.add(new BarEntry(5, everydayVaccinedose.get(4)));
                vaccineDoses.add(new BarEntry(6, everydayVaccinedose.get(5)));
                vaccineDoses.add(new BarEntry(7, everydayVaccinedose.get(6)));

                BarDataSet barDataSet = new BarDataSet(vaccineDoses, "Vaccine Doses");
                barDataSet.setColors(ColorTemplate.COLORFUL_COLORS);
                barDataSet.setValueTextColor(Color.BLACK);
                barDataSet.setValueTextSize(16f);

                BarData barData = new BarData(barDataSet);
                barData.setDrawValues(false);

                barChart.setFitBars(true);
                barChart.setData(barData);
                barChart.getDescription().setText("Vaccine Dose Barchart");
                barChart.animateY(2000);
            }
        });
    }
}