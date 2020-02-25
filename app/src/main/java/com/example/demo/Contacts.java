package com.example.demo;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import adapter.Adapter;
import models.User;

public class Contacts extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contacts);
        this.setTitle("Liste des utilisateurs");

        List<User> UserList = new ArrayList<>();
        ListView listView = (ListView) findViewById(R.id.listUser) ;
        UserList.add(new User("Lucas","96346856"));
        UserList.add(new User("Kismath", "96192019"));
        UserList.add(new User("Farhane", "61720976"));
        UserList.add(new User("Ipopo", "67712006"));
        UserList.add(new User("Enock", "67712006"));



       listView.setAdapter(new Adapter(this,UserList));

      listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                User item = (User) parent.getItemAtPosition(position);
                Intent intent = new Intent(Contacts.this, Details.class);
                intent.putExtra("user_name", item.getname());
                intent.putExtra("user_phone", item.getPhone());
                startActivity(intent);
            }
        });
    }
}