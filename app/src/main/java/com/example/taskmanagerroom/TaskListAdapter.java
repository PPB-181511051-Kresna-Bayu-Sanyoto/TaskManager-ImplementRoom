package com.example.taskmanagerroom;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class TaskListAdapter extends RecyclerView.Adapter<TaskListAdapter.TaskViewHolder> {

    class TaskViewHolder extends RecyclerView.ViewHolder {
        private final TextView taskItemViewTask;
        private final TextView taskItemViewDeskripsi;
        private final TextView taskItemViewDeadline;

        private TaskViewHolder(View itemView) {
            super(itemView);
            taskItemViewTask = itemView.findViewById(R.id.textTask);
            taskItemViewDeskripsi = itemView.findViewById(R.id.textDeskripsi);
            taskItemViewDeadline = itemView.findViewById(R.id.textDeadline);
        }
    }

    private final LayoutInflater mInflater;
    private List<Task> mTasks; // Cached copy of words

    TaskListAdapter(Context context) { mInflater = LayoutInflater.from(context); }

    @Override
    public TaskViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = mInflater.inflate(R.layout.recyclerview_item, parent, false);
        return new TaskViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(TaskViewHolder holder, int position) {
        if (mTasks != null) {
            Task current = mTasks.get(position);
            holder.taskItemViewTask.setText(current.getTask());
            holder.taskItemViewDeskripsi.setText(current.getDeskripsi());
            holder.taskItemViewDeadline.setText(current.getDeadline());
        } else {
            // Covers the case of data not being ready yet.
            holder.taskItemViewTask.setText("No Word");
            holder.taskItemViewDeskripsi.setText("No Word");
            holder.taskItemViewDeadline.setText("No Word");
        }
    }

    void setTasks(List<Task> tasks){
        mTasks = tasks;
        notifyDataSetChanged();
    }

    // getItemCount() is called many times, and when it is first called,
    // mWords has not been updated (means initially, it's null, and we can't return null).
    @Override
    public int getItemCount() {
        if (mTasks != null)
            return mTasks.size();
        else return 0;
    }
}
