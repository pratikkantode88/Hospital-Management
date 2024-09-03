package com.Hospital.Management.System.DocLogin.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Hospital.Management.System.DocLogin.Entity.Appointment;

@Repository
public interface AppointmentsRepository extends JpaRepository<Appointment, Long>{

}
