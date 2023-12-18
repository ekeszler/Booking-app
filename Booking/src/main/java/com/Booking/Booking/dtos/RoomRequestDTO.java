package com.Booking.Booking.dtos;

public class RoomRequestDTO {

    private Long id;

    private Integer roomNumber;
    private Integer price;
    private Integer personsNumber;

    public RoomRequestDTO(Long id, Integer roomNumber, Integer price, Integer personsNumber) {
        this.id = id;
        this.roomNumber = roomNumber;
        this.price = price;
        this.personsNumber = personsNumber;
    }

    public RoomRequestDTO() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(Integer roomNumber) {
        this.roomNumber = roomNumber;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Integer getPersonsNumber() {
        return personsNumber;
    }

    public void setPersonsNumber(Integer personsNumber) {
        this.personsNumber = personsNumber;
    }
}
