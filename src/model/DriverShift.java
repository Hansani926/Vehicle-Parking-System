package model;

public class DriverShift {
    private String driverName;
    private String vehicleNumber;


    public DriverShift() {
    }

    public DriverShift(String driverName, String vehicleNumber) {
        this.driverName = driverName;
        this.vehicleNumber = vehicleNumber;
    }

    public String getDriverName() {
        return driverName;
    }

    public void setDriverName(String driverName) {
        this.driverName = driverName;
    }

    public String getVehicleNumber() {
        return vehicleNumber;
    }

    public void setVehicleNumber(String vehicleNumber) {
        this.vehicleNumber = vehicleNumber;
    }
}
