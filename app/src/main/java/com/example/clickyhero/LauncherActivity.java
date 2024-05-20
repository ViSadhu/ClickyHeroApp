package com.example.clickyhero;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class LauncherActivity extends AppCompatActivity implements RecyclerViewClickListener {

    RecyclerView rvCombos;
    TextView tvCorrectCombos;
    ComboAdapter comboAdapter;
    ArrayList<Combo> comboList;
    int correctCombos = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_launcher);

        tvCorrectCombos = findViewById(R.id.tvCorrectCombos);
        tvCorrectCombos.setText(getString(R.string.correct_combos, correctCombos));

        rvCombos = findViewById(R.id.rvCombos);
        rvCombos.setLayoutManager(new LinearLayoutManager( LauncherActivity.this));

        DBHelper db = new DBHelper(this);

        comboList = db.getAllCombos();

        comboAdapter = new ComboAdapter(comboList, this);
        rvCombos.setAdapter(comboAdapter);
    }

    @Override
    public void onItemClick(int position) {

        Combo comboToPass = comboList.get(position);

        if(comboToPass.isCompleted() == -1) {
            Intent intent = new Intent(LauncherActivity.this, Attempt_Combo.class);
            intent.putExtra("combo", comboToPass);
            startActivity(intent);
        }
    }
}