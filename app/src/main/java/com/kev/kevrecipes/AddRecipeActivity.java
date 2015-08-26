package com.kev.kevrecipes;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.List;


public class AddRecipeActivity extends ActionBarActivity {
    private Spinner sourceSpinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_recipe);

        //initialize source spinner
        addItemsOnSourceSpinner();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_add_recipe, menu);
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

    private void addItemsOnSourceSpinner(){
        sourceSpinner = (Spinner) findViewById(R.id.source_spinner);
        List list = new ArrayList();
        list.add(Recipe.WEBSITE);
        list.add(Recipe.BOOK);
        list.add(Recipe.PERSON);
        list.add(Recipe.UNKNOWN);
        ArrayAdapter dataAdapter = new ArrayAdapter(this,android.R.layout.simple_spinner_item,list);
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sourceSpinner.setAdapter(dataAdapter);
    }

    public class SourceSpinner implements AdapterView.OnItemSelectedListener{
        public SourceSpinner(){}
        public void onItemSelected(AdapterView<?> parent,View view,int pos,long id){
            // An item was selected. You can retrieve the selected item using
            // parent.getItemAtPosition(pos)
        }

        public void onNothingSelected(AdapterView<?> parent) {
            // Another interface callback
        }

    }
}
