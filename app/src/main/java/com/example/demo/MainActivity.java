package com.example.demo;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btn_cal = (Button) findViewById(R.id.btn_cal);

        btn_cal.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent page_Calculatrice = new Intent(MainActivity.this, Calculatrice.class );
                startActivity(page_Calculatrice);
            }
        });

        Button btn_contact = (Button) findViewById(R.id.btn_contact);

        btn_contact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent page_contact = new Intent(MainActivity.this, Contacts.class );
                startActivity(page_contact);
            }
        });
    }

}
