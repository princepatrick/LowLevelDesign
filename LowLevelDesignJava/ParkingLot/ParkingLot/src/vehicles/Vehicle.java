package vehicles;

public abstract class Vehicle {

    private String licenseNumber;

    private VehicleType vehicleType;

    public Vehicle( String theLicenseNumber, VehicleType theVehicleType ){
        licenseNumber = theLicenseNumber;
        vehicleType = theVehicleType;
    }

    public VehicleType getType(){
        return vehicleType;
    }


}
