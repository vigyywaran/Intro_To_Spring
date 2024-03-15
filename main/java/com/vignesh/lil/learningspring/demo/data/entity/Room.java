package com.vignesh.lil.learningspring.demo.data.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.ToString;

@Entity
@Table(name="rooms")
@ToString
public class Room {
    @Id
    @Column(name="room_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column(name="name")
    private String name;
    @Column(name="room_number")
    private String roomNumber;
    @Column(name="bed_info")
    private String bedInfo;


    public long getId() {
        return this.id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRoomNumber() {
        return this.roomNumber;
    }

    public void setRoomNumber(String roomNumber) {
        this.roomNumber = roomNumber;
    }

    public String getBedInfo() {
        return this.bedInfo;
    }

    public void setBedInfo(String bedInfo) {
        this.bedInfo = bedInfo;
    }

}
