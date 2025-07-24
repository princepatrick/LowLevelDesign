package mediumdifficulty.hotelmanagementsystem;

import java.util.ArrayList;
import java.util.List;

public class HotelManagementSystem{

    List<Guest> guestList;
    List<Room> roomList;
    List<Reservation> reservationList;
    private static HotelManagementSystem hms;

    private HotelManagementSystem(){
        guestList = new ArrayList<>();
        roomList = new ArrayList<>();
        reservationList = new ArrayList<>();
    }

    public static HotelManagementSystem getInstance(){
        if( hms == null ){
            hms = new HotelManagementSystem();
        }

        return hms;
    }

    public Room createRoom( int floorNum, int roomNum, double price, RoomType roomType ){
        Room room = new Room( floorNum, roomNum, price, roomType );
        roomList.add(room);
        return room;
    }

    public Guest createGuest( String guestName, String guestPhoneNum ){
        Guest guest = new Guest( guestName, guestPhoneNum, this );
        guestList.add(guest);
        return guest;
    }

}
