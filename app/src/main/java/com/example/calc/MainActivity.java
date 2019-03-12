package com.example.calc;

import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button calc;
    Button exit;
    Button about;


    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        calc = findViewById(R.id.calc);
        exit = findViewById(R.id.exit);
        about = findViewById(R.id.about);
        View.OnClickListener onClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch (view.getId()) {
                    case (R.id.calc):
                        Intent intent = new Intent(getApplicationContext(), CalcActivity.class);
                        startActivity(intent);
                        break;
                    case (R.id.exit):
                        finish();
                        break;
                    case (R.id.about):
                        new AlertDialog.Builder(getApplicationContext())
                                .setTitle("About")
                                .setMessage("Creator:AnnaBA")
                                .show();
                        break;
                }

            }
        };
        calc.setOnClickListener(onClickListener);
        exit.setOnClickListener(onClickListener);
        about.setOnClickListener(onClickListener);
    }
}
