package me.koltensturgill.sloth.ui.editor;

import java.util.ArrayList;

//Class that is used to populate the KeyboardButton recycler view
// in the editor fragment.
public class KeyboardButton {

    private String mText;
    CharSequence mMakrdownChar;

    public KeyboardButton(String text, CharSequence markdownChar ){

        //Text that will appear on the button itself.
        //This will likely be replaced with an icon in the future.
        mText = text;
        mMakrdownChar = markdownChar;
    }

    public String getText(){
        return mText;
    }

    public CharSequence getmMakrdownChar() { return mMakrdownChar; }

    //Method that will aid in programatically creating the buttons for
    //the recycler view. Any new button added will have to be added to this list.
    public static ArrayList<KeyboardButton> createButtonList(){
        ArrayList<KeyboardButton> buttons = new ArrayList<KeyboardButton>();

        buttons.add(new KeyboardButton("**","*"));
        buttons.add(new KeyboardButton("//","/"));
        buttons.add(new KeyboardButton("__","_"));
        buttons.add(new KeyboardButton("--","-"));

        return buttons;
    }
}
