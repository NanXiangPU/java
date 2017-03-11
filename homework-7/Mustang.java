public class Mustang implements Vehicle{


private String name = "Mustang";

private int maxPassengers = 4;

private int maxSpeed = 800;

private int numWheels = 4;

private String startEngine ="Vroom! Vroom!";

public String name(){
  return name;  
} 

public int maxPassengers(){
  return maxPassengers;   
}

public int maxSpeed(){
    return maxSpeed;
} 

public int numWheels(){
    return numWheels;
    }

public String startEngine(){
    return startEngine;
    }
    
public boolean canFly(){
    return false;
    
}

}