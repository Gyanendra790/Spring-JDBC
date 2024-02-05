package com.springjdbc.dao;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

import com.springjdbc.entities.Student;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	    //USING XML CONFIGURATION
        //ApplicationContext context=new ClassPathXmlApplicationContext("com/springjdbc/dao/config.xml");
        
    	 //USING JAVA CONFIGURATION
    ApplicationContext context=new AnnotationConfigApplicationContext(JdbcConfig.class);	
    	StudentDao studentDao=context.getBean("studentDao",StudentDao.class);
        //FOR INSERTION
//        Student student=new Student();
//        student.setStudentId(290);
//        student.setStudentName("Prajjwal");
//        student.setStudentCity("Gonda");
//        
//        int result=studentDao.insert(student);
//        System.out.println("Inserted:"+result);
        
        
        //FOR UPDATION
//        Student student=new Student();
//        student.setStudentId(290);
//        student.setStudentName("Molu");
//        student.setStudentCity("Lucknow");
//        
//        int result=studentDao.change(student);
//        System.out.println("updated:"+result);
        
        //FOR DELETION
//        int result=studentDao.delete(222);
//        System.out.println("deleted:"+result);
        
        //FOR SELECTING SINGLE STUDENT DATA
//        Student student=studentDao.getStudent(290);
//        System.out.println(student);
        
        //FOR SELECTING ALL STUDENTS
        List<Student> students=studentDao.getAllStudents();
        for(Student st:students)
        {
        	System.out.println(st);
        }
          }
}
