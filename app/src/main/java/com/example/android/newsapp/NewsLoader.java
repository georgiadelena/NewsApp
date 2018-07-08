package com.example.android.newsapp;

import android.content.AsyncTaskLoader;
import java.util.List;
import android.content.Context;

/**
 * Loads a list of news items by using an AsyncLoader to perform the
 * network request to the given URL.
 *
 * Created by Elena on 1/7/2018.
 */

public class NewsLoader extends AsyncTaskLoader<List<News>> {
    /** Tag for log messages */
    private static final String LOG_TAG = NewsLoader.class.getName();

    /** Query URL */
    private String mUrl;

    /**
     * Constructs a new {@link NewsLoader}.
     *
     * @param context of the activity
     * @param url to load data from
     */
    public NewsLoader(Context context, String url) {
        super(context);
        mUrl = url;
    }

    @Override
    protected void onStartLoading() {
        forceLoad();
    }

    /**
     * This is on a background thread.
     */
    @Override
    public List<News> loadInBackground() {
        if (mUrl == null) {
            return null;
        }

        // Perform the network request, parse the response, and extract a list of news items.
        List<News> newsItems = QueryUtils.fetchNewsData(mUrl);
        return newsItems;
    }
}
