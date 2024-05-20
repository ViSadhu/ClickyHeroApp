package com.example.clickyhero;

import static com.example.clickyhero.ComboAdapter.getImgResource;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Attempt_Combo extends AppCompatActivity {
    TextView tvComboTitle;
    ImageView ivArrow0;
    ImageView ivArrow1;
    ImageView ivArrow2;
    ImageView ivArrow3;
    ImageView ivArrow4;
    ImageView ivArrow5;
    ImageView ivArrow6;
    ImageView ivArrow7;
    ImageButton ibArrowUp;
    ImageButton ibArrowDown;
    ImageButton ibArrowLeft;
    ImageButton ibArrowRight;
    String sequence;
    String attempedSequence = "";
    int numClicks = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        Bundle bundle = getIntent().getExtras();
        assert bundle != null;
        Combo receivedCombo = (Combo) bundle.getSerializable("combo");

        setContentView(R.layout.activity_attempt_combo);

        assert receivedCombo != null;
        sequence = receivedCombo.getSequence();

        tvComboTitle = findViewById(R.id.tvComboTitle);

        ivArrow0 = findViewById(R.id.ivArrow0);
        ivArrow1 = findViewById(R.id.ivArrow1);
        ivArrow2 = findViewById(R.id.ivArrow2);
        ivArrow3 = findViewById(R.id.ivArrow3);
        ivArrow4 = findViewById(R.id.ivArrow4);
        ivArrow5 = findViewById(R.id.ivArrow5);
        ivArrow6 = findViewById(R.id.ivArrow6);
        ivArrow7 = findViewById(R.id.ivArrow7);

        ibArrowUp = findViewById(R.id.ibArrowUp);
        ibArrowDown = findViewById(R.id.ibArrowDown);
        ibArrowLeft = findViewById(R.id.ibArrowLeft);
        ibArrowRight = findViewById(R.id.ibArrowRight);

        tvComboTitle.setText(receivedCombo.getComboName());
        ivArrow0.setImageResource(getImgResource(receivedCombo.getSequence(), 0));
        ivArrow1.setImageResource(getImgResource(receivedCombo.getSequence(), 1));
        ivArrow2.setImageResource(getImgResource(receivedCombo.getSequence(), 2));
        ivArrow3.setImageResource(getImgResource(receivedCombo.getSequence(), 3));
        ivArrow4.setImageResource(getImgResource(receivedCombo.getSequence(), 4));
        ivArrow5.setImageResource(getImgResource(receivedCombo.getSequence(), 5));
        ivArrow6.setImageResource(getImgResource(receivedCombo.getSequence(), 6));
        ivArrow7.setImageResource(getImgResource(receivedCombo.getSequence(), 7));

        ibArrowUp.setOnClickListener(ArrowClickListener('U'));
        ibArrowDown.setOnClickListener(ArrowClickListener('D'));
        ibArrowLeft.setOnClickListener(ArrowClickListener('L'));
        ibArrowRight.setOnClickListener(ArrowClickListener('R'));

    }

    private void checkSequence() {
        if (attempedSequence.equals(sequence)) {
            Toast.makeText(this, "Correct!", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "Incorrect!", Toast.LENGTH_SHORT).show();
        }
    }

    public View.OnClickListener ArrowClickListener(char arrow) {

        return v -> {
            switch (arrow) {
                case 'U':
                    attempedSequence += "U";
                    updateImageView(arrow, numClicks++);
                    break;
                case 'D':
                    attempedSequence += "D";
                    updateImageView(arrow, numClicks++);
                    break;
                case 'L':
                    attempedSequence += "L";
                    updateImageView(arrow, numClicks++);
                    break;
                case 'R':
                    attempedSequence += "R";
                    updateImageView(arrow, numClicks++);
                    break;
            }
        };
    }

    private void updateImageView(char arrow, int position) {

        switch (position) {
            case 0:
                ivArrow0.setImageResource(sequence.charAt(position) == arrow ?
                        android.R.drawable.btn_star_big_on : android.R.drawable.btn_star_big_off);
                break;
            case 1:
                ivArrow1.setImageResource(sequence.charAt(position) == arrow ?
                        android.R.drawable.btn_star_big_on : android.R.drawable.btn_star_big_off);
                break;
            case 2:
                ivArrow2.setImageResource(sequence.charAt(position) == arrow ?
                        android.R.drawable.btn_star_big_on : android.R.drawable.btn_star_big_off);
                break;
            case 3:
                ivArrow3.setImageResource(sequence.charAt(position) == arrow ?
                        android.R.drawable.btn_star_big_on : android.R.drawable.btn_star_big_off);
                break;
            case 4:
                ivArrow4.setImageResource(sequence.charAt(position) == arrow ?
                        android.R.drawable.btn_star_big_on : android.R.drawable.btn_star_big_off);
                break;
            case 5:
                ivArrow5.setImageResource(sequence.charAt(position) == arrow ?
                        android.R.drawable.btn_star_big_on : android.R.drawable.btn_star_big_off);
                break;
            case 6:
                ivArrow6.setImageResource(sequence.charAt(position) == arrow ?
                        android.R.drawable.btn_star_big_on : android.R.drawable.btn_star_big_off);
                break;
            case 7:
                ivArrow7.setImageResource(sequence.charAt(position) == arrow ?
                        android.R.drawable.btn_star_big_on : android.R.drawable.btn_star_big_off);
                break;
        }
    }
}