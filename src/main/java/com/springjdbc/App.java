package com.springjdbc;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        ApplicationContext context=new ClassPathXmlApplicationContext("com/springjdbc/config.xml");
        JdbcTemplate temp=context.getBean("jdbctemplate",JdbcTemplate.class);
        //insert query
        String query="insert into student(studentId,studentName,studentCity) values(?,?,?)";
        //fire the query
        int result=temp.update(query,222,"gyanendra","ambedkarnagar");
        System.out.println("Number of records inserted is:"+result);
          }
}
