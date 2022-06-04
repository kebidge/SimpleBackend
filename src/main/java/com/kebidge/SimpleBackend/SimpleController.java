package com.kebidge.SimpleBackend; 

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Optional;


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

    @PostMapping(path = "/item/{item}", produces = "application/json")
    public SimpleItem addSimpleItemJSON(@PathVariable String item){

        SimpleItem newItem = new SimpleItem(item);

        Iterable<SimpleItem> iterableItems = itemRepository.findAll();
        Iterator<SimpleItem> itemTerator = iterableItems.iterator();

        while(itemTerator.hasNext()){

            SimpleItem tempItem = itemTerator.next();

            if (tempItem.item.equals(item)) {  

                newItem.setId(tempItem.id);
                itemRepository.save(newItem);  

                return newItem;
            }
        }

        itemRepository.save(newItem);

        return newItem;
    }

 
    @GetMapping("/items")
    public ArrayList<Optional<SimpleItem>> getItems() {
     
        Iterable<SimpleItem> iterableItems = itemRepository.findAll();
 
        ArrayList<String> itemList = new ArrayList<String>();
        ArrayList<Optional<SimpleItem>> optionalItemList = new ArrayList<Optional<SimpleItem>>();
         
        Iterator<SimpleItem> itemIterator = iterableItems.iterator();

        while(itemIterator.hasNext()){
            SimpleItem tempItem = itemIterator.next();
            Optional<SimpleItem> optionalTempItem = itemRepository.findById(tempItem.id);
            itemList.add(tempItem.item);
            optionalItemList.add(optionalTempItem);
        }
 
        return optionalItemList; 
    }    
}

