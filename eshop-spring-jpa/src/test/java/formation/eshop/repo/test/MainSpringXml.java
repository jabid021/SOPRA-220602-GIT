package formation.eshop.repo.test;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainSpringXml {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("classpath:application-context.xml");

		context.close();
	}

}
