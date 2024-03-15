package com.vignesh.lil.learningspring.demo.data.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vignesh.lil.learningspring.demo.data.entity.Guest;

public interface GuestRepository extends JpaRepository<Guest,Long>{
    
}
