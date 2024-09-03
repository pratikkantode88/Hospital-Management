package com.Hospital.Management.System.DocLogin.Controller;

import java.util.List;
import java.util.Map;

import javax.management.AttributeNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Hospital.Management.System.DocLogin.Entity.Medicine;
import com.Hospital.Management.System.DocLogin.Service.MedicineService;

@CrossOrigin
@RestController
@RequestMapping("/medicine")
@PreAuthorize("hasRole('doctor')")
public class MedicineController {

	@Autowired
	private MedicineService medicineService;
	
	@PostMapping("/insert")
	public Medicine addMedicine(@RequestBody Medicine medicine) {
		return medicineService.addMedicine(medicine);
	}
	
	@GetMapping("/getAll")
	public List<Medicine> getMedicine(){
		return medicineService.getMedicines();
	}
	
	@GetMapping("/find/{id}")
	public ResponseEntity<Medicine> getMedicineById(@PathVariable Long id)throws AttributeNotFoundException{
		return medicineService.getMedicineById(id);
	}
	
	@PutMapping("/update/{id}")
	public ResponseEntity<Medicine> updateMedicine(@PathVariable long id,@RequestBody Medicine medicine) throws AttributeNotFoundException{
		return medicineService.updateMedicineById(id, medicine);
		
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Map<String, Boolean>> deleteMedicine(@PathVariable long id) throws AttributeNotFoundException{
		return medicineService.deleteMedicine(id);
	}
	
	
}
