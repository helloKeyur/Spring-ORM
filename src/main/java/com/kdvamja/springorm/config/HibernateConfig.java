package com.kdvamja.springorm.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@ComponentScan(basePackages = "com.kdvamja.springorm.config")
@EnableTransactionManagement
@PropertySource(value = "classpath:/com/kdvamja/springorm/resources/application.properties")
public class HibernateConfig {
	
	@Autowired
	private Environment env;
	
	@Bean(name= {"ds","dataSource"})
	public DataSource dataSource() {
		DriverManagerDataSource ds = new DriverManagerDataSource();
		ds.setUrl(env.getProperty("jdbc.url"));
		ds.setUsername(env.getProperty("jdbc.username"));
		ds.setPassword(env.getProperty("jdbc.password"));
		ds.setDriverClassName(env.getProperty("jdbc.driverClassName"));
		return ds;
	}
	
	private Properties hibernateProperties() {
		Properties pro = new Properties();
		pro.put("hibernate.dialect", env.getProperty("hibernate.dialect"));
		pro.put("hibernate.show_sql", env.getProperty("hibernate.show_sql"));
		pro.put("hibernate.format_sql", env.getProperty("hibernate.format_sql"));
		pro.put("hibernate.hbm2ddl.auto", env.getProperty("hibernate.hbm2ddl.auto"));
		return pro;
	}
	
	@Bean(name= {"sessionFactory"})
	public LocalSessionFactoryBean sessionFactory() {
		LocalSessionFactoryBean factory = new LocalSessionFactoryBean();
		factory.setDataSource(this.dataSource());
		factory.setHibernateProperties(this.hibernateProperties());
		factory.setPackagesToScan(new String[] { "com.kdvamja.springorm.entity" });
		return factory;
	}
	
	@Bean(name= {"template","hibernateTemplate"})
	public HibernateTemplate hibernateTemplate() {
		SessionFactory sf = this.sessionFactory().getObject();
		HibernateTemplate template = new HibernateTemplate();
		template.setSessionFactory(sf);
		return template;
	}
	
	@Bean(name= {"tx", "transactionManager"})
	public HibernateTransactionManager transactionManager() {
		SessionFactory sf = this.sessionFactory().getObject();
		HibernateTransactionManager tx = new HibernateTransactionManager();
		tx.setSessionFactory(sf);
		return tx;
	}
}
