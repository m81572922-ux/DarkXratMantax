package com.darkxrat.mantax.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.darkxrat.mantax.R;
import com.darkxrat.mantax.model.Sender;
import java.util.List;

public class SenderAdapter extends RecyclerView.Adapter<SenderAdapter.ViewHolder> {

    private List<Sender> senderList;

    public SenderAdapter(List<Sender> senderList) {
        this.senderList = senderList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
            .inflate(R.layout.item_sender, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Sender sender = senderList.get(position);
        holder.tvNomor.setText(sender.getNomor());
        holder.tvTipe.setText(sender.getTipe());
        holder.tvStatus.setText(sender.isOnline() ? "● Online" : "● Offline");
    }

    @Override
    public int getItemCount() {
        return senderList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvNomor, tvTipe, tvStatus;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvNomor = itemView.findViewById(R.id.tvNomorSender);
            tvTipe = itemView.findViewById(R.id.tvTipeSender);
            tvStatus = itemView.findViewById(R.id.tvStatusSender);
        }
    }
}