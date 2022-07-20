package formation.eshop.config;

import java.util.Properties;

import javax.persistence.EntityManagerFactory;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.dao.annotation.PersistenceExceptionTranslationPostProcessor;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@ComponentScan("formation.eshop.repo") // On activate des annotations @Component, @Repository, @Autowired, ... et on précise le(s) package(s) à scanner
@EnableTransactionManagement // On active les annotations @Transactional avec transactionManager
@PropertySource("classpath:db.properties") // On charge le fichier db.properties en mémoire
public class ApplicationConfig {
//	@Value("${db.driver}")
//	private String driver;

	@Autowired
	private Environment env;

	// On crée le DataSource
	@Bean
	public BasicDataSource dataSource() {
		BasicDataSource dataSource = new BasicDataSource();
		dataSource.setDriverClassName(env.getProperty("db.driver"));
		dataSource.setUrl(env.getProperty("db.url"));
		dataSource.setUsername(env.getProperty("db.user"));
		dataSource.setPassword(env.getProperty("db.password"));
		dataSource.setMaxTotal(Integer.valueOf(env.getProperty("db.maxConnection")));

		return dataSource;
	}

	// On crée un entityManagerFactory local à partir de la dataSource
	@Bean
	public LocalContainerEntityManagerFactoryBean entityManagerFactory(BasicDataSource dataSource) {
		LocalContainerEntityManagerFactoryBean emf = new LocalContainerEntityManagerFactoryBean();
		JpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
		emf.setDataSource(dataSource);
		emf.setPackagesToScan("formation.eshop.model");
		emf.setJpaVendorAdapter(vendorAdapter); // On précise le provider
		emf.setJpaProperties(this.hibernateProperties()); // On précise les propriétés

		return emf;
	}

	private Properties hibernateProperties() {
		Properties properties = new Properties();
		properties.setProperty("hibernate.hbm2ddl.auto", "update");
		properties.setProperty("hibernate.dialect", env.getProperty("db.dialect"));
		properties.setProperty("hibernate.show_sql", "true");
		properties.setProperty("hibernate.format_sql", "false");

		return properties;
	}

	// On crée le transactionManager pour JPA avec entityManagerFactory
	@Bean
	public JpaTransactionManager transactionManager(EntityManagerFactory emf) {
		JpaTransactionManager transactionManager = new JpaTransactionManager();
		transactionManager.setEntityManagerFactory(emf);

		return transactionManager;
	}

	// On active la translation d'exception
	@Bean
	public PersistenceExceptionTranslationPostProcessor exceptionTranslation() {
		return new PersistenceExceptionTranslationPostProcessor();
	}

}
