package lab_02;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Teacher {
    private String surname;
    private List<Subject> subjects;

    public Teacher() {
        this.subjects = new ArrayList<>();
    }

    public Teacher(String surname) {
        this.surname = surname;
        this.subjects = new ArrayList<>();
    }

    public String getSurname() {
        return surname;
    }

    public List<Subject> getSubjects() {
        return subjects;
    }

}
