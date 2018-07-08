package com.example.android.newsapp;

/**
 * Created by Elena on 1/7/2018.
 */

public class News {
    private String mTitle;
    private String mSection;
    private String mDate;
    private String mUrl;
    private String mAuthor;

    public News(String title, String section, String date, String url, String author){
        mTitle = title;
        mSection = section;
        mDate = date;
        mUrl = url;
        mAuthor = author;
    }

    public String getTitle(){
        return mTitle;
    }

    public String getSection(){
        return mSection;
    }

    public String getDate(){
        return mDate;
    }

    public String getUrl(){
        return mUrl;
    }

    public String getAuthor(){
        return mAuthor;
    }

}
