/*
 * Recipe.java
 * Kevin Gabele
 */
package com.kev.kevrecipes;

import java.net.URL;
import java.util.Set;

/**
 * This is going to have a lot of shit
 */
public class Recipe {
    //valid sources
    public static final String WEBSITE="Website";
    public static final String BOOK="Book";
    public static final String PERSON="Person";
    public static final String UNKNOWN="Unknown";
    
    protected String source;
    protected String recipeName;
    
    //only if source=WEBSITE, otherwise null
    protected String websiteName;
    protected URL websiteURL;
    
    //only if source=BOOK, otherwise null
    protected String bookName;
    protected String author;
    protected Integer pageNumber;
    
    //only if source=PERSON, otherwise null
    protected String personName;
    
    protected String ingredients;
    protected String instructions;
    protected int prepTime;
    protected int cookTime;
    protected String yield;
    protected Tags tags;

    //noarg constuctor assumes unknown source
    //this probably shouldn't be used
    public Recipe(){
        this(UNKNOWN,"blank");
    }
    
    //constructor given only source & recipe name
    //probably shouldn't be called directly
    public Recipe(String source, String recipeName){
        switch (this.source){
            case WEBSITE:
            case BOOK:
            case PERSON:
            case UNKNOWN:
                this.source=source;
                this.recipeName=recipeName;
                break;
            default:
                throw new IllegalArgumentException();
        }
    }
    
    //constructor given all common info
    //appropriate for UNKNOWN sources
    public Recipe(String source, String recipeName, String ingredients, String instructions,
            int prepTime,int cookTime, String yield){
        this(source,recipeName);
        this.ingredients=ingredients;
        this.instructions=instructions;
        this.prepTime=prepTime;
        this.cookTime=cookTime;
        this.yield=yield;
    }
    
    //constructor given all info for WEBSITE source
    public Recipe(String source, String recipeName, String websiteName, URL websiteURL,
            String ingredients, String instructions,
            int prepTime,int cookTime, String yield){
        this(source,recipeName,ingredients,instructions,prepTime,cookTime,yield);
        this.websiteName=websiteName;
        this.websiteURL=websiteURL;
    }
    
    //constructor given all info for BOOK source
    public Recipe(String source, String recipeName, String bookName, String author, Integer pageNumber,
            String ingredients, String instructions,
            int prepTime,int cookTime, String yield){
        this(source,recipeName,ingredients,instructions,prepTime,cookTime,yield);
        this.bookName=bookName;
        this.author=author;
        this.pageNumber=pageNumber;
    }
    
    //constructor given all info for PERSON source
    public Recipe(String source, String recipeName, String personName,
            String ingredients, String instructions,
            int prepTime,int cookTime, String yield){
        this(source,recipeName,ingredients,instructions,prepTime,cookTime,yield);
        this.personName=personName;
    }

    //basic getters and setters

    public String getRecipeName() {
        return recipeName;
    }
    public void setRecipeName(String recipeName) {
        this.recipeName = recipeName;
    }

    public String getWebsiteName() { return websiteName; }
    public void setWebsiteName(String websiteName) { this.websiteName = websiteName; }

    public URL getWebsiteURL() {
        return websiteURL;
    }
    public void setWebsiteURL(URL websiteURL) {
        this.websiteURL = websiteURL;
    }

    public String getIngredients() {
        return ingredients;
    }
    public void setIngredients(String ingredients) {
        this.ingredients = ingredients;
    }

    public String getInstructions() {
        return instructions;
    }
    public void setInstructions(String instructions) {
        this.instructions = instructions;
    }

    public int getPrepTime() {
        return prepTime;
    }
    public void setPrepTime(int prepTime) {
        this.prepTime = prepTime;
    }

    public int getCookTime() {
        return cookTime;
    }
    public void setCookTime(int cookTime) {
        this.cookTime = cookTime;
    }

    public String getYield() {
        return yield;
    }
    public void setYield(String yield) {
        this.yield = yield;
    }

    //get a Set of all tags
    public Set getTags() {
        return tags.getTags();
    }    
    //add a tag
    public void addTag(String tag){
        tags.addTag(tag);
    }
    //remove a tag
    public void removeTag(String tag){
        tags.removeTag(tag);
    }
    
}
