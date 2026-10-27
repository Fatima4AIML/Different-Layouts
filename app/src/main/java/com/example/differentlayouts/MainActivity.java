
package com.example.differentlayouts;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    EditText nameInput, emailInput;
    Spinner departmentSpinner;
    RadioGroup genderGroup;
    CheckBox termsCheckBox;
    Button registerButton, clearButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nameInput = findViewById(R.id.nameInput);
        emailInput = findViewById(R.id.emailInput);
        departmentSpinner = findViewById(R.id.departmentSpinner);
        genderGroup = findViewById(R.id.genderGroup);
        termsCheckBox = findViewById(R.id.termsCheckBox);
        registerButton = findViewById(R.id.registerButton);
        clearButton = findViewById(R.id.clearButton);

        String[] departments = {
                "Select Department",
                "Information Technology",
                "Computer Science",
                "Software Engineering"
        };

        ArrayAdapter<String> adapter = new ArrayAdapter<>(
                this,
                android.R.layout.simple_spinner_item,
                departments
        );

        adapter.setDropDownViewResource(
                android.R.layout.simple_spinner_dropdown_item
        );

        departmentSpinner.setAdapter(adapter);

        registerButton.setOnClickListener(v -> {
            String name = nameInput.getText().toString().trim();
            String email = emailInput.getText().toString().trim();

            if (name.isEmpty() || email.isEmpty()) {
                Toast.makeText(this,
                        "Please enter your name and email",
                        Toast.LENGTH_SHORT).show();
            } else if (departmentSpinner.getSelectedItemPosition() == 0) {
                Toast.makeText(this,
                        "Please select a department",
                        Toast.LENGTH_SHORT).show();
            } else if (genderGroup.getCheckedRadioButtonId() == -1) {
                Toast.makeText(this,
                        "Please select your gender",
                        Toast.LENGTH_SHORT).show();
            } else if (!termsCheckBox.isChecked()) {
                Toast.makeText(this,
                        "Please accept the terms and conditions",
                        Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this,
                        "Registration successful!",
                        Toast.LENGTH_LONG).show();
            }
        });

        clearButton.setOnClickListener(v -> {
            nameInput.setText("");
            emailInput.setText("");
            departmentSpinner.setSelection(0);
            genderGroup.clearCheck();
            termsCheckBox.setChecked(false);
        });
    }
}
