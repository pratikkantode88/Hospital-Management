package com.Hospital.Management.System.DocLogin.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.management.AttributeNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.Hospital.Management.System.DocLogin.Entity.Medicine;
import com.Hospital.Management.System.DocLogin.Repository.MedicineRepository;
import com.Hospital.Management.System.Entity.Patient;

@Service
public class MedicineServiceImpl implements MedicineService{

	@Autowired
	private MedicineRepository medicineRepository;
	
	@Override
	public Medicine addMedicine(Medicine medicine) {
		return medicineRepository.save(medicine);
	}

	@Override
	public List<Medicine> getMedicines() {
		return medicineRepository.findAll();
	}

	@Override
	public ResponseEntity<Medicine> getMedicineById(long id) throws AttributeNotFoundException {
		Medicine medicine=medicineRepository.findById(id).orElseThrow(()->new AttributeNotFoundException("Medicine Not Found With Id :"+id));
		
		return ResponseEntity.ok(medicine);
	}

	@Override
	public ResponseEntity<Medicine> updateMedicineById(long id, Medicine medicine) throws AttributeNotFoundException {
		
Medicine getMedicine = medicineRepository.findById(id).orElseThrow(()->new AttributeNotFoundException("Medicine Not Found With Id "+id));
		
       getMedicine.setDrugName(medicine.getDrugName());
       getMedicine.setStock(medicine.getStock());

		
		Medicine saveMedicine=medicineRepository.save(getMedicine);
		return ResponseEntity.ok(saveMedicine);
	
	}

	@Override
	public ResponseEntity<Map<String, Boolean>> deleteMedicine(long id) throws AttributeNotFoundException {
		Medicine medicine = medicineRepository.findById(id).orElseThrow(()->new AttributeNotFoundException("Medicine Not Found With Id "+id));
		medicineRepository.deleteById(medicine.getId());
		
		Map<String,Boolean> response=new HashMap<String, Boolean>();
		response.put("Deleted", Boolean.TRUE);
		
		return ResponseEntity.ok(response);
	}

}
