package com.kebidge.SimpleBackend; 

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class SimpleItem { 
    
    @Id
    @GeneratedValue
    long id;
 
    String item;
 
    public SimpleItem(){}
 
    public SimpleItem(String name){
 
        this.item = name;
    }    

    public void setId(long id) {
        this.id = id;
    }
    
    public void setItem(String item) {
        this.item = item;
    }

}
