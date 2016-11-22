package com.example.ruchee.mymenu;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.PopupMenu;
import android.widget.Toast;

public class TestPopupMenu extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_popup_menu);

        // start toolbar
        Toolbar mToolbar = (Toolbar) findViewById(R.id.toolbar2);
        setSupportActionBar(mToolbar);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater mMenuInflater = getMenuInflater();
        mMenuInflater.inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // action for setting menu
        if(item.getItemId() == R.id.action_setting) {
            Toast.makeText(this,
                    "You have clicked on setting menu",
                    Toast.LENGTH_SHORT)
                    .show();
        }

        // action for about us menu
        if(item.getItemId() == R.id.action_about_us) {
            Intent mIntent = new Intent(this, MainActivity.class);
            startActivity(mIntent);
        }

        // action for Floating Context menu
        if(item.getItemId() == R.id.action_floating_context_menu) {
            Intent fcIntent = new Intent(this, FloatingContextMenu.class);
            startActivity(fcIntent);

        }

        // action for Contextual Action Mode menu
        if(item.getItemId() == R.id.contextual_action_mode) {
            Intent caIntent = new Intent(this, ContextualAction.class);
            startActivity(caIntent);
        }
        return super.onOptionsItemSelected(item);
    }

    public void ShowPopupMenu(View v) {
        PopupMenu popup = new PopupMenu(this, v);
        MenuInflater pMenuInflater = popup.getMenuInflater();
        pMenuInflater.inflate(R.menu.context_menu, popup.getMenu());

        //registering popup with OnMenuItemClickListener
        popup.setOnMenuItemClickListener(new android.widget.PopupMenu.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.action_share:
                        Toast.makeText(TestPopupMenu.this,
                                "You have clicked Share menu",
                                Toast.LENGTH_SHORT)
                                .show();
                        break;
                    case R.id.action_edit:
                        Toast.makeText(TestPopupMenu.this,
                                "You have clicked Edit menu",
                                Toast.LENGTH_SHORT)
                                .show();
                        break;
                    case R.id.action_delete:
                        Toast.makeText(TestPopupMenu.this,
                                "You have clicked Delete menu",
                                Toast.LENGTH_SHORT)
                                .show();
                        break;
                }
                return true;
            }
        });

        popup.show();
    }
}
