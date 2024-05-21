package com.example.clickyhero;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import androidx.appcompat.app.AlertDialog;
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
    Combo currentCombo;
    ArrayList<Combo> comboList = new ArrayList<>();
    SharedPreferences sharedPreferences;
    int correctCombos;
    int attempts;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        Log.d("onCreate", "onCreate invoked ");
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_launcher);

        attempts = 0;
        sharedPreferences = getSharedPreferences("stats", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putInt("attempts", attempts);
        editor.apply();

        initializeList();

        tvCorrectCombos = findViewById(R.id.tvCorrectCombos);
        tvCorrectCombos.setText(getString(R.string.correct_combos, correctCombos));

        rvCombos = findViewById(R.id.rvCombos);
        rvCombos.setLayoutManager(new LinearLayoutManager(LauncherActivity.this));

        comboAdapter = new ComboAdapter(LauncherActivity.this, comboList, this);
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
            confirmReset();
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onItemClick(int position) {

        currentCombo = comboList.get(position);

        if(!currentCombo.isCompleted()) {
            Intent intent = new Intent(LauncherActivity.this, Attempt_Combo.class);
            intent.putExtra("combo", currentCombo);
            Log.d("Intent Launcher", "onItemClick: " + currentCombo);
            startActivity(intent, intent.getExtras());
        }
    }

    @Override
    protected void onResume() {

        super.onResume();

        int id = -1;

        if(currentCombo != null) {
            currentCombo.setCompleted(sharedPreferences.getBoolean("isCompleted", false));
            Log.d("onResume", "onResume: " + currentCombo.isCompleted());
            currentCombo.setIsCorrect(sharedPreferences.getInt("isCorrect", -1));
            Log.d("onResume", "onResume: " + currentCombo.isCorrect());
            id = currentCombo.getComboID();

            if(currentCombo.isCorrect() == 1) {
                correctCombos++;
                tvCorrectCombos.setText(getString(R.string.correct_combos, correctCombos));
            }
        }

        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.remove("isCompleted");
        editor.remove("isCorrect");
        editor.apply();

        if(updateList(id, currentCombo)) {
            comboAdapter.notifyDataSetChanged();
        }

        attempts = sharedPreferences.getInt("attempts", 0);

        if(attempts == 5) {
            showCongratulationsActivity();
        }
    }

    private boolean updateList(int id, Combo c) {

        if (id != -1) {
            for (Combo combo : comboList) {
                if (combo.getComboID() == id) {
                    int position = comboList.indexOf(combo);
                    comboList.remove(position);
                    comboList.add(position, c);
                    return true;
                }
            }
        }
        return false;
    }

    private void showCongratulationsActivity() {

        Intent intent = new Intent(LauncherActivity.this, CongratulationsActivity.class);
        intent.putExtra("correctCombos", correctCombos);
        startActivity(intent, intent.getExtras());
    }

    private void confirmReset() {

        AlertDialog alertDialog = new AlertDialog.Builder(this).create();

        alertDialog.setTitle("Confirm");
        alertDialog.setMessage("The game will be reset. Are you sure?");

        alertDialog.setButton(DialogInterface.BUTTON_NEGATIVE, "No", (dialog, which) -> {
        });

        alertDialog.setButton(DialogInterface.BUTTON_POSITIVE, "Yes", (dialog, which) -> {
            initializeList();
            comboAdapter.notifyDataSetChanged();
        });

        alertDialog.show();
    }

    public void initializeList() {

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

        if(!comboList.isEmpty())
            comboList.clear();

        comboList.add(new Combo(1, "Cheetah Sprint", sequence1, 4, false, -1));
        comboList.add(new Combo(2, "Cheetah Jump", sequence2, 5, false, -1));
        comboList.add(new Combo(3, "Cheetah Back Flip", sequence3, 4, false, -1));
        comboList.add(new Combo(4, "Cheetah Dive", sequence4, 4, false, -1));
        comboList.add(new Combo(5, "Cheetah Zap", sequence5, 6, false, -1));

        Collections.shuffle(comboList);
    }
}