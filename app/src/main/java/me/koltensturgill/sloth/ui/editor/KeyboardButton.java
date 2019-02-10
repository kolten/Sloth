package me.koltensturgill.sloth.ui.editor;

import java.util.ArrayList;

public class KeyboardButton {

    private String mText;

    public KeyboardButton(String text){

        mText = text;
    }

    public String getText(){
        return mText;
    }

    public static ArrayList<KeyboardButton> createButtonList(){
        ArrayList<KeyboardButton> buttons = new ArrayList<KeyboardButton>();

        buttons.add(new KeyboardButton("**"));
        buttons.add(new KeyboardButton("//"));
        buttons.add(new KeyboardButton("__"));
        buttons.add(new KeyboardButton("--"));

        return buttons;
    }
}
