package com.example.roommvvmdemo.ui;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.roommvvmdemo.R;
import com.example.roommvvmdemo.data.local.Note;

import java.util.ArrayList;
import java.util.List;

public class NoteAdapter extends RecyclerView.Adapter<NoteAdapter.NoteHolder> {

    private List<Note> drk_notes = new ArrayList<>();
    private OnItemClickListener drk_clickListener;
    private OnItemLongClickListener drk_longClickListener;

    public interface OnItemClickListener {
        void onItemClick(Note note);
    }

    public interface OnItemLongClickListener {
        void onItemLongClick(Note note);
    }

    public void setNotes(List<Note> notes) {
        this.drk_notes = notes;
        notifyDataSetChanged();
    }

    public void setOnItemClickListener(OnItemClickListener listener) {
        this.drk_clickListener = listener;
    }

    public void setOnItemLongClickListener(OnItemLongClickListener listener) {
        this.drk_longClickListener = listener;
    }

    @NonNull
    @Override
    public NoteHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.note_item, parent, false);
        return new NoteHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull NoteHolder holder, int position) {
        Note currentNote = drk_notes.get(position);
        holder.drk_tvTitle.setText(currentNote.getDrk_title());
        holder.drk_tvDescription.setText(currentNote.getDrk_description());
    }

    @Override
    public int getItemCount() {
        return drk_notes.size();
    }

    class NoteHolder extends RecyclerView.ViewHolder {
        private final TextView drk_tvTitle;
        private final TextView drk_tvDescription;

        public NoteHolder(@NonNull View itemView) {
            super(itemView);

            drk_tvTitle = itemView.findViewById(R.id.drk_tvTitle);
            drk_tvDescription = itemView.findViewById(R.id.drk_tvDescription);

            itemView.setOnClickListener(v -> {
                int position = getAdapterPosition();
                if (drk_clickListener != null && position != RecyclerView.NO_POSITION) {
                    drk_clickListener.onItemClick(drk_notes.get(position));
                }
            });

            itemView.setOnLongClickListener(v -> {
                int position = getAdapterPosition();
                if (drk_longClickListener != null && position != RecyclerView.NO_POSITION) {
                    drk_longClickListener.onItemLongClick(drk_notes.get(position));
                    return true;
                }
                return false;
            });
        }
    }
}
