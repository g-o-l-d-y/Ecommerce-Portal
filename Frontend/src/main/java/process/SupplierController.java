package process;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import process.DAO.SupplierDAO;
import process.Model.Supplier;


@Controller
public class SupplierController {
	@Autowired 
	SupplierDAO supplierDAO;
	
	@RequestMapping(value="addSupplier" , method=RequestMethod.POST)
	public String addSupplier(@RequestParam("supplierName") String supplierName, @RequestParam("supplierDesc") String supplierDesc)
	{
		Supplier s=new Supplier();
		s.setSupplierName(supplierName);
		s.setSupplierDesc(supplierDesc);
		supplierDAO.addSupplier(s);
		System.out.println("Done");
		return "Supplier";
	}
	
	@RequestMapping(value="listSuppliers" , method=RequestMethod.GET)
	public String listSuppliers(Model model)
	{
		List<Supplier> listSuppliers=supplierDAO.listSuppliers();
		model.addAttribute("supplierList", listSuppliers);
		return "SupplierList";
	}
	
	@RequestMapping(value="deleteSupplier",method=RequestMethod.POST)
	public String deleteSupplier(@RequestParam("supplierId") int supplierId)
	{
		Supplier s= supplierDAO.getSupplier(supplierId);
		supplierDAO.deleteSupplier(s);
		return "Supplier";
	}
	
	@RequestMapping(value="editSupplier",method=RequestMethod.POST)
	public String updateSupplier(@RequestParam("supplierId") int supplierId, @RequestParam("supplierName") String supplierName)
	{
		Supplier s= supplierDAO.getSupplier(supplierId);
		s.setSupplierName(supplierName);
		supplierDAO.updateSupplier(s);
		return "Supplier";
	}
}
