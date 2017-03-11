public interface Vehicle{
    // Write an interface Vehicle that describes the following methods:
    String name() ;//: returns the name of the vehicle.
    
    int maxPassengers(); // : returns the number of passengers that the vehicle supports.

    int maxSpeed() ;// returns the maximum speed of the vehicle.

    int numWheels();// : returns the number of wheels the vehicle has (or does not have)

    String startEngine();// : returns the sound made by the vehicle's engine

    boolean canFly();// : returns true if the vehicle can fly, false otherwise

}