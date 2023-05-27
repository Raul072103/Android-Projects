package com.example.atm_3;

import android.content.Intent;
import android.os.Bundle;

import com.example.atm_3.Retrofit.OnGetWeatherCallBack;
import com.example.atm_3.Retrofit.WeatherInfo;
import com.example.atm_3.Retrofit.WeatherRepository;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;

import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RatingBar;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.core.view.WindowCompat;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.example.atm_3.databinding.ActivityTripReadOnlyBinding;

public class TripReadOnlyActivity extends AppCompatActivity {

    private AppBarConfiguration appBarConfiguration;
    private ActivityTripReadOnlyBinding binding;
    public static final String EXTRA_TRIP_NAME =
            "com.example.atm_3.EXTRA_TRIP_NAME";
    public static final String EXTRA_DESTINATION =
            "com.example.atm_3.EXTRA_DESTINATION";
    public static final String EXTRA_NR_OF_STARS =
            "com.example.atm_3.EXTRA_NR_OF_STARS";
    public static final String EXTRA_IS_CHECKED =
            "com.example.atm_3.EXTRA_IS_CHECKED";

    public static final String EXTRA_ID =
            "com.example.atm_3.EXTRA_ID";

    String cityName = "London";
    private static final String API_ID = "d899ae98d33f6d3385819062aae2beba";
    private WeatherRepository weatherRepository;

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
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trip_read_only);
        priceSeekBar = findViewById(R.id.priceRangeBarReadOnly);
        textView = findViewById(R.id.textViewTripViewReadOnly);
        editTextTripName = findViewById(R.id.TripNameEditTextReadOnly);
        editTextDestination = findViewById(R.id.DestinationEditTextReadOnly);
        starRatingBar = findViewById(R.id.ratingBarEditTripReadOnly);
        startDateButton = findViewById(R.id.startDateButtonReadOnly);
        endDateButton = findViewById(R.id.endDateButtonReadOnly);
        radioGroup = findViewById(R.id.radioGroupReadOnly);
        radioButtonCityBreak = findViewById(R.id.cityBreakRadioButtonReadOnly);
        radioButtonSeaSide = findViewById(R.id.seaSideRadioButtonReadOnly);
        radioButtonMountains = findViewById(R.id.mountainsRadioButtonReadOnly);
        textViewStartDate = findViewById(R.id.StartDateTextViewReadOnly);
        textViewEndDate = findViewById(R.id.EndDateTextViewReadOnly);
        checkBoxFavourite = findViewById(R.id.checkBoxReadOnly);


        // Disable EditText views
        EditText tripNameEditText = findViewById(R.id.TripNameEditTextReadOnly);
        tripNameEditText.setEnabled(false);

        EditText destinationEditText = findViewById(R.id.DestinationEditTextReadOnly);
        destinationEditText.setEnabled(false);

        // Disable RadioGroup views
        RadioGroup radioGroup = findViewById(R.id.radioGroupReadOnly);
        for (int i = 0; i < radioGroup.getChildCount(); i++) {
            radioGroup.getChildAt(i).setEnabled(false);
        }

        // Disable RatingBar view
        RatingBar ratingBar = findViewById(R.id.ratingBarEditTripReadOnly);
        ratingBar.setEnabled(false);

        // Disable ImageButton views
        ImageButton startDateButton = findViewById(R.id.startDateButtonReadOnly);
        startDateButton.setEnabled(false);

        ImageButton endDateButton = findViewById(R.id.endDateButtonReadOnly);
        endDateButton.setEnabled(false);

        // Disable SeekBar view
        SeekBar priceRangeBar = findViewById(R.id.priceRangeBarReadOnly);
        priceRangeBar.setEnabled(false);


        Intent intent = getIntent();
        if(intent.hasExtra(EXTRA_ID)){
            editTextTripName.setText(intent.getStringExtra(EXTRA_TRIP_NAME));
            editTextDestination.setText(intent.getStringExtra(EXTRA_DESTINATION));
            starRatingBar.setNumStars(intent.getIntExtra(EXTRA_NR_OF_STARS, 1));
            checkBoxFavourite.setChecked(intent.getBooleanExtra(EXTRA_IS_CHECKED, false));
        }


        weatherRepository = WeatherRepository.getInstance();
        weatherRepository.getW(cityName, API_ID, new OnGetWeatherCallBack() {
            @Override
            public void onSuccess(WeatherInfo weatherInfo) {
                Log.e("Main= ", weatherInfo.weather.toString());
            }

            @Override
            public void onError() {
                Toast.makeText(TripReadOnlyActivity.this, "Cannot get weather", Toast.LENGTH_LONG).show();

            }
        });
    }


}