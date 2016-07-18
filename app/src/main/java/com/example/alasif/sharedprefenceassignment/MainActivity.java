package com.example.alasif.sharedprefenceassignment;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private static RadioGroup radioGroup;
    private static RadioButton radioButton;
    private static Button saveButton;

    //date picker part

    Button datePickerButton;
    int year_x, month_x, day_x;
    static final int DIALOG_ID = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        onClickListenerButton();

        showDialog();
    }

    public void onClickListenerButton(){
        radioGroup = (RadioGroup) findViewById(R.id.radioGrp);
        saveButton = (Button) findViewById(R.id.saveButton);
        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int selectedId = radioGroup.getCheckedRadioButtonId();
                radioButton = (RadioButton) findViewById(selectedId);
                Toast.makeText(MainActivity.this, radioButton.getText().toString(), Toast.LENGTH_LONG).show();
            }
        });
    }

    public void showDialog(){
        datePickerButton = (Button) findViewById(R.id.ExamDateButton);
        datePickerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showDialog(DIALOG_ID);
            }
        });
    }

    @Override
    protected Dialog onCreate(int id){
        if(id == DIALOG_ID)
            return new DatePickerDialog(this, dpickerListener, year_x, month_x, day_x);
        return null;
    }

    private DatePickerDialog.OnDateSetListener dpickerListener
           = new DatePickerDialog.OnDateSetListener() {
        @Override
        public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {
            year_x = i;
            month_x = i1;
            day_x = i2;
            Toast.makeText(MainActivity.this,year_x+"/ "+month_x+"/ "+day_x,Toast.LENGTH_LONG).show();
        }
    };

    }

