package com.example.ruchee.mymenu;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // start customized toolbar
        Toolbar mToolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(mToolbar);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // inflate main_menu.xml
        MenuInflater mMenuInflater = getMenuInflater();
        mMenuInflater.inflate(R.menu.main_menu, menu);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // action when clicks setting menu
        if(item.getItemId() == R.id.action_setting) {
            Toast.makeText(MainActivity.this,
                    "You have clicked on setting menu.",
                    Toast.LENGTH_SHORT)
                    .show();
        }

        // action when clicks about us menu
        if(item.getItemId() == R.id.action_about_us) {
            Toast.makeText(MainActivity.this,
                    "You have clicked on About us menu",
                    Toast.LENGTH_SHORT)
                    .show();
        }

        if(item.getItemId() == R.id.action_floating_context_menu) {
            Intent fcIntent = new Intent(this, FloatingContextMenu.class);
            startActivity(fcIntent);

        }

        if(item.getItemId() == R.id.contextual_action_mode) {
            Intent caIntent = new Intent(this, ContextualAction.class);
            startActivity(caIntent);
        }

        if(item.getItemId() == R.id.action_popup_menu) {
            Intent pmIntent = new Intent(this,TestPopupMenu.class);
            startActivity(pmIntent);
        }

        return super.onOptionsItemSelected(item);
    }
}
