package com.richcgim.mp1_mad314_pa2;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class StudentAdapter extends RecyclerView.Adapter<StudentViewHolder> {

    private LayoutInflater inflater;

    StudentAdapter(Context context) {
        this.inflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public StudentViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.student_vh, parent, false);
        return new StudentViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull StudentViewHolder holder, int position) {
        Student student = StudentDataSource.getInstance().students.get(position);

        holder.tvId.setText(String.valueOf(student.id));
        holder.tvName.setText(String.valueOf(student.name));
    }

    @Override
    public int getItemCount() {
        return StudentDataSource.getInstance().students.size();
    }
}
