package mediumdifficulty.carrentalsystem;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CarRentalSystem {

    private static CarRentalSystem carRentalSystem;

    private List<Car> carList;

    private List<Reservation> reservationList;

    public CarRentalSystem(){
        carList = new ArrayList<>();
        reservationList = new ArrayList<>();
    }

    public static CarRentalSystem getInstance(){
        if( carRentalSystem == null ){
            carRentalSystem = new CarRentalSystem();
        }

        return carRentalSystem;
    }

    public void addCar( Car c ){
        carList.add(c);
    }

    public Car startSearch(){

        Car selectCar = null;

        List<Car> carSearchList = carList;

        boolean cancelSearch = false;

        while( selectCar == null || cancelSearch ){
            System.out.println("Choose how do you want to filter the cars based on \n 1. Make \n 2. Model \n 3. Year \n 4. License \n 5. Rental Price Per Day \n 6. Reservation Timeline ");
            System.out.println("Choose the option based on the serial number");

            Scanner scanner = new Scanner(System.in);

            int filterChoice = scanner.nextInt();
            scanner.nextLine();

            switch (filterChoice){
                case 1:
                    System.out.println("Searching by the make of the car. Please type the make of the car");
                    String searchMake = scanner.nextLine();
                    carSearchList = searchCarsByMake(searchMake);
                    break;
                case 2:
                    System.out.println("Searching by the model of the car. Please type the model of the car");
                    String searchModel = scanner.nextLine();
                    carSearchList = searchCarsByModel(searchModel);
                    break;
                case 3:
                    System.out.println("Searching by the year of the car. Please type the year of the car");
                    int searchYear = scanner.nextInt();
                    carSearchList = searchCarsByYear(searchYear);
                    break;
                case 4:
                    System.out.println("Searching by the license number of the car. Please type the license number of the car");
                    String searchLicenseNumber = scanner.nextLine();
                    carSearchList = searchCarsByLicense(searchLicenseNumber);
                    break;
                case 5:
                    System.out.println("Searching by the price range of daily rent for the car.");
                    System.out.println("Please type the minimum price of the daily rent of the car.");
                    Double searchMinPriceRange = scanner.nextDouble();
                    System.out.println("Please type the maximum price of the daily rent of the car.");
                    Double searchMaxPriceRange = scanner.nextDouble();
                    carSearchList = searchCarsByPriceRange( searchMinPriceRange, searchMaxPriceRange );
                    break;
                case 6:
                    System.out.println("Searching by the availability date range of the car.");
                    System.out.println("Please type the starting date of availability of the car.");
                    String searchStartingDate = scanner.nextLine();
                    System.out.println("Please type the ending date of availability of the car.");
                    String searchEndingDate = scanner.nextLine();
                    carSearchList = searchCarsByAvailabilityRange( searchStartingDate, searchEndingDate );
                    break;
            }

            System.out.println("The cars found with the given filters are: ");
            int indexToChoose = 1;
            for( Car car : carSearchList ){
                System.out.println( "Option number " + indexToChoose + ". The car is " + car.getMake() +" - " + car.getModel() + " - $" + car.getRentalPrice() );
            }

            System.out.println(" Choose your next steps \n 1. Search Again \n 2. Select \n 3. Cancel");

            int ch = scanner.nextInt();

            switch (ch){
                case 1:
                    System.out.println("The search continues");
                    break;
                case 2:
                    System.out.println("Choose the car by the option number");
                    int optionNumber = scanner.nextInt();
                    selectCar = carSearchList.get(optionNumber-1);
                    break;
                case 3:
                    System.out.println("Cancelling the search");
                    cancelSearch = true;
                    break;
            }

        }

        return selectCar;

    }

    public void editReservation( Reservation r ){

        Scanner scanner = new Scanner(System.in);
        String startDate, endDate;

        System.out.println("Enter the prefered start date and end date for the car");
        System.out.println("Please enter start date (MM/DD/YY) format ");
        startDate = scanner.next();
        System.out.println("Please enter end date (MM/DD/YY) format ");
        endDate = scanner.next();

        r.setStartDate(startDate);
        r.setEndDate(endDate);

    }

    public void deleteReservation( Reservation r ){

        int sz = reservationList.size();

        for( int i=0 ; i<sz ; i++ ){
            Reservation res = reservationList.get(i);

            if( res == r ){
                reservationList.remove(res);
            }

        }

        Car reservedCar = r.reservedCar;

        reservedCar.deleteReservation( r );

    }

    List<Car> searchCarsByMake( String make ){

        List<Car> foundList = new ArrayList<>();

        for( Car car : carList ){
            System.out.println(car.getMake() + "   " + make );
            if( car.getMake().equals(make)  ){
                System.out.println("A valid car is found");
                foundList.add(car);
            }
        }

        return foundList;

    }

    List<Car> searchCarsByModel( String model ){

        List<Car> foundList = new ArrayList<>();

        for( Car car : carList ){

            if( car.getModel().equals(model) ){
                System.out.println("A valid car is found");
                foundList.add(car);
            }
        }

        return foundList;

    }

    List<Car> searchCarsByYear( int year ){

        List<Car> foundList = new ArrayList<>();

        for( Car car : carList ){

            if( car.getYear() == (year) ){
                System.out.println("A valid car is found");
                foundList.add(car);
            }
        }

        return foundList;

    }

    List<Car> searchCarsByLicense( String license ){

        List<Car> foundList = new ArrayList<>();

        for( Car car : carList ){

            if( car.getLicense().equals(license) ){
                System.out.println("A valid car is found");
                foundList.add(car);
            }
        }

        return foundList;

    }

    List<Car> searchCarsByPriceRange( Double minPrice, Double maxPrice ){

        List<Car> foundList = new ArrayList<>();

        for( Car car : carList ){

            if( car.rentalPrice >= minPrice && car.rentalPrice <= maxPrice ){
                System.out.println("A valid car is found");
                foundList.add(car);
            }
        }

        return foundList;

    }

    List<Car> searchCarsByAvailabilityRange( String minDate, String maxDate ){

//        List<Car> foundList = new ArrayList<>();
//
//        for( Car car : carList ){
//
//            if( car. >= minPrice && car.rentalPrice <= maxPrice ){
//                System.out.println("A valid car is found");
//                foundList.add(car);
//            }
//        }
//
//        return foundList;

        return null;

    }

    public Reservation createReservation( Car c ){
        Scanner scanner = new Scanner(System.in);
        String startDate, endDate;

        System.out.println("Enter the prefered start date and end date for the car");
        System.out.println("Please enter start date (MM/DD/YY) format ");
        startDate = scanner.next();
        System.out.println("Please enter end date (MM/DD/YY) format ");
        endDate = scanner.next();

        Reservation res = new Reservation( c, startDate, endDate );

        c.addReservations(res);

        return res;
    }
}
