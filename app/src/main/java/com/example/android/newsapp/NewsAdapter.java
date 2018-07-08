package com.example.android.newsapp;


import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.text.ParseException;
import java.util.List;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * Created by Elena on 1/7/2018.
 */

public class NewsAdapter extends ArrayAdapter<News>{
    /**
     *
     * @param context of the app
     * @param newsItems is the list of news items, which is the data source for the adapter
     */
    public NewsAdapter(Context context, List<News> newsItems){
        super(context, 0, newsItems);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        // Check if there is an existing list item view (called convertView) that we can reuse,
        // otherwise, if convertView is null, then inflate a new list item layout.
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.news_list_item, parent, false);
        }

        // Find the news item at the given position in the list of news items
        News currentNews = getItem(position);

        // Find the TextView with view ID title and set the title
        TextView titleView = (TextView) listItemView.findViewById(R.id.title);
        titleView.setText(currentNews.getTitle());

        // Find the TextView with view ID section and set the section
        TextView sectionView = (TextView) listItemView.findViewById(R.id.section);
        sectionView.setText(currentNews.getSection());

        // Find the TextView with view ID section and set the section
        TextView authorView = (TextView) listItemView.findViewById(R.id.author);
        authorView.setText(currentNews.getAuthor());

        // Find the TextView with view ID date and set the date
        TextView dateView = (TextView) listItemView.findViewById(R.id.date);
        String rawDate = currentNews.getDate();
        // Format the date string (i.e. "Mar 3, 1984")
        String formattedDate = formatDate(rawDate);
        // Display the date of the current earthquake in that TextView
        dateView.setText(formattedDate);

        // Return the list item view that is now showing the appropriate data
        return listItemView;
    }

    /**
     * Return the formatted date string (i.e. "Mar 3, 1984").
     */
    private String formatDate(String rawDate) {
        // Pattern for the date input
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'", Locale.UK);
        try {
            Date parsedJsonDate = dateFormat.parse(rawDate);
            // Pattern for the date output
            SimpleDateFormat outputDateFormatter = new SimpleDateFormat("MMM d, yyyy", Locale.UK);
            return outputDateFormatter.format(parsedJsonDate);
        } catch (ParseException e) {
            Log.e("QueryUtils", "Error parsing JSON date: ", e);
            return "";
        }
    }

}
