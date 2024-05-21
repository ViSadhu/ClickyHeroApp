package com.example.clickyhero;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class CongratulationsActivity extends AppCompatActivity {

    TextView tvMessage2;
    Button btnPlayAgain;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_congratulations);

        Bundle bundle = getIntent().getExtras();
        assert bundle != null;
        int numCorrectCombos = bundle.getInt("correctCombos");

        tvMessage2 = findViewById(R.id.tvMessage2);
        tvMessage2.setText(getString(R.string.message2, numCorrectCombos));

        btnPlayAgain = findViewById(R.id.btnPlayAgain);
        btnPlayAgain.setOnClickListener(v -> {
            Intent intent = new Intent(this, LauncherActivity.class);
            startActivity(intent);
            finish();
        });

    }
}