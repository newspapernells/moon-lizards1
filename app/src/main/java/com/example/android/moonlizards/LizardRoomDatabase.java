package com.example.android.moonlizards;

import android.arch.persistence.db.SupportSQLiteDatabase;
import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;
import android.os.AsyncTask;
import android.support.annotation.NonNull;

@Database(entities = {Lizard.class}, version = 1, exportSchema = false)
public abstract class LizardRoomDatabase extends RoomDatabase {

    public abstract LizardDao lizardDao();

    private static LizardRoomDatabase INSTANCE;

    public static LizardRoomDatabase getDatabase(final Context context) {
        if (INSTANCE == null) {
            synchronized (LizardRoomDatabase.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                            LizardRoomDatabase.class, "lizard_database")
                            .addCallback(sRoomDatabaseCallback).build();
                }
            }
        }
        return INSTANCE;
    }

    private static RoomDatabase.Callback sRoomDatabaseCallback =
            new RoomDatabase.Callback(){

        @Override
        public void onOpen (@NonNull SupportSQLiteDatabase db){
            super.onOpen(db);
            new PopulateDbAsync(INSTANCE).execute();
        }
    };

    private static class PopulateDbAsync extends AsyncTask<Void, Void, Void> {

        private final LizardDao mDao;

        PopulateDbAsync(LizardRoomDatabase db) {
            mDao = db.lizardDao();
        }

        @Override
        protected Void doInBackground(final Void... params) {

//            Lizard lizard = new Lizard("Memdoch", 0, 4.1f);
//            mDao.insert(lizard);

            return null;
        }
    }
}