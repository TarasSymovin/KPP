package lab_02;

import java.util.*;

public class Manager {
    private List<Teacher> teacherList;
    private List<Student> studentList;
    private List<Subject> subjectList;

    public Manager() {
        this.teacherList = new ArrayList<>();
        this.studentList = new ArrayList<>();
        this.subjectList = new ArrayList<>();
    }

    public void regStudent(Student student, Subject subject){

        if (isPresent(subject)){
            for (Subject s : subjectList){
                if (subject == s){
                    s.getStudents().add(student);
                }
            }
        }

        if (!isPresent(student)){
            studentList.add(student);
        }
    }

    public void regTeacher(Teacher teacher){
        this.teacherList.add(teacher);
    }

    public void addSubject(Teacher teacher, Subject subject){
        this.subjectList.add(subject);

        for (Teacher t : teacherList){
            if (t == teacher){
                t.getSubjects().add(subject);
            }
        }
    }

    public void printTable(){
        Map<Student, List<Subject>> table = makeTable();

        System.out.println("-----------------------------------------------------------------------");

        for(Student student : table.keySet()){
            System.out.print(student.getSurname() + ": ");
            for (Subject subject : table.get(student)){
                System.out.print(subject.getName() + " ");
            }
            System.out.println();
        }

        System.out.println("-----------------------------------------------------------------------");
    }

    public void printTask2(String subject1, String subject2){

        Subject firstSub = null;
        Subject secondSub = null;

        for (Subject subject : subjectList){
            if (subject.getName().equals(subject1)){
                firstSub = subject;
            }
        }

        for (Subject subject : subjectList){
            if (subject.getName().equals(subject2)){
                secondSub = subject;
            }
        }

        Map<Student, List<Subject>> table = makeTable();
        List<Student> list = new ArrayList<Student>();

        boolean firstSubject;
        boolean secondSubject;

        System.out.println("-----------------------------------------------------------------------");

        for (Student student : table.keySet()){
            firstSubject = false;
            secondSubject = false;

            for (Subject subject : table.get(student)){
                if (subject == firstSub){
                    firstSubject = true;
                    break;
                }
            }
            for (Subject subject : table.get(student)){
                if (subject == secondSub){
                    secondSubject = true;
                    break;
                }
            }

            if (firstSubject && secondSubject){
                System.out.println(student.getSurname());
            }
        }

        System.out.println("-----------------------------------------------------------------------");
    }

    public List<Teacher> task3(){
        List<Teacher> teachers = new ArrayList<Teacher>();

        int sum = 0;

        for (Teacher teacher : teacherList){
            sum += teacher.getSubjects().size();
        }

        double avarage = sum / teacherList.size();

        for (Teacher teacher : teacherList){
            if (teacher.getSubjects().size() > avarage){
                teachers.add(teacher);
            }
        }

        return teachers;
    }

    public void printActiveStudent(){
        Map<Student, List<Subject>> table = makeTable();

        System.out.println("-----------------------------------------------------------------------");

        for (Student student : table.keySet()){
            if (table.get(student).size() == subjectList.size()){
                System.out.println(student.getSurname());
            }
        }

        System.out.println("-----------------------------------------------------------------------");
    }

    private Map<Student, List<Subject>> makeTable(){
        Map<Student, List<Subject>> table = new HashMap<Student, List<Subject>>();

        for (Student student : studentList){
            List<Subject> list = new ArrayList<Subject>();
            for (Subject subject : subjectList) {
                for (Student s : subject.getStudents()) {
                    if (s == student) {
                        list.add(subject);
                    }
                }
            }
            table.put(student, list);
        }

        return table;
    }

    public void printInfoAboutTeachers() {
        for (Teacher teacher : teacherList){
            System.out.println(teacher.getSurname() + ":");

            for (Subject subject : teacher.getSubjects()){
                System.out.println("    " + subject.getName() + ":");

                for (Student student : subject.getStudents()){
                        System.out.println("        " + student.getSurname() + ";");
                    }
            }
        }
    }

    private boolean isPresent(Student student){
        boolean result = false;

        for (Student st : studentList){
            if (student == st){
                result = true;
            }
        }

        return result;
    }

    private boolean isPresent(Subject subject){
        boolean result = false;

        for (Subject sub : subjectList){
            if (sub == subject){
                result = true;
            }
        }

        return result;
    }

    public List<Subject> getSubjectList() {
        return subjectList;
    }
}