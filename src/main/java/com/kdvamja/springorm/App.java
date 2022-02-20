package com.kdvamja.springorm;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Date;
import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

import com.kdvamja.springorm.config.ApplicationConfig;
import com.kdvamja.springorm.dao.StudentDao;
import com.kdvamja.springorm.entity.Student;

/**
 * AUTHOR::KDVAMJA
 * DATE::20-FEB-2022
 * PURPOSE::TO LEARN SPRING ORM FROM SCRETCH AND CREATING SIMPLE CONSOLE BASED APPLICATION IN SPRING CORE, SPRING ORM, MYSQL BY USING SPRING ANNOTATION BASED CONFIGURATION
 */
public class App {
	
    private static AbstractApplicationContext applCon;

	public static void main( String[] args ){
    	applCon = new AnnotationConfigApplicationContext(ApplicationConfig.class);
    	StudentDao dao = (StudentDao) applCon.getBean("studentDao",StudentDao.class);
    	
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	boolean go = true;
    	while(go) {
    		System.out.println("\n\n");
    		System.out.println("PRESS 1 FOR CREATE NEW STUDENT");
    		System.out.println("PRESS 2 FOR LIST ALL STUDENTS");
    		System.out.println("PRESS 3 FOR SHOW STUDENT DETAILS");
    		System.out.println("PRESS 4 FOR DELETE STUDENT");
    		System.out.println("PRESS 5 FOR UPDATE STUDENT");
    		System.out.println("PRESS 6 FOR EXIT");
    		try {
    			int input = Integer.parseInt(br.readLine());
    			
    			switch(input) {
    				case 1 :
    					//CREATE STUDENT
    					int savedRecord = dao.store(new Student(1, "John dou", "2021-2022", new Date(), null));
    					System.out.println(savedRecord +" record save successfully.");
    					System.out.println("\n\n");
    					break;
    				case 2 :
    					//LIST ALL STUDENT
    					List<Student> list = dao.getAll();
    					list.forEach((e)->System.out.println(e));
    					System.out.println("\n\n");
    					break;
    				case 3 :
    					//SHOW STUDENT
    					System.out.println("\n Press studentId to get student details.");
    					BufferedReader stuIdBR = new BufferedReader(new InputStreamReader(System.in));
    					int stuId = Integer.parseInt(stuIdBR.readLine());
    					Student stu = dao.getStudentById(stuId);
    					System.out.println(stu);
    					System.out.println("\n\n");
    					break;
    				case 4 :
    					//DELETE STUDENT
    					System.out.println("\n Press studentId to delete student details.");
    					BufferedReader delStuIdBR = new BufferedReader(new InputStreamReader(System.in));
    					int delStuId = Integer.parseInt(delStuIdBR.readLine());
    					dao.delete(delStuId);
    					System.out.println(delStuId+" student is deleted.");
    					System.out.println("\n\n");
    					break;
    				case 5 :
    					//UPDATE STUDENT
    					System.out.println("\n Press studentId to update student details.");
    					BufferedReader updStuIdBR = new BufferedReader(new InputStreamReader(System.in));
    					int updStuId = Integer.parseInt(updStuIdBR.readLine());
    					dao.update(new Student(updStuId, "John dou updated", "2021-2022", new Date()));
    					System.out.println(updStuId +" record update successfully.");
    					System.out.println("\n\n");
    					break;
    				case 6 :
    					//EXIT
    					go = false;
    					System.out.println("\nThank you for using our System.");
    					break;
    			}
    		}catch(Exception e) {
    			System.out.println("INVALID INPUT PLEASE TRY AGAIN!!!");
    			System.out.println(e.getMessage());
    		}
    	}
    	applCon.close();
	}
}

/* OUTPUT
	
	PRESS 1 FOR CREATE NEW STUDENT
	PRESS 2 FOR LIST ALL STUDENTS
	PRESS 3 FOR SHOW STUDENT DETAILS
	PRESS 4 FOR DELETE STUDENT
	PRESS 5 FOR UPDATE STUDENT
	PRESS 6 FOR EXIT
	6
	
	Thank you for using our System.
*/