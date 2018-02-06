package com.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.daoimpl.CategoryDaoImpl;
import com.daoimpl.SupplierDaoImpl;
import com.daoimpl.UserDaoImpl;
import com.model.User;
@Configuration
@ComponentScan("com")
@EnableTransactionManagement
public class HibernateConfig {
    @Autowired
    @Bean(name="datasource")
    public  DataSource getH2Data()
    {
    	System.out.println("hibernate bean init");
    	DriverManagerDataSource dsource=new DriverManagerDataSource();
    	dsource.setDriverClassName("org.h2.Driver");
    	dsource.setUrl("jdbc:h2:~/new");
    	dsource.setUsername("sa");
    	dsource.setPassword("");
    	System.out.println("H2 connected");
    	return dsource;

    }
    private  Properties gethiberProp()
    {
    	Properties p=new Properties();
    	p.put("hibernate.dailect","org.hibernate.dailect.H2Dailect");
    	p.put("hibernate.hbm2ddl.auto","update");
    	p.put("hibernate.show_sql","true");
    	System.out.println("Data table created in H2");
    	return p;
    	
    	
    }
	

	@Autowired
	@Bean(name="sessionFactory")
	public   SessionFactory getSessionFac(DataSource datasource) {
		LocalSessionFactoryBuilder sb=new LocalSessionFactoryBuilder(datasource);
		sb.addProperties(gethiberProp());
		sb.addAnnotatedClass(User.class);
		return sb.buildSessionFactory();
	}
	
	@Autowired
	@Bean(name="supplierDaoImpl")
	public SupplierDaoImpl getSuppData(SessionFactory sf)
	{
		return new SupplierDaoImpl(sf);
	}
	@Autowired
	@Bean(name="categoryDaoImpl")
	public CategoryDaoImpl getcategoryData(SessionFactory sf)
	{
		return new CategoryDaoImpl(sf);
	}
	@Autowired
	@Bean(name="userDaoImpl")
	public UserDaoImpl getuserData(SessionFactory sf)
	{
		return new UserDaoImpl(sf);
	}
	@Autowired
	@Bean(name="transactionManager")
	public HibernateTransactionManager gettrans(SessionFactory sf)
	{
		HibernateTransactionManager tm= new HibernateTransactionManager(sf);
		return tm;
	}
	
}
