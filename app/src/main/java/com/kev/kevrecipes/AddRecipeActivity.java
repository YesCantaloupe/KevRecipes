package com.kev.kevrecipes;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;


public class AddRecipeActivity extends Activity implements AdapterView.OnItemSelectedListener{
    private NoDefaultSpinner sourceSpinner;
    //private int selectCount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_recipe);

        //selectCount=0;

        //initialize source spinner
        sourceSpinner = (NoDefaultSpinner) findViewById(R.id.source_spinner);
        List list = new ArrayList();
        list.add(Recipe.WEBSITE);
        list.add(Recipe.BOOK);
        list.add(Recipe.PERSON);
        list.add(Recipe.UNKNOWN);
        ArrayAdapter dataAdapter = new ArrayAdapter(this,android.R.layout.simple_spinner_item,list);
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sourceSpinner.setAdapter(dataAdapter);

        //add listener
        sourceSpinner.setOnItemSelectedListener(this);
    }

    public void onItemSelected(AdapterView<?> parent,View view,int pos,long id){
        // An item was selected. You can retrieve the selected item using
        // parent.getItemAtPosition(pos)

        //remove previous source input, if applicable
        ViewGroup oldSource=(ViewGroup)findViewById(R.id.hidden_source);
        oldSource.removeAllViews();

        //add appropriate source input
        switch(parent.getItemAtPosition(pos).toString()){
            case Recipe.WEBSITE:
                InitializeWebsiteInput();
                break;
            case Recipe.BOOK:
                InitializeBookInput();
                break;
            case Recipe.PERSON:
                InitializePersonInput();
                break;
            case Recipe.UNKNOWN:
                InitializeUnknownInput();
                break;
        }
    }

    public void onNothingSelected(AdapterView<?> parent) {
        // Another interface callback
    }

    //display the input views for website
    private void InitializeWebsiteInput(){
        LinearLayout destination = (LinearLayout)findViewById(R.id.hidden_source);
        View source = getLayoutInflater().inflate(R.layout.layout_website_source,destination,false);
        destination.addView(source);
    }

    //display the input views for book
    private void InitializeBookInput(){
        LinearLayout destination = (LinearLayout)findViewById(R.id.hidden_source);
        View source = getLayoutInflater().inflate(R.layout.layout_book_source,destination,false);
        destination.addView(source);
    }

    //display the input views for person
    private void InitializePersonInput(){
        LinearLayout destination = (LinearLayout)findViewById(R.id.hidden_source);
        View source = getLayoutInflater().inflate(R.layout.layout_person_source,destination,false);
        destination.addView(source);
    }

    //display the input views for unknown
    private void InitializeUnknownInput(){

    }
/*
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

    public void createMessage(Object temp){
        RelativeLayout relativeLayout = new RelativeLayout(this);
        TextView tempTV = new TextView(this);
        tempTV.setText(temp.toString());
        relativeLayout.addView(tempTV);
        setContentView(relativeLayout);
    }
    */
}
