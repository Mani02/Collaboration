package com.niit.applicationContextConfig;

import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
	@ComponentScan("com.niit.CollaborationBackEnd")
	@EnableTransactionManagement
	public class ApplicationContextConfig {
		private static final Logger logger = LoggerFactory.getLogger(ApplicationContextConfig.class);

		@Bean(name = "dataSource")
		public DataSource getOracleDataSource() {
			logger.debug("Starting of the method getOracleDataSource");
			DriverManagerDataSource dataSource = new DriverManagerDataSource();

			dataSource.setDriverClassName("oracle.jdbc.driver.OracleDriver");
			dataSource.setUrl("jdbc:oracle:thin:@localhost:1521:XE");

			dataSource.setUsername("MANI_01"); // Schema name
			dataSource.setPassword("Apee1");

			return dataSource;
		}
		private Properties getHibernateProperties(){
			Properties connectionProperties = new Properties();
			connectionProperties.setProperty("hibernate.dialect", "org.hibernate.dialect.Oracle10gDialect");
			connectionProperties.setProperty("hibernate.hbm2ddl.auto","update");
			//connectionProperties.setProperty("hibernate.show_sql", "true");
			//connectionProperties.setProperty("hibernate.format_sql", "true");
			return connectionProperties;
		}
		@Autowired
		@Bean(name = "sessionFactory")
		public SessionFactory getSessionFactory(DataSource dataSource) {

			logger.debug("Starting of the method getSessionFactory");
			
			
			LocalSessionFactoryBuilder sessionBuilder = new LocalSessionFactoryBuilder(dataSource);
			sessionBuilder.addProperties(getHibernateProperties());
			sessionBuilder.scanPackages("com.niit.CollaborationBackEnd.model");

			logger.debug("Ending of the method getSessionFactory");
			return sessionBuilder.buildSessionFactory();
		}

		@Autowired
		@Bean(name = "transactionManager")
		public HibernateTransactionManager getTransactionManager(SessionFactory sessionFactory) {

			logger.debug("Starting of the method getTransactionManager");
			HibernateTransactionManager transactionManager = new HibernateTransactionManager(sessionFactory);

			logger.debug("Ending of the method getTransactionManager");
			return transactionManager;
		}


	}

