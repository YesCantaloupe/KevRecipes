package com.kev.kevrecipes;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import java.util.ArrayList;
import java.util.List;


public class AddRecipeActivity extends Activity implements AdapterView.OnItemSelectedListener{
    private NoDefaultSpinner sourceSpinner;
    String source;
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

    public void onItemSelected(AdapterView<?> parent,View view,int pos,long id) {
        // An item was selected. You can retrieve the selected item using
        // parent.getItemAtPosition(pos)

        //remove previous source input, if applicable
        ViewGroup oldSource = (ViewGroup) findViewById(R.id.hidden_source);
        oldSource.removeAllViews();

        source = parent.getItemAtPosition(pos).toString();
        //add appropriate source input
        switch (source) {
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

        //add button to continue
        RelativeLayout destination = (RelativeLayout) findViewById(R.id.add_recipe);
        Button button = new Button(this);
        RelativeLayout.LayoutParams buttonParams = new RelativeLayout.LayoutParams(ActionBar.LayoutParams.WRAP_CONTENT, ActionBar.LayoutParams.WRAP_CONTENT);
        buttonParams.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM);
        buttonParams.addRule(RelativeLayout.ALIGN_PARENT_END);
        button.setLayoutParams(buttonParams);
        button.setText("Continue");
        //set what to do when the button is clicked
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AddRecipeActivity.this, IngredientsInstructionsActivity.class);
                //pass the name & source
                EditText recipeName = (EditText)findViewById(R.id.recipe_name);
                intent.putExtra("recipeName",recipeName.getText().toString());
                intent.putExtra("source",source);
                //pass extra info dependent on kind of source
                switch (source) {
                    case Recipe.WEBSITE:
                        EditText websiteName = (EditText)findViewById(R.id.website_name);
                        intent.putExtra("websiteName",websiteName.getText().toString());
                        EditText websiteUrl = (EditText)findViewById(R.id.website_url);
                        intent.putExtra("websiteUrl",websiteUrl.getText().toString());
                        break;
                    case Recipe.BOOK:
                        EditText bookName = (EditText)findViewById(R.id.book_name);
                        intent.putExtra("bookName",bookName.getText().toString());
                        EditText author = (EditText)findViewById(R.id.author);
                        intent.putExtra("author",author.getText().toString());
                        EditText pageNumber = (EditText)findViewById(R.id.page_number);
                        intent.putExtra("pageNumber",pageNumber.getText().toString());
                        break;
                    case Recipe.PERSON:
                        EditText personName = (EditText)findViewById(R.id.person_name);
                        intent.putExtra("personName",personName.getText().toString());
                        break;
                    case Recipe.UNKNOWN:
                        break;
                }
                startActivity(intent);
            }
        });
        destination.addView(button);
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
