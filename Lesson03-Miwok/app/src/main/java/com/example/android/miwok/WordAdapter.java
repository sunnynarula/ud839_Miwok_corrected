package com.example.android.miwok;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class WordAdapter extends ArrayAdapter<Word> {

    public WordAdapter(@NonNull Context context, ArrayList<Word> listOfWords) {
        super(context, 0, listOfWords);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        if(convertView == null) {
            Context context = getContext();
            LayoutInflater layoutInflater = LayoutInflater.from(context);
            convertView = layoutInflater.inflate(R.layout.list_item, parent, false);
        }
        TextView mewokWordTextView = convertView.findViewById(R.id.mewok_word);
        TextView englishWordTextView = convertView.findViewById(R.id.english_word);
        ImageView imageView = convertView.findViewById(R.id.imageView);
        Word word = getItem(position);
        mewokWordTextView.setText(word.getMewokTranslation());
        englishWordTextView.setText(word.getDefaultTranslation());
        int imageResourceId = word.getImageResourceId();
        if(imageResourceId == 0) {
            imageView.setVisibility(View.GONE);
        } else {
            imageView.setVisibility(View.VISIBLE);
            imageView.setImageResource(imageResourceId);
        }
        return convertView;
    }
}
