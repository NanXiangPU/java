/**
 * Created by xn527 on 3/10/2017.
 */
public class Professor extends Person {
    double salary;
    String course;
    String rank;
     public Professor(String startname,String startaddress, String startcourse,String startrank){
     super(startname, startaddress);
     course= startcourse;
     rank=startrank;
    }
    public void setSalary(){
        if(rank=="professor"){
            salary=100000;
        }else{
            salary=95000;
        }
    }
    public double getSalary(){
        return salary;
    }

    public void setCourse(String startcourse){
        course = startcourse;
    }
    public String getCourse(){
        return course;
    }

    public void setRank(String startrank){
        rank = startrank;

    }
    public String getRank(){
        return rank;
    }
}