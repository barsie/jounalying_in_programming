package Assignments.VehicleManagementSystem;

public class Car implements Vehicle, CarVehicle{

    private String make, model, fuelType;
    private int year, numberOfDoors;

    public Car (String make, String model, int year){
        this.year = year;
        this.make = make;
        this.model = model;
    }
    
    @Override public String Make() {return make;};
    @Override public String Model() {return model;};
    @Override public int manufacturingYear() {return year;}

    @Override public void setNumberOfDoors(int doors){this.numberOfDoors = doors;}
    @Override public int getNumberOfDoors(){return numberOfDoors;};

    @Override
    public void setFuelType(String fuelType){
        
        // Evaluate set fuel types to Diesel, Patrol and Gas
        if (fuelType.equalsIgnoreCase("Diesel") 
            || (fuelType.equalsIgnoreCase("Petrol") 
            || (fuelType.equalsIgnoreCase("Hybrid")) 
            || (fuelType.equalsIgnoreCase("Electric"))
            )){
            this.fuelType = fuelType;
        }
        else {
            throw new IllegalArgumentException("Invalid Fuel Type, plaase set: Diesel, Patrol or Gas");
        };
    }

    @Override public String getFuelType(){ return fuelType;}
    
}
