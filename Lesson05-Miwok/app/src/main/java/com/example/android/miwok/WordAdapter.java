/*
 * Copyright (C) 2016 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.android.miwok;

import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.media.MediaPlayer;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

/**
 * {@link WordAdapter} is an {@link ArrayAdapter} that can provide the layout for each list item
 * based on a data source, which is a list of {@link Word} objects.
 */
public class WordAdapter extends ArrayAdapter<Word> {

    private final int backgroundColor;

    /**
     * Create a new {@link WordAdapter} object.
     *
     * @param context is the current context (i.e. Activity) that the adapter is being created in.
     * @param words is the list of {@link Word}s to be displayed.
     */
    public WordAdapter(@NonNull Context context, ArrayList<Word> words, int colorResourceId) {
        super(context, 0, words);
        backgroundColor = ContextCompat.getColor(context, colorResourceId);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        // Check if an existing view is being reused, otherwise inflate the view
        if(convertView == null) {
            Context context = getContext();
            LayoutInflater layoutInflater = LayoutInflater.from(context);
            convertView = layoutInflater.inflate(R.layout.list_item, parent, false);
        }
        // Get the {@link Word} object located at this position in the list
        final Word word = getItem(position);
        LinearLayout wordHolderLinearLayout = convertView.findViewById(R.id.word_holder_linear_layout);
        wordHolderLinearLayout.setBackgroundColor(backgroundColor);

        // Find the TextView in the list_item.xml layout with the ID miwok_word.
        TextView mewokWordTextView = convertView.findViewById(R.id.mewok_word);
        // Get the Miwok translation from the currentWord object and set this text on
        // the Miwok TextView.
        mewokWordTextView.setText(word.getMiwokTranslation());

        // Find the TextView in the list_item.xml layout with the ID english_word.
        TextView englishWordTextView = convertView.findViewById(R.id.english_word);
        // Get the default translation from the currentWord object and set this text on
        // the default TextView.
        englishWordTextView.setText(word.getDefaultTranslation());

        ImageView imageView = convertView.findViewById(R.id.imageView);
        if(word.hasImage()) {
            imageView.setVisibility(View.VISIBLE);
            imageView.setImageResource(word.getImageResourceId());
        } else {
            imageView.setVisibility(View.GONE);
        }

        // Return the whole list item layout (containing 2 TextViews) so that it can be shown in
        // the ListView.
        return convertView;
    }

}
