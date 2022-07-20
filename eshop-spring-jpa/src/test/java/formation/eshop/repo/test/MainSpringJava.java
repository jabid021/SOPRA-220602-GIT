package formation.eshop.repo.test;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import formation.eshop.config.ApplicationConfig;

public class MainSpringJava {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ApplicationConfig.class);

		context.close();

	}

}
