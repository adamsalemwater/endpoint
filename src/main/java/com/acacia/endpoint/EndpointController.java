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
public class EndpointController {
		
    Map<String, Integer> mydata = new HashMap<String, Integer>();
    
    EndpointController()
	{
        this.mydata.put("adam", 20);
        this.mydata.put("abbas", 57);
	}

	@GetMapping("/hello/{name}")
	public HttpStatus getAge(@PathVariable("name") String name)
	{
		System.out.println("Name: " + this.mydata.get(name) );
        return HttpStatus.OK;

	}

	@DeleteMapping("/hello/{name}")
	public HttpStatus deleteName(@PathVariable("name") String name)
	{
		this.mydata.remove((name));
		print();
        return HttpStatus.OK;
	}


	@PostMapping("/hello")
	public HttpStatus addName(@RequestBody String value)
	{
        String[] myvalues = value.split(":");
        this.mydata.put(myvalues[0], Integer.valueOf(myvalues[1]));
        print();
        return HttpStatus.CREATED;
	}

	void print()
	{
		for (String key : this.mydata.keySet()) {
			System.out.print(this.mydata.get(key));
		}
    }
}

