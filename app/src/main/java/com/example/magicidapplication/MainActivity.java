package com.example.magicidapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText etEdit;
    Button btnSubmit;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etEdit = findViewById(R.id.etID);
        btnSubmit = findViewById(R.id.btnSubmit);
        textView = findViewById(R.id.textView);

        textView.setVisibility(View.GONE);

        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String idNumber = etEdit.getText().toString().trim();

                String dob = idNumber.substring(0, 6);

                int gender = Integer.parseInt(Character.toString(idNumber.charAt(6)));

                String sGender;

                if (gender < 5)
                    sGender = "'Female'";
                else
                    sGender = "Male";

                int nationality = Integer.parseInt(Character.toString(idNumber.charAt(10)));

                String sNationality;

                if (nationality == 0)
                    sNationality = getString(R.string.saCitizen);
                else
                    sNationality = getString(R.string.pr);

                String text = getString(R.string.dob) +dob+ getString(R.string.newLine) +
                        getString(R.string.gender) + sGender + getString(R.string.newLine) +
                        getString(R.string.nationality) + sNationality;

                textView.setText(text);
                textView.setVisibility(View.VISIBLE);
            }
        });
    }
}