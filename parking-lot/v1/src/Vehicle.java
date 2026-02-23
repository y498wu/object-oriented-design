public abstract class Vehicle{
    // use license plate as unique identifier of vehicles
    private String licensePlate;
    private VehicleSize vehicleSize;

    protected Vehicle(String licensePlate, VehicleSize vehicleSize){
        licensePlate = this.licensePlate;
        vehicleSize = this.vehicleSize;
    }

    public String getLicensePlate(){
        return licensePlate;
    }

    public VehicleSize vehicleSize(){
        return vehicleSize;
    }
}