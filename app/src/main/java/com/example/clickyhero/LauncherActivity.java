package com.example.clickyhero;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class LauncherActivity extends AppCompatActivity implements RecyclerViewClickListener {

    RecyclerView rvCombos;
    TextView tvCorrectCombos;
    ComboAdapter comboAdapter;
    ArrayList<Combo> comboList = new ArrayList<>();
    int correctCombos;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_launcher);

        tvCorrectCombos = findViewById(R.id.tvCorrectCombos);

        rvCombos = findViewById(R.id.rvCombos);

        initialize();

        rvCombos.setLayoutManager(new LinearLayoutManager( LauncherActivity.this));

        comboAdapter = new ComboAdapter(comboList, this);
        rvCombos.setAdapter(comboAdapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.restart_menu_button, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.btnReset) {
            initialize();
            comboAdapter.notifyDataSetChanged();
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onItemClick(int position) {

        Combo comboToPass = comboList.get(position);

        Intent intent = new Intent(LauncherActivity.this, Attempt_Combo.class);
        intent.putExtra("comboName", comboToPass.getComboName());
        intent.putExtra("comboSequence", comboToPass.getSequenceImages());
        Log.d("Intent this", "onItemClick: " + comboToPass.getSequenceImages());
        startActivity(intent);
    }
    public void initialize() {

        ArrayList<Integer> sequence1 = new ArrayList<>(Arrays.asList(
                R.drawable.right, R.drawable.right, R.drawable.up, R.drawable.right));
        ArrayList<Integer> sequence2 = new ArrayList<>(Arrays.asList(
                R.drawable.left, R.drawable.up, R.drawable.up, R.drawable.down, R.drawable.left));
        ArrayList<Integer> sequence3 = new ArrayList<>(Arrays.asList(
                R.drawable.up, R.drawable.left, R.drawable.left, R.drawable.down));
        ArrayList<Integer> sequence4 = new ArrayList<>(Arrays.asList(
                R.drawable.down, R.drawable.down, R.drawable.right, R.drawable.down));
        ArrayList<Integer> sequence5 = new ArrayList<>(Arrays.asList(
                R.drawable.up, R.drawable.down, R.drawable.up, R.drawable.right, R.drawable.left, R.drawable.right));

        correctCombos = 0;
        tvCorrectCombos.setText(getString(R.string.correct_combos, correctCombos));

        if (!comboList.isEmpty()) {
            comboList.clear();
        }

        comboList.add(new Combo(1,"Cheetah Sprint", sequence1, 4, -1, -1));
        comboList.add(new Combo(2,"Cheetah Jump", sequence2, 5, -1, -1));
        comboList.add(new Combo(3,"Cheetah Backflip", sequence3, 4, -1, -1));
        comboList.add(new Combo(4,"Cheetah Dive", sequence4, 4, -1, -1));
        comboList.add(new Combo(5,"Cheetah Zap", sequence5, 6, -1, -1));

        Collections.shuffle(comboList);
    }
}