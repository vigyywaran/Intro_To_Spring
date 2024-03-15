package com.vignesh.lil.learningspring.demo.data.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vignesh.lil.learningspring.demo.data.entity.Reservation;

public interface ReservationRepository extends JpaRepository<Reservation,Long>{
    List<Reservation>findAllByReservationDate(java.sql.Date resDate);
}
