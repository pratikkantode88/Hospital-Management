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

import com.Hospital.Management.System.Entity.Patient;
import com.Hospital.Management.System.Service.PatientService;

@CrossOrigin
@RestController
@RequestMapping("/patient")
@PreAuthorize("hasRole('doctor') or hasRole('receptionist')")
public class PatientController {

	@Autowired
	private PatientService patientService;
	
	@PostMapping("/insert")
	public Patient savePatient(@RequestBody Patient patient) {
		return patientService.savePatient(patient);
	}
	
	@GetMapping("/getAll")
	public List<Patient> getPatients(){
		return patientService.getPatients();
	}
	
	@GetMapping("/find/{id}")
	public ResponseEntity<Patient> findById(@PathVariable long id) throws AttributeNotFoundException{
		return patientService.findById(id);
	}
	
	@PutMapping("/update/{id}")
	public ResponseEntity<Patient> updatePatient(@PathVariable long id,@RequestBody Patient patient) throws AttributeNotFoundException{
		return patientService.updatePatientById(id, patient);
		
	}
	
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Map<String, Boolean>> deletePatient(@PathVariable long id) throws AttributeNotFoundException{
		return patientService.deletePatient(id);
	}
}
