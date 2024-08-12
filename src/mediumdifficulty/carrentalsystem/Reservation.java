package mediumdifficulty.carrentalsystem;

public class Reservation {

    Car reservedCar;
    String startDate;
    String endDate;

    Reservation( Car c, String stDate, String enDate ){
        reservedCar = c;
        startDate = stDate;
        endDate = enDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

}
