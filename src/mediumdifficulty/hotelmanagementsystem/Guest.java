package mediumdifficulty.hotelmanagementsystem;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Guest {

    private GuestDetails guestDetails;
    private HotelManagementSystem hms;
    private List<Reservation> reservationList;

    public Guest( String guestName, String guestNum, HotelManagementSystem theHms ){
        guestDetails = new GuestDetails( guestName, guestNum );
        hms = theHms;
        reservationList = new ArrayList<>();
    }

    public GuestDetails getGuestDetails() {
        return guestDetails;
    }

    public void setGuestDetails(GuestDetails guestDetails) {
        this.guestDetails = guestDetails;
    }

    public Reservation findAndReserveRoom(){

        try{
            System.out.println("Choose Start Date. Write in MM/DD/YYYY format ");
            Scanner scanner = new Scanner(System.in);
            String stDate = scanner.next();

            Date startDate = new SimpleDateFormat("MM/dd/yyyy").parse(stDate);

            System.out.println("Choose the end date. Write in MM/DD/YYYY format");
            String enDate = scanner.next();

            Date endDate = new SimpleDateFormat("MM/dd/yyyy").parse(enDate);

            List<Room> allRooms = hms.roomList;

            List<Integer> availableRooms = new ArrayList<>();

            for( int i=0 ; i<allRooms.size() ; i++ ){

                Room room = allRooms.get(i);

                List<Reservation> roomReservations = room.getReservationList();

                boolean isRoomAvailable = true;

                for( Reservation res : roomReservations ){

                    Date resStDate = res.getStartDate();
                    Date resEndDate = res.getStartDate();

                    if( (resStDate.compareTo(startDate) >= 0 && resStDate.compareTo(endDate) <= 0)
                        ||
                            (resEndDate.compareTo(startDate) >= 0 && resEndDate.compareTo(endDate) <= 0)
                        ||
                            (resStDate.compareTo(startDate) <= 0 && resStDate.compareTo(endDate) >= 0)
                    ){
                        isRoomAvailable = false;
                        break;
                    }

                }

                if( isRoomAvailable ){
                    availableRooms.add(i);
                }
            }

            System.out.println("The available rooms are: ");

            for( int ind : availableRooms ){
                Room room = allRooms.get(ind);
                System.out.println("The room details are Floor number " + room.getFloorNumber()
                + " and Room Number " + room.getRoomNumber()
                + " and the Room Price for a day is " + room.getPricePerDay()
                + " and the index to choose the room is " + ind );
            }

            System.out.println("The options are: ");
            System.out.println("1. Choose a room");
            System.out.println("2. Select again");
            System.out.println("3. Cancel selection");

            int action = scanner.nextInt();
//            scanner.next();

            switch( action ){
                case 1:
                    System.out.println("The available rooms are: ");

                    for( int ind : availableRooms ){
                        Room room = allRooms.get(ind);
                        System.out.println("The room details are Floor number " + room.getFloorNumber()
                                + " and Room Number " + room.getRoomNumber()
                                + " and the Room Price for a day is " + room.getPricePerDay()
                                + " and the index to choose the room is " + ind );
                    }

                    int chosenRoomInd = scanner.nextInt();
//                    scanner.next();

                    Room chosenRoom = allRooms.get( chosenRoomInd );

                    System.out.println("The room with Floor number " + chosenRoom.getFloorNumber()
                            + " and Room Number " + chosenRoom.getRoomNumber()
                            + " is chosen." );

                    Reservation reservation = new Reservation( this, chosenRoom, startDate, endDate );
                    reservation.calculateTotalCost();

                    return reservation;
                case 2:
                    System.out.println("Selecting the room again!");
                    findAndReserveRoom();
                    break;
                case 3:
                    break;
            }


        } catch( Exception ex ){
            System.out.println("The exception is " + ex );
        }

        return null;
    }

    public void bookRoom( Reservation res ){
        Room r = res.getOwnedRoom();

        double totalCost = res.getTotalCost();

        System.out.println("Please pay " + totalCost +" to confirm the booking");

        System.out.println("Choose payment type by choosing index number");
        System.out.println("1. Cash");
        System.out.println("2. Credit Card");
        System.out.println("3. Online Payment");

        Scanner scanner = new Scanner(System.in);
        int paymentChoice = scanner.nextInt();
//        scanner.next();
        CashTransactionType ctt;

        switch( paymentChoice ){
            case 1:
                System.out.println("Payment through Cash");
                ctt = CashTransactionType.CASH;
                break;
            case 2:
                System.out.println("Payment through Credit Card");
                ctt = CashTransactionType.CREDIT_CARD;
                break;
            default:
                System.out.println("Payment through Online Payment");
                ctt = CashTransactionType.ONLINE_PAYMENT;
                break;
        }

        double remChange = 0;

        while( totalCost > 0 ){
            System.out.println("Make payment of $");
            double paymentAmount = scanner.nextDouble();
//            scanner.next();

            if( paymentAmount <= totalCost ){
                totalCost -= paymentAmount;
            } else {
                remChange = paymentAmount - totalCost;
                totalCost = 0;
            }

            System.out.println("The remaining pending payment bill is " + totalCost );
        }

        System.out.println("The remaining change is " + remChange +" is returned" );
        res.setPaymentMode(ctt);

        r.addReservation(res);
        reservationList.add(res);
    }




}
