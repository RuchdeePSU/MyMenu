package com.example.ruchee.mymenu;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class FloatingContextMenu extends AppCompatActivity {
    String[] students = new String[]{"Bruce Vain", "John Wick", "Clark Kent", "Tony Stark"};
    ListView lvStudents_marvel;
    ArrayAdapter<String> studentAdapter = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_floating_context_menu);

        Toolbar mToolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(mToolbar);

        // set adapter to ListView
        studentAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, students);
        lvStudents_marvel = (ListView) findViewById(R.id.lvStudents);
        lvStudents_marvel.setAdapter(studentAdapter);

        // register context menu to ListView
        registerForContextMenu(lvStudents_marvel);
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
                    Toast.LENGTH_SHORT).show();
        }

        // action for About Us menu
        if(item.getItemId() == R.id.action_about_us) {
            Intent mIntent = new Intent(this, MainActivity.class);
            startActivity(mIntent);
        }

//        // action for Floating Context menu
//        if(item.getItemId() == R.id.action_floating_context_menu) {
//            Intent fcIntent = new Intent(this, FloatingContextMenu.class);
//            startActivity(fcIntent);
//        }

        // action for Contextual Action Mode
        if (item.getItemId() == R.id.contextual_action_mode) {
            Intent caIntent = new Intent(this, ContextualAction.class);
            startActivity(caIntent);
        }

        // action for Popup menu
        if(item.getItemId() == R.id.action_popup_menu) {
            Intent pmIntent = new Intent(this,TestPopupMenu.class);
            startActivity(pmIntent);
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        MenuInflater cMenuInflater = getMenuInflater();
        cMenuInflater.inflate(R.menu.context_menu, menu);
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        // get ListView current position
        AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();

        switch (item.getItemId()) {
            case R.id.action_share:
                Toast.makeText(this,
                        "You have clicked Share menu on item " + studentAdapter.getItem(info.position),
                        Toast.LENGTH_SHORT)
                        .show();
                break;
            case R.id.action_edit:
                Toast.makeText(this,
                        "You have clicked Edit menu on item " + studentAdapter.getItem(info.position),
                        Toast.LENGTH_SHORT)
                        .show();
                break;
            case R.id.action_delete:
                Toast.makeText(this,
                        "You have clicked Delete menu on item " + studentAdapter.getItem(info.position),
                        Toast.LENGTH_SHORT)
                        .show();
                break;
        }
        return super.onContextItemSelected(item);
    }

}
