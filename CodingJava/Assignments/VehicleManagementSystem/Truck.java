package Assignments.VehicleManagementSystem;

public class Truck implements Vehicle, TruckVehicle {
    private String make, model, type;
    private int year, cargoCapacity;

    public Truck(String make, String model, int year){
        this.make = make;
        this.model = model;
        this.year = year;
    }

    @Override public String Model(){return model;}
    @Override public String Make(){return make;}
    @Override public int manufacturingYear(){return year;}
    
    @Override public void setCargoCapacity(int cargoCapacity){ this.cargoCapacity = cargoCapacity;}
    @Override public int getCargoCapacity(){return cargoCapacity;}

    @Override public void setTransmissionType(String transmissionType){
        if (transmissionType.equalsIgnoreCase("Manual") 
            || (transmissionType.equalsIgnoreCase("Automatic"))
            ) {
            this.type = type;
        }
        else {
            throw new IllegalArgumentException("Invalid transmission type, select: Manual or Automatic");
        }
    }

    @Override public String getTransmissionType(){return type;}




}
