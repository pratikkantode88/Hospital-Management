package com.Hospital.Management.System.DocLogin.Service;

import java.util.List;
import java.util.Map;

import javax.management.AttributeNotFoundException;

import org.springframework.http.ResponseEntity;

import com.Hospital.Management.System.DocLogin.Entity.Medicine;

public interface MedicineService {

	public Medicine addMedicine(Medicine medicine);
	public List<Medicine> getMedicines();
	public ResponseEntity<Medicine> getMedicineById(long id)throws AttributeNotFoundException;
	public ResponseEntity<Medicine> updateMedicineById(long id,Medicine medicine) throws AttributeNotFoundException;
	public ResponseEntity<Map<String, Boolean>> deleteMedicine(long id) throws AttributeNotFoundException;
}
