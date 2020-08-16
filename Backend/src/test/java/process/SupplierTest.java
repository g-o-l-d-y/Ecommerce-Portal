package process;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import process.DAO.SupplierDAO;
import process.Model.Supplier;


public class SupplierTest {

	static SupplierDAO supplierDAO;
	@BeforeClass
	public static void executeFirst()
	{
	AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
	context.scan("process");
	context.refresh();
	supplierDAO=(SupplierDAO)context.getBean("supplierDAO");
	context.close();
	}
	
	@Test
	public void addSupplierTest()
	{
		Supplier supplier=new Supplier();
		supplier.setSupplierName("Richard Raymonds");
		supplier.setSupplierDesc("Only healthcare products");
		assertTrue("Problem in addition",supplierDAO.addSupplier(supplier));
	}
	
	@Ignore
	@Test
	public void getSupplierTest()
	{
	assertNotNull("Problem in get Supplier",supplierDAO.getSupplier(162));
	}
	
	@Ignore
	@Test
	public void updateSupplierTest()
	{
		Supplier supplier=supplierDAO.getSupplier(162);
		supplier.setSupplierName("Richard Raymonds West");
		assertTrue("Problem in updation",supplierDAO.updateSupplier(supplier));
	}
	
	@Ignore
	@Test
	public void deleteSupplierTest()
	{
		Supplier supplier=supplierDAO.getSupplier(162);
		assertTrue("Problem in deletion", supplierDAO.deleteSupplier(supplier));
	}
	
	@Test
	public void listSuppliersTest()
	{
		List<Supplier> listSuppliers=supplierDAO.listSuppliers();
		assertNotNull("No Suppliers",listSuppliers);
		for(Supplier supplier:listSuppliers)
		{
		System.out.print(supplier.getSupplierId()+":::");
		System.out.print(supplier.getSupplierName()+":::");
		System.out.println(supplier.getSupplierDesc());
		}
	}
}
