package com.example.atm_3;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.Menu;
import android.widget.Toast;

import com.example.atm_3.RecyclerView.ROOM.Trip;
import com.example.atm_3.RecyclerView.ROOM.TripAdapter;
import com.example.atm_3.RecyclerView.ROOM.TripViewModel;
import com.example.atm_3.ui.home.HomeFragment;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.navigation.NavigationView;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.atm_3.databinding.ActivityNavigationBinding;

import java.util.List;

public class NavigationActivity extends AppCompatActivity {


    public static final int EDIT_NOTE_REQUEST = 2;
    private TripViewModel tripViewModel;
    private AppBarConfiguration mAppBarConfiguration;
    private ActivityNavigationBinding binding;
    public static final int NEW_WORD_ACTIVITY_REQUEST_CODE = 1;
    ActivityResultLauncher<Intent> newTripActivityLauncher;
    FloatingActionButton fab;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityNavigationBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        setSupportActionBar(binding.appBarNavigation.toolbar);
        binding.appBarNavigation.fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        DrawerLayout drawer = binding.drawerLayout;
        NavigationView navigationView = binding.navView;
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        mAppBarConfiguration = new AppBarConfiguration.Builder(
                R.id.nav_home, R.id.nav_gallery, R.id.nav_slideshow)
                .setOpenableLayout(drawer)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_navigation);
        NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration);
        NavigationUI.setupWithNavController(navigationView, navController);

        newTripActivityLauncher = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), result -> {
            if (result.getResultCode() == RESULT_OK) {
                Intent data = result.getData();
                String tripName = data.getStringExtra(NewTripActivity.EXTRA_TRIP_NAME);
                String destination = data.getStringExtra(NewTripActivity.EXTRA_DESTINATION);
                int nrOfStars = data.getIntExtra(NewTripActivity.EXTRA_NR_OF_STARS, 1);
                boolean isChecked = data.getBooleanExtra(NewTripActivity.EXTRA_IS_CHECKED, false);
                boolean seaSide = data.getBooleanExtra(NewTripActivity.EXTRA_SEA_SIDE,false);
                boolean mountains = data.getBooleanExtra(NewTripActivity.EXTRA_MOUNTAINS,false);
                boolean cityBreak = data.getBooleanExtra(NewTripActivity.EXTRA_CITY_BREAK,false);
                String price = data.getStringExtra(NewTripActivity.EXTRA_PRICE);
                String endDate = data.getStringExtra(NewTripActivity.EXTRA_END_DATE);
                String startDate = data.getStringExtra(NewTripActivity.EXTRA_START_DATE);

                Trip trip = new Trip(tripName, destination, nrOfStars, startDate, endDate, cityBreak,seaSide,mountains,R.drawable.logo,isChecked );
                tripViewModel.insert(trip);
                int id = data.getIntExtra(NewTripActivity.EXTRA_ID, -1);
                    if(id == -1){
                        Toast.makeText(this,"Trip can't be updated", Toast.LENGTH_SHORT).show();
                        return;
                    }
                    trip.setId(id);
                    tripViewModel.update(trip);

            } else {
                Toast.makeText(
                        getApplicationContext(),
                        R.string.empty_not_saved,
                        Toast.LENGTH_LONG
                ).show();
            }
        });

        RecyclerView recyclerView = findViewById(R.id.recyclerview);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);

        TripAdapter tripAdapter = new TripAdapter();
        recyclerView.setAdapter(tripAdapter);

        tripViewModel = new ViewModelProvider(this).get(TripViewModel.class);
        tripViewModel.getAllTrips().observe(this, new Observer<List<Trip>>() {
            @Override
            public void onChanged(List<Trip> trips) {
                tripAdapter.setTrips(trips);

            }
        });

        fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(NavigationActivity.this, NewTripActivity.class);
                newTripActivityLauncher.launch(intent);
            }
        });

        new ItemTouchHelper(new ItemTouchHelper.SimpleCallback(0,ItemTouchHelper.LEFT | ItemTouchHelper.RIGHT)
                {


            @Override
            public boolean onMove(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder target) {
                return false;
            }

            @Override
            public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int direction) {
                tripViewModel.delete(tripAdapter.getTripAt(viewHolder.getAdapterPosition()));
                Toast.makeText(NavigationActivity.this, "Trip deleted", Toast.LENGTH_SHORT).show();
            }
        }).attachToRecyclerView(recyclerView);

        tripAdapter.setOnItemClickListener(new TripAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(Trip trip) {
                Intent intent = new Intent(NavigationActivity.this, NewTripActivity.class);
                intent.putExtra(NewTripActivity.EXTRA_ID, trip.getId());
                intent.putExtra(NewTripActivity.EXTRA_TRIP_NAME, trip.getTripName());
                intent.putExtra(NewTripActivity.EXTRA_DESTINATION, trip.getDestination());
                intent.putExtra(NewTripActivity.EXTRA_IS_CHECKED, trip.isFavourite());
                intent.putExtra(NewTripActivity.EXTRA_NR_OF_STARS, trip.getNrOfStars());

                startActivity(intent);

            }

            @Override
            public void onItemLongClick(Trip trip) {
                Intent intent = new Intent(NavigationActivity.this, TripReadOnlyActivity.class);
                intent.putExtra(NewTripActivity.EXTRA_ID, trip.getId());
                intent.putExtra(NewTripActivity.EXTRA_TRIP_NAME, trip.getTripName());
                intent.putExtra(NewTripActivity.EXTRA_DESTINATION, trip.getDestination());
                intent.putExtra(NewTripActivity.EXTRA_IS_CHECKED, trip.isFavourite());
                intent.putExtra(NewTripActivity.EXTRA_NR_OF_STARS, trip.getNrOfStars());

                startActivity(intent);
            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.navigation, menu);

        return true;
    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_navigation);
        return NavigationUI.navigateUp(navController, mAppBarConfiguration)
                || super.onSupportNavigateUp();
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId() == R.id.action_settings) {
            tripViewModel.deleteAllTrips();
            Toast.makeText(this, "All trips deleted", Toast.LENGTH_SHORT).show();
            return true;
        }
        else
                return super.onOptionsItemSelected(item);
        }


}