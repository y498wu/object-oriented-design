public class ParkingSpot{
    private final int spotID;
    private final SpotSize size;
    private Vehicle parkedVehicle;

    public ParkingSpot(int spotID, SpotSize size){
        this.spotID = spotID;
        this.size = size;
    }

    public Vehicle getParkedVehicle(){
        return parkedVehicle;
    }
    public boolean isAvailable(){
        return parkedVehicle == null;
    }
    public void clear(){
        // need to add "this" here
        this.parkedVehicle = null;
    }
    public boolean canPark(Vehicle vehicle){
        return isAvailable() & size.canFit(vehicle.vehicleSize());
    }
    public void park(Vehicle vehicle){
        if (canPark(vehicle)){
            this.parkedVehicle = vehicle;
        } else {
            throw new IllegalStateException("The vehicle cannot fit into this parking spot");
        }
    }
}