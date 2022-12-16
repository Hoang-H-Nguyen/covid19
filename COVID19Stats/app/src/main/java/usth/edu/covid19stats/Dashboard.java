package usth.edu.covid19stats;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Dashboard extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        Button settingBtn = (Button) findViewById(R.id.settingBtn);
        Button healthDeclareationBtn = (Button) findViewById(R.id.healthDeclarationBtn);
        Button dataCovidBtn = (Button)findViewById(R.id.dataCovidBtn);
        Button vaccinePassportBtn = (Button)findViewById(R.id.vaccinePassportBtn);
        Button paperWalletBtn = (Button)findViewById(R.id.paperWalletBtn);
        Button handbookBtn = (Button)findViewById(R.id.handbookBtn);
        Button reportBtn = (Button)findViewById(R.id.reportBtn);
        Button notificationBtn = (Button)findViewById(R.id.notificationBtn);

        settingBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Dashboard.this, Settings.class);
                startActivity(i);
            }
        });

        healthDeclareationBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse("https://tokhaiyte.vn/"));
                startActivity(i);
            }
        });

        dataCovidBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.arcgis.com/apps/dashboards/85320e2ea5424dfaaa75ae62e5c06e61"));
                startActivity(i);
            }
        });

        handbookBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse("https://covid19.hochiminhcity.gov.vn/health-care/-/asset_publisher/ZSHLi888uq2s/content/so-tay-suc-khoe-covid--1?fbclid=IwAR1C6Pgkt6OJsUfJFLi_g7E1x4Ji6b4dQ34fT7Vl0ohXxrLOmcCbAe2gZw8"));
                startActivity(i);
            }
        });


        vaccinePassportBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Dashboard.this, VaccinePassport.class);
                startActivity(i);
            }
        });

        paperWalletBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Dashboard.this, PaperWallet.class);
                startActivity(i);
            }
        });

        reportBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Dashboard.this, Newspaper.class);
                startActivity(i);
            }
        });

        notificationBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Dashboard.this, Notification.class);
                startActivity(i);
            }
        });
    }
}