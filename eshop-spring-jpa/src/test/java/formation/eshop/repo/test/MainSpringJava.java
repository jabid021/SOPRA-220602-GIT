package formation.eshop.repo.test;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import formation.eshop.config.ApplicationConfig;
import formation.eshop.model.Produit;
import formation.eshop.repo.IFournisseurRepository;
import formation.eshop.repo.IProduitRepository;

public class MainSpringJava {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ApplicationConfig.class);

		IFournisseurRepository fournisseurRepo = context.getBean(IFournisseurRepository.class);
		IProduitRepository produitRepo = context.getBean(IProduitRepository.class);

		Produit iphone = new Produit("IPhone 13");

		produitRepo.save(iphone);

		context.close();

	}

}
