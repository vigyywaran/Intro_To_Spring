package com.vignesh.lil.learningspring.demo.data.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vignesh.lil.learningspring.demo.data.entity.Room;

public interface RoomRepository extends JpaRepository<Room,Long>{
    Optional<Room> findByRoomNumberIgnoreCase(String roomNumber);    
}
