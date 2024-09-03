package com.Hospital.Management.System.Controller;

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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Hospital.Management.System.DocLogin.Entity.Appointment;
import com.Hospital.Management.System.DocLogin.Service.AppointmentService;

@CrossOrigin
@RestController
@RequestMapping("/apointment")
@PreAuthorize("hasRole('receptionist')")
public class AppointmentController {

	@Autowired
	private AppointmentService appointmentService;
	
	@PostMapping("/insert")
	public Appointment saveAppointment(@RequestBody Appointment appointment) {
		return appointmentService.addAppointment(appointment);
	}
	
	@GetMapping("/getAll")
	public List<Appointment> getAppointments(){
		return appointmentService.getAppointments();
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Map<String, Boolean>> deleteAppintment(@PathVariable long id) throws AttributeNotFoundException{
		return appointmentService.deleteAppointment(id);
	}
	
}
