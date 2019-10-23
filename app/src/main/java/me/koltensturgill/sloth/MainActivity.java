package me.koltensturgill.sloth;

import android.app.Activity;
import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.Toast;

import java.util.List;

import me.koltensturgill.sloth.Model.Note;
import me.koltensturgill.sloth.Model.NotesViewModel;


public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener, View.OnClickListener {

    Activity activity;
    public static final int NEW_NOTE_ACTIVITY_REQUEST_CODE = 1;
    EditText editText;

    private NotesViewModel notesViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Utils.setThemeToActivity(this, true);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        activity = this;
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);

        final Intent intent = new Intent(this, Editor.class);

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            startActivityForResult(intent, NEW_NOTE_ACTIVITY_REQUEST_CODE);
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        // Bind our view model
        notesViewModel = ViewModelProviders.of(this).get(NotesViewModel.class);

        // Set up the recycler
        RecyclerView recyclerView = findViewById(R.id.recyclerview_notes);
        final NoteListAdapter adapter = new NoteListAdapter(this);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        // Create an observer, and update our adapter
        notesViewModel.getAllNotes().observe(this, new Observer<List<Note>>() {
            @Override
            public void onChanged(@Nullable List<Note> notes) {
                adapter.setNotes(notes);
            }
        });
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            final Intent intent = new Intent(this, Settings.class);
            startActivity(intent);
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_camera) {
            // Handle the camera action
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void onClick(View view) {

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data){
        try {
            super.onActivityResult(requestCode, resultCode, data);

            if (requestCode == NEW_NOTE_ACTIVITY_REQUEST_CODE  && resultCode == RESULT_OK) {
                String extra = data.getStringExtra(Editor.EXTRA_EDITOR);
                //Determine the note title from the body of the note.
                String title = getNoteTitle(extra);
                //Chop the title off the string before creating a note from it.
                extra = extra.substring(title.length());
                Note note = new Note(title, extra);
                notesViewModel.insert(note);
            } else {
                Toast.makeText(getApplicationContext(), "Not saved", Toast.LENGTH_SHORT).show();
            }
        } catch (Exception ex) {
            Toast.makeText(this, ex.toString(),
                    Toast.LENGTH_LONG).show();
        }
    }

    protected String getNoteTitle(String note){
        int firstNewLine = note.indexOf('\n');
        //Hardcoded max title length, probably a better way of doing this.
        int maxTitleLength = 30;

        String title;
        //No newline character found
        if(firstNewLine == -1){
            //Dont want to control the length of our title
            if(note.length() > maxTitleLength) {
                title = note.substring(0, maxTitleLength);
            }
            else{ //else one line note, set title to the note itself.
                title = note;
            }
        //Newline Character found within max title limit
        } else {
            title = note.substring(0, firstNewLine);
        }
        //if first character is not a hashtag, insert one at the beginning
        if(title.charAt(0) != '#'){
            title = "#" + title;
        }
        return title;
    }

    //onRestart method recreates main activity so when theme is changed in settings, activity recreates so new theme can be applied from Utils
    @Override
    protected void onRestart()
    {
        super.onRestart();
        recreate();
    }
}
