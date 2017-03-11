/**
 * Created by xn527 on 3/10/2017.
 */
public class Person {
    String name;
    String address;
    public Person(String startname, String startaddress){
       name=startname;
       address=startaddress;
    }
    String getName(){
        return name;
    }
    public void setName(String startname){
        name=startname;
    }
    String getAddress(){
        return address;
    }
    public void setAddress(String startaddress){
        address=startaddress;
    }

}
