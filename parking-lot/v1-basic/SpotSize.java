public enum SpotSize{
    SMALL,
    MEDIUM,
    LARGE;

    public boolean canFit(VehicleSize vehicleSize){
        return vehicleSize.ordinal() <= this.ordinal();
    }
}