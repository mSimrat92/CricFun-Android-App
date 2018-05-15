package com.example.sachinsharma.cricfun;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Toast;

import com.twitter.sdk.android.core.Callback;
import com.twitter.sdk.android.core.DefaultLogger;
import com.twitter.sdk.android.core.Result;
import com.twitter.sdk.android.core.Twitter;
import com.twitter.sdk.android.core.TwitterAuthConfig;
import com.twitter.sdk.android.core.TwitterAuthToken;
import com.twitter.sdk.android.core.TwitterConfig;
import com.twitter.sdk.android.core.TwitterCore;
import com.twitter.sdk.android.core.TwitterException;
import com.twitter.sdk.android.core.TwitterSession;
import com.twitter.sdk.android.core.identity.TwitterLoginButton;

public class TwitterActivity extends AppCompatActivity {

    TwitterLoginButton loginButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate ( savedInstanceState );
        //Twitter.initialize(this);
        TwitterConfig config = new TwitterConfig.Builder ( this )
                .logger ( new DefaultLogger ( Log.DEBUG ) )
                .twitterAuthConfig ( new TwitterAuthConfig ( getResources ( ).getString ( R.string.com_twitter_sdk_android_CONSUMER_KEY ), getResources ( ).getString ( R.string.com_twitter_sdk_android_CONSUMER_SECRET ) ) )
                .debug ( true )
                .build ( );
        Twitter.initialize ( config );

        setContentView ( R.layout.activity_twitter);

        loginButton = findViewById ( R.id.login_button );
        loginButton.setCallback ( new Callback <TwitterSession> ( ) {
            @Override
            public void success(Result <TwitterSession> result) {
                TwitterSession session = TwitterCore.getInstance ( ).getSessionManager ( ).getActiveSession ( );
                TwitterAuthToken authToken = session.getAuthToken ( );
                String token = authToken.token;
                String secret = authToken.secret;
                login ( session );
            }

            @Override
            public void failure(TwitterException exception) {
                Toast.makeText ( TwitterActivity.this, "Authentication Failed..!!", Toast.LENGTH_LONG ).show ( );
            }
        } );
    }

    private void login(TwitterSession session) {
        String username = session.getUserName ( );
        long id = session.getId ( );
        Intent intent = new Intent ( TwitterActivity.this, HomePage.class );
        intent.putExtra ( "username", username );
        intent.putExtra ( "id", id );
        startActivity ( intent );
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult ( requestCode, resultCode, data );
        loginButton.onActivityResult ( requestCode, resultCode, data );
    }
}
