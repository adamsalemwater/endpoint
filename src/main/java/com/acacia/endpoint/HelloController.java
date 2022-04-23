package com.acacia.endpoint;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
		
    Map<String, Integer> mydata = new HashMap<String, Integer>();
    
    HelloController()
	{
        this.mydata.put("adam", 20);
        this.mydata.put("abbas", 57);
	}

	@GetMapping("/hello/{name}")
	public Integer getAge(@PathVariable("name") String inputName)
	{
		Integer loc = this.mydata.get(inputName);

		if(loc == null){
			return null;
		}else{
		System.out.println("Name: " + loc );
        return loc;
		}
	}

	@DeleteMapping("/hello/{name}")
	public Map<String, Integer>  deleteName(@PathVariable("name") String name)
	{
		this.mydata.remove((name));
		printme();
        return this.mydata;
	}

	@PostMapping("/hello")
	public Map<String, Integer> addName(@RequestBody String nameage)
	{
        String[] myvalues = nameage.split(":");
		System.out.println(myvalues.toString());
        this.mydata.put(myvalues[0], Integer.valueOf(myvalues[1]));
        printme();
        return mydata;
	}

	void printme()
	{
		for (String key : this.mydata.keySet()) {
			System.out.print(this.mydata.get(key));
		}
    }
}

