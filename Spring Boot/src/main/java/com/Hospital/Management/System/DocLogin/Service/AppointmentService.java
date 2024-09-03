package com.Hospital.Management.System.DocLogin.Service;

import java.util.List;
import java.util.Map;

import javax.management.AttributeNotFoundException;

import org.springframework.http.ResponseEntity;

import com.Hospital.Management.System.DocLogin.Entity.Appointment;

public interface AppointmentService {

	public Appointment addAppointment(Appointment appointment);
	public List<Appointment> getAppointments();
	public ResponseEntity<Map<String, Boolean>> deleteAppointment(long id) throws AttributeNotFoundException;
}
