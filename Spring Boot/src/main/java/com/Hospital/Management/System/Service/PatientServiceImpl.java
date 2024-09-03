package com.Hospital.Management.System.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.management.AttributeNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.Hospital.Management.System.Entity.Patient;
import com.Hospital.Management.System.Repository.PatientRepository;

@Service
public class PatientServiceImpl implements PatientService{

	@Autowired
	private PatientRepository patientRepository;
	

	@Override
	public Patient savePatient(Patient patient) {
		return patientRepository.save(patient);
	}


	@Override
	public List<Patient> getPatients() {
		return patientRepository.findAll();
	}

	@Override
	public ResponseEntity<Map<String, Boolean>> deletePatient(long id) throws AttributeNotFoundException{

		Patient patient = patientRepository.findById(id).orElseThrow(()->new AttributeNotFoundException("Appointment Not Found With Id "+id));
		patientRepository.deleteById(patient.getId());
		
		Map<String,Boolean> response=new HashMap<String, Boolean>();
		response.put("Deleted", Boolean.TRUE);
		
		return ResponseEntity.ok(response);
	}

	@Override
	public ResponseEntity<Patient> updatePatientById(long id, Patient patient) throws AttributeNotFoundException {
		Patient getPatient = patientRepository.findById(id).orElseThrow(()->new AttributeNotFoundException("Appointment Not Found With Id "+id));
		
		getPatient.setFirstName(patient.getFirstName());
		getPatient.setLastName(patient.getLastName());
		getPatient.setAge(patient.getAge());
		getPatient.setBlood(patient.getBlood());
		getPatient.setDose(patient.getDose());
		getPatient.setFees(patient.getFees());
		getPatient.setPrescription(patient.getPrescription());
		getPatient.setUrgency(patient.getUrgency());
		
		Patient savePatient=patientRepository.save(getPatient);
		return ResponseEntity.ok(savePatient);
		 
	}


	@Override
	public ResponseEntity<Patient> findById(long id) throws AttributeNotFoundException {
		Patient patient=patientRepository.findById(id).orElseThrow(()->new AttributeNotFoundException("Appointment Not Found With Id "+id));
		return ResponseEntity.ok(patient);
	}
}
