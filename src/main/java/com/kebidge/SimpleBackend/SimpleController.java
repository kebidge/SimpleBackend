package com.kebidge.SimpleBackend; 

import java.util.ArrayList;
import java.util.Iterator;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
public class SimpleController { 

    @Autowired
    SimpleRepository itemRepository; 

    @PostMapping("/items/{item}")
    public String addItem(@PathVariable String item){
 
        SimpleItem newItem = new SimpleItem(item);
        itemRepository.save(newItem);
 
        return "Save Item!"; 
    } 
 
    @GetMapping("/items/")
    public ArrayList<String> getItems() {
     
        Iterable<SimpleItem> iterableItems = itemRepository.findAll();
 
        ArrayList<String> itemList = new ArrayList<String>();
         
        Iterator<SimpleItem> itemTerator = iterableItems.iterator();
        while(itemTerator.hasNext()){
            SimpleItem tempItem = itemTerator.next();
            itemList.add(tempItem.item);
        }
 
        return itemList; 
    }    
}
