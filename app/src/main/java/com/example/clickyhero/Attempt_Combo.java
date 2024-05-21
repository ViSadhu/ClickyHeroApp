package com.example.clickyhero;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Objects;

public class Attempt_Combo extends AppCompatActivity {
    TextView tvComboTitle;
    RecyclerView rvArrows2;
    ImageButton ibArrowUp;
    ImageButton ibArrowDown;
    ImageButton ibArrowLeft;
    ImageButton ibArrowRight;
    Combo receivedCombo;
    ArrayList<Integer> sequenceImages;
    ArrayList<Integer> attempedSequence;;
    private int numClicks = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_attempt_combo);

        attempedSequence = new ArrayList<>();

        Bundle bundle = getIntent().getExtras();
        assert bundle != null;
        receivedCombo = (Combo) bundle.getSerializable("combo");
        assert receivedCombo != null;
        sequenceImages = receivedCombo.getSequenceImages();
        Log.d("Bundle", "sequenceImages: " + sequenceImages);

        rvArrows2 = findViewById(R.id.rvArrows2);
        ArrowAdapter arrowAdapter = new ArrowAdapter(sequenceImages);
        rvArrows2.setAdapter(arrowAdapter);

        tvComboTitle = findViewById(R.id.tvComboTitle);

        ibArrowUp = findViewById(R.id.ibArrowUp);
        ibArrowDown = findViewById(R.id.ibArrowDown);
        ibArrowLeft = findViewById(R.id.ibArrowLeft);
        ibArrowRight = findViewById(R.id.ibArrowRight);

        tvComboTitle.setText(receivedCombo.getComboName());

        ibArrowUp.setOnClickListener(ArrowClickListener(R.drawable.up));
        ibArrowDown.setOnClickListener(ArrowClickListener(R.drawable.down));
        ibArrowLeft.setOnClickListener(ArrowClickListener(R.drawable.left));
        ibArrowRight.setOnClickListener(ArrowClickListener(R.drawable.right));

    }

    private void checkSequenceAndQuit() {

        SharedPreferences sharedPreferences = getSharedPreferences("stats", MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putBoolean("isCompleted", true);

        int attempts = sharedPreferences.getInt("attempts", 0);
        editor.putInt("attempts", attempts + 1);

        if (attempedSequence.equals(sequenceImages)) {
            Toast.makeText(this, "Correct!", Toast.LENGTH_SHORT).show();

            editor.putInt("isCorrect", 1);

        } else {
            Toast.makeText(this, "Incorrect!", Toast.LENGTH_SHORT).show();

            editor.putInt("isCorrect", 0);
        }

        editor.apply();
        finish();
    }

    public View.OnClickListener ArrowClickListener(int arrow) {

        return v -> {
            attempedSequence.add(arrow);
            updateImageView(arrow, numClicks);
            numClicks++;
            if (numClicks == sequenceImages.size()) {
                checkSequenceAndQuit();
            }
        };
    }

    private void updateImageView(int arrow, int position) {

        ImageView ivArrow = Objects.requireNonNull(rvArrows2.findViewHolderForAdapterPosition(position))
                .itemView.findViewById(R.id.ivArrow);

        ivArrow.setImageResource(arrow == sequenceImages.get(position)
                ? android.R.drawable.btn_star_big_on : android.R.drawable.btn_star_big_off);

    }
}