package com.vignesh.lil.learningspring.demo;

import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.vignesh.lil.learningspring.demo.data.entity.Guest;
import com.vignesh.lil.learningspring.demo.data.entity.Reservation;
import com.vignesh.lil.learningspring.demo.data.entity.Room;
import com.vignesh.lil.learningspring.demo.data.repository.GuestRepository;
import com.vignesh.lil.learningspring.demo.data.repository.ReservationRepository;
import com.vignesh.lil.learningspring.demo.data.repository.RoomRepository;
import com.vignesh.lil.learningspring.demo.service.RoomReservationService;
import com.vignesh.lil.learningspring.demo.service.model.RoomReservation;

@Component
public class CLRunner implements CommandLineRunner {

    private final RoomReservationService roomReservationService;
    private final RoomRepository roomRepository;
    private final GuestRepository guestRepository;
    private final ReservationRepository reservationRepository;

    public CLRunner(RoomRepository roomRepository, GuestRepository guestRepository, ReservationRepository reservationRepository,RoomReservationService roomReservationService){
        this.roomRepository=roomRepository;
        this.guestRepository=guestRepository;
        this.reservationRepository=reservationRepository;
        this.roomReservationService = roomReservationService;
    }
    @Override
    public void run(String... args) throws Exception{
        List<Room> rs=this.roomRepository.findAll();
        rs.forEach(System.out::println);
        System.out.println("This is the real shit");
        List<RoomReservation> reservations = this.roomReservationService.getRoomReservationsForDate("2023-08-28");
        reservations.forEach(System.out::println);
        
    }
}
