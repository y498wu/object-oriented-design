import java.util.List;

public class ParkingLot{
    private final List<ParkingSpot> parkingSpots;

    public ParkingLot(List<ParkingSpot> parkingSpots){
        this.parkingSpots = parkingSpots;
    }

    public boolean parkVehicle(Vehicle vehicle){
        for (ParkingSpot spot : parkingSpots){
            if (spot.canPark(vehicle)){
                spot.park(vehicle);
                return true;
            }
        }
        return false;
    }

    public boolean leaveVehicle(String licensePlate){
        for (ParkingSpot spot : parkingSpots){
            if (!spot.isAvailable()
                    && spot.getParkedVehicle().getLicensePlate().equals(licensePlate)){
                spot.clear();
                return true;
            }
        }
        return false;
    }
}