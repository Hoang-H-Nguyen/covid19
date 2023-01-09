package usth.edu.covid19stats;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;

public class userInformation extends AppCompatActivity {

    Spinner nationality;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_information);

        nationality = (Spinner)findViewById(R.id.spinner);
        ArrayList<String> arrayNation = new ArrayList<String>();
        arrayNation.add("Vietnam");
        arrayNation.add("England");
        arrayNation.add("France");
        arrayNation.add("Korea");
        arrayNation.add("Japan");
        arrayNation.add("Germany");
        arrayNation.add("Spain");
        arrayNation.add("Thailand");
        arrayNation.add("China");
        arrayNation.add("India");
        arrayNation.add("Venezuela");

        ArrayAdapter arrayAdapter = new ArrayAdapter(this, android.R.layout.simple_spinner_item,arrayNation);
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        nationality.setAdapter(arrayAdapter);
        nationality.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(userInformation  .this, arrayNation.get(position), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }
}