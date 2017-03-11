public class FighterJet implements Vehicle{

private String name = "F-15";

private int maxPassengers = 2;

private int maxSpeed = 1875;

private int numWheels = 3;

private String startEngine ="Whoosh!";

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
    return true;
    
}

public String sonicBoom(int currentSpeed){
    if( currentSpeed > 761){
        return "BOOM!!";
    }else{ 
        return "Whoosh!";
    }
}
}
