package com.example.ticket_system.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.ticket_system.model.User;

public interface UserRepository extends JpaRepository<User,Long>{

}
