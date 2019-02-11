package me.koltensturgill.sloth.Model;

import java.util.ArrayList;

public class Note {
    public String title;
    public String body;
    public ArrayList<String> tags;
    public int notebookId;

    //Base constructor
    public Note(String title, String body, ArrayList<String> tags, int notebookId){
        this.title = title;
        this.body = body;
        this.tags = tags;
        this.notebookId = notebookId;
    }

    //Getters
    public int getNotebookId(){return this.notebookId;}

    public String getTitle(){return this.title;}

    public ArrayList<String> getTags(){return this.tags;}

    public String getBody(){return this.body;}


    //Setters
    public void changeTitle(String title){this.title = title;}

    public void changeNotebookId(int notebookId){this.notebookId = notebookId;}

    public void changeBody(String body){this.body = body;}

    public void addTags(String tag) {this.tags.add(tag);}

    public void removeTags(String tag){this.tags.remove(tag);}
}