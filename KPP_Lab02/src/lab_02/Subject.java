package lab_02;

import java.util.ArrayList;
import java.util.List;

public class Subject {
    private String name;
    private List<Student> students;

    public Subject(String name) {
        this.name = name;
        this.students = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void printStudents() {
        for (Student student : students){
            System.out.println("        " + student.getSurname() + ";");
        }
    }
}
