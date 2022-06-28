package com.Student.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.Student.Fields.StudentFields;
import com.Student.Service.StudentService;

@RestController
public class StudentController {
	@Autowired
	StudentService ss;
	
	@PostMapping("/insert")   // to insert data into table
	public String insert(StudentFields sf)
	{
		int i =ss.insert(sf);
		if(i>0)
		{
			return "inserted";
		}
		else
		{
			return "not inserted";
		}
		
	}
	@PostMapping("/updatename")   // to update name in the data of a table 
	public String update( StudentFields sf )
	{
		ss.update(sf);
		int i =ss.insert(sf);
		if(i>0)
		{
			return "inserted";
		}
		else
		{
			return "not inserted";
		}
		
	}
	@DeleteMapping("/delete")	 // to delete data in a row
	public String delete( StudentFields sf  )
	{
		ss.delete(sf);
		int i =ss.insert(sf);
		if(i>0)
		{
			return "deleted";
		}
		else
		{
			return "that id not there in database";
		}
		
	}
	@GetMapping("/getall")		 // to get all the data present in table
	public List getall( StudentFields sf)
	{
		
		return ss.getall();
	}
	/*@PostMapping("/inserall")		 // to insert data in huge 
	public int[] insertall( List<StudentFields> sf)
	{
		return ss.insertall(sf);
	}*/
	@GetMapping("/create")		// to create table in data base
	public String create ()
	{
		return ss.create();
	}
	@GetMapping("/getbyage/{age}")		// to get details of a person by his age
	public List getage(@PathVariable int age )
	{
		return ss.getage(age);
	}

}
