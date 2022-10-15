package com.epam.school.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.epam.school.entities.EpamUser;

public interface UserRepository extends JpaRepository<EpamUser, Integer>{
	
	public EpamUser findByUsername(String username);
}
