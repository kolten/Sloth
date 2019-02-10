package me.koltensturgill.sloth;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import java.util.List;

import me.koltensturgill.sloth.ui.editor.KeyboardButton;

public class KeyboardBarAdapter extends RecyclerView.Adapter<KeyboardBarAdapter.ViewHolder> {

    public Context context;
    public class ViewHolder extends RecyclerView.ViewHolder{

        public Button barButton;

        public ViewHolder(View itemView){
            super(itemView);
            barButton = (Button) itemView.findViewById(R.id.keboardrv_button);

            //TODO create variable for button name
        }
    }

    private List<KeyboardButton> mButtons; //TODO create barBUtton class
    public KeyboardBarAdapter(List<KeyboardButton> buttons){

        mButtons = buttons;
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

        KeyboardButton keyboardButton = mButtons.get(position);
        Button button = viewHolder.barButton;
        button.setText(keyboardButton.getText());
    }

    @Override
    public int getItemCount(){
        return mButtons.size();
    }
}
