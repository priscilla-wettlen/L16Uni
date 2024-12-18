package Uni;

public class Program {
    private Student[] students;
    private int counter;
    private String programName;
    private Course[] courses;


    public Program(String programName, int amountOfCourses, int numberOfStudents){
        this.programName = programName;
        this.students = new Student[numberOfStudents];
        this.courses = new Course[amountOfCourses];
    }


    public Student[] getStudents() {
        return students;
    }

    public String addStudent(Student student){
        if (counter < students.length) {
            students[counter] = student;
            counter++;
            return "Student tillagd i programmet.";
        } else {
            return "Programmet är fullt.";
        }

    }

    public String setCourses(Course[] courses){
        return (this.courses = courses).toString();
    }


    public String removeStudent(int index) {
        if (index >= 0 && index < counter) {
            for (int i = index; i < counter - 1; i++) { //Flyttar "till vänster" ergo -1
                students[i] = students[i + 1]; //overwrites current position with next element
            }
            students[counter - 1] = null; //make last element null
            counter--;
            return "Student borttagen.";
        }
            return "Student fanns ej i programmet.";
    }


    public String getProgramName(){
        return programName;
    }


}
