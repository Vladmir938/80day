package com.example.a80daylab;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class QuizActivity extends AppCompatActivity {

    private Button btn_A, btn_B, btn_C, btn_D;
    private ImageView img1, img2, img3, img4;
    private TextView question;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        question = (TextView) findViewById(R.id.textQuestion);

        btn_A = (Button) findViewById(R.id.btn_a);
        btn_B = (Button) findViewById(R.id.btn_b);
        btn_C = (Button) findViewById(R.id.btn_c);
        btn_D = (Button) findViewById(R.id.btn_d);

        img1 = (ImageView) findViewById(R.id.imgAnswer1);
        img2 = (ImageView) findViewById(R.id.imgAnswer2);
        img3 = (ImageView) findViewById(R.id.imgAnswer3);
        img4 = (ImageView) findViewById(R.id.imgAnswer4);

        Intent intent = getIntent();
        String valueCity = intent.getStringExtra("filenameCity");
        String valueQue = intent.getStringExtra("filenameQuestions");
        String valueAnsButton = intent.getStringExtra("filenameAnswerButton");
        String valueAnswer = intent.getStringExtra("filenameAnswer");

        if (valueCity.equals("Moscow")) {
                img1.setImageResource(R.drawable.moscow_danilov);
                img2.setImageResource(R.drawable.moscow_diveev);
                img3.setImageResource(R.drawable.moscow_soloveckiy);
                img4.setImageResource(R.drawable.moscow_valaamskiy);
                question.setText(valueQue);
        }
        else if (valueCity.equals("Sydney")) {
            img1.setImageResource(R.drawable.sydney_maria);
            img2.setImageResource(R.drawable.sydney_oper);
            img3.setImageResource(R.drawable.sydney_taronga);
            img4.setImageResource(R.drawable.sydney_tele);
            question.setText(valueQue);
        }
        else if (valueCity.equals("Rio")) {
            img1.setImageResource(R.drawable.rio_lion);
            img2.setImageResource(R.drawable.rio_parrot);
            img3.setImageResource(R.drawable.rio_dolphin);
            img4.setImageResource(R.drawable.rio_zhir);
            question.setText(valueQue);
        }
        else if (valueCity.equals("Paris")) {
            img1.setImageResource(R.drawable.paris_klodmone);
            img2.setImageResource(R.drawable.paris_pascal);
            img3.setImageResource(R.drawable.paris_zhanna);
            img4.setImageResource(R.drawable.paris_jim);
            question.setText(valueQue);
        }

    }

    public void onClickA (View view) {
        Intent intent1 = getIntent();
        String valueAnsButton = intent1.getStringExtra("filenameAnswerButton");
        String valueAnswer = intent1.getStringExtra("filenameAnswer");
        if ("A".equals(valueAnsButton)) {
            AlertDialog.Builder builder = new AlertDialog.Builder(QuizActivity.this);
            builder.setTitle("Верно!")
                    .setMessage("Это " + valueAnswer)
                    .setCancelable(false)
                    .setPositiveButton("Продолжить", (dialog, id) ->
                    {dialog.cancel();
                        Intent intent = new Intent(QuizActivity.this, MapsActivity.class);
                        startActivity(intent);
                    });
            AlertDialog alert = builder.create();
            alert.show();
        } else {
            btn_A.setBackgroundColor(Color.RED);
        }
    }

    public void onClickB (View view) {
        Intent intent1 = getIntent();
        String valueAnsButton = intent1.getStringExtra("filenameAnswerButton");
        String valueAnswer = intent1.getStringExtra("filenameAnswer");
        if ("B".equals(valueAnsButton)) {
            AlertDialog.Builder builder = new AlertDialog.Builder(QuizActivity.this);
            builder.setTitle("Верно!")
                    .setMessage("Это " + valueAnswer)
                    .setCancelable(false)
                    .setPositiveButton("Продолжить", (dialog, id) ->
                    {dialog.cancel();
                        Intent intent = new Intent(QuizActivity.this, MapsActivity.class);
                        startActivity(intent);
                    });
            AlertDialog alert = builder.create();
            alert.show();
        } else {
            btn_B.setBackgroundColor(Color.RED);
        }
    }

    public void onClickC (View view) {
        Intent intent1 = getIntent();
        String valueAnsButton = intent1.getStringExtra("filenameAnswerButton");
        String valueAnswer = intent1.getStringExtra("filenameAnswer");
        if ("C".equals(valueAnsButton)) {
            AlertDialog.Builder builder = new AlertDialog.Builder(QuizActivity.this);
            builder.setTitle("Верно!")
                    .setMessage("Это " + valueAnswer)
                    .setCancelable(false)
                    .setPositiveButton("Продолжить", (dialog, id) ->
                    {dialog.cancel();
                        Intent intent = new Intent(QuizActivity.this, MapsActivity.class);
                        startActivity(intent);
                    });
            AlertDialog alert = builder.create();
            alert.show();
        } else {
            btn_C.setBackgroundColor(Color.RED);
        }
    }

    public void onClickD(View view) {
        Intent intent1 = getIntent();
        String valueAnsButton = intent1.getStringExtra("filenameAnswerButton");
        String valueAnswer = intent1.getStringExtra("filenameAnswer");
        if ("D".equals(valueAnsButton)) {
            AlertDialog.Builder builder = new AlertDialog.Builder(QuizActivity.this);
            builder.setTitle("Верно!")
                    .setMessage("Это " + valueAnswer)
                    .setCancelable(false)
                    .setPositiveButton("Продолжить", (dialog, id) ->
                    {dialog.cancel();
                        Intent intent = new Intent(QuizActivity.this, MapsActivity.class);
                        startActivity(intent);
                    });
            AlertDialog alert = builder.create();
            alert.show();
        } else {
            btn_D.setBackgroundColor(Color.RED);
        }
    }

}