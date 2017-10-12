package cz.fi.muni.pa165.tasks;

import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;
import javax.validation.ConstraintViolationException;

import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import cz.fi.muni.pa165.PersistenceSampleApplicationContext;
import cz.fi.muni.pa165.entity.Category;
import cz.fi.muni.pa165.entity.Product;

 
@ContextConfiguration(classes = PersistenceSampleApplicationContext.class)
public class Task02 extends AbstractTestNGSpringContextTests {

        Category electro, kitchen;
        Product flashlight, plate, robot;
    
        @BeforeClass
        public void initialize() {
            
            electro = new Category();
            electro.setName("Electro");
            kitchen = new Category();
            kitchen.setName("Kitchen");            
            
            robot = new Product();
            plate = new Product();
            flashlight = new Product();
             
            flashlight.setName("Flashlight");
            robot.setName("Kitchen robot");
            plate.setName("Plate");
       
            electro.addProduct(robot);
            electro.addProduct(flashlight);
            kitchen.addProduct(plate);
            
            
            
            EntityManager em = emf.createEntityManager();
            em.getTransaction().begin();
            
            em.persist(electro);
            em.persist(kitchen);
            em.persist(flashlight);
            em.persist(plate);
            em.persist(robot);
            
            em.getTransaction().commit();
            em.close();
        }
    
	@PersistenceUnit
	private EntityManagerFactory emf;

        
        @Test
        private void category1() {
            EntityManager em = emf.createEntityManager();
            em.getTransaction().begin();
            
            
            //assertContainsProductWithName(products, "");
            
            
        }
        
        @Test
        private void category2() {
            
        }
        
        @Test
        private void product1() {
            
        }
        
        @Test
        private void product2() {
            
        }
        
        @Test
        private void product3() {
            
        }
	
	private void assertContainsCategoryWithName(Set<Category> categories,
			String expectedCategoryName) {
		for(Category cat: categories){
			if (cat.getName().equals(expectedCategoryName))
				return;
		}
			
		Assert.fail("Couldn't find category "+ expectedCategoryName+ " in collection "+categories);
	}
	private void assertContainsProductWithName(Set<Product> products,
			String expectedProductName) {
		
		for(Product prod: products){
			if (prod.getName().equals(expectedProductName))
				return;
		}
			
		Assert.fail("Couldn't find product "+ expectedProductName+ " in collection "+products);
	}

	
}
