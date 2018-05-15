package com.example.sachinsharma.cricfun;


import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.twitter.sdk.android.core.Callback;
import com.twitter.sdk.android.core.Result;
import com.twitter.sdk.android.core.TwitterApiClient;
import com.twitter.sdk.android.core.TwitterCore;
import com.twitter.sdk.android.core.TwitterException;
import com.twitter.sdk.android.core.models.Search;
import com.twitter.sdk.android.core.models.Tweet;
import com.twitter.sdk.android.core.services.SearchService;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.List;

import retrofit2.Call;

public class HomePage extends AppCompatActivity {

    TextView tvUsername;
    TextView tweet_txt;
    String username;
    long id;
    TextView tweetDisplay;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate ( savedInstanceState );
        setContentView ( R.layout.activity_home_page );
        username = getIntent ( ).getStringExtra ( "username" );
        id = getIntent ( ).getLongExtra ( "id", -1 );
        tvUsername = findViewById ( R.id.tvUsername );
        tweet_txt = findViewById ( R.id.tweet_txt );
        tvUsername.setText ( "Logged in as: " + username );
    }


    private void loadTwitterAPI(String query) {
        TwitterApiClient twitterApiClient = TwitterCore.getInstance ( ).getApiClient ( );
        SearchService searchService = twitterApiClient.getSearchService ( );
        Call <Search> call = searchService.tweets ( query, null, "en", null, "mixed", null, null, null, null, true );
        call.enqueue ( new Callback <Search> ( ) {
            @Override
            public void success(Result <Search> result) {
                //final List <Tweet> tweets = result.data.tweets;
                tweet_txt.setText ( "" );
                final List <Tweet> tweets = result.data.tweets;
                for (Tweet tw : tweets) {
                    tweet_txt.append ( "Tweet Id:" + tw.id + "\n" + "Date: " + tw.createdAt.split("[+]")[0] + "\n" + "Content:" + tw.text + "\n\n\n" );
                }
            }

            @Override
            public void failure(TwitterException exception) {
                Toast.makeText ( HomePage.this, "Records not found..!!", Toast.LENGTH_LONG ).show ( );
            }
        } );

    }

    public void searchTwitter(View view) {
        EditText searchTxt = findViewById ( R.id.search_edit );
        String searchTerm = searchTxt.getText ( ).toString ( );
        if (searchTerm.length ( ) > 0) {
            try {
                String encodedSearch = URLEncoder.encode ( searchTerm, "UTF-8" );
                loadTwitterAPI ( encodedSearch );
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace ( );
            }
        } else {
            tweetDisplay.setText ( "Enter a search query!" );
        }
    }

}
