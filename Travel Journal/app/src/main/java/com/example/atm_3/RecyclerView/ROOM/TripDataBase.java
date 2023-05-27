package com.example.atm_3.RecyclerView.ROOM;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

import com.example.atm_3.R;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Database(entities = Trip.class, version = 1)
public abstract class TripDataBase extends RoomDatabase {

    private static  TripDataBase instance;

    public abstract TripDao tripDao();
    private static final int NUMBER_OF_THREADS = 6;
    static final ExecutorService databaseWriteExecutor =
            Executors.newFixedThreadPool(NUMBER_OF_THREADS);
    public static synchronized TripDataBase getInstance(Context context){

        if(instance == null){

            instance = Room.databaseBuilder(context.getApplicationContext(),
                    TripDataBase.class,"trip_database")
                    .fallbackToDestructiveMigration()
                    .addCallback(roomCallBack)
                    .build();

        }

        return instance;
    }

    private static RoomDatabase.Callback roomCallBack = new RoomDatabase.Callback(){
        @Override
        public void onCreate(@NonNull SupportSQLiteDatabase db) {
            super.onCreate(db);
            TripDataBase.databaseWriteExecutor.execute(() -> {
                TripDao tripDao = instance.tripDao();
                tripDao.insert(new Trip("Trip 1", "London", 2,"21/20/2023", "22/20/2023",true,false,false, R.drawable.logo,true));
                tripDao.insert(new Trip("Trip 1", "London", 2,"21/20/2023", "22/20/2023",true,false,false, R.drawable.logo,true));
                tripDao.insert(new Trip("Trip 1", "London", 2,"21/20/2023", "22/20/2023",true,false,false, R.drawable.logo,true));
            });
        }
    };

}
