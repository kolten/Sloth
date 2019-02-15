package me.koltensturgill.sloth.Model;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.support.annotation.NonNull;

import java.util.List;

public class NoteViewModel extends AndroidViewModel {
    private NoteRepository mRepository;
    private LiveData<List<Note>> mAllNotes;

    public NoteViewModel(@NonNull Application application) {
        super(application);
        mRepository = new NoteRepository(application);
        mAllNotes = mRepository.getAllNotes();
    }

    // Getters to abstract request from UI
    public LiveData<List<Note>> getAllNotes() {
        return mAllNotes;
    }

    // Wrapper for insert method in repo
    public void insert(Note note) { mRepository.insert(note); }
}
