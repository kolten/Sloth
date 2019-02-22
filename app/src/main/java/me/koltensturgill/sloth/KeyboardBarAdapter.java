package me.koltensturgill.sloth;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.Button;
import android.widget.EditText;

import java.util.List;

import me.koltensturgill.sloth.ui.editor.KeyboardButton;


//Adapter class for the Keyboard button bar used in the Editor Fragment
public class KeyboardBarAdapter extends RecyclerView.Adapter<KeyboardBarAdapter.ViewHolder> {

    public Context context;
    public class ViewHolder extends RecyclerView.ViewHolder{

        public Button barButton;

        public ViewHolder(View itemView){
            super(itemView);
            barButton = (Button) itemView.findViewById(R.id.keboardrv_button);


        }
    }
    //Constructor that will be used to get all of the buttons to be created
    //for the button bar.
    private List<KeyboardButton> mButtons;
    public EditText mDummyText;
    public KeyboardBarAdapter(List<KeyboardButton> buttons, EditText dummyText){

        mButtons = buttons;
        mDummyText = dummyText;
    }

    @Override
    public KeyboardBarAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType){

        context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        View buttonView = inflater.inflate(R.layout.rvkeyboard_bar, parent, false);

        ViewHolder viewHolder = new ViewHolder(buttonView);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(KeyboardBarAdapter.ViewHolder viewHolder, int position){

        final KeyboardButton keyboardButton = mButtons.get(position);
        Button button = viewHolder.barButton;
        button.setText(keyboardButton.getText());

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                mDummyText.getText().insert(mDummyText.getSelectionStart(), keyboardButton.getmMakrdownChar());
                mDummyText.getText().insert(mDummyText.getSelectionStart(), keyboardButton.getmMakrdownChar());
                mDummyText.setSelection(mDummyText.getSelectionStart()-1);

            }
        });
    }

    @Override
    public int getItemCount(){
        return mButtons.size();
    }
}
