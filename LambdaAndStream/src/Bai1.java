import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

class Students {
    String name;
    int score;

    Students(String name, int score) {
        this.name = name;
        this.score = score;
    }
 }

public class Bai1 {
    public static void main(String[] args) {
        List<Student> student = Arrays.asList(
                new Student("An" ,9),
                new Student("Tú", 7),
                new Student("Dương", 4),
                new Student("Viet", 9),
                new Student("Hồng", 4)
        );

        Student topStudent = student.stream().max(Comparator.comparingInt(s->s.score)).orElse(null);

        if(topStudent != null) {
            System.out.println("Học Sinh có điểm cao nhất la: ");
            System.out.println("Tên: " + topStudent.name);
            System.out.println("Điểm: " + topStudent.score);
        }
    }
}
