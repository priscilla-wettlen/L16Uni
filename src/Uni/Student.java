package Uni;

public class Student {
    private String name;
    private String uniID;


    public Student(String name, String uniID){
        this.name = name;
        this.uniID = uniID;
    }

    public String getName(){
        return name;
    }

    public String getUniID(){
        return uniID;
    }

}
