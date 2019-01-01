package com.example.android.miwok;

import android.app.Activity;
import android.media.MediaPlayer;
import android.provider.ContactsContract;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import static android.widget.ImageView.*;

public class WordAdapter extends ArrayAdapter<Word> {

    /**Resource ID for the background color for this list of words */

    private int mColorResourceId;

    /**create a new WordAdapter object */

    public WordAdapter(Activity context, ArrayList<Word> words,int ColorResourceId){
        super (context,0,words);

    mColorResourceId=ColorResourceId;

    }


        @Override

        public View getView(int position, View convertView, ViewGroup parent) {
            // Check if the existing view is being reused, otherwise inflate the view
            View listItemView = convertView;
            if(listItemView == null) {
                listItemView = LayoutInflater.from(getContext()).inflate(
                        R.layout.list_item, parent, false);
            }

            // Get the {@link AndroidFlavor} object located at this position in the list
            Word currentWord = getItem(position);


            /** Find the TextView in the list_item.xml layout with the ID version_name*/

            TextView miwokTextView = (TextView) listItemView.findViewById(R.id.miwok_text_view);

            // Get the version name from the current AndroidFlavor object and
            // set this text on the name TextView
            miwokTextView.setText(currentWord.getMiwokTranslation());


            /** Find the TextView in the list_item.xml layout with the ID version_name*/

            TextView defaultTextView = (TextView) listItemView.findViewById(R.id.default_text_view);
            // Get the version name from the current AndroidFlavor object and
            // set this text on the name TextView
            defaultTextView.setText(currentWord.getDefaultTranslation());



            /** Find the ImageView in the list_item.xml layout with the ID version_name*/

            ImageView listIcon = (ImageView) listItemView.findViewById(R.id.list_item_icon);
            // Get the image resource ID from the current AndroidFlavor object and
            if (currentWord.hasImage()) {
                // set the image to iconView specified in the current word
                listIcon.setImageResource(currentWord.getListIcon());
                //Make sure the view is visible
                listIcon.setVisibility(View.VISIBLE);
            }
            else {
                //otherwise, hide the image view completely (GONE)
                listIcon.setVisibility(View.GONE);
            }

            // Set the theme color for the list item
            View textContainer = listItemView.findViewById(R.id.text_container);
            // Find the color that the resource ID maps to
            int color = ContextCompat.getColor(getContext(), mColorResourceId);
            // Set the background color of the text container View
            textContainer.setBackgroundColor(color);



                // Return the whole list item layout (containing 2 TextViews and an ImageView)
            // so that it can be shown in the ListView
            return listItemView;
        }

}
