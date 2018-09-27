package com.example.android.moonlizards;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.Ignore;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

@Entity(tableName = "active_lizard_table")
public class Lizard {

    @PrimaryKey(autoGenerate = true)
    private int id;
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    @NonNull
    @ColumnInfo(name="lizard_name")
    private String mName;
    public String getName(){ return this.mName; }

    // basic lizard information
    @Ignore
    public Lizard(@NonNull String name, int fedStatus, int restedStatus,
                  int cleanedStatus, int happyStatus, float ageMulti, int ageCount) {
        this.mName = name;
        this.mFedStatus = fedStatus;
        this.mRestedStatus = restedStatus;
        this.mCleanedStatus = cleanedStatus;
        this.mHappyStatus = happyStatus;
        this.mAgeMulti = ageMulti;
        this.mAgeCount = ageCount;
    }

    // full lizard information
    @Ignore
    public Lizard(@NonNull String name, int ageStatus, int fedStatus, int restedStatus,
                  int cleanedStatus, int happyStatus, float ageMulti, int fedMulti, int restedMulti,
                  int cleanedMulti, int happyMulti, int ageCount, int poopCount, int dirtyCount,
                  int mendingCount, int dyingCount, int posBenchCount, int negBenchCount,
                  boolean isSleeping, boolean isSick, boolean isLit, boolean hadMedicine) {
        this.mName = name;
        this.mAgeStatus = ageStatus;
        this.mFedStatus = fedStatus;
        this.mRestedStatus = restedStatus;
        this.mCleanedStatus = cleanedStatus;
        this.mHappyStatus = happyStatus;
        this.mAgeMulti = ageMulti;
        this.mFedMulti = fedMulti;
        this.mRestedMulti = restedMulti;
        this.mCleanedMulti = cleanedMulti;
        this.mHappyMulti = happyMulti;
        this.mAgeCount = ageCount;
        this.mPoopCount = poopCount;
        this.mDirtyCount = dirtyCount;
        this.mMendingCount = mendingCount;
        this.mDyingCount = dyingCount;
        this.mPosBenchCount = posBenchCount;
        this.mNegBenchCount = negBenchCount;
        this.mIsSleeping = isSleeping;
        this.mIsSick = isSick;
        this.mIsLit = isLit;
        this.mHadMedicine = hadMedicine;
    }

    @ColumnInfo(name="age_status")
    private int mAgeStatus;
    public int getAgeStatus(){ return this.mAgeStatus; }

    @ColumnInfo(name="fed_status")
    private int mFedStatus;
    public int getFedStatus() { return this.mFedStatus; }

    @ColumnInfo(name="rested_status")
    private int mRestedStatus;
    public int getRestedStatus() { return this.mRestedStatus; }

    @ColumnInfo(name="cleaned_status")
    private int mCleanedStatus;
    public int getCleanedStatus() { return this.mCleanedStatus; }

    @ColumnInfo(name="happy_status")
    private int mHappyStatus;
    public int getHappyStatus() { return this.mHappyStatus; }

    @ColumnInfo(name="age_multi")
    private float mAgeMulti;
    public float getAgeMulti() { return this.mAgeMulti; }

    @ColumnInfo(name="fed_multi")
    private int mFedMulti;
    public int getFedMulti() { return this.mFedMulti; }

    @ColumnInfo(name="rested_multi")
    private int mRestedMulti;
    public int getRestedMulti() { return this.mRestedMulti; }

    @ColumnInfo(name="cleaned_multi")
    private int mCleanedMulti;
    public int getCleanedMulti() { return this.mCleanedMulti; }

    @ColumnInfo(name="happy_multi")
    private int mHappyMulti;
    public int getHappyMulti() { return this.mHappyMulti; }

    @ColumnInfo(name="age_count")
    private int mAgeCount;
    public int getAgeCount(){ return this.mAgeCount; }

    @ColumnInfo(name="poop_count")
    private int mPoopCount;
    public int getPoopCount(){ return this.mPoopCount; }

    @ColumnInfo(name="dirty_count")
    private int mDirtyCount;
    public int getDirtyCount(){ return this.mDirtyCount; }

    @ColumnInfo(name="mending_count")
    private int mMendingCount;
    public int getMendingCount(){ return this.mMendingCount; }

    @ColumnInfo(name="dying_count")
    private int mDyingCount;
    public int getDyingCount(){ return this.mDyingCount; }

    @ColumnInfo(name="pos_bench_count")
    private int mPosBenchCount;
    public int getPosBenchCount(){ return this.mPosBenchCount; }

    @ColumnInfo(name="neg_bench_count")
    private int mNegBenchCount;
    public int getNegBenchCount(){ return this.mNegBenchCount; }

    @ColumnInfo(name="is_sleeping")
    private boolean mIsSleeping;
    public boolean getIsSleeping(){ return this.mIsSleeping; }

    @ColumnInfo(name="is_sick")
    private boolean mIsSick;
    public boolean getIsSick(){ return this.mIsSick; }

    @ColumnInfo(name="is_lit")
    private boolean mIsLit;
    public boolean getIsLit(){ return this.mIsLit; }

    @ColumnInfo(name="had_medicine")
    private boolean mHadMedicine;
    public boolean getHadMedicine(){ return this.mHadMedicine; }

}