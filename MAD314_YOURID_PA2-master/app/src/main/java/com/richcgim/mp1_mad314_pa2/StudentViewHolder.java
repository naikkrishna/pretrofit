package com.richcgim.mp1_mad314_pa2;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

class StudentViewHolder extends RecyclerView.ViewHolder {

    TextView tvId, tvName;

    StudentViewHolder(@NonNull View itemView) {
        super(itemView);
        tvId = itemView.findViewById(R.id.tvId);
        tvName = itemView.findViewById(R.id.tvName);
    }
}
