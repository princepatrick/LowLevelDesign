import vehicles.Vehicle;
import vehicles.VehicleType;

public class ParkingSpot {

    private Vehicle parkedVehicle = null;
    private VehicleType vehicleType;

    public void setType(VehicleType vehType){
        vehicleType = vehType;
    }

    public VehicleType getType(){
        return vehicleType;
    }

    public boolean isAvailable(){
        return parkedVehicle == null;
    }

    public void addVehicle( Vehicle vehicle ){
        parkedVehicle = vehicle;
    }

    public void removeVehicle(){
        parkedVehicle = null;
    }

}
