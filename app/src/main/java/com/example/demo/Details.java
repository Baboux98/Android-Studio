package com.example.demo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Details extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        Bundle bundle = getIntent().getExtras();
        this.setTitle("Détails ");
        if (bundle != null) {
            TextView name = (TextView) findViewById(R.id.txt_user_name);
            TextView telephone = (TextView) findViewById(R.id.user_phone);


            String first_name = bundle.getString("user_name");
            final String phone = bundle.getString("user_phone");

            name.setText(first_name);
            telephone.setText(phone);
            Button Call = (Button) findViewById(R.id.Make_a_call);

            Call.setOnClickListener(new View.OnClickListener() {
                public void onClick(View arg0) {
                    Intent callIntent = new Intent(Intent.ACTION_CALL);
                    String appel = "tel:" + phone;
                    callIntent.setData(Uri.parse(appel));

                    if (ActivityCompat.checkSelfPermission(Details.this,
                            Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                        return;
                    }
                    startActivity(callIntent);
                }
            });

        }

    }
}
