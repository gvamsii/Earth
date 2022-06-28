package com.Student;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mockingDetails;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;

import com.Student.Fields.StudentFields;
import com.Student.Service.StudentService;


@SpringBootTest
public class StudentTestService {
	
	@InjectMocks
	StudentService studentService;
	
	@Mock
	StudentFields studentFields;
	
	@Mock
	JdbcTemplate jdbcTemplate;
	
	@Test
	public void insertdata() {
		StudentFields studentFields = new StudentFields("vamsi", 25, "vixag", 25000);
		Mockito.when(jdbcTemplate.update(Mockito.anyString(),Mockito.anyString(),Mockito.anyInt(),Mockito.anyString(),Mockito.anyInt())).thenReturn(1);
		int vamsi = studentService.insert(studentFields);
		System.out.println(vamsi);
		assertEquals(1, vamsi);
		
	}
	
	
	@Test
	public void updtae() {
		StudentFields studentFields = new StudentFields("ram", 25, null, 0);
		Mockito.when(jdbcTemplate.update(Mockito.anyString(),Mockito.anyString(),Mockito.anyInt())).thenReturn(1);
		int updatedreturn = studentService.update(studentFields);
		assertEquals(1, updatedreturn);
	}
	
	@Test
	public int delete() {
		StudentFields studentFields = new StudentFields(null, 25, null, 0);
		Mockito.when(jdbcTemplate.update(Mockito.anyString(),Mockito.anyInt())).thenReturn(1);
		int deletedreturn = studentService.delete(studentFields);
		assertEquals(1, deletedreturn);
		return deletedreturn;
	}
	
	
	

}
