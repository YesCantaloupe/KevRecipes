package com.kev.kevrecipes;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

/**
 * Created by Kevin on 2/19/2016.
 */
public class IngredientsInstructionsActivity extends Activity {
    String source,recipeName;
    String websiteName,websiteUrl;
    String bookName,author, pageNumber;
    String personName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ingredients_instructions);

        //retrieve passed information, tho' most of this will simply be passed on to the next, to be added to the db later
        source = getIntent().getExtras().getString("source");
        recipeName = getIntent().getExtras().getString("recipeName");
        switch (source) {
            case Recipe.WEBSITE:
                websiteName = getIntent().getExtras().getString("websiteName");
                websiteUrl = getIntent().getExtras().getString("websiteUrl");
                break;
            case Recipe.BOOK:
                bookName = getIntent().getExtras().getString("bookName");
                author = getIntent().getExtras().getString("author");
                pageNumber = getIntent().getExtras().getString("pageNumber");
                break;
            case Recipe.PERSON:
                personName = getIntent().getExtras().getString("personName");
                break;
            case Recipe.UNKNOWN:
                break;
        }

        TextView title = (TextView)findViewById(R.id.recipeTitle);
        title.setText(recipeName);
    }
    public void continueToConfirmation(View view){
        Intent intent = new Intent(IngredientsInstructionsActivity.this, ConfirmationActivity.class);
        //pass the name & source
        intent.putExtra("recipeName",recipeName);
        intent.putExtra("source",source);
        //pass extra info dependent on kind of source
        switch (source) {
            case Recipe.WEBSITE:
                intent.putExtra("websiteName",websiteName);
                intent.putExtra("websiteUrl",websiteUrl);
                break;
            case Recipe.BOOK:
                intent.putExtra("bookName",bookName);
                intent.putExtra("author",author);
                intent.putExtra("pageNumber",pageNumber);
                break;
            case Recipe.PERSON:
                intent.putExtra("personName",personName);
                break;
            case Recipe.UNKNOWN:
                break;
        }
        //pass the ingredients and instructions
        EditText ingredients = (EditText)findViewById(R.id.ingredientsText);
        intent.putExtra("ingredients",ingredients.getText().toString());
        EditText instructions = (EditText)findViewById(R.id.instructionsText);
        intent.putExtra("instructions",instructions.getText().toString());
        startActivity(intent);
        //continue to the confirmation screen
        startActivity(intent);
    }
}
