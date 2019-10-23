package me.koltensturgill.sloth.Model;

import android.os.AsyncTask;

class PopulateDbAsync extends AsyncTask<Void, Void, Void> {

    private final NoteDao dao;

    public PopulateDbAsync(AppRoomDatabase instance) {
        dao = instance.noteDao();
    }


    @Override
    protected Void doInBackground(final Void... params) {
        dao.getAllNotes();
        return null;
    }
}
