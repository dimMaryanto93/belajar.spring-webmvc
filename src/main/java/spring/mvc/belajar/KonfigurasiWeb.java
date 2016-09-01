package spring.mvc.belajar;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "spring.mvc.belajar")
@EnableJpaRepositories(basePackages = "spring.mvc.belajar")
public class KonfigurasiWeb extends WebMvcConfigurerAdapter {

	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/resources/**").addResourceLocations("/WEB-INF/resources/");
		//registry.addResourceHandler("/webjars").addResourceLocations("classpath:/resources/webjars/");
	}

	@Override
	public void configureViewResolvers(ViewResolverRegistry registry) {
		super.configureViewResolvers(registry);
		registry.jsp("/WEB-INF/pages/", ".jsp");
	}

	@Bean
	public DataSource dataSource() {
		BasicDataSource dbcp = new BasicDataSource();

		dbcp.setDriverClassName("org.postgresql.Driver");
		dbcp.setUrl("jdbc:postgresql://localhost:5432/belajar-spring-mvc");
		dbcp.setUsername("postgres");
		dbcp.setPassword("admin");

		return dbcp;
	}

	@Bean
	@Autowired
	public LocalContainerEntityManagerFactoryBean entityManagerFactory(DataSource ds) {
		LocalContainerEntityManagerFactoryBean factory = new LocalContainerEntityManagerFactoryBean();
		// untuk menentukan package nama yang akan discan
		factory.setPackagesToScan("spring.mvc.belajar");
		// setting datasource
		factory.setDataSource(ds);

		HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
		// set hibernate dialect = org.hibernate.dialect.PostgreSQL
		vendorAdapter.setDatabase(Database.POSTGRESQL);
		// set hibernate.hbm2dll.auto = true
		vendorAdapter.setGenerateDdl(true);
		// set hibernate.show-sql = true
		vendorAdapter.setShowSql(true);

		factory.setJpaVendorAdapter(vendorAdapter);
		return factory;
	}

	@Bean
	@Autowired
	public JpaTransactionManager transactionManager(EntityManagerFactory session) {
		JpaTransactionManager jpaTM = new JpaTransactionManager(session);
		return jpaTM;
	}

}
