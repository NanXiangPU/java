/**
 * Created by xn527 on 3/10/2017.
 */
public class Student extends Person {
    //. A new student’s course array should  have all entries as “none”.
    String[] courses;
    //. A new student’s grades array should have all entries as ‘A’
    char[] grades;
   // A student can take at most 6 courses, therefore both courses and grades should be of length 6.

    public Student(String startname, String startaddress){
        super(startname, startaddress);
        courses = new String[]{"None","None","None","None","None","None"};
    }
    public String[] getCourses(){
        return courses;
    }

    public char[]  getGrades(){
        return grades;
    }
   //add
    //They are not currently enrolled in the course.
    //They are not already taking 6 courses, i.e. one or more entries in their courses array is “none”
    //New courses should be added to the leftmost available slot in the courses array
    //This method returns true if they successfully add the course, and false otherwise
    public boolean addCourse(String course) {
        int count = 0;
        for(int i = 0; i < 6; ++i) {
            if(!courses[i].equals("None")) {
                count++;
            }
        }
        if(count == 6) {
            return false;
        }
        String[] res = new String[6];
        for (int i = 0; i < 6; i++) {
            if (courses[i] == course) {
                return false;
            }
        }
        res[0] = course;
        for(int i = 1; i < 6; i++) {
            res[i] = courses[i - 1];
        }
        courses = res;
        return true;
    }
}
