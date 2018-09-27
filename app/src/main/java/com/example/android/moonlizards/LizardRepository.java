package com.example.android.moonlizards;

import android.app.Application;
import android.arch.lifecycle.LiveData;
import android.os.AsyncTask;

import java.util.List;

public class LizardRepository {
    private LizardDao mLizardDao;
    private LiveData<List<Lizard>> mAllLizards;

    LizardRepository(Application application){
        LizardRoomDatabase db = LizardRoomDatabase.getDatabase(application);
        mLizardDao = db.lizardDao();
        mAllLizards = mLizardDao.getAll();
    }

    LiveData<List<Lizard>> getAllLizards(){
        return mAllLizards;
    }

    public void insert (Lizard lizard){
        new insertAsyncTask(mLizardDao).execute(lizard);
    }

    public void update (Lizard lizard){
        new updateAsyncTask(mLizardDao).execute(lizard);
    }

    private static class insertAsyncTask extends AsyncTask<Lizard, Void, Void> {

        private LizardDao mAsyncTaskDao;

        insertAsyncTask(LizardDao dao) {
            mAsyncTaskDao = dao;
        }

        @Override
        protected Void doInBackground(final Lizard... params) {
            mAsyncTaskDao.insert(params[0]);
            return null;
        }
    }

    private static class updateAsyncTask extends AsyncTask<Lizard, Void, Void> {

        private LizardDao mAsyncTaskDao;

        updateAsyncTask(LizardDao dao) {
            mAsyncTaskDao = dao;
        }

        @Override
        protected Void doInBackground(final Lizard... params) {
            mAsyncTaskDao.update(params[0]);
            return null;
        }
    }
}
