package mediumdifficulty.hotelmanagementsystem;

public class HotelManagementSystemDemoRun {

    public static void run(){

        HotelManagementSystem hms = HotelManagementSystem.getInstance();

        hms.createRoom( 1, 1, 20, RoomType.SINGLE );
        hms.createRoom( 1, 2, 20, RoomType.SINGLE );
        hms.createRoom( 1, 3, 30, RoomType.DOUBLE );
        hms.createRoom( 2, 1, 60, RoomType.DELUXE );
        hms.createRoom( 2, 2, 60, RoomType.DELUXE );
        hms.createRoom( 2, 2, 100, RoomType.SUITE );

        Guest g1 = hms.createGuest("Guest 1", "XXX-XXXX" );
        Guest g2 = hms.createGuest("Guest 2", "XXX-XXXX" );
        Guest g3 = hms.createGuest("Guest 3", "XXX-XXXX" );

        Reservation res = g1.findAndReserveRoom();

        g1.bookRoom(res);

        res.setCheckinTime(res.getStartDate());
        res.setCheckoutTime(res.getEndDate());

    }
}
