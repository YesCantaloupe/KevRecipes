package com.kev.kevrecipes;

import android.content.Context;
import android.database.sqlite.*;
import android.provider.BaseColumns;

/**
 * Created by Kevin on 7/31/2015.
 */
public final class RecipeBookContract {
    public RecipeBookContract() {
    }

    //
    public static abstract class Recipes implements BaseColumns {
        public static final String TABLE_NAME = "recipes";

        //I think BaseColums should take care of the unique integer primary key
        //public static final String COLUMN_NAME_RECIPE_ID = "recipeid";
        public static final String COLUMN_NAME_RECIPE_NAME = "recipename";
        public static final String COLUMN_NAME_SOURCE = "source";
        //only if source=website
        public static final String COLUMN_NAME_WEBSITE_NAME = "websitename";
        public static final String COLUMN_NAME_WEBSITE_URL = "url";
        //only if source=book
        public static final String COLUMN_NAME_BOOK_NAME = "bookname";
        public static final String COLUMN_NAME_BOOK_AUTHOR = "author";
        public static final String COLUMN_NAME_BOOK_PAGE = "page";
        //only if source=person
        public static final String COLUMN_NAME_PERSON_NAME = "personname";
        //common to all sources
        public static final String COLUMN_NAME_INGREDIENTS = "ingredients";
        public static final String COLUMN_NAME_INSTRUCTIONS = "instructions";
        public static final String COLUMN_NAME_PREP_TIME = "preptime";
        public static final String COLUMN_NAME_COOK_TIME = "cooktime";
        public static final String COLUMN_NAME_YIELD = "yield";
    }

    public static abstract class RecipeTags implements BaseColumns {
        public static final String TABLE_NAME = "recipetags";
        //I think BaseColums should take care of the unique integer primary key
        //public static final String COLUMN_NAME_RECIPE_ID = "recipeid";
        public static final String COLUMN_NAME_TAG = "tag";
    }

    private static final String TEXT_TYPE = "TEXT";
    private static final String INT_TYPE = "INTEGER(3)";
    private static final String COMMA_SEP = ",";
    private static final String SQL_CREATE_RECIPES =
            "CREATE TABLE " + Recipes.TABLE_NAME + " (" +
                    Recipes._ID + " INTEGER PRIMARY KEY," +
                    Recipes.COLUMN_NAME_RECIPE_NAME + TEXT_TYPE + COMMA_SEP +
                    Recipes.COLUMN_NAME_SOURCE + TEXT_TYPE + COMMA_SEP +
                    Recipes.COLUMN_NAME_WEBSITE_NAME + TEXT_TYPE + COMMA_SEP +
                    Recipes.COLUMN_NAME_WEBSITE_URL + TEXT_TYPE + COMMA_SEP +
                    Recipes.COLUMN_NAME_BOOK_NAME + TEXT_TYPE + COMMA_SEP +
                    Recipes.COLUMN_NAME_BOOK_AUTHOR + TEXT_TYPE + COMMA_SEP +
                    Recipes.COLUMN_NAME_BOOK_PAGE + INT_TYPE + COMMA_SEP +
                    Recipes.COLUMN_NAME_PERSON_NAME + TEXT_TYPE + COMMA_SEP +
                    Recipes.COLUMN_NAME_INGREDIENTS + TEXT_TYPE + COMMA_SEP +
                    Recipes.COLUMN_NAME_INSTRUCTIONS + TEXT_TYPE + COMMA_SEP +
                    Recipes.COLUMN_NAME_PREP_TIME + INT_TYPE + COMMA_SEP +
                    Recipes.COLUMN_NAME_COOK_TIME + INT_TYPE + COMMA_SEP +
                    Recipes.COLUMN_NAME_YIELD + TEXT_TYPE + ")";


    //KEVIN: FIX THIS. The primary key should be teh combo of the recipe ID & the tag
    private static final String SQL_CREATE_RECIPE_TAGS =
            "CREATE TABLE " + RecipeTags.TABLE_NAME + " (" +
                    RecipeTags._ID + " INTEGER PRIMARY KEY," +
                    RecipeTags.COLUMN_NAME_TAG + TEXT_TYPE + ")";

    private static final String SQL_DELETE_RECIPES =
            "DROP TABLE IF EXISTS " + Recipes.TABLE_NAME;

    private static final String SQL_DELETE_RECIPE_TAGS =
            "DROP TABLE IF EXISTS " + RecipeTags.TABLE_NAME;

    public class RecipeBookDbHelper extends SQLiteOpenHelper {
        public static final int DATABASE_VERSION = 1;
        public static final String DATABASE_NAME = "RecipeBook.db";

        public RecipeBookDbHelper(Context context) {
            super(context, DATABASE_NAME, null, DATABASE_VERSION);
        }

        public void onCreate(SQLiteDatabase db) {
            db.execSQL(SQL_CREATE_RECIPES);
            db.execSQL(SQL_CREATE_RECIPE_TAGS);
        }

        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            db.execSQL(SQL_DELETE_RECIPES);
            db.execSQL(SQL_DELETE_RECIPE_TAGS);
            onCreate(db);
        }

        public void onDowngrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            onUpgrade(db, oldVersion, newVersion);
        }
    }


}