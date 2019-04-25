package config;

import java.util.Properties;

import javax.sql.DataSource;

//import org.apache.tomcat.dbcp.dbcp2.BasicDataSource;
//import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
//import org.springframework.orm.hibernate5.HibernateTransactionManager;
//import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import entity.AdditionValidator;
import service.AdditionServiceImpl;


@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "controller")
@EnableTransactionManagement
public class BeanCreationConfig extends WebMvcConfigurationSupport {

//	@Autowired
//	private SessionFactory sessionFactory; 
	
	@Override
	public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) { 
		      configurer.enable();
	}
	
	@Bean
	public AdditionValidator validator(){
		return new AdditionValidator();
	}
	
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/resources/**").addResourceLocations("/resources/");
//		  if (!registry.hasMappingForPattern("/public/**")) {
//		        registry.addResourceHandler("/public/**")
//		                .addResourceLocations("/public/");
////		                .setCachePeriod(CACHE_PERIOD); // You have to define a cache period.
//		    }
	}
//	@Override
//	public void configure(WebSecurity web) throws Exception {
//	    web.ignoring().antMatchers("/public/**");
//	}
	
//	@Bean
//	public StudentDaoImpl studentDao(){
//		return new StudentDaoImpl();
//	}
	
	@Bean
	public AdditionServiceImpl additionService(){
		return new AdditionServiceImpl();
	}

//	@Bean
//	public LocalSessionFactoryBean sessionFactory() {
//		LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
//		sessionFactory.setDataSource(dataSource());
//		sessionFactory.setPackagesToScan(new String[] {"com.hari.spring"});
//		sessionFactory.setHibernateProperties(hibernateProperties());
//		return sessionFactory;
//	}

//
//	@Bean
//	public DataSource dataSource() {
//		BasicDataSource dataSource = new BasicDataSource();
//		dataSource.setDriverClassName("com.mysql.jdbc.Driver");
//		dataSource.setUrl("jdbc:mysql://localhost:3306/hibernate");
//		//batch insert in mysql{when using IDENTITY generator, batch insert wont work in mysql}
//		//dataSource.setUrl("jdbc:mysql://localhost:3306/hibernate/rewriteBatchedStatements=true");
//		dataSource.setUsername("root");
//		dataSource.setPassword("root");
//
//		return dataSource;
//	}
//
//
//	private final Properties hibernateProperties() {
//		Properties hibernateProperties = new Properties();
//		hibernateProperties.setProperty(
//				"hibernate.dialect", "org.hibernate.dialect.MySQL57Dialect");
//		hibernateProperties.setProperty("hibernate.jdbc.batch_size", "50");
//		return hibernateProperties;
//	}
//
//    @Bean
//    public PlatformTransactionManager hibernateTransactionManager() {
//        HibernateTransactionManager transactionManager  = new HibernateTransactionManager();
//        transactionManager.setSessionFactory(sessionFactory().getObject());
//        return transactionManager;
//    }

	@Bean
	public InternalResourceViewResolver viewResolver() {
		InternalResourceViewResolver viewResolver = 
				new InternalResourceViewResolver();
		viewResolver.setPrefix("/WEB-INF/");
		viewResolver.setSuffix(".jsp");
		return viewResolver;
	}

}
