package formation.eshop.repo.test.v3;

import java.util.Optional;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import formation.eshop.model.Adresse;
import formation.eshop.model.Fournisseur;
import formation.eshop.repo.IAdresseRepository;
import formation.eshop.repo.IFournisseurRepository;
import junit.framework.TestCase;

public class FournisseurRepositoryTest extends TestCase {

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
		IFournisseurRepository fournisseurRepo = context.getBean(IFournisseurRepository.class);

		// ARRANGE
		int startSize = fournisseurRepo.findAll().size();

		Fournisseur amazon = new Fournisseur();
		fournisseurRepo.save(amazon);

		Fournisseur cdiscount = new Fournisseur();
		fournisseurRepo.save(cdiscount);

		// ACT
		int endSize = fournisseurRepo.findAll().size();

		// ASSERT
		assertEquals(2, endSize - startSize);
	}

	public void testFindById() {
		IFournisseurRepository fournisseurRepo = context.getBean(IFournisseurRepository.class);

		// ARRANGE
		Fournisseur amazon = new Fournisseur();
		amazon = fournisseurRepo.save(amazon);

		// ACT
		Optional<Fournisseur> optAmazonFind = fournisseurRepo.findById(amazon.getId());

		// ASSERT
		assertEquals(true, optAmazonFind.isPresent());
		assertEquals(amazon.getId(), optAmazonFind.get().getId());
	}

	public void testCreate() {
		IAdresseRepository adresseRepo = context.getBean(IAdresseRepository.class);
		IFournisseurRepository fournisseurRepo = context.getBean(IFournisseurRepository.class);

		// ARRANGE
		Adresse adrAmazon = new Adresse("1 avenue Silicon Valley", "99999", "San Franscico");
		adrAmazon = adresseRepo.save(adrAmazon);

		// ACT
		Fournisseur amazon = new Fournisseur();

		amazon.setNom("BEZOS");
		amazon.setPrenom("Jeff");
		amazon.setSociete("AMAZON");
		amazon.setAdresse(adrAmazon);

		amazon = fournisseurRepo.save(amazon);

		// ASSERT
		Optional<Fournisseur> optAmazonFind = fournisseurRepo.findById(amazon.getId());

		if (optAmazonFind.isEmpty()) {
			fail("Le fournisseur n'a pu être créé !");
		}

		Fournisseur amazonFind = optAmazonFind.get();

		assertEquals("BEZOS", amazonFind.getNom());
		assertEquals("Jeff", amazonFind.getPrenom());
		assertEquals("AMAZON", amazonFind.getSociete());
		assertEquals(adrAmazon.getId(), amazonFind.getAdresse().getId());
	}

	public void testUpdate() {
		IAdresseRepository adresseRepo = context.getBean(IAdresseRepository.class);
		IFournisseurRepository fournisseurRepo = context.getBean(IFournisseurRepository.class);

		// ARRANGE
		Adresse adrAmazon = new Adresse("1 avenue Silicon Valley", "99999", "San Franscico");
		adrAmazon = adresseRepo.save(adrAmazon);
		
		Adresse adrAmagates = new Adresse("5 avenue Silicon Valley", "99999", "San Franscico");
		adrAmagates = adresseRepo.save(adrAmagates);

		Fournisseur amazon = new Fournisseur();
		amazon.setNom("BEZOS");
		amazon.setPrenom("Jeff");
		amazon.setSociete("AMAZON");
		amazon.setAdresse(adrAmazon);

		amazon = fournisseurRepo.save(amazon);

		// ACT
		Optional<Fournisseur> optAmazonFind = fournisseurRepo.findById(amazon.getId());

		if (optAmazonFind.isPresent()) {
			Fournisseur amazonFind = optAmazonFind.get();

			amazonFind.setNom("GATES");
			amazonFind.setPrenom("Bill");
			amazonFind.setSociete("AMAGATES");
			amazonFind.setAdresse(adrAmagates);

			amazonFind = fournisseurRepo.save(amazonFind);
		}

		// ASSERT
		optAmazonFind = fournisseurRepo.findById(amazon.getId());

		Fournisseur amazonFind = optAmazonFind.get();

		assertEquals("GATES", amazonFind.getNom());
		assertEquals("Bill", amazonFind.getPrenom());
		assertEquals("AMAGATES", amazonFind.getSociete());
		assertEquals(adrAmagates.getId(), amazonFind.getAdresse().getId());
	}

	public void testDelete() {
		IFournisseurRepository fournisseurRepo = context.getBean(IFournisseurRepository.class);

		// ARRANGE
		Fournisseur amazon = new Fournisseur();
		amazon.setNom("BEZOS");
		amazon.setPrenom("Jeff");
		amazon.setSociete("AMAZON");

		amazon = fournisseurRepo.save(amazon);

		// ACT
		fournisseurRepo.deleteById(amazon.getId());

		// ASSERT
		Optional<Fournisseur> optAmazonFind = fournisseurRepo.findById(amazon.getId());

		assertEquals(false, optAmazonFind.isPresent());
	}

}
