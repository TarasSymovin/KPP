package lab_02;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {

        Manager manager = new Manager();
        getData(manager);

        int swValue;
        System.out.println("|   MENU SELECTION DEMO    |");
        System.out.println("| Options:                 |");
        System.out.println("|        1. TASK 1       |");
        System.out.println("|        2. TASK 2       |");
        System.out.println("|        3. TASK 3       |");
        System.out.println("|        4. Exit         |");
        swValue = Keyin.inInt(" Select option: ");

        switch (swValue) {
            case 1:
                System.out.println("Option 1 selected");
                manager.printTable();
                break;
            case 2:
                System.out.println("Option 2 selected");
                manager.printActiveStudent();
                manager.printTask2("КПЗ", "МАПЗ");
                break;
            case 3:
                System.out.println("Option 3 selected");
                List<Teacher> teachers = manager.task3();
                for (Teacher teacher : teachers){
                    System.out.println(teacher.getSurname());
                }
                break;
            case 4:
                System.out.println("Exit selected");
                break;
            default:
                System.out.println("Invalid selection");
                break;
        }
    }

    static void getData(Manager manager) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("src/lab_02/teachers"));
        BufferedReader br2 = new BufferedReader(new FileReader("src/lab_02/subjects"));

        List<String> linesTeachers = new ArrayList<>();
        List<String> linesSubjects = new ArrayList<>();

        while (br.ready()) {
            linesTeachers.add(br.readLine());
        }

        for (String st : linesTeachers){
            String[] line = st.split(" ");
            Teacher teacher = new Teacher(line[0]);
            manager.regTeacher(teacher);
            for (int i = 1; i < line.length; i++){
                Subject subject = new Subject(line[i].replace('_', ' '));
                manager.addSubject(teacher, subject);
            }
        }

        while (br2.ready()) {
            linesSubjects.add(br2.readLine());
        }

        for (String st : linesSubjects){
            String[] line = st.split(" ");
            Student student = new Student(line[0]);
            for (Subject subject : manager.getSubjectList()){
                for (int i = 1; i < line.length; i++){
                    if (subject.getName().equals(line[i].replace('_', ' '))){
                        manager.regStudent(student, subject);
                    }
                }
            }
        }
    }
}

class Keyin {

    //*******************************
    //   support methods
    //*******************************
    //Method to display the user's prompt string
    public static void printPrompt(String prompt) {
        System.out.print(prompt + " ");
        System.out.flush();
    }

    //Method to make sure no data is available in the
    //input stream
    public static void inputFlush() {
        int dummy;
        int bAvail;

        try {
            while ((System.in.available()) != 0)
                dummy = System.in.read();
        } catch (java.io.IOException e) {
            System.out.println("Input error");
        }
    }
    public static String inString() {
        int aChar;
        String s = "";
        boolean finished = false;

        while (!finished) {
            try {
                aChar = System.in.read();
                if (aChar < 0 || (char) aChar == '\n')
                    finished = true;
                else if ((char) aChar != '\r')
                    s = s + (char) aChar; // Enter into string
            }

            catch (java.io.IOException e) {
                System.out.println("Input error");
                finished = true;
            }
        }
        return s;
    }

    public static int inInt(String prompt) {
        while (true) {
            inputFlush();
            printPrompt(prompt);
            try {
                return Integer.valueOf(inString().trim()).intValue();
            }

            catch (NumberFormatException e) {
                System.out.println("Invalid input. Not an integer");
            }
        }
    }

}
