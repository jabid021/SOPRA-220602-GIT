package formation.eshop.repo.test.v3;

import java.util.Optional;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import formation.eshop.model.Fournisseur;
import formation.eshop.model.Produit;
import formation.eshop.repo.IFournisseurRepository;
import formation.eshop.repo.IProduitRepository;
import junit.framework.TestCase;

public class ProduitRepositoryTest extends TestCase {
	
	private ClassPathXmlApplicationContext context = null;

	@Override
	protected void setUp() throws Exception {
		context = new ClassPathXmlApplicationContext("classpath:application-context.xml");
	}

	@Override
	protected void tearDown() throws Exception {
		context.close();
	}

	public void testFindAll() {
		IProduitRepository produitRepo = context.getBean(IProduitRepository.class);

		// ARRANGE
		int startSize = produitRepo.findAll().size();

		Produit iphone = new Produit("IPhone");
		produitRepo.save(iphone);

		Produit galaxyS22 = new Produit("Galaxy S22");
		produitRepo.save(galaxyS22);

		// ACT
		int endSize = produitRepo.findAll().size();

		// ASSERT
		assertEquals(2, endSize - startSize);
	}

	public void testFindById() {
		IProduitRepository produitRepo = context.getBean(IProduitRepository.class);

		// ARRANGE
		Produit iphone = new Produit("IPhone");
		iphone = produitRepo.save(iphone);

		// ACT
		Optional<Produit> optIphoneFind = produitRepo.findById(iphone.getId());

		// ASSERT
		assertEquals(true, optIphoneFind.isPresent());
		assertEquals(iphone.getId(), optIphoneFind.get().getId());
	}

	public void testCreate() {
		IProduitRepository produitRepo = context.getBean(IProduitRepository.class);
		IFournisseurRepository fournisseurRepo = context.getBean(IFournisseurRepository.class);

		// ARRANGE
		Fournisseur cdiscount = new Fournisseur();
		cdiscount.setNom("CDISCOUNT");
		cdiscount = fournisseurRepo.save(cdiscount);

		// ACT
		Produit iphone = new Produit("IPhone");

		iphone.setStock(10);
		iphone.setPrixAchat(550d);
		iphone.setPrixVente(950d);
		iphone.setReference("REF");
		iphone.setFournisseur(cdiscount);

		iphone = produitRepo.save(iphone);

		// ASSERT
		Optional<Produit> optIphoneFind = produitRepo.findById(iphone.getId());
		
		if(optIphoneFind.isEmpty()) {
			fail("Le produit n'a pu être créé !");
		} 
		
		Produit iphoneFind = optIphoneFind.get();

		assertEquals(10, iphoneFind.getStock());
		assertEquals(550d, iphoneFind.getPrixAchat());
		assertEquals(950d, iphoneFind.getPrixVente());
		assertEquals("REF", iphoneFind.getReference());
		assertEquals(cdiscount.getId(), iphoneFind.getFournisseur().getId());
	}
	
	public void testUpdate() {
		IProduitRepository produitRepo = context.getBean(IProduitRepository.class);
		IFournisseurRepository fournisseurRepo = context.getBean(IFournisseurRepository.class);

		// ARRANGE
		Fournisseur amazon = new Fournisseur();
		amazon.setNom("AMAZON");
		amazon = fournisseurRepo.save(amazon);
		
		Fournisseur cdiscount = new Fournisseur();
		cdiscount.setNom("CDISCOUNT");
		cdiscount = fournisseurRepo.save(cdiscount);
		
		Produit iphone = new Produit("IPhone");

		iphone.setStock(10);
		iphone.setPrixAchat(550d);
		iphone.setPrixVente(950d);
		iphone.setReference("REF");
		iphone.setFournisseur(cdiscount);

		iphone = produitRepo.save(iphone);

		// ACT
		Optional<Produit> optIphoneFind = produitRepo.findById(iphone.getId());
		
		if(optIphoneFind.isPresent()) {
		
			Produit iphoneFind = optIphoneFind.get();
	
			iphoneFind.setStock(15);
			iphoneFind.setPrixAchat(650d);
			iphoneFind.setPrixVente(1000d);
			iphoneFind.setReference("REF X");
			iphoneFind.setFournisseur(amazon);
	
			iphoneFind = produitRepo.save(iphoneFind);
			
		}

		// ASSERT
		optIphoneFind = produitRepo.findById(iphone.getId());
		
		Produit iphoneFind = optIphoneFind.get();

		assertEquals(15, iphoneFind.getStock());
		assertEquals(650d, iphoneFind.getPrixAchat());
		assertEquals(1000d, iphoneFind.getPrixVente());
		assertEquals("REF X", iphoneFind.getReference());
		assertEquals(amazon.getId(), iphoneFind.getFournisseur().getId());
	}
	
	public void testDelete() {
		IProduitRepository produitRepo = context.getBean(IProduitRepository.class);

		// ARRANGE
		Produit iphone = new Produit("IPhone");

		iphone.setStock(10);
		iphone.setPrixAchat(550d);
		iphone.setPrixVente(950d);
		iphone.setReference("REF");

		iphone = produitRepo.save(iphone);

		// ACT
		produitRepo.deleteById(iphone.getId());
		
		// ASSERT	
		Optional<Produit> optIphoneFind = produitRepo.findById(iphone.getId());
		
		assertEquals(false, optIphoneFind.isPresent());	
	}
	
	public void testfindBetween() {
		IProduitRepository produitRepo = context.getBean(IProduitRepository.class);

		// ARRANGE		
		int startSize = produitRepo.findByPrixBetween(900d, 1300d).size();
		
		Produit iphone = new Produit("IPhone");

		iphone.setStock(10);
		iphone.setPrixAchat(550d);
		iphone.setPrixVente(950d);
		iphone.setReference("REF");

		iphone = produitRepo.save(iphone);
		
		Produit galaxyS22 = new Produit("Galaxy S22");

		galaxyS22.setStock(100);
		galaxyS22.setPrixAchat(450d);
		galaxyS22.setPrixVente(750d);
		galaxyS22.setReference("REF S22");

		galaxyS22 = produitRepo.save(galaxyS22);
		
		Produit ipadAir = new Produit("Ipad Air 5");

		ipadAir.setStock(3);
		ipadAir.setPrixAchat(850d);
		ipadAir.setPrixVente(1250d);
		ipadAir.setReference("AIR 5 WIFI");

		ipadAir = produitRepo.save(ipadAir);

		// ACT
		int endSize = produitRepo.findByPrixBetween(900d, 1300d).size();

		// ASSERT
		assertEquals(2, endSize - startSize);
	}
}
