package process.Supplier;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


@Repository("supplierDAO")
@Transactional
public class SupplierImpl implements SupplierInterface
{
	@Autowired
	SessionFactory sessionFactory; 
	
	public boolean addSupplier(Supplier supplier) 
	{
		try
		{
		sessionFactory.getCurrentSession().saveOrUpdate(supplier);
		return true;	
		}
		catch(Exception e)
		{
			System.out.println(e);
		return false;
		}
	}

	public boolean deleteSupplier(Supplier supplier)
	{
		try
		{
		sessionFactory.getCurrentSession().delete(supplier);
		return true;	
		}
		catch(Exception e)
		{
		return false;
		}
	
		
	}

	public boolean updateSupplier(Supplier supplier) 
	{
		try
		{
		sessionFactory.getCurrentSession().update(supplier);
		return true;	
		}
		catch(Exception e)
		{
		return false;
		}
	}

	public Supplier getSupplier(int supplierId) 
	{
		Session session=sessionFactory.openSession();
		Supplier supplier=(Supplier)session.get(Supplier.class,supplierId);
		session.close();
		return supplier;
	}

	public List<Supplier> listSuppliers()
	{
		Session session=sessionFactory.openSession();
		List<Supplier> listSuppliers=(List<Supplier>)(session.createQuery("from Supplier").list());
		session.close();
		return listSuppliers;
	}
}
