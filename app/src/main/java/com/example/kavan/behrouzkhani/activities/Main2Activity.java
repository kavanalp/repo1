package com.example.kavan.behrouzkhani.activities;

import android.content.ActivityNotFoundException;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.kavan.behrouzkhani.R;

public class Main2Activity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    Toolbar toolbar;
    Uri uri;
    NavigationView navigationView;
    DrawerLayout drawer;
    ActionBarDrawerToggle toggle;
    ImageView loginBtn;
    TextView proTextView;
    String proText;
    View headerView;
    String tele = "https://telegram.me/masiresaadat_com";
    String insta = "http://instagram.com/Masiresaadat_com";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().getDecorView().setLayoutDirection(View.LAYOUT_DIRECTION_RTL);
        setContentView(R.layout.activity_main2);
        Intent intent = getIntent();
        proText = intent.getStringExtra("text");
        init();
        proTextView.setText(proText);
        toolbar.setTitle("");
        setSupportActionBar(toolbar);
        toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
        navigationView.setNavigationItemSelectedListener(this);


    }

    private void init() {
        toolbar = findViewById(R.id.toolbar);
        navigationView = findViewById(R.id.nav_view);
        drawer = findViewById(R.id.drawer_layout);
        headerView = navigationView.getHeaderView(0);
        proTextView = headerView.findViewById(R.id.proTextView);
    }

    public void accountClick(View view) {

        startActivity(new Intent(Main2Activity.this, Login.class));
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.

        int id = item.getItemId();

        if (id == R.id.nav_camera) {
            startActivity(new Intent(Main2Activity.this,MainActivity.class));
            // Handle the camera action
        } else if (id == R.id.nav_gallery) {

        } else if (id == R.id.nav_slideshow) {

        } else if (id == R.id.nav_manage) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    public void usersClick(View view) {
        startActivity(new Intent(Main2Activity.this, MainActivity.class));
    }

    public void items(View view) {
        if (view.getId() == R.id.exitBtn) {
            Alert();
        } else if (view.getId() == R.id.instagram)
            url(insta);
        else if (view.getId() == R.id.telegram)
            url(tele);
        else if (view.getId() == R.id.web)
            url("http://www.behrouzkhani.com");
        else if (view.getId() == R.id.videos)
            startActivity(new Intent(this, Videosssss.class));
        else if (view.getId() == R.id.doereha)
            startActivity(new Intent(this, Courses.class));
    }

    private void url(String url1) {
        uri = Uri.parse(url1);
        Intent likeIng = new Intent(Intent.ACTION_VIEW, uri);

        likeIng.setPackage("com.example.kavan.behrouzkhani");

        try {
            startActivity(likeIng);
        } catch (ActivityNotFoundException e) {
            startActivity(new Intent(Intent.ACTION_VIEW,
                    Uri.parse(url1)));
        }
    }

    private void Alert() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Close the app")
                .setMessage("Are you sure you want to exit?")
                .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        finish();
                        System.exit(0);
                    }
                })
                .setNegativeButton(android.R.string.no, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        // do nothing
                    }
                })
                .setIcon(android.R.drawable.ic_menu_close_clear_cancel)
                .show();
    }

}
