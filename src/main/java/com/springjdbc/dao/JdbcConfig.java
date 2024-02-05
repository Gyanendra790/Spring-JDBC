package com.springjdbc.dao;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@Configuration
@ComponentScan(basePackages="com.springjdbc.dao")
public class JdbcConfig {
	@Bean("ds")
	public DriverManagerDataSource getDataSource()
	{
		DriverManagerDataSource ds=new DriverManagerDataSource();
		ds.setDriverClassName("com.mysql.cj.jdbc.Driver");
		ds.setUrl("jdbc:mysql://localhost:3306/springjdbc");
		ds.setUsername("root");
		ds.setPassword("Root@123");
		return ds;
	}
	@Bean("jdbctemplates")
	public JdbcTemplate getTemplate()
	{
		JdbcTemplate jdbctemplate=new JdbcTemplate();
		jdbctemplate.setDataSource(getDataSource());
		return jdbctemplate;
	}
	//USE IT WHEN WE NOT USE AUTOWIRING
//	@Bean("studentDao")
//	public StudentDao getStudentDao()
//	{
//		StudentDaoImpl st=new StudentDaoImpl();
//		st.setJdbctemplates(getTemplate());
//		return st;
//	}

}
