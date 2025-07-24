package mediumdifficulty.hotelmanagementsystem;

import java.util.ArrayList;
import java.util.List;

public class Room {

    private RoomType roomType;
    private double pricePerDay;
    private List<Reservation> reservationList;
    private int floorNumber;
    private int roomNumber;

    public Room( int theRN, int theFN, double price, RoomType theRoomType ){
        floorNumber = theFN;
        roomNumber = theRN;
        roomType = theRoomType;
        pricePerDay = price;
        reservationList = new ArrayList<>();
    }

    public void addReservation( Reservation res ){
        reservationList.add(res);
    }

    public int getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(int roomNumber) {
        this.roomNumber = roomNumber;
    }

    public RoomType getRoomType() {
        return roomType;
    }

    public void setRoomType(RoomType roomType) {
        this.roomType = roomType;
    }

    public double getPricePerDay() {
        return pricePerDay;
    }

    public void setPricePerDay(double pricePerDay) {
        this.pricePerDay = pricePerDay;
    }

    public int getFloorNumber() {
        return floorNumber;
    }

    public void setFloorNumber(int floorNumber) {
        this.floorNumber = floorNumber;
    }

    public List<Reservation> getReservationList() {
        return reservationList;
    }

    public void setReservationList(List<Reservation> reservationList) {
        this.reservationList = reservationList;
    }



}
