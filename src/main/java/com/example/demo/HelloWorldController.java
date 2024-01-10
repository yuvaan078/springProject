package com.example.demo;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController; 

@RestController  
public class HelloWorldController   
{  
	 @CrossOrigin
@GetMapping(path="/controller")  
	 public List<User> po() {
		 ArrayList<User> al = new ArrayList();
		 User us = new User();
		 us.setFirstName("rajiv");
		 al.add(us);
		   return al;
		}
	 
	 @CrossOrigin
	 @RequestMapping(
			    value = "/user", 
			    method = RequestMethod.POST,consumes=MediaType.APPLICATION_JSON_VALUE)
			public User process(@Valid @RequestBody User user) throws Exception {
             System.out.println("============== "+user.getName()+" "+user.getEmail());
			  user.setName(user.getName()+" verma");
			  user.setEmail(user.getEmail()+" @gmail");
			  return user;

			} 

	 @CrossOrigin
	 @RequestMapping(
			    value = "/user1", 
			    method = RequestMethod.GET)
			public User process1() throws Exception {

            User us = new User();
				us.setFirstName("brijesh");
				us.setLastName("verma");
				us.setId("100");
				us.setEmail("brijesh078@gmail.com");
			  return us;

			} 

	   @PutMapping("{id}")
	    public ResponseEntity<User> updateEmployee(@PathVariable long id,@RequestBody User employeeDetails) {
               // update the user

	        return ResponseEntity.ok(employeeDetails);
	    }	 

	    @DeleteMapping("{id}")
	    public ResponseEntity<String> deleteTodo(@PathVariable("id") Long todoId){
	        //todoService.deleteTodo(todoId);
	        return ResponseEntity.ok("Todo deleted successfully!.");
	    }
	   
}  
