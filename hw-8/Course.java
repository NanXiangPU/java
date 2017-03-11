/**
 * Created by xn527 on 3/10/2017.
 */
public class Course {
    Professor professor;
    Student[] students;
    String courseName;
    int numEnrolled;
    public Course(Professor startprofessor,String startcourseName){
        professor=startprofessor;
        courseName=startcourseName;
        numEnrolled = 0;
        students = new Student[100];
    }
     public Professor getProfessor(){
            return professor;
    }

     public Student[] getStudents(){
         return students;
     }
     public String getCourseName(){
         return courseName;
     }

    public int getNumEnrolled(){
         return numEnrolled;
    }

    boolean enroll(Student s){
        if(numEnrolled == 100){
            return false;
        }
        String[] courses = s.courses;
        for(int i=0;i<6;i++){
            if(courses[i].equals(courseName)){
                return false;
            }
        }
        s.addCourse(courseName);
        students[numEnrolled++] = s;
        return true;
    }
}

