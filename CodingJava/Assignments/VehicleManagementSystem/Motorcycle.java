package Assignments.VehicleManagementSystem;

public class Motorcycle implements Vehicle, MotorVehicle {
    private String make, model, type;
    private int year, numberOfWheels;

    public Motorcycle(String make, String model, int year) {
        this.make = make;
        this.model = model;
        this.year = year;
    }
    
    @Override public String Make() {return make;};
    @Override public String Model() {return model;};
    @Override public int manufacturingYear() {return year;}

    @Override public void setNumberOfWheels(int wheels){this.numberOfWheels = wheels;}
    @Override public int getNumberOfWheels(){return numberOfWheels;}

    @Override public void setTypeOfMotorcycle(String motorcycleType){ 
        if (motorcycleType.equalsIgnoreCase("Type-1") 
            || motorcycleType.equalsIgnoreCase("Type-2")
            || motorcycleType.equalsIgnoreCase("Type-3")
        ) {
            this.type = motorcycleType;
        } 
        else {
            throw new IllegalArgumentException("Invalid Motorcycle Type");
        }
    }

    @Override public String getTypeOfMotorcycle(){return type;}


}
