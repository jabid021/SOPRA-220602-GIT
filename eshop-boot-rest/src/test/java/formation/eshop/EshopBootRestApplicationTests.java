package formation.eshop;

import java.util.Date;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import formation.eshop.model.Achat;
import formation.eshop.model.Adresse;
import formation.eshop.model.Client;
import formation.eshop.model.Commande;
import formation.eshop.model.EtatCommande;
import formation.eshop.model.Fournisseur;
import formation.eshop.model.Produit;
import formation.eshop.repo.IAchatRepository;
import formation.eshop.repo.IAdresseRepository;
import formation.eshop.repo.IClientRepository;
import formation.eshop.repo.ICommandeRepository;
import formation.eshop.repo.IFournisseurRepository;
import formation.eshop.repo.IProduitRepository;

@SpringBootTest
class EshopBootRestApplicationTests {

	@Autowired
	private IAchatRepository achatRepo;
	
	@Autowired
	private IAdresseRepository adresseRepo;
	
	@Autowired
	private IClientRepository clientRepo;
	
	@Autowired
	private ICommandeRepository commandeRepo;
	
	@Autowired
	private IFournisseurRepository fournisseurRepo;
	
	@Autowired
	private IProduitRepository produitRepo;

	@Test
	void contextLoads() {
		Adresse adrCassandre = new Adresse("1 rue de la Paix", "75008", "Paris");
		adrCassandre = adresseRepo.save(adrCassandre);
		
		Client cassandre = new Client();
		cassandre.setNom("CERTAIN");
		cassandre.setPrenom("Cassandre");
		cassandre.setAge(29);
		cassandre.setEmail("cassandre.certain@gmail.com");
		cassandre.setAdresse(adrCassandre);

		cassandre = clientRepo.save(cassandre);
		
		Adresse adrLeclerc = new Adresse("1 rue perdu", "01000", "De Vu");
		adrLeclerc = adresseRepo.save(adrLeclerc);
		
		Fournisseur leclerc = new Fournisseur();
		leclerc.setNom("LECLERC");
		leclerc.setPrenom("Michel-Edouard");
		leclerc.setSociete("E-LECLERC");
		leclerc.setAdresse(adrLeclerc);
		
		leclerc = fournisseurRepo.save(leclerc);
		
		Produit ipadAir5 = new Produit("Ipad Air 5");
		ipadAir5.setPrixAchat(650.0);
		ipadAir5.setPrixVente(950.0);
		ipadAir5.setReference("IPAD AIR 5 256 Go WIFI");
		ipadAir5.setStock(10);
		ipadAir5.setFournisseur(leclerc);
		
		ipadAir5 = produitRepo.save(ipadAir5);
		
		Produit switchOLED = new Produit("Switch OLED");
		switchOLED.setPrixAchat(250.0);
		switchOLED.setPrixVente(350.0);
		switchOLED.setReference("SWITCH OLED Noir");
		switchOLED.setStock(100);
		switchOLED.setFournisseur(leclerc);
		
		switchOLED = produitRepo.save(switchOLED);
		
		Commande commandeCassandre = new Commande();
		commandeCassandre.setDate(new Date());
		commandeCassandre.setClient(cassandre);
		commandeCassandre.setEtat(EtatCommande.ENCOURS);
		commandeCassandre.setPrixTotal(2350.0);
		
		commandeCassandre = commandeRepo.save(commandeCassandre);	
		
		Achat achatIpad = new Achat(950.0, 1, ipadAir5, commandeCassandre);
		
		achatIpad = achatRepo.save(achatIpad);

		Achat achatSwitch = new Achat(700.0, 2, switchOLED, commandeCassandre);
		
		achatSwitch = achatRepo.save(achatSwitch);
	}

}
