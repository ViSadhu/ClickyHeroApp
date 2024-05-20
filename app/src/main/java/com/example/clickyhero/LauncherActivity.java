package com.example.clickyhero;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class LauncherActivity extends AppCompatActivity {

    RecyclerView rvCombos;
    ComboAdapter comboAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_launcher);

        rvCombos = findViewById(R.id.rvCombos);
        rvCombos.setLayoutManager(new LinearLayoutManager( LauncherActivity.this));

        DBHelper db = new DBHelper(LauncherActivity.this);

        ArrayList<Combo> comboList = db.getAllCombos();

        comboAdapter = new ComboAdapter(comboList);
        rvCombos.setAdapter(comboAdapter);
    }
}