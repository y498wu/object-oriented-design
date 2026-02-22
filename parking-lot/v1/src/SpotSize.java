public enum SpotSize{
    SMALL, // ordinal: 0
    MEDIUM, // ordinal: 1
    LARGE; // ordinal: 2

    public boolean canFit(VehicleSize vehicleSize){
        return vehicleSize.ordinal() <= this.ordinal();
    }
}