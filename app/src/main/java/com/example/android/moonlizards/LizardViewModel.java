package com.example.android.moonlizards;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;

import java.util.List;

public class LizardViewModel extends AndroidViewModel {

    // Never pass context into ViewModel instances. Do not store Activity, Fragment, or View
    // instances or their Context in the ViewModel.

    // ViewModel is not a replacement for the onSaveInstanceState() method,
    // because the ViewModel does not survive a process shutdown.

    private LizardRepository mRepository;

    private LiveData<List<Lizard>> mAllLizards;

    public LizardViewModel(Application application) {
        super(application);
        mRepository = new LizardRepository(application);
        mAllLizards = mRepository.getAllLizards();
    }

    LiveData<List<Lizard>> getAllLizards() { return mAllLizards; }

    public void insert(Lizard lizard) { mRepository.insert(lizard); }

    public void update(Lizard lizard) { mRepository.update(lizard); }

}