package formation.eshop.repo.test;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import formation.eshop.model.Produit;
import formation.eshop.repo.IFournisseurRepository;
import formation.eshop.repo.IProduitRepository;

public class MainSpringXml {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("classpath:application-context.xml");

		IFournisseurRepository fournisseurRepo = context.getBean(IFournisseurRepository.class);
		IProduitRepository produitRepo = context.getBean(IProduitRepository.class);

		Produit iphone = new Produit("IPhone 13");

		produitRepo.save(iphone);
		
		context.close();
	}

}
