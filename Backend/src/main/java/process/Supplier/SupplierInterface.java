package process.Supplier;

import java.util.List;


public interface SupplierInterface {

		public boolean addSupplier(Supplier supplier);
		public boolean deleteSupplier(Supplier supplier);
		public boolean updateSupplier(Supplier supplier);
		public Supplier getSupplier(int supplierId);
		public List<Supplier> listSuppliers();
}
