public class Test{
    

  public static void main(String[] args){
      Mustang m=new Mustang();
      FighterJet jet=new FighterJet();
      OilTank o=new OilTank();

    System.out.println(m.canFly()); //prints "false"
    System.out.println(jet.sonicBoom(550)); //prints "Whoosh!"
    System.out.println(jet.numWheels()); //prints '3'
    System.out.println(o.name()); //prints "Oil Tanker"
    }
      
}