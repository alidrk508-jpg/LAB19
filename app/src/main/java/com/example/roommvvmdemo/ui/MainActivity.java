package com.example.roommvvmdemo.ui;

import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.roommvvmdemo.R;
import com.example.roommvvmdemo.data.local.Note;
import com.example.roommvvmdemo.viewmodel.NoteViewModel;
import com.google.android.material.appbar.MaterialToolbar;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton;
import com.google.android.material.textfield.TextInputEditText;

public class MainActivity extends AppCompatActivity {

    private NoteViewModel drk_noteViewModel;
    private TextInputEditText drk_etTitle;
    private TextInputEditText drk_etDescription;
    private MaterialButton drk_btnAdd;
    private ExtendedFloatingActionButton drk_btnDeleteAll;
    private NoteAdapter drk_adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Setup Toolbar
        MaterialToolbar toolbar = findViewById(R.id.drk_toolbar);
        setSupportActionBar(toolbar);

        drk_etTitle = findViewById(R.id.drk_etTitle);
        drk_etDescription = findViewById(R.id.drk_etDescription);
        drk_btnAdd = findViewById(R.id.drk_btnAdd);
        drk_btnDeleteAll = findViewById(R.id.drk_btnDeleteAll);

        RecyclerView recyclerView = findViewById(R.id.drk_recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);

        drk_adapter = new NoteAdapter();
        recyclerView.setAdapter(drk_adapter);

        drk_noteViewModel = new ViewModelProvider(this).get(NoteViewModel.class);

        drk_noteViewModel.drk_getAllNotes().observe(this, notes -> {
            drk_adapter.setNotes(notes);
        });

        drk_btnAdd.setOnClickListener(v -> {
            drk_saveNote();
        });

        drk_btnDeleteAll.setOnClickListener(v -> {
            drk_noteViewModel.drk_deleteAllNotes();
            Toast.makeText(this, "Toutes les notes ont été supprimées", Toast.LENGTH_SHORT).show();
        });

        drk_adapter.setOnItemLongClickListener(note -> {
            drk_noteViewModel.drk_delete(note);
            Toast.makeText(this, "Note supprimée", Toast.LENGTH_SHORT).show();
        });

        drk_adapter.setOnItemClickListener(note -> {
            Toast.makeText(this, "Titre : " + note.getDrk_title(), Toast.LENGTH_SHORT).show();
        });
    }

    private void drk_saveNote() {
        if (drk_etTitle.getText() == null || drk_etDescription.getText() == null) return;

        String title = drk_etTitle.getText().toString().trim();
        String description = drk_etDescription.getText().toString().trim();

        if (title.isEmpty() || description.isEmpty()) {
            Toast.makeText(this, "Veuillez remplir tous les champs", Toast.LENGTH_SHORT).show();
            return;
        }

        Note note = new Note(title, description);
        drk_noteViewModel.drk_insert(note);

        drk_etTitle.setText("");
        drk_etDescription.setText("");
        drk_etTitle.clearFocus();
        drk_etDescription.clearFocus();

        Toast.makeText(this, "Note ajoutée", Toast.LENGTH_SHORT).show();
    }
}
