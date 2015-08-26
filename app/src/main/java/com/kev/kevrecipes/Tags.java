/**
* Tags.java
* Kevin Gabele
 */
package com.kev.kevrecipes;


import java.util.HashMap;
import java.util.Set;
import java.util.Iterator;
import java.util.Map;

/**
* This is to be a basic tagging system
* 
*/

public class Tags{
    protected HashMap<String,Integer> tags;
    protected static HashMap<String,Integer> allTags;
    
    //basic constructor
    public Tags(){
        tags = new HashMap<String,Integer>();
    }
    
    //constructor given a Hashmap (this really shouldn't happen outside of below
    public Tags(HashMap<String,Integer> tags){
        tags=this.tags;
    }
    
    //constructor given a Set (standard way of copying a set of Tags, I think)
    public Tags(Set setTags){
        tags = new HashMap();
        Iterator i = setTags.iterator();
        while(i.hasNext()){
            Map.Entry me = (Map.Entry)i.next();
            addTag(me.toString());
        }
    }
    
    //returns a Set of the keys
    public Set getTags(){
        return tags.keySet();
    }

    //add a tag to this recipe if it isn't already there
    public void addTag(String newTag){
        tags.put(newTag, 1);

        int i=allTags.get(newTag)+1;
        allTags.put(newTag, i);
    }
    //removes a tag from this recipe
    public void removeTag(String dropTag){
        tags.remove(dropTag);
        
        int i=allTags.get(dropTag);
        if(i>1){
            allTags.put(dropTag, i-1);
        }else{
            allTags.remove(dropTag);
        }
    }
    
}