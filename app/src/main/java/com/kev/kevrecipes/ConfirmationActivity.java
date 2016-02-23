package com.kev.kevrecipes;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;


public class ConfirmationActivity extends Activity {
    String source,recipeName;
    String websiteName,websiteUrl;
    String bookName,author, pageNumber;
    String personName;
    String ingredients,instructions;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirmation);

        //retrieve passed information, populate textviews
        recipeName = getIntent().getExtras().getString("recipeName");
        TextView tRecipeName = (TextView)findViewById(R.id.confirmation_recipe_name);
        tRecipeName.setText(recipeName);
        source = getIntent().getExtras().getString("source");
        TextView tSource = (TextView)findViewById(R.id.confirmation_source);
        tSource.setText(source);
        switch (source) {
            case Recipe.WEBSITE:
                websiteName = getIntent().getExtras().getString("websiteName");
                TextView tWebsiteName = (TextView)findViewById(R.id.confirmation_website_name);
                tWebsiteName.setText(websiteName);
                websiteUrl = getIntent().getExtras().getString("websiteUrl");
                TextView tWebsiteUrl = (TextView)findViewById(R.id.confirmation_website_url);
                tWebsiteUrl.setText(websiteUrl);
                break;
            case Recipe.BOOK:
                bookName = getIntent().getExtras().getString("bookName");
                TextView tBookName = (TextView)findViewById(R.id.confirmation_book_name);
                tBookName.setText(bookName);
                author = getIntent().getExtras().getString("author");
                TextView tAuthor = (TextView)findViewById(R.id.confirmation_author);
                tAuthor.setText(author);
                pageNumber = getIntent().getExtras().getString("pageNumber");
                TextView tPageNumber = (TextView)findViewById(R.id.confirmation_page_number);
                tPageNumber.setText("Page: " + pageNumber);
                break;
            case Recipe.PERSON:
                personName = getIntent().getExtras().getString("personName");
                TextView tPersonName = (TextView)findViewById(R.id.confirmation_person_name);
                tPersonName.setText(personName);
                break;
            case Recipe.UNKNOWN:
                break;
        }
        ingredients = getIntent().getExtras().getString("ingredients");
        TextView tIngredients = (TextView)findViewById(R.id.confirmation_ingredients);
        tIngredients.setText(ingredients);
        instructions = getIntent().getExtras().getString("instructions");
        TextView tInstructions = (TextView)findViewById(R.id.confirmation_instructions);
        tInstructions.setText(instructions);
    }

    protected void confirm(View view){
        //write recipe to database
    }
}
