package com.acacia.endpoint;

import java.util.ArrayList;
import java.util.List;

import com.acacia.models.Category;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CategoryController{

    List<Category> catList = new ArrayList<Category>();
    CategoryController(){
        this.initilizeList();
    }

    void initilizeList(){
		this.catList.add( new Category(1,"Tooth Pate"));
		this.catList.add( new Category(2,"Mouthwash"));
		this.catList.add( new Category(3,"Soap"));
	}
    
    @RequestMapping(method = RequestMethod.GET,path = "/category/{id}")
    public Category getCategory(@PathVariable("id") int inId ){ 
        for (Category cat: this.catList){
            if (cat.id == inId){
                return cat;
            }
        }
        return null;
    }
}