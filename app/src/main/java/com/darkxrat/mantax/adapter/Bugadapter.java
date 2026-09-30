package com.darkxrat.mantax.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.darkxrat.mantax.R;
import com.darkxrat.mantax.model.Bug;
import java.util.List;

public class BugAdapter extends RecyclerView.Adapter<BugAdapter.ViewHolder> {

    private List<Bug> bugList;
    private OnBugClickListener listener;

    public interface OnBugClickListener {
        void onBugClick(Bug bug);
    }

    public BugAdapter(List<Bug> bugList, OnBugClickListener listener) {
        this.bugList = bugList;
        this.listener = listener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
            .inflate(R.layout.item_bug, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Bug bug = bugList.get(position);
        holder.tvNama.setText(bug.getNama());
        holder.tvFunc.setText(bug.getFunc());
        holder.itemView.setOnClickListener(v -> listener.onBugClick(bug));
    }

    @Override
    public int getItemCount() {
        return bugList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvNama, tvFunc;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvNama = itemView.findViewById(R.id.tvNamaBug);
            tvFunc = itemView.findViewById(R.id.tvFuncBug);
        }
    }
}