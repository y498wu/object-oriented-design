public abstract class Vehicle{
    // use license plate as unique identifier of vehicles
    private final String licensePlate;
    private final VehicleSize vehicleSize;

    protected Vehicle(String licensePlate, VehicleSize vehicleSize){
        this.licensePlate = licensePlate;
        this.vehicleSize = vehicleSize;
    }

    public String getLicensePlate(){
        return licensePlate;
    }

    public VehicleSize vehicleSize(){
        return vehicleSize;
    }
}