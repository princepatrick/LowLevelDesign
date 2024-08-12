package mediumdifficulty.carrentalsystem;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Car {

    String make;
    String model;
    int year;
    String license;
    double rentalPrice;
    List<Reservation> carReservationList;

    public Car( String theMake, String theModel, int theYear, String theLicense, double theRentalPrice ){
        make = theMake;
        model = theModel;
        year = theYear;
        license = theLicense;
        rentalPrice =theRentalPrice;
        carReservationList = new ArrayList<>();
    }

    public void addReservations( Reservation r ){
        carReservationList.add(r);
    }

    public void viewReservations(){

        System.out.println("Please find the info on reservations");

        for( Reservation res : carReservationList ){
            System.out.println("The Reserved car's license number is " + res.reservedCar.getLicense()
                    + " reservation's start date " + res.startDate
                    + " reservations's end date " + res.endDate );
        }

    }

    public Reservation searchReservation(){

        System.out.println("Please find the info on reservations");

        int indexOfReservations = 1;

        for( Reservation res : carReservationList ){
            System.out.println( indexOfReservations + ". The Reserved car's license number is " + res.reservedCar.getLicense()
                    + " reservation's start date " + res.startDate
                    + " reservations's end date " + res.endDate );
        }

        System.out.println("Please choose a reservation based on the index number");

        Scanner scanner = new Scanner(System.in);
        int index = scanner.nextInt();

        return carReservationList.get(index-1);

    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getLicense() {
        return license;
    }

    public void setLicense(String license) {
        this.license = license;
    }

    public double getRentalPrice() {
        return rentalPrice;
    }

    public void setRentalPrice(double rentalPrice) {
        this.rentalPrice = rentalPrice;
    }

    public void deleteReservation( Reservation r ){
        int sz = carReservationList.size();

        for( int i=0 ; i<sz ; i++ ){
            Reservation res = carReservationList.get(i);

            if( res == r ){
                carReservationList.remove(res);
            }

        }

    }

}
