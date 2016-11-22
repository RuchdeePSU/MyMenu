package com.example.ruchee.mymenu;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
//import android.support.v7.view.ActionMode;
import android.view.ActionMode;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class ContextualAction extends AppCompatActivity implements ActionMode.Callback {
    String[] students = new String[]{"Bruce Vain", "John Wick", "Clark Kent", "Tony Stark"};
    ListView lvStudent_marvel;
    ArrayAdapter<String> studentAdapter = null;
    ActionMode mActionMode;
    int student_list_pos = -1;
    Context ctx = this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contextual_action);

        Toolbar mToolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(mToolbar);

        studentAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, students);
        lvStudent_marvel = (ListView) findViewById(R.id.lvStudents);
        lvStudent_marvel.setAdapter(studentAdapter);

        lvStudent_marvel.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

            }
        });

//        lvStudent_marvel.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                if(mActionMode != null) {
//                    return;
//                }
//                student_list_pos = position;
//                // start contextual action bar
//                mActionMode = startActionMode((ActionMode.Callback) ctx);
//                lvStudent_marvel.setSelected(true);
//            }
//        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater mMenuInflater = getMenuInflater();
        mMenuInflater.inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_setting:
                Toast.makeText(this,
                        "You have clicked on setting menu",
                        Toast.LENGTH_SHORT).show();
                break;
            case R.id.action_about_us:
                Intent mIntent = new Intent(this, MainActivity.class);
                startActivity(mIntent);
                break;
            case R.id.action_floating_context_menu:
                Intent fcIntent= new Intent(this, FloatingContextMenu.class);
                startActivity(fcIntent);
                break;
            case R.id.action_popup_menu:
                Intent pmIntent = new Intent(this,TestPopupMenu.class);
                startActivity(pmIntent);
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onCreateActionMode(ActionMode mode, Menu menu) {
        // inflate context menu
        MenuInflater cMenuInflater = getMenuInflater();
        cMenuInflater.inflate(R.menu.context_menu, menu);

        return true;
    }

    @Override
    public boolean onPrepareActionMode(ActionMode mode, Menu menu) {
        return false;
    }

    @Override
    public boolean onActionItemClicked(ActionMode mode, MenuItem item) {
        boolean success = true;
        switch(item.getItemId()) {
            case R.id.action_share:
                Toast.makeText(this,
                        "You have clicked Share menu on item " + studentAdapter.getItem(student_list_pos),
                        Toast.LENGTH_SHORT).show();
                mode.finish();
                break;
            case R.id.action_edit:
                Toast.makeText(this,
                        "You have clicked Edit menu on item " + studentAdapter.getItem(student_list_pos),
                        Toast.LENGTH_SHORT).show();
                mode.finish();
                break;
            case R.id.action_delete:
                Toast.makeText(this,
                        "You have clicked Delete menu on item " + studentAdapter.getItem(student_list_pos),
                        Toast.LENGTH_SHORT).show();
                mode.finish();
                break;
            default:
                success = false;
        }
        return success;
    }

    @Override
    public void onDestroyActionMode(ActionMode mode) {
        mActionMode = null;

    }
}
