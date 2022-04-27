package com.acacia.endpoint;

import java.util.ArrayList;
import java.util.List;

import com.acacia.models.Phone;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/phone")
public class PhoneController {

    List<Phone> phoneList = new ArrayList<Phone>();
    
    PhoneController(){
        this.initializePhone();
    }

    void initializePhone(){
        this.phoneList.add(new Phone(1, "", "", ""));
        this.phoneList.add(new Phone(2, "", "", ""));
        this.phoneList.add(new Phone(3, "", "", ""));
        this.phoneList.add(new Phone(4, "", "", ""));

    }

    @RequestMapping(path = "{id}", method = RequestMethod.GET)
    public Phone getPhone(@PathVariable("id") int inId){
        for (Phone phone: this.phoneList){
            if (inId == phone.id){
                return phone;
            }
        }
        return null;
    }
    
} 
