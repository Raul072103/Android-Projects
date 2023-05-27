package com.example.atm_3;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RatingBar;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Calendar;

public class NewTripActivity extends AppCompatActivity {

    public static final String EXTRA_TRIP_NAME =
            "com.example.atm_3.EXTRA_TRIP_NAME";
    public static final String EXTRA_DESTINATION =
            "com.example.atm_3.EXTRA_DESTINATION";
    public static final String EXTRA_NR_OF_STARS =
            "com.example.atm_3.EXTRA_NR_OF_STARS";
    public static final String EXTRA_IS_CHECKED =
            "com.example.atm_3.EXTRA_IS_CHECKED";

    public static final String EXTRA_PRICE =
            "com.example.atm_3.EXTRA_PRICE";

    public static final String EXTRA_START_DATE =
            "com.example.atm_3.EXTRA_START_DATE";

    public static final String EXTRA_END_DATE =
            "com.example.atm_3.EXTRA_END_DATE";

    public static final String EXTRA_SEA_SIDE=
            "com.example.atm_3.EXTRA_SEA_SIDE";

    public static final String EXTRA_MOUNTAINS =
            "com.example.atm_3.EXTRA_MOUNTAINS";

    public static final String EXTRA_CITY_BREAK =
            "com.example.atm_3.EXTRA_CITY_BREAK";

    public static final String EXTRA_ID =
            "com.example.atm_3.EXTRA_ID";

    int priceSelected;
    SeekBar priceSeekBar;
    CheckBox checkBoxFavourite;
    TextView textView;
    EditText editTextTripName, editTextDestination;
    TextView textViewStartDate, textViewEndDate;
    RatingBar starRatingBar;
    RadioGroup radioGroup;
    RadioButton radioButtonCityBreak, radioButtonSeaSide, radioButtonMountains;
    Button saveButton;
    ImageButton startDateButton, endDateButton;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_trip);
        priceSeekBar = findViewById(R.id.priceRangeBar);
        textView = findViewById(R.id.textViewTripView);
        editTextTripName = findViewById(R.id.TripNameEditText);
        editTextDestination = findViewById(R.id.DestinationEditText);
        starRatingBar = findViewById(R.id.ratingBarEditTrip);
        startDateButton = findViewById(R.id.startDateButton);
        endDateButton = findViewById(R.id.endDateButton);
        radioGroup = findViewById(R.id.radioGroupEditTrip);
        radioButtonCityBreak = findViewById(R.id.cityBreakRadioButton);
        radioButtonSeaSide = findViewById(R.id.seaSideRadioButton);
        radioButtonMountains = findViewById(R.id.mountainsRadioButton);
        textViewStartDate = findViewById(R.id.StartDateTextView);
        textViewEndDate = findViewById(R.id.EndDateTextView);
        checkBoxFavourite = findViewById(R.id.checkBoxNewTrip);

        Button button = findViewById(R.id.save_button);

        priceSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                textView.setVisibility(View.VISIBLE);
                priceSelected = progress;
                textView.setText(progress + "$");
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        // here are the date Pickers

        final Calendar c = Calendar.getInstance();
        int startYear = c.get(Calendar.YEAR);
        int startMonth = c.get(Calendar.MONTH);
        int startDay = c.get(Calendar.DAY_OF_MONTH);

        int endYear = c.get(Calendar.YEAR);
        int endMonth = c.get(Calendar.MONTH);
        int endDay = c.get(Calendar.DAY_OF_MONTH);

        startDateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                DatePickerDialog datePickerDialog = new DatePickerDialog(NewTripActivity.this,
                        new DatePickerDialog.OnDateSetListener() {
                            @Override
                            public void onDateSet(DatePicker view, int startYear, int startMonth, int startDay) {
                                textViewStartDate.setText(startDay + "/" + startMonth + "/" + startYear);
                            }
                        }, startYear, startMonth, startDay);
                datePickerDialog.show();

            }
        });

        endDateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                DatePickerDialog datePickerDialog = new DatePickerDialog(NewTripActivity.this,
                        new DatePickerDialog.OnDateSetListener() {
                            @Override
                            public void onDateSet(DatePicker view, int endYear, int endMonth, int endDay) {
                                textViewEndDate.setText(endDay + "/" + endMonth + "/" + endYear);
                            }
                        }, endYear, endMonth, endDay);
                datePickerDialog.show();

            }
        });


        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                saveTrip();
            }
        });

        Intent intent = getIntent();
        if(intent.hasExtra(EXTRA_ID)){
            editTextTripName.setText(intent.getStringExtra(EXTRA_TRIP_NAME));
            editTextDestination.setText(intent.getStringExtra(EXTRA_DESTINATION));
            starRatingBar.setNumStars(intent.getIntExtra(EXTRA_NR_OF_STARS, 1));
            checkBoxFavourite.setChecked(intent.getBooleanExtra(EXTRA_IS_CHECKED, false));
        }


    }

    private void saveTrip(){
        String tripName = editTextTripName.getText().toString();
        String destination = editTextDestination.getText().toString();
        String textViewPrice = textView.getText().toString();
        String startDate = textViewStartDate.getText().toString();
        String endDate = textViewEndDate.getText().toString();
        int nrOfStars = starRatingBar.getNumStars();
        boolean seaSide = radioButtonSeaSide.isChecked();
        boolean mountains = radioButtonMountains.isChecked();
        boolean cityBreak = radioButtonCityBreak.isChecked();
        boolean isFavourite = checkBoxFavourite.isChecked();

        if(tripName.trim().isEmpty() || destination.trim().isEmpty()  ){
            Toast.makeText(getApplicationContext(), "Please complete all info", Toast.LENGTH_LONG).show();
            return;
        }

        Intent data = new Intent();
        data.putExtra(EXTRA_TRIP_NAME, tripName);
        data.putExtra(EXTRA_DESTINATION, destination);
        data.putExtra(EXTRA_IS_CHECKED, isFavourite);
        data.putExtra(EXTRA_NR_OF_STARS, nrOfStars);
        data.putExtra(EXTRA_START_DATE, startDate);
        data.putExtra(EXTRA_END_DATE, endDate);
        data.putExtra(EXTRA_SEA_SIDE, seaSide);
        data.putExtra(EXTRA_MOUNTAINS, mountains);
        data.putExtra(EXTRA_CITY_BREAK, cityBreak);
        data.putExtra(EXTRA_PRICE, textViewPrice);



        int id = getIntent().getIntExtra(EXTRA_ID,-1);

            if(id != -1){
                data.putExtra(EXTRA_ID, id);
            }

        setResult(RESULT_OK, data);
        finish();


    }
}