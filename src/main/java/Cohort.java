import java.util.ArrayList;
import java.util.Random;

public class Cohort {

    private ArrayList<Student> students;
    private ArrayList<String> studentNames;
    private int num;

    public Cohort(int num) {
        this.students = new ArrayList<Student>();
        this.studentNames = new ArrayList<String>();
        this.num = num;
        addName(num);
    }

    public void addName(int number){
        int num = 0;
        for(int i = 0; i < number; i++){
        num += 1;
        String student = String.format("Student %d", num);
        students.add(new Student(student));
        }
    }

    public ArrayList<Student> getStudents() {
        return students;
    }

    public ArrayList<String> getStudentNames() {
        for (Student student : students) {
            studentNames.add(student.getName());
        }
        return studentNames;
    }

    public String getRandomStudent() {
        getStudentNames();
        int rnd = new Random().nextInt(studentNames.size());
        return studentNames.get(rnd);
    }

    public ArrayList<String> getStudentPair(){
       ArrayList<String> pair = new ArrayList<>();
       String student1 = getRandomStudent();
       String student2 = getRandomStudent();
       while(student1 == student2){
           student2 = getRandomStudent();
       }
       pair.add(student1);
       pair.add(student2);
       return pair;
    }

    public ArrayList<String> getNumStudents(int num){
        ArrayList<String> numStudents = new ArrayList<>();
        if(num <= students.size()) {
            for (int i = 0; i < num; i++) {
                String randomStudent = getRandomStudent();
                if (!numStudents.contains(randomStudent)) {
                    numStudents.add(randomStudent);
                } else {
                    i -= 1;
                }
            }
            return numStudents;
        } else {
        return null;
        }
    }

}
