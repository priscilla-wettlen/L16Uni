package Uni;

public class Faculty {
    private Program[] programs;
    private Teacher[] teachers;
    private String facultyName;
    private int programIndex;

    public Faculty(String facultyName, int amountOfPrograms, int amountOfTeachers) {
        this.facultyName = facultyName;
        this.programs = new Program[amountOfPrograms];
        this.teachers = new Teacher[amountOfTeachers];
    }

    private int getProgramIndex(String programName) {
        programIndex = 0;
        for (int i = 0; i < programs.length; i++) {
            if (programs[i].getProgramName().equals(programName)) {
                programIndex = i;
            } else {
                return 0;
            }
        }
        return programIndex;
    }

    public String removeStudentFromProgram(String studentName, String programName) {
        Program someProgram;

        for (int i = 0; i < programs.length; i++) {
            if (programs[i] != null && programs[i].getProgramName().equals(programName)) {
                someProgram = programs[i];
                if(someProgram.getStudents()[i].getName().equals(studentName)){
                    someProgram.removeStudent(i);
                     return "Student borttagen.";
                }else{
                    return "Student fanns ej i programmet.";
                }

//                for (int j = 0; j < someProgram.getStudents().length; j++) {
//                    if (someProgram.getStudents()[j] != null && someProgram.getStudents()[j].getName().equals(studentName)) {
//                        someProgram.removeStudent(j);
//                        return "Student borttagen";
//                    }
//                }
//                return "Student fanns ej i programmet.";
            }
        }
        return "Inget program med det namnet.";
    }

    public String checkIfTeacherExists(String teacherName) {
        for (Teacher teacher : Teacher.values()) {
            if (teacher.toString().equals(teacherName)) {
                return "Läraren tillhör fakulteten.";
            }
        }
        return "Läraren tillhör inte fakulteten.";
    }

    //TODO
    public String addCoursesToProgram(Course[] courses, String programName) {
        int counter = 0;
        for (int i = 0; i < programs.length; i++) {
            if (programs[i] != null && programs[i].getProgramName().equals(programName) ) {
                programs[i].setCourses(courses);
                counter++;

                if(courses.length > counter){
                    return "Fler kurser än tillåtet.";
                }
            }
        }
        return "Inget program med det namnet.";
    }

    public String getFacultyName() {
        return facultyName;
    }

    public String addStudentToProgram(String programName, Student student) {
        for (int i = 0; i < programs.length; i++) {
            if (programs[i] != null && programs[i].getProgramName().equals(programName)) {
                return programs[i].addStudent(student);
            }
        }

        return "Inget program med det namnet.";
    }


    public String addProgram(String programName, int amountOfCourses, int numberOfStudents) {
        if (programIndex >= programs.length) {
            return "Max antal program tillagda.";
        }

        programs[programIndex] = new Program(programName, amountOfCourses, numberOfStudents);
        programIndex++;
        return "Program tillagt.";

    }

    public String[] getProgramNames() {
        if (programs.length > 0) {
            String[] programNames = new String[programs.length];
            for (int i = 0; i < programs.length; i++) {
                if (programs[i] != null) {
                    programNames[i] = programs[i].getProgramName();
                } else {
                    programNames[i] = null;
                }
            }

            return programNames;
        }

        return new String[0];
    }

    //TODO
    public String findStudent(String uniID, String programName) {
        Program program;
        Student student;
        for (int i = 0; i < programs.length; i++) {
            if (programs[i] != null && programs[i].getProgramName().equals(programName)) {
                program = programs[i];
                if(program.getStudents()[i] != null && program.getStudents()[i].getUni_ID().equals(uniID)){
                    return "Studenten är registrerad.";

                }

            }



        }
        return "Studenten är inte registrerad på programmet.";
    }

//    public String findStudent(String uniID, String programName) {
//        Program program;
//        Student student;
//        for (int i = 0; i < programs.length; i++) {
//            if (programs[i] != null && programs[i].getProgramName().equals(programName)) {
//                program = programs[i];
//            }
//            if(program.getStudents()[i].getUni_ID().equals(uniID)){
//                student = program.getStudents()[i];
//                return "Studenten är registrerad.";
//            }
//        }
//        //return "Studenten är registrerad.";
//        return "Studenten är inte registrerad på programmet.";
//    }

    public String addTeachersToFaculty(Teacher[] teachers) {
        teachers = new Teacher[Teacher.values().length];

        int i = 0;
        for (Teacher teacher : Teacher.values()) {
            teachers[i++] = teacher;
        }
        return "För många valda lärare.";

    }

    //TODO

    public String findStudentByID(String uniID, String programName){
//        Program program;
//        for(int i =0; i < programs.length; i++){
//            if(programs[i] != null && programs[i].getProgramName().equals(programName)){
//                program = programs[i];
//                if(uniID != null && program.getStudents()[i].getUni_ID().equals(uniID)){
//                    return "Ett namn finns associerat med detta student-ID.";
//                }
//            }
//        }

        return "Inget namn finns associerat med detta student-ID.";
    }



}
//end of class
