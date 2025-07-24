package mediumdifficulty.carrentalsystem;

public class CarRentalSystemDemoRun {

    public static void run(){

        CarRentalSystem crs = CarRentalSystem.getInstance();

        //make, model, year, license plate number, and rental price per day
        Car c1 = new Car( "Ford", "Ecosport", 2012, "ABV0982", 20 );

        Car c2 = new Car( "Porsche", "Carera", 2020, "VBC0981", 120 );

        Car c3 = new Car( "Ferrari", "Regira", 2018, "NVB9871", 80 );

        Car c4 = new Car( "Rolls Royce", "Phantom", 2021, "DFC0171", 150 );

        Car c5 = new Car( "Bugatti", "Veyron", 2015, "POW2312", 100 );

        Car c6 = new Car( "Hyundai", "F1 Gig", 2020, "AER2314", 20 );

        Car c7 = new Car( "Honda", "Civic", 2007, "AFG7681", 10 );

        crs.addCar( c1 );
        crs.addCar( c2 );
        crs.addCar( c3 );
        crs.addCar( c4 );
        crs.addCar( c5 );
        crs.addCar( c6 );
        crs.addCar( c7 );

        Car fc = crs.startSearch();

        if( fc != null ){
            Reservation res = crs.createReservation( fc );
        }

        Car fc1 = crs.startSearch();

        if( fc1 != null ){
            Reservation res1 = crs.createReservation( fc1 );
        }

        System.out.println("Reservations for the car are");
        fc.viewReservations();

        Reservation foundRes = fc.searchReservation();

        if( foundRes != null ){
            crs.editReservation( foundRes );
        }

        Car fc2 = crs.startSearch();

        if( fc2 != null ){
            Reservation res2 = crs.createReservation( fc2 );
            crs.deleteReservation( res2 );
        }


    }
}
