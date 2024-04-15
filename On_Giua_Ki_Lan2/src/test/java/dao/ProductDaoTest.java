package dao;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import java.util.Map.Entry;
import java.util.Set;

import javax.sound.midi.SysexMessage;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.neo4j.driver.Driver;

import entity.Product;
import util.AppUtil;

/**
 * @author Nguyen Thi Nga
 * @date Mar 19, 2024
 */
class ProductDaoTest {
	private static final String DB_NAME = "neo4j";
	private ProductDao productDao;
	private CategoryDao categoryDao;
	private SupplierDao supplierDao;
	/**
	 * @throws java.lang.Exception
	 */
	@BeforeEach
	void setUp() throws Exception {
		productDao = new ProductDao(AppUtil.driverInit(), DB_NAME);
		categoryDao = new CategoryDao(AppUtil.driverInit(), DB_NAME);
		supplierDao = new SupplierDao(AppUtil.driverInit(), DB_NAME);
	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterEach
	void tearDown() throws Exception {
		productDao.close();
		categoryDao.close();
		supplierDao.close();
		productDao = null;
	}

	@Test
	void testGetProductsBySupplierName() {
		System.err.println("Test GetProductsBySupplierName()");
		List<Product> products = productDao.getProductsBySupplierName("New Orleans Cajun Delights");
		assertEquals(4, products.size());
		products.forEach(p -> System.out.println(p));
	}
	
	@Test
	void testGetProductsWithMaxUnitPrice() {
		System.err.println("Test GetProductsWithMaxUnitPrice()");
		List<Product> products = productDao.getProductsWithMaxUnitPrice();
		assertEquals(1, products.size());
		products.forEach(p -> System.out.println(p));
	}
	
	@Test
	void testgetTotalProduct() {
		System.err.println("Test GetTotalProduct()");
		Set<Entry<String, Integer>> n = productDao.getTotalProduct().entrySet();
		for (Entry<String, Integer> entry : n) {
			System.out.println(entry);
		}
		
	}
	
	@Test
	void testGetProductsByTextSearch() {
		System.err.println("Test GetProductsByTextSearch()");
		List<Product> products = productDao.getProductsByTextSearch("Chai");
		for (Product product : products) {
			System.out.println(product);
		}
	}
	@Test
	void testAddNewProduct() {
		System.err.println("Test AddNewProduct()");
        Product p = new Product();
        p.setProductId("Nga");
        p.setProductName("Nga");
        p.setQuantityPerUnit("10");
        p.setUnitPrice(100);
        p.setUnitsInStock(100);
        p.setUnitsOnOrder(100);
        p.setReorderLevel(100);
        p.setDiscoutinued(false);
        p.setCategory(categoryDao.getCategoryByCategoryID("6"));
        p.setSupplier(supplierDao.getSupplierBySupplierID("2"));
        String id = productDao.addNewProduct(p);
        assertNotNull(id);
        System.out.println(id);
    }
	

}
