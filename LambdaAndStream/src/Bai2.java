import java.util.Arrays;
import java.util.List;

class Student {
    String name;
    int score;

    Student(String name, int score) {
        this.name = name;
        this.score = score;
    }
}
public class Bai2 {
    public static void main(String[] args) {
        List<Student> students = Arrays.asList(
                new Student("An" ,9),
                new Student("Tú", 7),
                new Student("Dương", 4),
                new Student("Viet", 9),
                new Student("Hồng", 4)
        );
        double average = students.stream().mapToInt(s->s.score).average().orElse(0.0);

        System.out.println("Điểm trung bình của lớp: " + average);
    }
}
