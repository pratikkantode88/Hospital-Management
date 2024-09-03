package com.Hospital.Management.System.DocLogin.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.management.AttributeNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.Hospital.Management.System.DocLogin.Entity.Appointment;
import com.Hospital.Management.System.DocLogin.Repository.AppointmentsRepository;

@Service
public class AppointmentServiceImpl implements AppointmentService{

	@Autowired
	private AppointmentsRepository appointmentsRepository;
	
	@Override
	public Appointment addAppointment(Appointment appointment) {
		return appointmentsRepository.save(appointment);
	}

	@Override
	public List<Appointment> getAppointments() {
		return appointmentsRepository.findAll();
	}

	@Override
	public ResponseEntity<Map<String, Boolean>> deleteAppointment(long id) throws AttributeNotFoundException{

		Appointment appointment= appointmentsRepository.findById(id).orElseThrow(()->new AttributeNotFoundException("Appointment Not Found With Id "+id));
		appointmentsRepository.deleteById(appointment.getId());
		
		Map<String,Boolean> response=new HashMap<String, Boolean>();
		response.put("Deleted", Boolean.TRUE);
		
		return ResponseEntity.ok(response);
	}

}
