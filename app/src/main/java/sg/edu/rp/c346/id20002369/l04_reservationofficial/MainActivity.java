package sg.edu.rp.c346.id20002369.l04_reservationofficial;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TimePicker;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText etName, etPhone, etSize;
    CheckBox checkbox;
    DatePicker dp;
    TimePicker tp;
    Button btnCmf, btnRst;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Variable link to UI element
        etName = findViewById(R.id.editTextName);
        etPhone = findViewById(R.id.editTextPhone);
        etSize = findViewById(R.id.editTextSize);
        checkbox = findViewById(R.id.checkBox);
        dp = findViewById(R.id.datePicker);
        tp = findViewById(R.id.timePicker);
        btnCmf = findViewById(R.id.buttonCmf);
        btnRst = findViewById(R.id.buttonRst);

        //Set date to default first
        dp.updateDate(2021, 5, 1);

        btnCmf.setOnClickListener((v) -> {
            //store or convert all the input to a string variable
            String name = etName.getText().toString();
            String num = etPhone.getText().toString();
            String noOfSize = etSize.getText().toString();

            //store or check if smoking is ticked or not
            String checkSmoking = "";
            if (checkbox.isChecked()) {
                checkSmoking = "Smoking";
            } else {
                checkSmoking = "Non-smoking";
            }

            //store user's entered data and time into string variable with proper display format
            String date = dp.getYear() + "/" + (dp.getMonth() + 1) + "/" + dp.getDayOfMonth();
            String time = tp.getCurrentHour() + ":" + String.format("%02d", tp.getCurrentMinute());

            String message = "Hi, " + name + ", you have booked a " + noOfSize + "people"
                    + checkSmoking + " table on " + date + " at " + time + ". Your contact details are " + num + ".";


            //Create Toast
            Toast.makeText(MainActivity.this, message, Toast.LENGTH_LONG).show();
        });

        //OnClickListener for Resetbtn
        btnRst.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                etName.setText("");
                etPhone.setText("");
                etSize.setText("");
                checkbox.setChecked(false);
                dp.updateDate(2021, 5, 1);
                tp.setCurrentHour(19);
                tp.setCurrentMinute(30);
            }

        });

    }
}