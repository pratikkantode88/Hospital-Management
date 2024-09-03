package com.security.service;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.security.entity.Roles;
import com.security.entity.User;
import com.security.repository.RolesRepository;
import com.security.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
   private UserRepository userRepository;
	
	@Autowired
	private RolesRepository rolesRepository;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
   
	
	public void initRolesAdUser() {
		Roles doctorRoles=new Roles();
		doctorRoles.setRoleName("doctor");
		doctorRoles.setDescription("doctor role");
		rolesRepository.save(doctorRoles);
		
		Roles receptionistRoles=new Roles();
		receptionistRoles.setRoleName("receptionist");
		receptionistRoles.setDescription("receptionist role");
		rolesRepository.save(receptionistRoles);
	
		
		User doctor =new User();
		doctor.setUsername("doctor123");
		doctor.setFirstname("pratik");
		doctor.setLastname("kantode");
		doctor.setPassword(passwordEncoder.encode("12345"));
		Set<Roles> doctorRole=new HashSet<Roles>();
		doctorRole.add(doctorRoles);
		doctor.setRole(doctorRole);
		userRepository.save(doctor);
		
		User receptionist =new User();
		receptionist.setUsername("receptionist123");
		receptionist.setFirstname("rushi");
		receptionist.setLastname("ichake");
		receptionist.setPassword(passwordEncoder.encode("12345"));
		Set<Roles> receptionistRole=new HashSet<Roles>();
		receptionistRole.add(receptionistRoles);
		receptionist.setRole(receptionistRole);
		userRepository.save(receptionist);
	}
}
