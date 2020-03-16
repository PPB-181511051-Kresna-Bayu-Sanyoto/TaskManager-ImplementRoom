package com.example.taskmanagerroom;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class NewTaskActivity extends AppCompatActivity {

    public static final String EXTRA_REPLY = "com.example.android.task.REPLY";
    public static final String EXTRA_REPLYDESKRIPSI = "com.example.android.deskripsi.REPLY";
    public static final String EXTRA_REPLYDEADLINE = "com.example.android.deadline.REPLY";

    private EditText mEditTaskViewTask;
    private EditText mEditTaskViewDeskripsi;
    private EditText mEditTaskViewDeadline;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_task);
        mEditTaskViewTask = findViewById(R.id.edit_task);
        mEditTaskViewDeskripsi = findViewById(R.id.edit_deskripsi);
        mEditTaskViewDeadline = findViewById(R.id.edit_deadline);

        final Button button = findViewById(R.id.button_save);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent replyIntent = new Intent();
                if (TextUtils.isEmpty(mEditTaskViewTask.getText())) {
                    setResult(RESULT_CANCELED, replyIntent);
                } else {
                    String task = mEditTaskViewTask.getText().toString();
                    String deskripsi = mEditTaskViewDeskripsi.getText().toString();
                    String deadline = mEditTaskViewDeadline.getText().toString();
                    replyIntent.putExtra(EXTRA_REPLY, task);
                    replyIntent.putExtra(EXTRA_REPLYDESKRIPSI, deskripsi);
                    replyIntent.putExtra(EXTRA_REPLYDEADLINE, deadline);
                    setResult(RESULT_OK, replyIntent);
                }
                finish();
            }
        });
    }
}