package com.Student.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.Student.Fields.StudentFields;

@Service
public class StudentService {
	@Autowired
	JdbcTemplate jdbc;
	StudentFields sf;
	
	public int insert(StudentFields sf)  // to insert data into table
	{
		int age = sf.getAge();
		int salary = sf.getSalary();
		String name = sf.getName();
		String city = sf.getCity();
		String s= ("insert into miraclestudents values(?,?,?,?)");
		return jdbc.update(s, name,age, city,salary );
	}
	
	
	public int update(StudentFields sf)  // to update the data in table 
	{
		String name = sf.getName();
		int age = sf.getAge();
		String s = ("update miraclestudents set name=? where age=? ");
		return jdbc.update(s,name,age);
	}
	
	
	public int delete(StudentFields sf)   // to delete data in a row
	{
		int age = sf.getAge();
		String s = ("delete from miraclestudents where age=?");
		return jdbc.update(s,age);
	}
	
	
	public List getall()   // to get all the data present in table
	{
		List<Map<String,Object>> get = new ArrayList<Map<String, Object>>();
		get= jdbc.queryForList("select * from miraclestudents");
		return get;
	}
	public List getage(int age)
	{
		
		String s= "select * from miraclestudents where age=?";
		return jdbc.queryForList(s,age);
	}
	
	
	public int[] insertall(List<StudentFields> sf)  // to insert data in huge 
	{
		List<Object[]> listobj = new ArrayList<Object[]>();

		for(StudentFields sfs:sf)
		{
			Object[] obj = {sfs.getAge(),sfs.getName(),sfs.getCity(),sfs.getSalary()};
			listobj.add(obj);
		}
		String s=( "insert into miraclestudents values(?,?,?)");
		return jdbc.batchUpdate(s,listobj);
	
	}
	
	
	public String create()    // to create table in data base
	{
		jdbc.execute("create table miraclestudents (name varchar(15), age int primary key, city varchar(20), salary int)");
		return "created";
	}

}
