package formation.eshop.repo.test.v4spring;

import java.util.Optional;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import formation.eshop.model.Fournisseur;
import formation.eshop.model.Produit;
import formation.eshop.repo.IFournisseurRepository;
import formation.eshop.repo.IProduitRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:application-context.xml")
public class ProduitRepositoryTest {

	@Autowired
	private IProduitRepository produitRepo;

	@Autowired
	private IFournisseurRepository fournisseurRepo;

	@Test
	public void testFindAll() {
		// ARRANGE
		int startSize = produitRepo.findAll().size();

		Produit iphone = new Produit("IPhone");
		produitRepo.save(iphone);

		Produit galaxyS22 = new Produit("Galaxy S22");
		produitRepo.save(galaxyS22);

		// ACT
		int endSize = produitRepo.findAll().size();

		// ASSERT
		Assert.assertEquals(2, endSize - startSize);
	}

	@Test
	public void testFindById() {
		// ARRANGE
		Produit iphone = new Produit("IPhone");
		iphone = produitRepo.save(iphone);

		// ACT
		Optional<Produit> optIphoneFind = produitRepo.findById(iphone.getId());

		// ASSERT
		Assert.assertEquals(true, optIphoneFind.isPresent());
		Assert.assertEquals(iphone.getId(), optIphoneFind.get().getId());
	}

	@Test
	public void testCreate() {
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

		if (optIphoneFind.isEmpty()) {
			Assert.fail("Le produit n'a pu être créé !");
		}

		Produit iphoneFind = optIphoneFind.get();

		Assert.assertEquals(10, iphoneFind.getStock());
		Assert.assertEquals((Double) 550d, iphoneFind.getPrixAchat());
		Assert.assertEquals((Double) 950d, iphoneFind.getPrixVente());
		Assert.assertEquals("REF", iphoneFind.getReference());
		Assert.assertEquals(cdiscount.getId(), iphoneFind.getFournisseur().getId());
	}

	@Test
	public void testUpdate() {
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

		if (optIphoneFind.isPresent()) {

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

		Assert.assertEquals(15, iphoneFind.getStock());
		Assert.assertEquals((Double) 650d, iphoneFind.getPrixAchat());
		Assert.assertEquals((Double) 1000d, iphoneFind.getPrixVente());
		Assert.assertEquals("REF X", iphoneFind.getReference());
		Assert.assertEquals(amazon.getId(), iphoneFind.getFournisseur().getId());
	}

	@Test
	public void testDelete() {
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

		Assert.assertEquals(false, optIphoneFind.isPresent());
	}

	@Test
	public void testfindBetween() {
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
		Assert.assertEquals(2, endSize - startSize);
	}
}
