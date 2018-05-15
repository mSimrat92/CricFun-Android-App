package com.example.sachinsharma.cricfun;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.PagerTabStrip;
import android.support.v4.view.ViewPager;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    DrawerLayout mDrawerLayout;
    ViewPager vp;
    Fragment fragment = null;
    private View navHeader;
    NavigationView navigationView;
    private ImageView imgNavHeaderBg, imgProfile;
    TextView nametxt,idText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        navigationView = (NavigationView) findViewById(R.id.nav_view);
        navHeader=navigationView.getHeaderView(0);
        nametxt=navHeader.findViewById(R.id.name);
        idText=navHeader.findViewById(R.id.email);
        imgProfile=navHeader.findViewById(R.id.image_profile);
        nametxt.setText("Cricket App");
        idText.setText("info@cricketapp.com");
       //imgProfile.setImageResource(R.drawable.download);
        navigationView.setNavigationItemSelectedListener(this);
        //=findViewById(R.id.drawer_layout);
        vp=findViewById(R.id.vpPager);
        vp.setAdapter(new SampleFragmentPagerAdapter(getSupportFragmentManager(),this));
        vp.setCurrentItem(1,true);


        //displayMatches();

    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_home) {
           Intent intent=new Intent(this,MainActivity.class);
           startActivity(intent);
        } else if (id == R.id.nav_currentMatches) {
            findViewById(R.id.mainLinear).setVisibility(View.GONE);
            fragment=new CurrentMatchesFragment().newInstance();
        }
        else if (id == R.id.nav_Results) {
            findViewById(R.id.mainLinear).setVisibility(View.GONE);
            fragment=new ResultsFragment().newInstance();
        } else if (id == R.id.nav_News) {

        } else if (id == R.id.nav_videos) {

        } else if (id == R.id.nav_photos) {

        }
        else if(id == R.id.nav_pointsTable){

        }
        else if(id== R.id.nav_PlayerProfiles){
           Intent intent=new Intent(this,TwitterActivity.class);
           startActivity(intent);
        }
        if (fragment != null) {
            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
            ft.replace(R.id.mainConstraint, fragment);
            Log.d("TAG", "Item Click Working");
            ft.commit();
        }
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }


}
