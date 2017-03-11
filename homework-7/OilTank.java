public class OilTank implements Vehicle{

private String name = "Oil Tanker";

private int maxPassengers = 30;

private int maxSpeed = 20;

private int numWheels = 0;

private String startEngine ="Brum Brum!";

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
public double maxOilCarried(double radius, double height){
   double maxOilCarried = Math.PI * radius*radius * height;
   return maxOilCarried;
}
}