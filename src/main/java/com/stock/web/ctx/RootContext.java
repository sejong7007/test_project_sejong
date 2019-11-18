package com.stock.web.ctx;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.Import;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.transaction.annotation.EnableTransactionManagement;

//@EnableAspectJAutoProxy
//@EnableTransactionManagement
@Configuration
@ComponentScan(basePackages = { "com.stock.web" })
@Import({MyBatisContext.class, ServletContext.class})
public class RootContext {

	@Bean
	public DataSource dataSource() {
	
		  DriverManagerDataSource dataSource = new DriverManagerDataSource();
		    dataSource.setDriverClassName("org.mariadb.jdbc.Driver");
		    //dataSource.setDriverClassName("com.mysql.jdbc.Driver");
		    dataSource.setUrl("jdbc:mysql://172.168.0.78/goodfor");
		    //dataSource.setUrl("jdbc:mysql://localhost:3306/getmoney?serverTimezone=UTC");
		    dataSource.setUsername("goodfor");
		    dataSource.setPassword("goodfor");

		    return dataSource;
	}	
	
	@Bean
	public DataSourceTransactionManager txManager() {
		return new DataSourceTransactionManager(dataSource());
	}
	
}