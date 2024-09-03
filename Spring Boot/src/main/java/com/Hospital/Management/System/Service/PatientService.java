package com.Hospital.Management.System.Service;

import java.util.List;
import java.util.Map;

import javax.management.AttributeNotFoundException;

import org.springframework.http.ResponseEntity;

import com.Hospital.Management.System.Entity.Patient;

public interface PatientService {

	public Patient savePatient(Patient patient);
	public List<Patient> getPatients();
	public ResponseEntity<Map<String, Boolean>> deletePatient(long id) throws AttributeNotFoundException;
	public ResponseEntity<Patient> updatePatientById(long id,Patient patient) throws AttributeNotFoundException;
	public ResponseEntity<Patient> findById(long id)throws AttributeNotFoundException;
}
