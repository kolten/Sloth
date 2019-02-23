package me.koltensturgill.sloth.Model;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.Ignore;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

import java.lang.reflect.Array;
import java.util.ArrayList;

@Entity(tableName = "notes_table")
public class Note {

    @PrimaryKey(autoGenerate = true)
    @NonNull
    @ColumnInfo(name = "id")
    private int id;

    @ColumnInfo(name = "title")
    private String title;
    @ColumnInfo(name = "body")
    private String body;


    @Ignore
    private ArrayList<String> tags;
    @Ignore
    private int notebookId;

    //Base constructor
    public Note(String title, String body, ArrayList<String> tags, int notebookId){
        this.title = title;
        this.body = body;
        this.tags = tags;
        this.notebookId = notebookId;
    }

    //Getters
    public int getId() {
        return this.id;
    }

    public int getNotebookId(){return this.notebookId;}

    public String getTitle(){return this.title;}

    public ArrayList<String> getTags(){return this.tags;}

    public String getBody(){return this.body;}


    //Setters
    public void setId(int id) {
        this.id = id;
    }

    public void changeTitle(String title){this.title = title;}

    public void changeNotebookId(int notebookId){this.notebookId = notebookId;}

    public void changeBody(String body){this.body = body;}

    public void addTags(String tag) {this.tags.add(tag);}

    public void removeTags(String tag){this.tags.remove(tag);}

    // For now, basic note
    public Note(String title, String body){
        this.title = title;
        this.body = body;
    }
}