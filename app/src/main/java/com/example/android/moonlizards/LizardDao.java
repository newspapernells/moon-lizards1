package com.example.android.moonlizards;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import java.util.List;

@Dao
public interface LizardDao {

    @Query("SELECT * FROM active_lizard_table ORDER BY id ASC")
    LiveData<List<Lizard>> getAll();

    @Query("DELETE FROM active_lizard_table")
    void deleteAll();

//        @Query("SELECT * FROM user WHERE uid IN (:userIds)")
//        List<Lizard> loadAllByIds(int[] userIds);
//
//        @Query("SELECT * FROM user WHERE first_name LIKE :first AND "
//                + "last_name LIKE :last LIMIT 1")
//        Lizard findByName(String first, String last);

    @Insert
    void insert(Lizard lizard);

    @Update
    void update(Lizard lizard);

    @Delete
    void delete(Lizard lizard);

}