package mediumdifficulty.hotelmanagementsystem;

import java.util.Date;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class Reservation {

    private Guest ownedGuest;
    private Room ownedRoom;
    private Date startDate;
    private Date endDate;
    private double totalCost;
    private CashTransactionType paymentMode;

    private Date checkinTime;
    private Date checkoutTime;

    public Reservation( Guest g, Room r, Date start, Date end ){
        ownedGuest = g;
        ownedRoom = r;
        startDate = start;
        endDate = end;
        totalCost = 0;
    }

    public void calculateTotalCost(){
        long numDays = TimeUnit.DAYS.convert(endDate.getTime() - startDate.getTime(), TimeUnit.MILLISECONDS);
        totalCost = numDays * ownedRoom.getPricePerDay();
    }

    public Guest getOwnedGuest() {
        return ownedGuest;
    }

    public void setOwnedGuest(Guest ownedGuest) {
        this.ownedGuest = ownedGuest;
    }


    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Room getOwnedRoom() {
        return ownedRoom;
    }

    public void setOwnedRoom(Room ownedRoom) {
        this.ownedRoom = ownedRoom;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public double getTotalCost() {
        return totalCost;
    }

    public void setTotalCost(double totalCost) {
        this.totalCost = totalCost;
    }

    public Date getCheckinTime() {
        return checkinTime;
    }

    public void setCheckinTime(Date checkinTime) {
        if( checkinTime.before(startDate) ){
            System.out.println(" Checking in before the start date. Please checkin later ");
            return;
        }
        System.out.println("Successful check-in");
        this.checkinTime = checkinTime;
    }

    public Date getCheckoutTime() {
        return checkoutTime;
    }

    public void setCheckoutTime(Date checkoutTime) {
        if( checkoutTime.after(endDate) ){
            System.out.println(" Checking out after the end date. ");
            totalCost += ownedRoom.getPricePerDay();

            System.out.println("Please pay the late fine of " + totalCost );

            System.out.println("Choose payment type by choosing index number");
            System.out.println("1. Cash");
            System.out.println("2. Credit Card");
            System.out.println("3. Online Payment");

            Scanner scanner = new Scanner(System.in);
            int paymentChoice = scanner.nextInt();
            scanner.next();
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
                scanner.next();

                if( paymentAmount <= totalCost ){
                    totalCost -= paymentAmount;
                } else {
                    totalCost = 0;
                    remChange = paymentAmount - totalCost;
                }

                System.out.println("The remaining pending payment bill is " + totalCost );
            }

            System.out.println("The remaining change is " + remChange +" is returned" );

        } else {
            System.out.println("Successful check-out");
        }

        this.checkoutTime = checkoutTime;
    }

    public CashTransactionType getPaymentMode() {
        return paymentMode;
    }

    public void setPaymentMode(CashTransactionType paymentMode) {
        this.paymentMode = paymentMode;
    }




}
