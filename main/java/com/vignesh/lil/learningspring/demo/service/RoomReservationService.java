package com.vignesh.lil.learningspring.demo.service;

import java.sql.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.vignesh.lil.learningspring.demo.data.entity.Guest;
import com.vignesh.lil.learningspring.demo.data.entity.Reservation;
import com.vignesh.lil.learningspring.demo.data.entity.Room;
import com.vignesh.lil.learningspring.demo.data.repository.GuestRepository;
import com.vignesh.lil.learningspring.demo.data.repository.ReservationRepository;
import com.vignesh.lil.learningspring.demo.data.repository.RoomRepository;
import com.vignesh.lil.learningspring.demo.service.model.RoomReservation;

import io.micrometer.common.util.StringUtils;

@Service
public class RoomReservationService {
    private final GuestRepository guestRepository;
    private final RoomRepository roomRepository;
    private final ReservationRepository reservationRepository;


    public RoomReservationService(GuestRepository guestRepository, RoomRepository roomRepository, ReservationRepository reservationRepository) {
        this.guestRepository = guestRepository;
        this.roomRepository = roomRepository;
        this.reservationRepository = reservationRepository;
    }

    public List<RoomReservation> getRoomReservationsForDate(String reservationDate){
        Date date=null;
        if(StringUtils.isNotEmpty(reservationDate)){
            date=Date.valueOf(reservationDate);
        }
        else{
            date=new Date(new java.util.Date().getTime());
        }
        Map<Long, RoomReservation> roomReservations=new HashMap<>();
        //List<Room> rooms=this.roomRepository.findAll();
        List<Room> rooms=this.roomRepository.findAll();
        rooms.forEach(room -> {
            RoomReservation roomReservation=new RoomReservation();
            roomReservation.setRoomId(room.getId());
            roomReservation.setRoomName(room.getName());
            roomReservation.setRoomNumber(room.getRoomNumber());
            roomReservations.put(roomReservation.getRoomId(), roomReservation);
        });
        List<Reservation> reservations=this.reservationRepository.findAllByReservationDate(date);
        reservations.forEach(reservation -> {
            RoomReservation roomReservation=roomReservations.get(reservation.getRoomId());
            roomReservation.setReservationId(reservation.getId());
            roomReservation.setReservationDate(reservation.getReservationDate().toString());
            Optional<Guest> guest=this.guestRepository.findById(reservation.getGuestId());
            roomReservation.setGuestId(guest.get().getId());
            roomReservation.setFirstName(guest.get().getFirstName());
            roomReservation.setLastName(guest.get().getLastName());
        });
        return roomReservations.values().stream().toList();
    }
}
