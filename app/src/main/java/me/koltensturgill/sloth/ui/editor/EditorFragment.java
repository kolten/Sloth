package me.koltensturgill.sloth.ui.editor;

import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import me.koltensturgill.sloth.R;

public class EditorFragment extends Fragment {

    private EditorViewModel mViewModel;

    //sean left off here, was trying to get the data the user types...
    //EditText editText = (EditText) findViewById(R.id.editText);

    public static EditorFragment newInstance() {
        return new EditorFragment();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {





        return inflater.inflate(R.layout.editor_fragment, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = ViewModelProviders.of(this).get(EditorViewModel.class);
        // TODO: Use the ViewModel
    }





}
