package sg.edu.rp.c346.id18015518.mybmicalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    EditText etWeight;
    EditText etHeight;
    Button btnCalculate;
    Button btnResetData;
    TextView tvDate;
    TextView tvCalculate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etWeight = findViewById(R.id.editTextWeight);
        etHeight = findViewById(R.id.editTextHeight);
        tvDate = findViewById(R.id.textViewDate);
        tvCalculate = findViewById(R.id.textViewCalculate);
        btnCalculate = findViewById(R.id.buttonCalculate);
        btnResetData = findViewById(R.id.buttonResetData);

        btnCalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Calendar now = Calendar.getInstance();  //Create a Calendar object with current date and time
                String datetime = now.get(Calendar.DAY_OF_MONTH) + "/" +
                        (now.get(Calendar.MONTH)+1) + "/" +
                        now.get(Calendar.YEAR) + " " +
                        now.get(Calendar.HOUR_OF_DAY) + ":" +
                        now.get(Calendar.MINUTE);

                tvDate.setText("Last Calculated Date:" + datetime);

                int bmiWeight = Integer.parseInt(etWeight.getText().toString());
                int bmiHeight = Integer.parseInt(etHeight.getText().toString());

                int bmi = (bmiWeight/(bmiHeight * bmiHeight));
                String calc = Integer.toString(bmi);

                tvCalculate.setText("Last Calculated BMI: " + calc);

            }
        });

        btnResetData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tvDate.setText("");
                tvCalculate.setText("");
            }
        });
    }
}
