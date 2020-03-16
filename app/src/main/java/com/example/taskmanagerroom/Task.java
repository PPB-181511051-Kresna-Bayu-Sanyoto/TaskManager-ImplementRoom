package com.example.taskmanagerroom;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "task_table")
public class Task {
    @PrimaryKey
    @NonNull
    private String mTask;
    private String mDeskripsi;
    private String mDeadline;

    public Task(@NonNull String mTask, String mDeskripsi, String mDeadline) {
        this.mTask = mTask;
        this.mDeskripsi = mDeskripsi;
        this.mDeadline = mDeadline;
    }
    public String getTask() {
        return this.mTask;
    }

    public String getDeskripsi() {

        return this.mDeskripsi;
    }

    public String getDeadline() {

        return this.mDeadline;
    }

}
