package me.koltensturgill.sloth;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.EditText;

import java.util.ArrayList;

import me.koltensturgill.sloth.ui.editor.KeyboardButton;

public class Editor extends AppCompatActivity {

    ArrayList<KeyboardButton> buttons;
    private EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.editor_activity);

        //Setup for the keyboard button bar recycler view
        editText = (EditText) findViewById(R.id.et_editor);
        RecyclerView buttonBar = (RecyclerView) findViewById(R.id.rvKeyboardBar);
        buttons = KeyboardButton.createButtonList();
        KeyboardBarAdapter rvAdapter = new KeyboardBarAdapter(buttons, editText);
        buttonBar.setAdapter(rvAdapter);
        buttonBar.setLayoutManager(new LinearLayoutManager(this,
                LinearLayoutManager.HORIZONTAL,false));

        }

}
