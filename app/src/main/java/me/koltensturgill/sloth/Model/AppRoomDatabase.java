package me.koltensturgill.sloth.Model;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

// Add more entities here
@Database(entities = {Note.class}, version = 1, exportSchema = false)
public abstract class AppRoomDatabase extends RoomDatabase {
    public abstract NoteDao noteDao();

    private static volatile AppRoomDatabase INSTANCE;

    // Create a singleton instance of the Room database
    static AppRoomDatabase getInstance(final Context context){
        if (INSTANCE == null){
            synchronized (AppRoomDatabase.class){
                if (INSTANCE == null){
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                    AppRoomDatabase.class, "sloth_database").build();
                }
            }
        }
        return INSTANCE;
    }
}