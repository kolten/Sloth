package me.koltensturgill.sloth;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import me.koltensturgill.sloth.ui.editor.EditorFragment;
import me.koltensturgill.sloth.ui.editor.Utils;

public class Editor extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Utils.setThemeToActivity(this);
        setContentView(R.layout.editor_activity);
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.container, EditorFragment.newInstance())
                    .commitNow();
        }
    }
}
