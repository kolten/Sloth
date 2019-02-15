package me.koltensturgill.sloth.Model;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

@Database(entities = {Note.class}, version = 1)
public abstract class NoteRoomDatabase extends RoomDatabase {
    public abstract NoteDao noteDao();

    private static volatile NoteRoomDatabase INSTANCE;

    // Create a singleton instance of the Room database
    static NoteRoomDatabase getInstance(final Context context){
        if (INSTANCE == null){
            synchronized (NoteRoomDatabase.class){
                if (INSTANCE == null){
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                    NoteRoomDatabase.class, "sloth_database").build();
                }
            }
        }
        return INSTANCE;
    }
}